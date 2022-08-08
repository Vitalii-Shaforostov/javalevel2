package ru.levelup;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void sum1() {
        if (Main.sum( 1, 2 ) != 3){
            fail("Суммка 1 и 2 должна быть 3");
        }
    }
}