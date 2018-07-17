# Information about nut-ocaml

## File system

```sh
$>tree
.
├── dune-project
├── README.md
├── Makefile
├── nut.opam
└── src
├── bin
│ ├── dune
│ └── nut_cmd.ml
└── lib
├── dune
└── nut.ml
```

## Compiling system
To compile or execute this project you can use the Makefile. All the make commands launch dune commands. It's used to abstract dune for OCaml beginners. Dune is a project manager (like maven or gradle) for OCaml.
Only nut library is public. The nut_cmd executable is here to provide example. That's why it's define as a local program. Dune considers it as local whereas it considers nut as public project.

## Packaging system
The nut.opam file allows the nut library to be package for opam. The command **make install** prepare the nut library to be installed with opam.

## Dependencies
Two dependencies are needed for the nut-ocaml :
* dune (formerly jbuilder) to manage project
* odoc to generate documentation