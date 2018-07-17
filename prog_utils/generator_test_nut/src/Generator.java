import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class Generator {

    private int typeFiles;
    private String type;
    public final static int maxChar = 65535;
    public final static String folderPath = "test_files/";
    private FileWriter file = null;
    public static final Random random = new Random();
    public static final int doubleQuote_ascii = 34;
    public static final int simpleQuote_ascii = 39;
    public static final int backslash_ascii = 92;

    public Generator(int typeFiles){
        this.typeFiles = typeFiles;
        if(typeFiles = 0) type = "error";
        else type = "good";
    }

    /**
     * Tesy
     */
    public void createNewFile(int numberOfFiles) {
        try {
            File newFile = new File(this.folderPath + this.type + "_files/" + this.type + "_file" + numberOfFiles);
            newFile.createNewFile();
            this.file = new FileWriter(newFile);
            this.generateFile();
        } catch (Exception e) {
            System.out.println("Problème de localisation du dossier des fichiers test.");
            System.exit(1);
        }
    }

    public void generateFile() {
        
    }
}