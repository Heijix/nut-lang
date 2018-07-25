.PHONY: usage all deploy_dev_doc remove_dev_doc clean

LANGUAGES=c cpp go java ocaml python

_RED=$(shell tput setaf 1)
_GREEN=$(shell tput setaf 2)
_YELLOW=$(shell tput setaf 3)
_BLUE=$(shell tput setaf 4)
_PURPLE=$(shell tput setaf 5)
_CYAN=$(shell tput setaf 6)
_WHITE=$(shell tput setaf 7)
_END=$(shell tput sgr0)

usage:
	@printf "%sNut Makefile Usage:%s\\n\\n" "$(_GREEN)" "$(_END)"
	@printf "Deploy Nut documentation\\n"
	@printf "\\t%smake deploy_dev_doc%s\\n\\t\\t# Deploying it on localhost:42420\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake remove_dev_doc%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\n"
	@printf "Compile libraries:\\n"
	@printf "\\t%smake all%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\n"
	@printf "\\t%smake lib-c%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake lib-cpp%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake lib-go%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake lib-java%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake lib-ocaml%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\t%smake lib-python%s\\n" "$(_CYAN)" "$(_END)"
	@printf "\\n"
	@printf "Cleaning:\\n"
	@printf "\\t%smake clean%s\\n" "$(_RED)" "$(_END)"

all:
	for i in $(LANGUAGES); do \
		make -C . lib-$$i; \
	done

lib-%: core/%
	make -C $?

deploy_dev_doc:
	make -C nut-doc deploy_local

remove_dev_doc:
	make -C nut-doc remove_deploy

clean:
	make -C nut-doc/ clean
	for i in $(LANGUAGES); do \
		make -C core/$$i/ clean; \
	done
