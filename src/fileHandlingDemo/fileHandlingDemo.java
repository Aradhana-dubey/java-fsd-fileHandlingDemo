package fileHandlingDemo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileHandlingDemo {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\dell\\eclipse-workspace\\Practice";
		create(filePath);

        writeToFile(filePath, "Hello, this is a file handling example.");
        

        readFromFile(filePath);
        writeToFile(filePath, "My Name is Aradhana Kumari.");
        readFromFile(filePath);
    }

	private static void create(String filePath) {
        try {
            
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write content to the file
            writer.write(content);

            System.out.println("Content successfully written to the file.");

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read each line from the file and print it
            System.out.println("Reading content from the file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
		

	}

}
