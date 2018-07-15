################################################
# Makefile pour le générateur de test pour nut #
#           © Heijix - Année 2018              #
################################################


# Variables
FLAG_1 = -sourcepath
FLAG_2 = -d
JC = javac
JVM = java
BIN = binary
DOC = docs
SOURCE = src/
FILES = 10
START = 1


##############
# Indication #
#############

# Affichage indicatif
all: 
	@echo "Pour créer la javadoc : make docs"
	@echo "\\n"
	@echo "Pour générer [\e[1;34mn\e[0m] fichiers tests d'erreurs dont la numérotation commence par [\e[1;34mp\e[0m] : make error_file FILES=[\e[1;34mn\e[0m] START=[\e[1;34mp\e[0m]"
	@echo "Pour générer [\e[1;34mn\e[0m] ficheirs tests positifs dont la numérotation commence par [\e[1;34mp\e[0m]  : make good_file FILES=[\e[1;34mn\e[0m] START=[\e[1;34mp\e[0m]"
	@echo "Par défaut, FILES=10 et START=1"
	@echo "\\n"
	@echo "Pour supprimer les binaires et la documentation : make clear"

###############
# Compilation #
##############

#Compilation unique
compile: 
			@echo ''Création des binaires''
			@mkdir -p $(BIN)
			@echo -e "[\e[1;34mEn cours\e[0m] Compilation"
			@$(JC) $(FLAG_1) $(SOURCE) -d $(BIN) $(SOURCE)**/*.java $(SOURCE)*.java
			@echo -e "[\e[1;32mOK\e[0m] Compilation finie"

#################
# Lancement jeu #
#################

# Lancement avec compilation si besoin
error_file: clear_binary compile
			@clear
			@$(JVM) -cp $(BIN) Main 0 $(FILES) $(START)


good_file: clear_binary compile
			@clear
			@$(JVM) -cp $(BIN) Main 1 $(FILES) $(START)


#################
# Documentation #
#################

# créer la doc
docs:
			@clear
			@echo "Création de la documentation"
			-@javadoc -charset utf8 -author -d $(DOC) -Xdoclint:none -sourcepath $(SOURCE) $(SOURCE)**/*.java $(SOURCE)*.java  $(SOURCE)**/**/*.java 2>/dev/null 1>/dev/null
			@echo -e "[\e[1;32mOK\e[0m] Création documentation dans \e[1;35mdocs/\e[0m"


#########
# Clear #
#########

clear: clear_binary clear_doc
# Vider les binaires
ifeq ($(shell test -e binary && echo yes),yes)
clear_binary:
		@rm -Rf $(BIN) 
		@echo -e "[\e[1;32mOK\e[0m] Binaires supprimés"
else
clear_binary:
	@echo "Aucun binaire à supprimer"
endif

# Supprimer la doc
ifeq ($(shell test -e docs && echo yes),yes)
clear_doc:
		@rm -Rf $(DOC) 
		@echo -e "[\e[1;32mOK\e[0m] Documentation supprimée"
else
clear_doc:
	@echo "Aucune doc à supprimer"
endif