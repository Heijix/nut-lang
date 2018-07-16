
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
