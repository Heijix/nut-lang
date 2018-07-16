# Variable
_RED=$(shell tput setaf 1)
_BLUE=$(shell tput setaf 4)
_GREEN=$(shell tput setaf 2)
_END=$(shell tput sgr0)

_NUMBER1 = [$(_BLUE)n$(_END)]
_NUMBER2 = [$(_BLUE)p$(_END)]
BIN = binary
DOC = docs
SOURCE = src/
FILES = 10
START = 1



##############
all: 
	@printf "Create a javadoc of the generator : $(_RED)make docs$(_END)\\n"
	@printf "Generate $(_NUMBER1) error test files where file dailing start at $(_NUMBER2) : make error_file FILES=$(_NUMBER1) START=$(_NUMBER2)\\n"
	@printf "Generate $(_NUMBER1) good test files where file dailing start at $(_NUMBER2)  : make good_file  FILES=$(_NUMBER1) START=$(_NUMBER2)\\n"
	@printf "By default, FILES=10 and START=1 \\n"
	@printf "\\n"
	@printf "Delete binary and documentation : $(_RED)make clean$(_END)\\n"  



##############
compile: 
			@printf "Creation of binary\\n"
			@mkdir -p $(BIN)
			@printf "[$(_BLUE)In progress$(_END)] Compilation\\n"
			@javac -sourcepath $(SOURCE) -d $(BIN) $(SOURCE)/Main.java
			@printf "[$(_GREEN)OK$(_END)] End of compilation\\n"



##############
error_file: clean_binary compile
			@java -cp $(BIN) Main 0 $(FILES) $(START)


good_file: clean_binary compile
			@java -cp $(BIN) Main 1 $(FILES) $(START)



##############
docs: clean_doc
			@printf "Creation of documentation\\n"
			@mkdir -p $(DOC)
			@javadoc -charset utf8 -author -d $(DOC) -Xdoclint:none -sourcepath $(SOURCE) -subpackages $(SOURCE)* 2>/dev/null 1>/dev/null
			@printf "[$(_GREEN)OK$(_END)] Documentation in $(_BLUE)docs$(_END) folder\\n"


##############
clean: clean_binary clean_doc
ifeq ($(shell test -e binary && echo yes),yes)
clean_binary:
		@rm -Rf $(BIN) 
		@printf "[$(_GREEN)OK$(_END)] Binary deleted\\n"
else
clean_binary:
	@printf "No binary to delete\\n"
endif


##############
ifeq ($(shell test -e docs && echo yes),yes)
clean_doc:
		@rm -Rf $(DOC) 
		@printf "[$(_GREEN)OK$(_END)] Documentation deleted\\n"
else
clean_doc:
	@printf "No documentation to delete\\n"
endif