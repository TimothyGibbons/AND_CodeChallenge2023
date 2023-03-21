package and.codechallenge.challenge3.consolecolour;

public enum Format implements ConsoleText{
    REGULAR("0"),  // Regular text / reset all SGR effects to their default
    BOLD("1"),  // bold or increased intensity
    FAINT("2"),  // faint or decreased intensity
    UNDERLINE("4"),  // singly underlined
    BLINK("5");  // singly underlined

    private String code;

    Format(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
