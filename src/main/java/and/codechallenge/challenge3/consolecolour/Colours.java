package and.codechallenge.challenge3.consolecolour;

import java.util.Arrays;

/**
 * Some common SGR parameters are shown below:
 *
 * Parameter	Effect
 * 0	reset all SGR effects to their default
 * 1	bold or increased intensity
 * 2	faint or decreased intensity
 * 4	singly underlined
 * 5	slow blink
 * 30-37	foreground color (8 colors)
 * 38;5;x	foreground color (256 colors, non-standard)
 * 38;2;r;g;b	foreground color (RGB, non-standard)
 * 40-47	background color (8 colors)
 * 48;5;x	background color (256 colors, non-standard)
 * 48;2;r;g;b	background color (RGB, non-standard)
 * 90-97	bright foreground color (non-standard)
 * 100-107	bright background color (non-standard)
 * The 8 actual colors within the ranges (30-37, 40-47, 90-97, 100-107) are defined by the ANSI standard as follows:
 *
 * Last Digit	Color
 * 0	black
 * 1	red
 * 2	green
 * 3	yellow
 * 4	blue
 * 5	magenta
 * 6	cyan
 * 7	white
 */
public class Colours {
    // CSI
    private static final String CSI = "[";

    // ESC character
//    private static final String OCTAL = "\033";  // Octal
    private static final String UNICODE = "\u001b";  // Unicode

    // Reset
    public static final String RESET = "\u001b[0m";;  // Unicode reset
    public static final String OCTAL_RESET = "\033[0m";  // Octal reset
    public static final String UNICODE_RESET = "\u001b[0m";;  // Unicode reset

    // Final Byte
    public static final String FINAL_BYTE = "m";

    // Parameters
    // Text Styling
    public static final String REGULAR = "0";  // Regular text / reset all SGR effects to their default
    public static final String BOLD = "1";  // bold or increased intensity
    public static final String FAINT = "2";  // faint or decreased intensity
    public static final String UNDERLINE = "4";  // singly underlined
    public static final String BLINK = "5";  // singly underlined

    // Regular Colors
    public static final String BLACK = "30";   // BLACK
    public static final String RED = "31";     // RED
    public static final String GREEN = "32";   // GREEN
    public static final String YELLOW = "33";  // YELLOW
    public static final String BLUE = "34";    // BLUE
    public static final String PURPLE = "35";  // PURPLE
    public static final String CYAN = "36";    // CYAN
    public static final String WHITE = "37";   // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "90";  // BLACK
    public static final String RED_BRIGHT = "91";    // RED
    public static final String GREEN_BRIGHT = "92";  // GREEN
    public static final String YELLOW_BRIGHT = "93"; // YELLOW
    public static final String BLUE_BRIGHT = "94";   // BLUE
    public static final String PURPLE_BRIGHT = "95"; // PURPLE
    public static final String CYAN_BRIGHT = "96";   // CYAN
    public static final String WHITE_BRIGHT = "97";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "40";  // BLACK
    public static final String RED_BACKGROUND = "41";    // RED
    public static final String GREEN_BACKGROUND = "42";  // GREEN
    public static final String YELLOW_BACKGROUND = "43"; // YELLOW
    public static final String BLUE_BACKGROUND = "44";   // BLUE
    public static final String PURPLE_BACKGROUND = "45"; // PURPLE
    public static final String CYAN_BACKGROUND = "46";   // CYAN
    public static final String WHITE_BACKGROUND = "47";  // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "100";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "101";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "102";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "103";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "104";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "105"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "106";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "107";   // WHITE


    public static String getUnicodeStringParams(String ... params) {
        return UNICODE + CSI + Arrays.stream(params).reduce((c1, c2) -> c1 + ";" + c2).get() + FINAL_BYTE;
    }
    
    public String getUnicodeString(Format ... format) {
        return getUnicodeString(null, null, format);
    }
    public String getUnicodeString(Colour colour, Format ... format) {
        return getUnicodeString(colour, null, format);
    }

    public String getUnicodeString(Colour colour, Background background, Format ... format) {
        String concat = Arrays.stream(format).map(f -> f.getCode()).reduce((f1, f2) -> f1 + ";" + f2).orElse("");

        concat += nvlString(background);
        concat += nvlString(colour);

        if (concat.startsWith(";"))
            concat = concat.substring(1);

        return UNICODE + CSI + concat + FINAL_BYTE;
    }

    public String getUnicodeTextRGB(int r, int g, int b, Format ... format) {
        String string = Arrays.stream(format).map(f -> f.getCode()).reduce((f1, f2) -> f1 + ";" + f2).orElse("");

        string += ";38;2;"+r+";"+g+";"+b;

        if (string.startsWith(";"))
            string = string.substring(1);

        return UNICODE + CSI + string + FINAL_BYTE;
    }

    private String nvlString(ConsoleText consoleText) {
        if (consoleText == null)
            return "";
        return ";" + consoleText.getCode();
    }
}