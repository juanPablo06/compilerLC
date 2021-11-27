public class SyntaxAnalyzer {
    private ES_File ES;
    private LexicalReg LR;
    private SymbolTable ST;
    private LexicalAnalyzer LA;

    private int currentToken;
    private String lexeme;  

    public SyntaxAnalyzer(){}

    public SyntaxAnalyzer(ES_File ES, SymbolTable ST, LexicalAnalyzer LA){
        this.ES = ES;
        this.ST = ST;
        this.LA = LA;

        this.LR = (LexicalReg) LA.getLR();
        this.currentToken = this.LR.getToken();
        this.lexeme = this.LR.getLexeme();

        if(this.currentToken == -1){
            new Error(Error.FILE_END_NOT_EXPECTED, LA.getLine());
        }

        this.program();

        if(this.currentToken != -1){
            new Error(Error.FILE_END_NOT_EXPECTED, LA.getLine());
        }
    }

    private void program(){
       while(this.currentToken == ST.getTokens('int') || 
            this.currentToken == ST.getTokens('final') || 
            this.currentToken == ST.getTokens('boolean') || 
            this.currentToken == ST.getTokens('byte') || 
            this.currentToken == ST.getTokens('final')){
            this.declaration();
        }

        this.block();
    }

    private void declaration() {
        
    }
}