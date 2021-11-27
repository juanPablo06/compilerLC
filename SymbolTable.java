import java.util.HashTable;
import java.util.Enumeration;

public class SymbolTable {
    private final int MAX_SIZE = 256;
    private LexicalReg LR;

    private HashTable<String, Integer> hash;

    private String[][] symbolTable;

    public symbolTable() {
        hash = new HashTable<String, Integer>(MAX_SIZE);
        this.loadSymbolTable();
    }

    public void loadSymbolTable() {
        this.symbolTable = new String[][]{
            {"1", "id"},
            {"2", "const"},
            {"3", "final"},
            {"4", "int"}, 
            {"5", "byte"},
            {"6", "string"},
            {"7", "while"},
            {"8", "if"}, 
            {"9", "else"},
            {"10", "and"}, 
            {"11", "or"}, 
            {"12", "not"}, 
            {"13", "--"}, 
            {"14", "-"},
            {"15", "("},
            {"16", ")"},
            {"17", "<"},
            {"18", ">"},
            {"19", "<>"},
            {"20", ">="},
            {"21", "<="},
            {"22", ","},
            {"23", "+"},
            {"24", "-"},
            {"25", "*"},
            {"26", "/"},
            {"27", ";"},
            {"28", "begin"},
            {"29", "end"},
            {"30", "readln"},
            {"31", "write"},
            {"32", "writeln"},
            {"2", "true"}, 
            {"2", "false"}, 
            {"35", "boolean"}
        };
    for(int i = 0; i < symbolTable.length; i++) {
        LR =  new LexicalReg(
            Integer.parseInt(symbolTable[i][0]),
            symbolTable[i][1]
        );
        this.insertSymbol(symbolTable[i][1], LR);
        }
    }

    public LexicalReg insertSymbol(String lexeme, LexicalReg LR) {
        hash.put(lexeme, LR.getToken());
        return LR;
    }

    public LexicalReg getSymbol(String lexeme) {
        return hash.get(lexeme);
    }

    public int getTokens(String lexeme) {
        return ((LexicalReg) hash.get(lexeme)).getToken();
    }

    public String getLexeme(int token) {
        return ((LexicalReg) hash.get(token)).getLexeme();
    }

    public void displayHash() {
        if (!hash.isEmpty()) {
            System.out.println("\nSymbol Table:");
            for (Enumeration e = hash.keys(); e.hasMoreElements();) {
                LexicalReg LR = (LexicalReg) hash.get(e.nextElement());
                System.out.println(LR.getToken() + " " + LR.getLexeme());
            }
        } else {
            System.out.println("\nSymbol Table is empty.");
        }
    }

    @Override
    public String toString() {
        String symbolTab = "The table has " + this.hash.size() + " entries.\n";
        for(int i = 0; i < symbolTable.length; i++) {
            symbolTab += symbolTable[i][0] + " " + symbolTable[i][1] + "\n";
        }
        return symbolTab;
    }
}