# Nut with Java parser

This program is a parser in Java language of a Nut file.

It can be used in an open source project.

## Organisation
 
This document deals with the organisation of work.
 
This project is separated in three parts : Lexer, Parser and Analyser.
 
For organisation :
 
- @Xavitator is the master of the Lexer and error files.
- @Elusyo is the master of the parser.
- @FauconFan is the master of the Analyzer.
 
Moreover, @Xavitator is the mediator of Nut-java project.

## Download

Download binaries and put them in the 'Nut-java' folder:
```
waiting for production
``` 

## Use

To use Nut, you need to import Nut-java library and use it.

### Analyzer
The main class is 'NutAnalyzer.java' and has following functions :

 - parse(String pathName), returns a Nut object
 - parse(String pathName, String wantedObjectModel), returns a Nut object and validate that the object in wantedIbjectModel is the same
 - parse(String pathName, String wantedObjectModel, String objectName), same as above, but we specify the object in case that there are multiple objects definitions in wantedObjectModel file
 - validate(String pathName, String wantedObjectModel) just validate, return true, false
 - validate(String pathName, String wantedObjectModel, String objectName) just validate, return true false

### Nut object
The parser creates a 'Nut.java' object corresponding to the Nut file. You just need to import 'Nut.java' file in your class to use it.

This object contains these functions :
 - getNutObject(String attribute) and it returns a 'Nut' object corresponding to the attribute string.
 - getNutArray(String attribute), returns an array of 'Nut' object corresponding to the attribute string.
 - getNutString(String attribute), returns a string value of the attribute string.
 - getNutBoolean(String attribute), returns a boolean value of the attribute string.
 - getNutNumber(String attribute), returns a integer value of the attribute string.

If you call one of these functions and it is not correspond to the attribute type in parameter, it throws an WrongTypeException.




 
