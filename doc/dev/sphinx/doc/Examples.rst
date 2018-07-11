Examples
========

Let's become with a simple example.

..  code-block:: none

    {
        menu: {
            id: "file"
            value: "File"
            popup: {
                menuitem: [
                    { value: "New", onclick: "CreateNewDoc()" }
                    { value: "Open", onclick: "OpenDoc()" }
                    { value: "Close", onclick: "CloseDoc()" }
                ]
            }
        }
    }

This data looks like Json right ? But it's not.
We don't have double quotes for the value of a object, and there is no commas anymore... Of course you can keep write them, if you want, but it clarify the syntax, and make it more readable.

.. note::

	Every json file is nut friendly !

A storing-data example using Data Types in Nut.


..  code-block:: none

    Alias TimeEpoch :- ulong
    Alias ColorRange :- uchar

    Data Color :-
        - ColorRange: red
        - ColorRange: green
        - ColorRange: blue

    Alias Pixel :- Color

    Data Image :-
        - ulong : size_x
        - ulong : size_y
        - list<Pixel> : content

    Data Picture :-
        - string : name
        - TimeEpoch : dateCreation
        - TimeEpoch : dateModification
        - Image : image

    &[R123] Color {
        red: 255
        green: 42
        blue: 57
    }

    @ Picture {
        name: "Awesome picture"
        dateCreation: 1530264398
        dateModification: 1530264398
        image: Image {
            size_x: 1
            size_y: 2
            content: [
                *[R123]
                *[R123]
            ]
        }
    }

We have a lot to say, here. Here have defined what is picture, we define it as a name, a dateCreation, a dateModification, and a lot of Pixels, but let's imagine that all data Types can be imported from another file, or from the cloud.


..  code-block:: none

    Import 'Picture.nut'
    # In this import, we have imported Picture (of course), but also
    #       Image, Color, and aliases such as TimeEpoch, ColorRange, Pixel
    # All of this is depedencies of the Picrure module.

    &[R123] Color {
        red: 255
        green: 42
        blue: 57
    }

    @ Picture {
        name: "Awesome picture"
        dateCreation: 1530264298
        dateModification: 1530264399
        image: Image {
            size_x: 1
            size_y: 2
            content: [
                *[R123]
                *[R123]
            ]
        }
    }

Here we have the same file than above, but we have import all the Data Definition part from another file called 'Picture.nut'

So let'stalk about this '&[R123]' and '@ Picture'.

So let's start with the beginning, when we are parsing the file, here in this example, we have two objects : the Color and the Picture. But Nut language will give one single object after parsing. So we have to specify it by using the character '@' just before the name object. The '@' is called a Data Type Qualifier. The other object (the Color one) is defined here in the main scope. But it's not in the Picture image. We can say that the Color object is a varible here. And the reference of this variable is 'R123'. So we use the Data Type Qualifier &[R123], then we can use it later in the Picture image by calling the reference '\*[R1234]'.

But we have to say two more things :
 - Aliases objects in main scope, has to be used at least once.
 - You can also define the Color object directly in the Picture object, set the reference and still use it after. It is accepted, but not very readable... So it will raise a single warnings... (somehow). See the example below.

..  code-block:: none

    Import 'Picture.nut'

    @ Picture {
        name: "Awesome picture"
        dateCreation: 1530264298
        dateModification: 1530264399
        image: Image {
            size_x: 1
            size_y: 2
            content: [
                &[R123] Color { # Here raise the warning
                    red: 255
                    green: 42
                    blue: 57
                }
                \*[R123]
            ]
        }
    }
