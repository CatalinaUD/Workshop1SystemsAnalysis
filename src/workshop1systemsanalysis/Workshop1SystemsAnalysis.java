package workshop1systemsanalysis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Catalina
 */
public class Workshop1SystemsAnalysis {
    private static final String DATABASE_NAME = "database.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int DATABASE_MIN_SIZE = 1000;
        final int DATABASE_MAX_SIZE = 2000000;
        int database_size = getRandomNumber(DATABASE_MIN_SIZE, DATABASE_MAX_SIZE);
        System.out.println("Creating database with " + database_size + " lines.");        
        buildDB(database_size);  
        System.out.println("Database created.");
    }  
    
    private static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(min, max + 1);
    }
    
    private static void buildDB(int dbSize) {        
        final int SEQUENCE_MIN_SIZE = 5;
        final int SEQUENCE_MAX_SIZE = 100;
        final String[] bases = {"A", "C", "G", "T"};
        try {
            FileWriter writer = new FileWriter(DATABASE_NAME);
            for (int i = 0; i < dbSize; i++) {
                int sequenceSize = getRandomNumber(SEQUENCE_MIN_SIZE, SEQUENCE_MAX_SIZE);
                String sequence = "";
                for (int j = 0; j < sequenceSize; j++) {
                    sequence += bases[getRandomNumber(0, bases.length - 1)];                    
                }
                writer.write(sequence + "\n");
            }   
            writer.close();
        } catch (IOException e) {
           System.out.println("Error while building the database");
        }
    }
}

