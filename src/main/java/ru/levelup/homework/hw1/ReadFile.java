package ru.levelup.homework.hw1;

import ru.levelup.j2.Main;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public static void readFile(String fileName) throws IOException {
        java.io.File file = new java.io.File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            ru.levelup.homework.hw1.User user = new User(lineSplit(line)[0], lineSplit(line)[1], Integer.parseInt(lineSplit(line)[2]), Integer.parseInt(lineSplit(line)[3]));
            String json = User.userToJson(user);
            System.out.println(json);
            ReadFile.writeFile("./usersToJSON.txt", json);
        }
        br.close();
        fr.close();

    }

    private static String[] lineSplit(String line) {
        String[] splittedUser = line.split(",");
        //System.out.println(Integer.parseInt(splittedUser[2]));
        return splittedUser;
    }
    public static void writeFile(String fileName, String user) throws IOException {

        File file = new File(fileName);
        FileWriter writer = new FileWriter(fileName, true);

        writer.write(user);
        writer.write("\n");
        writer.close();

    }
}

