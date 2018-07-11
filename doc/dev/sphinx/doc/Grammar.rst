Grammar
=======

Nut Grammars
------------

A nut format is composed of three little formats. We call them :
 - iota
 - lambda
 - omega

iota is for imports.
lambda is for data definitions.
omega define the data itself.

You will find a list of all tokens at the end of the file, then e wan have a simple, easy lexer.

For this definition, we will add a underscore '\_' to distinguish between token and rules.
We will use None if epsilon (empty) is accepted in the rule.

Standard Tokens
---------------

Here is defined some definition of useful tokens, and some useful rules :
 - ASCII_ACHAR
 - ZERO
 - DIGIT19
 - STRING
 - NAME
 - ID_ALIAS
 - \_DIGIT (this one is a rule, not a token)
 - \_STD_CHAR

Note : May STRING, NAME and ID_ALIAS are not tokens at the beginning, but it will be useful, if we transform them as tokens before parsing... Or you can keep them as rules, it is the choice of the programemr, but at the state of the first lexer, it is not consider as tokens...

Ignorable characters
--------------------

We have a thing in common between all the grammars, it is handling ignorable characters between tokens...
IGNORE_UNTIL_NL is for line comment.
We don't have way to have multi line comment.

IG

.. code-block:: none

    ' '
    '\n'
    '\t'
    '\r'
    '\f'
    '\v'
    '#' [^\r\n]*

We will note explicitly IG, but id doesn't generate any tokens, but IG can't be present in a string for example. So it is written explicitly everywhere, just above every sub grammars.

Miscellaneous simple tokens
~~~~~~~~~~~~~~~~~~~~~~~~~~~

ASCII_ACHAR for any alphabet ascii char.

No IG

.. code-block:: none

    ASCII_ACHAR
        [a-z]
        [A-Z]

ZERO

No IG

.. code-block:: none

    ZERO
        0

DIGIT19

No IG

.. code-block:: none

    DIGIT19
        [1-9]

\_DIGIT for 0, 1, ...

No IG

.. code-block:: none

    _DIGIT
        ZERO
        DIGIT19

\_STD_CHAR for standard character

No IG

.. code-block:: none

    _STD_CHAR
        ASCII_ACHAR
        DIGIT

STRING
~~~~~~

No IG

.. code-block:: none

    STRING
        " _chars_d "
        ' _chars_s '

    _chars_d
        None
        _char_d _chars_d

    _chars_s
        None
        _char_s _chars_s

    _char_s
        any-Unicode-character-
            except-'-or-\-or-
            control-character
        \'
        _char

    _char_d
        any-Unicode-character-
            except-"-or-\-or-
            control-character
        \"
        _char

    _char
        \\
        \/
        \b
        \f
        \n
        \r
        \t
        \u ([a-f][A-F][0-9]) ** 4 # 4 times though...

NAME
~~~~

No IG

.. code-block:: none

    NAME
        _STD_CHAR _std_char_next

    _std_char_next
        None
        _STD_CHAR _std_char_next

ID_ALIAS
~~~~~~~~

No IG

.. code-block:: none

    ID_ALIAS
        ASCII_ACHAR id_alias_next

    id_alias_next
        None
        _STD_CHAR id_alias_next

Iota Grammar
------------

IG

.. code-block:: none

    Iota_command
        Iota_command
        import_command Iota_command
        None

    import_command
        Import STRING

This will generate 2 types of tokens:
 - IMPORT : for the word Import
 - STRING : for the string...

Lambda Grammar
--------------

IG

.. code-block:: none

    Lambda_command
        None
        alias_command Lambda_command
        define_new_type_command Lambda_command

    alias_command
        Alias NewType :- Type

    define_new_type_command
        Data NewType Generic_Type :- MemberType_next

    Generic_Type
        None
        < Type Generic_Type_Next >

    Generic_Type_Next
        None
        , Type Generic_Type_Next

    MemberType
        None
        MemberType_next MemberType

    MemberType_next
        - Type Generic_Type : NameMember ContentMemberTypeDefault MemberType

    ContentMemberTypeDefault
        None
        = _value

This will generate this bunch of tokens:
 - ALIAS : for the word Alias word
 - NAME : for the Type and NewType... We use these words to be more understandable when we will read the grammar later. But in fact, they are just names, we will interpret them as Types later.
 - COLON_DASH : for ':-'
 - L_ANGLE_BRACE : for '<'
 - R_ANGLE_BRACE : for '>'
 - COMMA : for ','
 - COLON : for ':'
 - DASH_MINUS : for '-'
 - EQUAL : for '='
 - (all tokens about value, we will see them just below)

If we encounter '=', we use the \_value subgrammar to generate all the tokens.

More details about Type and Generic types can be found in the Language file.
There is something tricky here, about ContentMemberTypeDefault, see Language file. The \_value rule here and the \_value below are the same.

Omega Grammar
-------------

Here come the grammar: This is exactly the same as Json's one, except for some changes. All changes are written explicitly at the end of the grammar.

First, we will define all of the 6 objects that define Json by default. We can access of any of them by using the rule '\_value': We note that String is already defined above, and null is just a token and not a rule...

IG

.. code-block:: none

    _value
        *[ ID_ALIAS ]
        _value_reference _value_type

    _value_reference
        None
        &[ ID_ALIAS ]

    _value_type
        _object
        _array
        STRING
        _bool
        _number
        null

Tokens generated:
 - REF_ACCESS : for "\*["
 - REF_DEFINE : for "&["
 - R_SQ_BRACE : for "]"
 - STRING
 - NULL : for "null"

Object
~~~~~~

IG

.. code-block:: none

    _object
        _object_identifier { _object_content }

    _object_identifier
        None
        Type

    _object_content
        None
        _pair _members

    _pair
        _key : _value

    _key
        STRING
        NAME

    _members
        , _pair _members_comma
        _members_no_comma

    _members_no_comma
        None
        _pair _members_no_comma

    _members_comma
        None
        _pair , _members_comma

We use the ':' token to know if we have to call the \_value sub grammar.

Tokens generated:
 - STRING
 - NAME
 - L_BRACE : for "{"
 - R_BRACE : for "}"
 - COMMA
 - COLON

Array
~~~~~

IG

.. code-block:: none

    _array
        [ _array_content ]

    _array_content
        None
        _value _elements

    _elements
        , _value _elements_comma
        _elements_no_comma

    _elements_no_comma
        None
        _value _elements_no_comma

    _elements_comma
        None
        _value , _elements_comma

Here, we need a explicit state to know if we have to call \_value sub grammar

Tokens generated:
 - L_SQ_BRACE : for '['
 - R_SQ_BRACE : for ']'
 - COMMA

Bool
~~~~

IG

.. code-block:: none

    _bool
        true
        false

Tokens generated:
 - TRUE
 - FALSE

Number
~~~~~~

No IG here

.. code-block:: none

    _number
        _whole_part
        _whole_part _frac
        _whole_part _exp
        _whole_part _frac _exp

    _whole_part
        _DIGIT
        DIGIT19 digits
        - _DIGIT
        - DIGIT19 digits

    _frac
        . digits

    _exp
        _exp_marker digits

    digits
        _DIGIT
        _DIGIT digits

    _exp_marker
        e [+-]?
        E [+-]?

Tokens generated:
 - \_DIGIT
 - DIGIT19
 - POINT : for '.'
 - PLUS : for '+'
 - DASH_MINUS : for '-'
 - EXP_MARKER : for 'e' or 'E'

Real Omega Grammar
~~~~~~~~~~~~~~~~~~

It is using all above :)

IG

.. code-block:: none

    object_root
        Data_Type_Identifier _object

    Data_Type_Identifier
        None
        &[ id alias ]
        @

Changes with json
~~~~~~~~~~~~~~~~~

 - String can be with single quote
 - id aliases
 - Object can be a data type now with the data type identifier.
 - a key of a object member is not necessary a string, it is just to simplify the syntax, and make it more readable.
 - comma is now optional to distinguish two elements, it clarify the syntax
