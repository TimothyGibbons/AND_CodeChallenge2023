package and.codechallenge.challenge3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void breakString() {
        Utils utils = new Utils();
        assertEquals("llo", utils.getViewString("hello world", 13, 2, 3, 2));
        assertEquals("ll", utils.getViewString("hello world", 13, 2, 2, 2));
        assertEquals("ll", utils.getViewString("hello", 7, 2, 2, 2));
        assertEquals("llo    h", utils.getViewString("hello", 9, 2, 8, 4));
        assertEquals("    12  ", utils.getViewString("12", 6, 2, 8, 4));
        assertEquals("   1    ", utils.getViewString("1", 5, 2, 8, 4));
        assertEquals("    1   ", utils.getViewString("1", 5, 1, 8, 4));
        assertEquals("1    1  ", utils.getViewString("1", 5, 0, 8, 4));
        assertEquals("hello world    hello world    hello worl", utils.getViewString("hello world", 15, 0, 40, 4));

        assertEquals("Good Mor", utils.getViewString("Good Morning Vietnam", 24,0, 8, 4));
        assertEquals("ood Morn", utils.getViewString("Good Morning Vietnam", 24,1, 8, 4));
        assertEquals("od Morni", utils.getViewString("Good Morning Vietnam", 24,2, 8, 4));
        assertEquals("d Mornin", utils.getViewString("Good Morning Vietnam", 24,3, 8, 4));
        assertEquals(" Vietnam", utils.getViewString("Good Morning Vietnam", 24,12, 8, 4));
        assertEquals("    Good", utils.getViewString("Good Morning Vietnam", 24,20, 8, 4));
        assertEquals("tnam    ", utils.getViewString("Good Morning Vietnam", 24,40, 8, 4));
        assertEquals("nam    G", utils.getViewString("Good Morning Vietnam", 24,41, 8, 4));
        assertEquals("od Morni", utils.getViewString("Good Morning Vietnam", 24,50, 8, 4));
    }

    @Test
    void extendString() {
        Utils utils = new Utils();

        assertEquals("12345678    12345678    " , utils.extendString("12345678", 8, 4));
        assertEquals("1234567    1234567    " , utils.extendString("1234567", 8, 4));
        assertEquals("hello world    hello world    " , utils.extendString("hello world", 8, 4));
        assertEquals("hello world      hello world      " , utils.extendString("hello world", 12, 6));
        assertEquals("1  1  " , utils.extendString("1", 4, 2));
        assertEquals("1  1  1  1  " , utils.extendString("1", 10, 2));
    }


    @Test
    void testBold() {
        Utils utils = new Utils();

        assertEquals("Welcome on" , utils.getViewString(
                "Welcome on board this service to [B]London[/B]. " +
                        "Please have [U]all[/U] tickets and passes ready for inspection. " +
                        "This service is expected to depart [C:#00FF00]on time[/C]",
                100,
                0,
                10,
                4));

        assertEquals("to [B]Lond" , utils.getViewString(
                "Welcome on board this service to [B]London[/B]. " +
                        "Please have [U]all[/U] tickets and passes ready for inspection. " +
                        "This service is expected to depart [C:#00FF00]on time[/C]",
                100,
                30,
                10,
                4));
    }
}