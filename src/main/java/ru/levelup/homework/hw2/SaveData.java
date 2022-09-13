package ru.levelup.homework.hw2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SaveData {
    public static void writeToFile(String fileName, List<Double>  results) throws IOException {
        Collections.sort(results);
        deleteFileifExists(fileName);
        writeResultsToFile(fileName, results);
    }

    private static void writeResultsToFile(String fileName, List<Double> results) throws IOException {
        for (double result : results) {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(String.valueOf(result));
            writer.write("\n");
            writer.close();
        }
    }

    private static void deleteFileifExists(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
