Language
========

The idea is that a Nut is a extension of json. It means that all json files is a Nut file. And now we can add some features and rules to make json great again.

Here come a bench of rules and features that will be implemented in Nut.
 - (local and remote) imports
 - Data types
 - Comment Line
 - Aliases

In comparison with yaml, Nut doesn't care about indentation, numbers of spaces or tabulations, except for Comment line.

Local and Remote imports
------------------------

You can import a remote or a local module.

Local import must be a absolute path (like, i download data Types in /home/${USER}/.Nut/types/Color.nut), or a relative path.

Note about relative path
~~~~~~~~~~~~~~~~~~~~~~~~

It is relative from the current file.
A example of the usage is that, if the python module, we want to load a Nut file, and if in this Nut we import another Nut file, the relative path is relative of the path of the first Nut file, and not relative of the script.

OR and OI files
~~~~~~~~~~~~~~~

If we use import, the imported file must only contain others imports, Data definitions and aliases objects, but not any root objects. If such thing appends, we do not import the file... And we throw an error.

Here is some example of accepted and refused imported file :

Accepted importable file

.. code-block:: none

    Data Pixel :=
        - uchar: red
        - uchar : green
        - uchar : blue

    &[WhitePixel] Pixel {
        red : 0
        green : 0
        blue : 0
    }

Refused importable file

.. code-block:: none

    Data Pixel :=
        - uchar: red
        - uchar : green
        - uchar : blue

    &[WhitePixel] Pixel {
        red : 0
        green : 0
        blue : 0
    }

    @ {
        content : [
            *[WhitePixel],
            *[WhitePixel],
            *[WhitePixel]
        ]
    }

Here we have two kind of files, a only-importable file and only-readable file. We will note them OI file and OR file.

OR files may needs OI files if they imports them. But OI files can't generate a root object file... In the example above, the first file is a OI file, the second one is a OR file.

Reminder:
 - *Only-Importable* File : **OI** file
 - *Only-Readable* File : **OR** file

Comment Line
------------

Comment line is done in the token generation...

Aliases
-------

We have multiple kind of aliases. We have the Type aliases, and the value reference alias :
  - Data Type Alias is for Data definition in Iota Format
    - Ex: Alias Time := ulong
  - Value reference alias
    - Ex: See below.

.. code-block:: none

    {
        'name': &[U1234] 'John',
        'last_name': *[U1234]
    }

It is usefull to factorize code.

Data types
----------

Data types is used to store data in a given way.

Example:

.. code-block:: none

    Data Color :=
        - uchar : red
        - uchar : green
        - uchar : blue

Another example:

.. code-block:: none

    Data Pixel :=
        - Color : colors
        - uchar : alpha

    Data Pixel :=
        - uchar: red
        - uchar : green
        - uchar : blue
        - uchar : alpha

    Data Image :=
        - ulong : size_x
        - ulong : size_y
        - list<Pixel> : pixels

So, there is a lot to say about these data types.
First, we can define a Type as a combination of Primitives Types or created-by-user Types.

Primitives Types:
 - char, uchar (8 bits)
 - short, ushort (16 bits)
 - int, uint (32 bits)
 - long, ulong (64 bits)
 - bool (true or false)
 - string

The u prefix means that the data type is not signed...
Care, char in this representation is not a character, it is a number between -128 and 127.

Then, we can define a type, as a combination of types that we just define before. We can also define a data structure multiple times. We define here Pixel 2 times. It can have two definitions (if they are defined in the same file).

**An important rule here: We can't give another definition of a data structure if it was defined in another file (because it was imported with import command)**

If you want to use these data types that we just create. You have to put the Data Type identifier just before a object bracket.
