package ru.levelup.homework.hw1;

import java.io.*;


public class File {

    public static void readAndWrite(String fileName) throws IOException {
        java.io.File file = new java.io.File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            ru.levelup.homework.hw1.User user = new User(lineSplit(line)[0], lineSplit(line)[1], Integer.parseInt(lineSplit(line)[2]), Integer.parseInt(lineSplit(line)[3]));
            String json = User.userToJson(user);
            System.out.println(json);
            File.write("./usersToJSON.txt", json);
        }
        br.close();
        fr.close();

    }

    private static String[] lineSplit(String line) {
        //System.out.println(Integer.parseInt(splittedUser[2]));
        return line.split(",");
    }
    public static void write(String fileName, String user) throws IOException {

       // File file = new File(fileName);
        FileWriter writer = new FileWriter(fileName, true);

        writer.write(user);
        writer.write("\n");
        writer.close();

    }
}

