package ru.levelup.j2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {



    @Test
    public void sum1() {
        if (Main.sum( 1, 2 ) != 3){
            fail("Сумма 1 и 2 должна быть 3");
        }
    }

    @Test
    public void sub1() {
        if (Main.sub( 5, 3 ) != 2){
            fail("Разность 5 и 3 должна быть 2");
        }

    }
}