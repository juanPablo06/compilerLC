import java.io.RandomAccessFile;

public class ES_File{
    private String nameInputFile;
    private String nameOutputFile;
    private RandomAccessFile inputFile;
    private RandomAccessFile outputFile;


    public ES_File(){} // Constructor

    public void openInputFile(String inputFile) {
        this.nameInputFile = inputFile;
        try {
            this.inputFile = new RandomAccessFile(this.nameInputFile, "r");
        } catch (IOException e) {
            new Error(Error.ERROR_OPEN_FILE);
        }      
    }

    public void openOutputFile(String outputFile) {
        this.nameOutputFile = outputFile;
        try {
            this.outputFile = new RandomAccessFile(this.nameOutputFile, "wb");
        } catch (Exception e) {
            new Error(Error.ERROR_OPEN_FILE);
        }
    }

    public int readByte() {
        int caracter = 0;

        try {
            caracter = this.inputFile.read();
        } catch (Exception e) {
            caracter = -1;
            new Error(Error.ERROR_READ_FILE);
        }

        return caracter;
    }

    public String readLines() {
        String line = "";
        try {
            line = this.inputFile.read();
        } catch (Exception e) {
            new Error(Error.ERROR_READ_FILE);
        }
        return line;
    }

    public boolean checkFileOpening(String inputFile){
        File file;
        boolean error = true;

        try {
            file = new File(inputFile);
            error = file.exists();
        } catch (IOException e) {
            new Error(Error.ERROR_OPEN_FILE);
        }

        return error;
    }

    public void returns(int position) {
        try {
            if(this.inputFile.getFilePointer() > 0) {
                this.inputFile.seek(this.inputFile.getFilePointer() + position);
            }
        } catch (IOException e) {
            new Error(Error.ERROR_INPUT_FILE_POINTER);
        }
    }

    @Override
    public String toString() {
        return "ES_File{" +
                "nameInputFile='" + nameInputFile + '\'' +
                ", nameOutputFile='" + nameOutputFile + '\'' +
                ", inputFile=" + inputFile +
                ", outputFile=" + outputFile +
                '}';
    }
}