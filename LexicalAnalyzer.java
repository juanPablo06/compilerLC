public class LexicalAnalyzer{

    private ES_File ES;
    private SymbolTable ST;
    private Compiler compiler;

    private String lexeme;
    private int caracter, line, actualState, finalState, lexemSize;
    private char[] validChars;


    public LexicalAnalyzer(){}

    public LexicalAnalyzer(ES_File ES, SymbolTable ST){
        this.ES = ES;
        this.ST = ST;
        
        line = 1;

        this.LR = new LexicalReg();

        this.validChars =  new caracter[] { ' ', '_', '.', ',', ';', '(', ')', '/', '*', '+', '>', '<', '=', 
        '-', '{', '}', '[', ']', ':', '"', '\n', '\t', '\r' };

    }

    public LexicalReg getLR(){
        this.RL =  null;
        lexeme = "";
        actualState = 0; 
        finalState = 14;
        lexemSize = 0;

        do {
            caracter = ES.readByte();

            if (this.validChars(caracter)) {
                switch (actualState) {
                    case 0:

                        if (caracter == ' ' || caracter == '\n' || caracter == '\t' || caracter == '\r') {
                            actualState = 0;
                            if (caracter == '\n') {
                                line++;
                            }
                        }

                        else if(Character.isLetter(caracter) || caracter == '_'){
                            lexeme += (char) caracter;
                            lexemSize = 1;
                            actualState = 1;
                        }

                        else if (Character.isDigit(caracter) && caracter != '0') {
                            lexeme += (char) caracter;
                            lexemSize = 1;
                            actualState = 2;
                        }

                        else if (caracter == '0') {
                            lexeme += (char) caracter;
                            lexemSize = 1;
                            actualState = 3;
                        }

                        else if (caracter == '"') {
                            actualState = 6;
                        }

                        else if(caracter == '{') {
                            actualState = 13;
                        }

                        else if(caracter == '(' || caracter == ')' || caracter == '[' || caracter == ']' || caracter == ';' || caracter == ',' || caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '>' || caracter == '<' || caracter == '=' || caracter == ':') {
                            lexeme += (char) caracter;
                            LR =  (LexicalReg) ST.getSymbol(lexeme);
                            if(LR == null) {
                                LR = ST.insertSymbol(lexeme, new LexicalReg(ST.getTokens(lexeme), lexeme, line));
                            
                            actualState = finalState;
                            }
                        }

                        else if(caracter == -1) {
                            LR =  (LexicalReg) ST.getSymbol("EOF");
                            actualState = finalState;
                        }

                        else (caracter != -1) {
                            new Error(Error.LEXICAL_ERROR, line, caracter);
                        }

                        break;

                        1:21:17
             }  
}