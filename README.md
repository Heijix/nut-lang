# Nut

This is the main repository for the nut language.

Make sure that the way you code the library will be easy-to-push to given package manager (like pip).

If you want to see the nut documentation, do the following:
```
git clone https://github.com/Heijix/nut-lang.git
cd nut-lang
make deploy_dev_doc
# Then go to your browser at address localhost:42420
```

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
├── nut-doc
│   └── [Some Stuff]
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
└── README.md
```

| folder | explanation |
| :----- | :---------- |
| core | main code about library in there |
| nut-doc | the documentation |
| examples | a bench a nut files |
| prog_utils | utils code |

# To do list

Terminate the Java library to start writing code.

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
 - [ ] JavaScript

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
