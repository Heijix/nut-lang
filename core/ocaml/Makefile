#############################
#  Makefile for Nut Library #
#       (C) Heijix          #
#############################

.PHONY: all run build test install clean

# Launch tests for OCaml
all: test

# Execute an example command for nut files
run:
	@dune exec nut_cmd

# Build the project : library and executable
build:
	@dune build
	ln -sf _build/default/src/nut_cmd ./bin

# Launch tests
test:
	@dune runtest

# Prepare install for Opam
install:
	@dune @install	

# Clean the repository
clean:
	@dune clean	
	rm -rf ./bin