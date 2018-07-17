#Write of this parser

##Lexer
We will use Jflex to do the lexer. It will generate a minimum of token in the minimum of states (use of HashMap). 

Moreover, we need to do all that we can in the lexer to reduce the parser.

##Parser
The parsing step is composed of 4 classes :
- **Iota.java** for Iota-grammar
- **Omega.java** for Omega-grammar
- **Lambda.java** for Lambda-grammar 
- **NutParser.java**, the main class wich contains functions described in the Readme.md file.

