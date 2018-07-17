.phony: all gradle clean assemble javadoc build test help

all:
	@printf "this project depends of gradle-4.9. you need to have it.\\n"
	@printf "make gradle - download and setup gradle-4.9\\n\\n"
	@printf "make assemble - assembles the outputs of this project.\\n"
	@printf "make clean - deletes the build directory.\\n"
	@printf "make javadoc - generates javadoc api documentation for the main source code.\\n"
	@printf "make build - assembles and tests this project.\\n"
	@printf "make test - runs the unit tests.\\n"
	@printf "make help - to have more information.\\n"

gradle:
	@sudo -s
	@wget https://services.gradle.org/distributions/gradle-4.9-bin.zip
	@mkdir /opt/gradle
	@unzip -d /opt/gradle gradle-4.9-bin.zip
	@export path=$path:/opt/gradle/gradle-4.9/bin
	@printf "do \"echo 'export PATH=\$PATH:/opt/gradle/gradle-4.9/bin' >> .bashrc\" after installation please."
	@exit

assemble:
	@gradle assemble

clean:
	@gradle clean

javadoc:
	@gradle javadoc

build:
	@gradle build

test:
	@gradle test

help:
	@gradle tasks
	@printf "\\nyou need to do - gradle <command> - to run an other command."