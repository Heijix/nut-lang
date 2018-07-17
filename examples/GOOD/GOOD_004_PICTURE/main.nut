
Import 'Picture.nut'

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
