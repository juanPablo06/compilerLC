public class LC {

    public static void main(String[] args) {
    
        args[0] = "exemplo.lc";
        args[1] = "exemplo.asm";

    if(new ES_File().checkFileOpening(args[0])) {
           new Error(Error.FILE_NOT_FOUND);
    } else {
        new Compiler(args[0], args[1]);
        System.out.println("Compilado com sucesso!");
    }
}