#############################
#  Makefile for Nut Library #
#       (C) Heijix          #
#############################

.PHONY: all run build test install clean

# Launch tests for OCaml
all: test

# Execute an example command for nut files
run:
	@echo "Run nut_cmd"
	@dune exec src/bin/nut_cmd.exe

# Build the project : library and executable
build:
	@dune build
	@dune build src/bin/nut_cmd.exe
	@echo "Create bin directory"
	@ln -sf _build/default/src/bin ./bin

# Launch tests for OCaml
test:
	@echo "Tests are runnning :"
	@dune build @runtest

# Prepare install for Opam
install:
	@dune build @install	

# Clean the repository
clean:
	@echo "Delete bin directory and clean _build"
	@dune clean	
	@rm -rf ./bin