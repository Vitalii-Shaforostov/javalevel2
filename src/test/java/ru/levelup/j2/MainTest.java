package ru.levelup.j2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

        assertEquals(2, Main.sub( 5, 3 ) );
  /*      if (Main.sub( 5, 3 ) != 2){
            fail("Разность 5 и 3 должна быть 2");
        }
*/

    }

    @Test
    public void userToJson() {
        User user = new User(123, "user1", Arrays.asList("admin", "moderator"));
        String json = Main.userToJson(user);
        String expected = "{\"id\":123,\"login\":\"user1\",\"roles\":[\"admin\",\"moderator\"]}";

    /*   if(!json.equals(expected)) {
            fail("Json format is not valid: expected = " + expected + ", actual = " + json);
        }
*/

      assertEquals(expected, json);

    }

    @Test
    public void jsonToUser() {
        String json = "{\"id\":113,\"login\":\"user2\",\"roles\":[\"admin\",\"creator\"]}";
        User user = Main.jsonToUser(json);

        User expected = new User (113, "user2", List.of("admin", "creator"));
        assertEquals(expected, user);

    }
}