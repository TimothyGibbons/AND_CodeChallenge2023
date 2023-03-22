package and.codechallenge.challenge3;

import and.codechallenge.challenge3.consolecolour.Background;
import and.codechallenge.challenge3.consolecolour.Colour;
import and.codechallenge.challenge3.consolecolour.Colours;
import and.codechallenge.challenge3.consolecolour.Format;
import org.junit.jupiter.api.Test;

import static and.codechallenge.challenge3.consolecolour.Colours.*;
import static org.junit.jupiter.api.Assertions.*;

class ColoursTest {

    @Test
    void testGetUnicodeStringParams() {
        assertEquals("\u001b[30m", Colours.getUnicodeStringParams(BLACK));
        assertEquals("\u001b[1;30m", Colours.getUnicodeStringParams(BOLD, BLACK));
        assertEquals("\u001b[1;30;42m", Colours.getUnicodeStringParams(BOLD, BLACK, GREEN_BACKGROUND));
        assertEquals("\u001b[4;30;42m", Colours.getUnicodeStringParams(UNDERLINE, BLACK, GREEN_BACKGROUND));
        assertEquals("\u001b[4;1;30;42m", Colours.getUnicodeStringParams(UNDERLINE, BOLD, BLACK, GREEN_BACKGROUND));
        assertEquals("\u001b[1;4;30;42m", Colours.getUnicodeStringParams(BOLD, UNDERLINE, BLACK, GREEN_BACKGROUND));
    }

    @Test
    void getUnicodeString() {
        Colours colours = new Colours();
        assertEquals("\u001b[30m", colours.getUnicodeString(Colour.BLACK));
        assertEquals("\u001b[1;30m", colours.getUnicodeString(Colour.BLACK, Format.BOLD));
        assertEquals("\u001b[46;30m", colours.getUnicodeString(Colour.BLACK, Background.CYAN));
        assertEquals("\u001b[1;46;30m", colours.getUnicodeString(Colour.BLACK, Background.CYAN, Format.BOLD));
        assertEquals("\u001b[1;4;46;30m", colours.getUnicodeString(Colour.BLACK, Background.CYAN, Format.BOLD, Format.UNDERLINE));
    }

    @Test
    void getUnicodeStringRGB() {
        Colours colours = new Colours();
        assertEquals("\u001b[38;2;2;55;66m", colours.getUnicodeTextRGB(2, 55, 66));
        assertEquals("\u001b[1;38;2;2;55;66m", colours.getUnicodeTextRGB(2, 55, 66, Format.BOLD));
        assertEquals("\u001b[4;38;2;2;55;66m", colours.getUnicodeTextRGB(2, 55, 66, Format.UNDERLINE));
        assertEquals("\u001b[1;4;38;2;2;55;66m", colours.getUnicodeTextRGB(2, 55, 66, Format.BOLD, Format.UNDERLINE));
    }

    @Test
    void test2() {

        System.out.println("Blank");
        System.out.println(Colours.getUnicodeStringParams(BOLD, WHITE) + "Testing" + RESET);
        System.out.println("Blank");
        System.out.println(Colours.getUnicodeStringParams(WHITE) + "Testing" + RESET);
        System.out.println("Blank");
        System.out.println(Colours.getUnicodeStringParams(BOLD, BLACK, GREEN_BACKGROUND) + "Testing" + RESET);
        System.out.println(Colours.getUnicodeStringParams(UNDERLINE, BLACK, GREEN_BACKGROUND) + "Testing" + RESET);
        System.out.println(Colours.getUnicodeStringParams(UNDERLINE, BOLD, BLACK, GREEN_BACKGROUND) + "Testing" + RESET);
        System.out.println("Blank");
        System.out.println(new Colours().getUnicodeString(Colour.BLACK, Background.CYAN, Format.BOLD) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeString(Colour.BLACK, Background.CYAN, Format.BOLD) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeString(Colour.BLACK, Background.RED, Format.BOLD, Format.UNDERLINE) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeString(Colour.BLACK, Background.RED, Format.UNDERLINE) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeString(Colour.BLACK, Background.RED, Format.BOLD) + "Testing" + RESET);
        System.out.println("Blank");
        System.out.println(new Colours().getUnicodeTextRGB(2, 255, 66, Format.BOLD) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeTextRGB(100, 55, 66, Format.UNDERLINE) + "Testing" + RESET);
        System.out.println(new Colours().getUnicodeTextRGB(2, 55, 166, Format.BOLD, Format.UNDERLINE) + "Testing" + RESET);
        System.out.println("Blank");
    }
}