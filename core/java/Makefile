.PHONY: all gradle clean assemble javadoc build test help

all:
	@printf "this project depends of gradle-4.9. you need to have it.\\n"
	@printf "make gradle - download and setup gradle-4.9\\n\\n"
	@printf "make assemble - assembles the outputs of this project.\\n"
	@printf "make jflex - compiles jfex file.\\n"
	@printf "make compileAll - compiles jflex then assembles the outputs of this project.\\n"
	@printf "make clean - deletes the build directory.\\n"
	@printf "make javadoc - generates javadoc api documentation for the main source code.\\n"
	@printf "make build - assembles and tests this project.\\n"
	@printf "make test - runs the unit tests.\\n"
	@printf "make help - to have more information.\\n"

gradle:
    @printf "wget https://services.gradle.org/distributions/gradle-4.9-bin.zip\\n"
	@printf "mkdir /opt/gradle\\n"
	@printf "unzip -d /opt/gradle gradle-4.9-bin.zip\\n"
	@printf "export PATH=$PATH:/opt/gradle/gradle-4.9/bin\\n"
	@printf "\"do \"echo 'export PATH=\$PATH:/opt/gradle/gradle-4.9/bin' >> .bashrc\" after installation please.\"\\n"

assemble:
	@gradle assemble

jflex:
	@gradle jflex

compileAll:
	@gradle compileAll

clean:
	@gradle clean

javadoc:
	@gradle javadoc

build:
	@gradle build

test:
	@gradle test

help:
	@gradle tasks --all
	@printf "\\nyou need to do - gradle <command> - to run an other command."