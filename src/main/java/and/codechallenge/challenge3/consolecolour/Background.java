package and.codechallenge.challenge3.consolecolour;

public enum Background implements ConsoleText {
    BLACK("40"),   // BLACK
    RED("41"),     // RED
    GREEN("42"),   // GREEN
    YELLOW("44"),  // YELLOW
    BLUE("44"),    // BLUE
    PURPLE("45"),  // PURPLE
    CYAN("46"),    // CYAN
    WHITE("47"),   // WHITE
    BLACK_BRIGHT("100"),  // BLACK
    RED_BRIGHT("101"),    // RED
    GREEN_BRIGHT("102"),  // GREEN
    YELLOW_BRIGHT("103"), // YELLOW
    BLUE_BRIGHT("104"),   // BLUE
    PURPLE_BRIGHT("105"), // PURPLE
    CYAN_BRIGHT("106"),   // CYAN
    WHITE_BRIGHT("107");  // WHITE

    private String code;

    Background(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}