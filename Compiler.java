public class Compiler {

    private ES_File ES; // Instance of the ES_File class
    private SymbolTable ST;
    private LexicalAnalyzer LA;
    private SyntaxAnalyzer SA;
    private Otimizer OT;

    public Compiler() {}

    public Compiler(String inputFile, String outputFile) {

        ES = new ES_File();// Create an instance of the ES_File class
        
        ES.openInputFile(inputFile); // Open the input file
        ES.openOutputFile(outputFile); // Open the output file

        ST = new SymbolTable();
        LA = new LexicalAnalyzer(ES, ST);

        SA =  new SyntaxAnalyzer(LA, ST, ES); 

        OT = new Otimizer(LA, ST, ES);
    }
}