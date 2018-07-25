# Java implementation of Nut language
## Lexer

Its purpose is to check all words in the Nut document, i.e if a word that is not known by the program is written, it throws an error.

It throws a max of Token to the Parser, and if it is needed, it throws directly an exception.

The Lexer has to ignore all comment blocks : they begin by "\#".

This is a table of tokens which contain following symbol :

### Standard tokens :

| Symbols       | Examples      |
| :-----------: |:-------------:|
| STRING_VALUE  | "helloWord42" |
| NAME          | R24           |
| NUMBER        | -42           |
| FLOAT_NUMBER  | 0.45          |
| BOOLEAN_VALUE | true          |
| EOF           | \<\<EOF\>\>   |


We need recognize :
- a negative number with "-" 
- a positive with or whithout "+" before
- a float number which can be positive and negative with "."

Tokens contained these symbols have a value. Following classes conrespond to these tokens :

- StringToken
- NameToken
- NumberToken
- FloatToken
- BooleanToken

Other symbols are in a simple token (name of the class : Token).
### Iota Grammar :

| Symbols       | Examples      |
| :-----------:|:-------------:|
| IMPORT       |   import      |

### Lambda Grammar :

| Symbols       | Examples      |
| :------------:|:-------------:|
| NULL          | null          |
| STRING        | string        |
| BOOLEAN       | boolean       |
| LIST          | list          |
| INT8          | int8          |
| INT16         | int16         |
| INT32         | int32         |
| INT64         | int64         |
| UINT8         | uint8         |
| UINT16        | uint16        |
| UINT32        | uint32        |
| UINT64        | uint64        |
| FLOAT         | float         |
| ALIAS         | Alias         |
| DATA          | Data          |
| COLON_EQUAL   | :=            |
| L_ANGLE_BRACE | \<             |
| R_ANGLE_BRACE | \>             |
| COMMA         | ,             |
| COLON         | :             |
| DASH          | -             |
| EQUAL         | =             |

### Omega Grammar :

| Symbols       | Examples      |
| :------------:|:-------------:|
| REF_ACCESS    | *[            |
| REF_DEFINE    | &[            |
| L_SQ_BRACE    | [             |
| R_SQ_BRACE    | ]             |
| L_BRACE       | {             |
| R_BRACE       | }             |
| EXP_MARKER    | E ou e        |
| ROOT          | @             |

I believe that this part could be done by @xavitator. 

## Parser

The parsing step is composed of 3 classes :
 - **Iota.java** for Iota-grammar
 - **Omega.java** for Omega-grammar
 - **Lambda.java** for Lambda-grammar 

The parser needs to follow the following grammar.

Symbols are represented by capital letters, states are represented by '_' before the name of the state, and terminal states are represented by tiny letters.
Moreover, 'None' representes nothing (none).

```
##### Iota grammar #####

_Iota -> 
        | IMPORT STRING _Iota
        | None
        




##### Lambda grammar #####

_Lambda ->
        | _Alias _Lambda
        | _Data _Lambda
        | None 
        
_Alias ->
        | ALIAS NAME COLON_EQUAL _Type
        
_Type ->
        | NAME
        | LIST _Generic
        | STRING
        | BOOLEAN
        | INT8
        | INT16
        | INT32
        | INT64
        | UINT8
        | UINT16
        | UINT32
        | UINT64
        | FLOAT

_Generic ->
        | L_ANGLE_BRACE _Type _NextType R_ANGLE_BRACE
        | None
        
_NextType ->
        | _NextTypeComma
        | _NextTypeSpace
  
_NextTypeComma ->
        | COMMA _Type _NextTypeComma
        | None
        
_NextTypeSpace ->
        | _Type _NextTypeSpace
        | None  
            
_Data ->
        | DATA NAME COLON_EQUAL _MemberType

_MemberType ->
        | DASH _Type COLON NAME _DefaultContent _MemberTypeNext
        
_DefaultContent -> 
        | EQUAL _Value
        | None

_MemberTypeNext ->
         | _MemberType
         | None
   
   
   
   
         
##### Omega Grammar #####

_Value -> 
        | STRING_VALUE
        | BOOLEAN_VALUE
        | _ValueExtension
        | _Number
        
_ValueExtension ->
        | REF_ACCESS NAME R_SQ_BRACE
        | _Object
        | _Array
        | NULL
        
_Object ->
        | _ObjectIdentifier L_BRACE _ObjectContent R_BRACE

_ObjectIdentifier ->
        | _Type
        | None
        
_ObjectContent ->
        | _Pair _Members
        | None 

_Pair ->
        | _Key COLON _Value

_Key ->
        | STRING_VALUE
        | NAME

_Members ->
        | _MembersComma
        | _MembersSpace

_MembersComma ->
        | COMMA _Pair _MembersComma
        | None

_MembersSpace ->
        | _Pair _MembersSpace
        | None

_Array ->
        | L_SQ_BRACE _ArrayContent R_SQ_BRACE

_ArrayContent ->
        | _Value _ArrayContentNext
        | None
       
_ArrayContentNext ->
        | _ArrayContentComma
        | _ArrayContentSpace
        
_ArrayContentComma ->
        | COMMA _Value _ArrayContentComma
        | None
      
_ArrayContentSpace ->
        | _Value _ArrayContentSpace   
        | None     

_Number ->
        | NUMBER _Exp
        | FLOAT_NUMBER _Exp

_Exp ->
        | EXP_MARKER NUMBER
        | None
        
_Root ->
        | _DataIdentifier _ValueExtension
        
_DataIdentifier ->
        | REF_DEFINE NAME R_SQ_BRACE
        | ROOT
        | None
```

In this part, if there is an error/exception, we throw it directly.

## Analyser

The analyser need to verify following constraints :

- all variables wich called exist
- there is only one root object
- manage all imports (conflict problems, etc)
- repetition of variables/alias/data
- Need return a 'Nut' object

## Error

Here is a table of all exceptions thrown :

| Key Code | Warning | Error Meaning  |
|:--------:|:-------:|:---------------|
| L0       | ✘       | EOF is encountered too early in the file |
| L1       | ✘       | Control Command Character is not allowed in a Nut File |
| L2       | ✘       | Any explicit Unicode Character need to be followed by 4 hexadecimal characters in [0-9] or [a-f] or [A-F] |
| L3       | ✘       | Unexpected Character, match nothing in the grammar|
| C1       | ✘       | Imported files, contains only imports and Data types definitions|
| C2       | ✘       | All Data Types created has to start with a uppercase character|
| C3       | ✘       | You cannot define a Data Type, with a Data Type that is not defined yet|
| C4       | ✘       | Data Types cannot be defined recursively|
| C5       | ✘       | We cannot overwrite a Data Type already defined in imported file|
| C6       | ✘       | The default value has to respect the Type in Data Type Definition|
| B1       | ✘       | Root Object has to be set explicitly with '@', and all objects that remains in the root scope need a alias id|
| B2       | ✘       | You need to implement all members of the object you want to create|
| B3       | ✘       | You cannot add fields in the object, because it doesn't exist in the Data Type Definition of the object you want to create. |
| B4       | ✔       | An alias is never used |
| B5       | ✘       | An alias already exist, choose another one |
