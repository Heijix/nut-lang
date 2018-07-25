
Alias TimeEpoch := uint64
Alias ColorRange := uint8

Data Color :=
    - ColorRange: red
    - ColorRange: green
    - ColorRange: blue

Alias Pixel := Color

Data Image :=
    - uint64 : size_x
    - uint64 : size_y
    - list<Pixel> : content

Data Picture :=
    - string : name
    - TimeEpoch : dateCreation
    - TimeEpoch : dateModification
    - Image : image
