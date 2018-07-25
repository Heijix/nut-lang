Implementation
==============

So here is described the way that Nut needs to be implemented to deal with all the exceptions, all languages, and all cases that we need to care to lex, parse and use out data file.

At the end of the file, we have a list of given errors, that we have to throw, if something wrong happens. This list is exhaustive in purpose.

Lexical Analysis (L)
--------------------

First of all, we will have 3 Lexical analysis, just because we have 3 grammars.

 - Iota Grammar
 - Lambda Grammar
 - Omega Grammar

We will have 3 lists of tokens, one for each grammar. We start with the Iota Grammar, then when we can't generate any new Token. We change the state, and we're now lexing for Lambda Grammar, and the same thing for Omega. If we encounter some sets of character that doesn't match anything, we throw an error (L3).

We need a token for strings.
If we encounter a " or a ', we store each existing character that we have until we get the same character as the starting string character (L0). We accept any character that is escaped, and all character starting with \u followed with 4 hexadecimal characters (L2). We do not accept Control Command Character in a string Token (L1).

With this previous definition, we now have a string represention in a token named STRING.

We need a token for names.
Name is just a string without explicit quotes, and with only ascii characters. We still do not accept Control Command Character in a name Token (L1).

With this previous definition, we now have a name represention in a token names NAME.

If we are not in a string represention, we ignore a lot of characters such as spaces, new lines etc. And we also ignore all characters after '#' character until new line.
So for Character token, we have to ignore all this list of characters.

 - ' '
 - '\n'
 - '\t'
 - '\v'
 - '\f'
 - '\r'
 - any control command character (L1)

Iota Tokens (LI)
~~~~~~~~~~~~~~~~

+------------+---------+
| Token Name | Example |
+============+=========+
| IMPORT_CMD | Import  |
+------------+---------+

In fact, this grammar is very small, because we only need IMPORT_CMD and STRING.

Lambda Tokens (LG)
~~~~~~~~~~~~~~~~~~

+---------------------+---------+
| Token Name          | Example |
+=====================+=========+
| ALIAS_CMD           | Alias   |
+---------------------+---------+
| DEFINITION          | :=      |
+---------------------+---------+
| DASH                | \-      |
+---------------------+---------+
| COLON               | :       |
+---------------------+---------+
| LEFT_ANGLE_BRACKET  | <       |
+---------------------+---------+
| RIGHT_ANGLE_BRACKER | >       |
+---------------------+---------+
| EQUALS              | =       |
+---------------------+---------+

We also need the NAME Token.

Omega Tokens (LO)
~~~~~~~~~~~~~~~~~

+-------------------+---------+
| Token Name        | Example |
+===================+=========+
| LBRACE            | {       |
+-------------------+---------+
| RBRACE            | }       |
+-------------------+---------+
| LBRACKET          | [       |
+-------------------+---------+
| RBRACKER          | ]       |
+-------------------+---------+
| COLON             | :       |
+-------------------+---------+
| ROOT_QUALIFIER    | @       |
+-------------------+---------+
| BEG_ALIAS_DEF     | &       |
+-------------------+---------+
| BEG_ALIAS_ACC     | \*      |
+-------------------+---------+
| INTEGER(int)      | 123     |
+-------------------+---------+
| FLOATTANT(double) | 42.42   |
+-------------------+---------+

We also need the STRING and NAME Tokens.

Semantic Analysis 1 (S)
-----------------------

We just generate the grammar of Iota, and Lambda Part. We will do the Omega one, later.

For all the Semantic Analysis, we refer to the grammar. We have to fill the errors code, when someone will implement the first parser / lexer of this language. A lot of error have to be handled in the Semantic analysis

Consistency Analysis (C)
------------------------

Now, we query for the imports files. The imports file has to imported in order, and they can define Iota, Lambda and Omega Grammars, except that Grammar cannot define any root objects. If they define one object roots (are many), it is a OR file and not a OI file (C1). We also import recursively. When we have fetch all imports, we now have a ordered set of Data Definition, and a miscellaneous set of aliases objects. When we load all the Data Type definition, we give to each Data Type and to each alias object its provenance, then we can check if we try to redefine a Data Type or use an alias that's already exist.

In the beginning of the program, we just have the standard primary types, id est :

 - char / uchar
 - short / ushort
 - int / uint
 - long / ulong
 - string
 - boolean

We just note that that they are start with a lowercase character, that is done in purpose.

We now have to store each definition of the DataTypes into a Table. We analyse them one by one, from the top to the bottom. We now have a bench of little things to check.

 - For DataTypes:
    - We don't accept any Data Types that start with a lower case character (C2). We now distinguish the native primitive types and the created Data Types by user.
    - If we try to define a data variable as a set of Data that we don't know the types, we throw an error. If we try to define a variable with another Data Type that is defined later (we throw the same error) (C3).
    - A Data Type cannot be defined recursively (with itself) (C4)
    - Verify if the Data Type that we are currently defining is not overwriting another Data Type imported from another file (C5).
    - If a member have a default value, we have to generate the given object, but the object must be the same Type as the Type of the member in the Data Type Definition. (C6)
 - For Aliases Objects:
    - Aliases can't overwrite any already used aliases id. (B5)
    - Note: If a alias id is not used in a imported file, we don't throw an error. It could have be made in purpose. We don't throw a B4 error.
	- A alias can only be used in the current scope, it means that, for the momemnt, we can't access references of an imported file.

Next, we have a consistent list of Data Types.

Content Building (B)
--------------------

We now have a list of Data Types, and a list of tokens for Omega Part.

Now we can apply the grammar to the Omega Part. We count the number of objects roots. If there is more than one. Root Object has to be set explicitly, and all the rest, needs to have an alias id (B1).

We start by generate the objects with aliases in order. We also have to verify if the alias id is not used. (B5). Then we generate the root one, in order.

In the generation of objects, if the object respect a Data Type, this object has to implement every member of the Data Type, not more, not less. If a member is not defined and doesn't have a default value, throw an error (B2). If a member is defined, but it isn't in the Data Type Definition, throw an error (B3).

In the generation of objects, we also fetch every alias id, with the corresponding one.

At the end, if a alias id, was never called, we throw an error (B4)

Finally, we just have a big object (the root one). :)

Errors Code and Meaning
-----------------------

+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| Key Code | Warning | Error Meaning                                                                                                               |
+==========+=========+=============================================================================================================================+
| L0       | ✘       | EOF is encountered too early in the file                                                                                    |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| L1       | ✘       | Control Command Character is not allowed in a Nut File                                                                      |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| L2       | ✘       | Any explicit Unicode Character need to be followed by 4 hexadecimal characters in [0-9] or [a-f] or [A-F]                   |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| L3       | ✘       | Unexpected Character, match nothing in the grammar                                                                          |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| C1       | ✘       | Imported files, contains only imports and Data types definitions                                                            |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| C2       | ✘       | All Data Types created has to start with a uppercase character                                                              |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| C3       | ✘       | You cannot define a Data Type, with a Data Type that is not defined yet                                                     |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| C4       | ✘       | We cannot overwrite a Data Type already defined in imported file                                                            |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| C5       | ✘       | The default value has to respect the Type in Data Type Definition                                                           |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| B1       | ✘       | Root Object has to be set explicitly with '@', and all objects that remains in the root scope need a alias id               |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| B2       | ✘       | You need to implement all members of the object you want to create                                                          |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| B3       | ✘       | You cannot add fields in the object, because it doesn't exist in the Data Type Definition of the object you want to create. |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| B4       | ✔       | An alias is never used                                                                                                      |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
| B5       | ✘       | An alias already exist, choose another one                                                                                  |
+----------+---------+-----------------------------------------------------------------------------------------------------------------------------+
