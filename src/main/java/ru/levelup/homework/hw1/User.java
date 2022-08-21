package ru.levelup.homework.hw1;

import java.util.Objects;

public class User {
    //Поля у пользователей: логин, имя, возраст, количество накопленных бонусных баллов.

    private String login;
    private String name;
    private int age;
    private int balls;




    public User(String login, String name, int age, int balls) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.balls = balls;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balls=" + balls +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && balls == user.balls && login.equals(user.login) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, age, balls);
    }




    }