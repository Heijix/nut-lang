# Nut

This is the main repository for the nut language.

Make sure that the way you code the library will be easy-to-push to given package manager (like pip).

## Nut Tree Repository

```bash
$> tree_customized
.
├── core
│   ├── c
│   ├── cpp
│   ├── go
│   ├── java
│   ├── ocaml
│   └── python
├── doc
│   └── dev
│       └── [Some Stuff]
├── examples
│   ├── BAD
│   │   ├── BAD_000_MINIMAL
│   │   ├── BAD_001_MINIMAL
│   │   ├── BAD_002_MINIMAL
│   │   ├── BAD_003_MINIMAL
│   │   └── BAD_004_EMPTY
│   ├── GOOD
│   │   └── GOOD_000_MINIMAL
│   └── JSON_COMPATIBLE
├── prog_utils
├── test_utils
│   └── core
│   │   └── [Some Stuff]
└── README.md
```

| folder | explanation |
| :----- | :---------- |
| core | main code about library in there |
| doc | the documentation |
| examples | a bench a nut files |
| prog_utils | utils code |
| test_utils | tests code or scripts |
| test_utils/code | main code for run and test library code |

# To do list

The first goal is to write examples, and it has to be Json compatible. So we have to write or download or generate 500 Json files, and put them in the /examples/JSON_COMPATIBLE folder. If you want to download, or generate Json files, make sure that you use differents generators. Because generators just changes values, and not the architecture of the file.

## Ordered list

 - [x] Get 500 Json files (download, or write it)
 - [ ] Code Libraries / Write documentation_a
 - [ ] Write CI
 - [ ] Write utility programs like
     - [ ] Nut Beautifier
     - [ ] Converter Json/Yaml/Nut
     - [ ] Nut validator

## Miscellaneous list

Coding libraries
 - [ ] c
 - [ ] cpp
 - [ ] go
 - [ ] java
 - [ ] ocaml
 - [ ] python

We have to respect the corresping table to write nut files at the same time than we write library code

N represents the number of library that was coded.  
Files represents the numbers of Nut files that is present in examples/{GOOD|BAR} directory.

| N | Files |
| :-: | :-: |
| 0 | 50 |
| 1 | 200 |
| 2 | 400 |
| 3 | 500 |
| 4 | 600 |
| 5 | 700 |
| 6 | 800 |
