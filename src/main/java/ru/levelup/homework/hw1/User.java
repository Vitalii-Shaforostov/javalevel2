package ru.levelup.homework.hw1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

public class User {
    //Поля у пользователей: логин, имя, возраст, количество накопленных бонусных баллов.

    private String login;
    private String name;
    private int age;
    private int bonus;




    public User(String login, String name, int age, int bonus) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bonus=" + bonus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && bonus == user.bonus && login.equals(user.login) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, bonus);
    }


        private static Gson gson = new GsonBuilder().create();

        // Serializatoin
        public static String userToJson(ru.levelup.homework.hw1.User user){
            return gson.toJson(user);
        }


    }