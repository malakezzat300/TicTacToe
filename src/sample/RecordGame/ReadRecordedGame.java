package sample.RecordGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadRecordedGame {

    private final String directoryPath = "C:\\TicTacToe\\Records\\";

    public List<String> readRecord(String fileName) {
        List<String> recordedGames = new ArrayList<>();    // list to be fill and returned
        File fileToSearch = new File(fileName+".dat");

        try {
            File directoryToSearchIn = new File(directoryPath);
            File foundedFile = searchInDirectory(directoryToSearchIn, fileToSearch); // search for a file

            if (foundedFile != null) {
                try (BufferedReader reader = new BufferedReader(new FileReader(foundedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        recordedGames.add(line);   // add each record in the list
                    }
                }
            } else {
                System.out.println("File not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordedGames;
    }

    // search in directory
    public static File searchInDirectory(File directory, File fileToSearch) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileToSearch.getName())) {
                        return file;
                    }
                }
            }
        }
        return null;
    }




}
