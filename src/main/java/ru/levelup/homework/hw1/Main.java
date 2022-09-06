package ru.levelup.homework.hw1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.levelup.j2.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "./Users.csv";
        ReadFile.readFile(fileName);



}
    private static Gson gson = new GsonBuilder().create();
    // Serializatoin
    public static String userToJson(User user){
        return gson.toJson(user);
    }

    // Deserialization
    public static User jsonToUser(String message){
        return gson.fromJson(message, User.class);
    }
}




