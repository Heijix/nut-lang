import javax.print.attribute.standard.PrinterLocation;

public class Main{

    public static void main(String[] args){
        int typeFile = 0; 
        int numberOfFiles = 0; 
        int startNameFiles = 0;
        try {
            typeFile = Integer.parseInt(args[0]);
        } 
        catch (Exception e) {
            System.out.println("Le type de fichier demandé doit être un entier : 0 pour error_files et 1 pour good_files");
            System.exit(1);
        }
        try {
            numberOfFiles = Integer.parseInt(args[1]);    
        } 
        catch (Exception e) {
            System.out.println("FILES doit être un entier.");
            System.exit(1);
        }
        try {
            startNameFiles = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("START doit être un entier.");
            System.exit(1);
        }
        Generator generator = new Generator(typeFile);
        for (int i = 0; i < numberOfFiles; i++) {
            generator.createNewFile(startNameFiles+i);
        }
    }

}