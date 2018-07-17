

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
