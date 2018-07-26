Data Address :=
    - string: type
    - string: name
    - uint32: number

Data House :=
    - Address: address
    - string: family_name

@ [
    House {
        Address {
            name: "Butte aux cailles"
            number: 28
        }
        family_name: "Duval"
    }
]
