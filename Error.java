import java.util.file;

public class Error {
    private int line;
    private String message;
    private String lexeme;

    public final String ERROR_FILE_NOT_FOUND = "File not found";
    public final String ERROR_READ_FILE = "Error reading file";
    public final String ERROR_OPEN_FILE = "Error opening file";

    public final String ERROR_LA_TOKEN_UNRECOGNIZED = "Token unrecognized";

    public final String ERROR_TOKEN_NOT_EXPECTED = "Token not expected";

    public Error() {}

    public Error(String message) {
        this.message = message;
        System.out.println(this.message);
        System.exit(0);
    }

    public Error(String message, int line) {
        this.message = message;
        this.line = line;
        System.out.println(this.message + " at line " + this.line);
        System.exit(0);
    }

    public Error(String message, String lexeme, int line) {
        this.message = message;
        this.lexeme = lexeme;
        this.line = line;

        System.out.println(this.message + " at line " + this.line + ": " + this.lexeme);
        System.exit(0);
    }

    @Override
    public String toString() {
        return this.message;
    }
}

