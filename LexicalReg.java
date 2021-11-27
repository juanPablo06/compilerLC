public class LexicalReg{
    private int token
    private String lexeme

    private int type;
    private int classe;
    private int address;

    public LexicalReg(){
        this.token = 0
        this.lexeme = ""
    }

    public LexicalReg(int token, String lexeme){
        this.token = token;
        this.lexeme = lexeme;
    }

    public int getToken(){
        return this.token;
    }

    public void setToken(int token){
        this.token = token;
    }

    public String getLexeme(){
        return this.lexeme;
    }

    public void setLexeme(String lexeme){
        this.lexeme = lexeme;
    }

    @Override
    public String toString(){
        return "Token: " + this.token + " Lexeme: " + this.lexeme;
    }
}