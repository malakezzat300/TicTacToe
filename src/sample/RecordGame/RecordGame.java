package sample.RecordGame;

import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecordGame {

    String directoryPath = "D:\\1-ITI STUDY\\TicTacToe\\src\\sample\\RecordGame\\Records";
    String fileName;
    List<String> recordedGame;

    public void saveRecords(List<String> recordedGame, String fileId) {
        fileName = fileId;
        this.recordedGame = recordedGame;
        Path filePath = Paths.get(directoryPath, fileName + ".txt"); // path of the file
        String ConvertedList = String.join(", ", recordedGame);   // convert list to String

        File directory = filePath.getParent().toFile();
        if (!directory.exists()) {
            directory.mkdirs(); // Create directories if they don't exist
        }
                                    // try with resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile(), true))) {
            writer.write(ConvertedList); // write the String
            writer.write("\n|"); // needed when read file
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    public static void main(String[] args) {

        RecordGame recordGame = new RecordGame(); // object of recordGame

        List tagroba = new ArrayList();
        tagroba.add("ahmed");
        tagroba.add("zezo");
        tagroba.add("lolo");

        recordGame.saveRecords(tagroba, "ahmed3"); // pass the JsonString and file Name
    }
}
