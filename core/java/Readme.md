# Nut with Java parser

This program is a parser in Java language of a Nut file.

It can be used in an open source project.

## Download

Download binaries and put them in the 'Nut-java' folder:
```
waiting for production
``` 

## Use

### Parser
The main class is 'NutParser.java' and has following functions :

- parse(String pathName), returns a Nut object
- parse(String pathName, String wantedObjectModel), returns a Nut object and validate that the object in wantedIbjectModel is the same
- parse(String pathName, String wantedObjectModel, String objectName), same as above, but we specify the object in case that there are multiple objects definitions in wantedObjectModel file
- validate(String pathName, String wantedObjectModel) just validate, return true, false
- validate(String pathName, String wantedObjectModel, String objectName) just validate, return true false
- etc (ethnic and tyranic conception)

### Nut object
The parser creates a 'Nut' object corresponding to the Nut file. You just need to import 'Nut.java' file in your class to use it.

This object contains these functions :
- getNutObject(String attribute) and it returns a 'Nut' object corresponding to the attribute string.
- getNutArray(String attribute), returns an array of 'Nut' object corresponding to the attribute string.
- getNutString(String attribute), returns a string value of the attribute string.
- getNutBoolean(String attribute), returns a boolean value of the attribute string.
- getNutNumber(String attribute), returns a integer value of the attribute string.

If you call one of these function and it is not correspond to the attribute type in paramater, it throws an WrongTypeException.

## Write of parser

### Lexer
We will use Jflex to do the lexer. It will generate a minimum of token in the minimum of states (use of HashMap). 

Moreover, we need to do all that we can in the lexer to reduce the parser.

### Parser
The parsing step is composed of 4 classes :
- **Iota.java** for Iota-grammar
- **Omega.java** for Omega-grammar
- **Lambda.java** for Lambda-grammar 
- **NutParser.java**, the main class wich contains functions described in the Readme.md file.




 
