package and.codechallenge.challenge3.consolecolour;

public enum Colour implements ConsoleText {
    BLACK("30"),   // BLACK
    RED("31"),     // RED
    GREEN("32"),   // GREEN
    YELLOW("33"),  // YELLOW
    BLUE("34"),    // BLUE
    PURPLE("35"),  // PURPLE
    CYAN("36"),    // CYAN
    WHITE("37"),   // WHITE
    BLACK_BRIGHT("90"),  // BLACK
    RED_BRIGHT("91"),    // RED
    GREEN_BRIGHT("92"),  // GREEN
    YELLOW_BRIGHT("93"), // YELLOW
    BLUE_BRIGHT("94"),   // BLUE
    PURPLE_BRIGHT("95"), // PURPLE
    CYAN_BRIGHT("96"),   // CYAN
    WHITE_BRIGHT("97");  // WHITE

    private String code;

    Colour(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}