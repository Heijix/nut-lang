Data Address :=
    - string: type
    - string: name
    - uint32: number

Data House :=
    - Address: address
    - string: family_name

@ House {
    Address {
        type: "Street"
        name: "Butte aux cailles"
        number: 28
        isBis: false
    }
    family_name: "Duval"
}
