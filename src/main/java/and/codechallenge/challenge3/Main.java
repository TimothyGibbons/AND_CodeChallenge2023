package and.codechallenge.challenge3;

import and.codechallenge.challenge3.consolecolour.Colours;

import java.io.IOException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String BOLD = "\033[1;31m";
    public static final String UNDERLINE_RED = "\033[4;31m";
    public static final String UNDERLINE_GREEN = "\033[4;32m";
    public static final String UNDERLINE = "\033[4;";


    public Main() throws InterruptedException {
        System.out.println("Hello\u001b[32;1m World");
        System.out.println(Colours.BLUE_BACKGROUND_BRIGHT + Colours.RED+"Hello"+ Colours.CYAN+" World"+ Colours.RESET);
        System.out.println(Colours.BLUE_BACKGROUND_BRIGHT + Colours.RED+"Hel"+BOLD+"lo"+ Colours.CYAN+" Wo"+BOLD+"rld"+ Colours.RESET);
        System.out.println(UNDERLINE_GREEN+ "TEST" + Colours.RESET);

        String text = "Good Morning Vietnam";

//        print(text, 1000);


    }

    private void print(String output, int loopCount) {
        Utils utils = new Utils();
        String outputString = utils.extendString(output, 8, 4);
        for (int i = 0; i < 100; i++) {
            String printStr = utils.getViewString(outputString, output.length()+4, i, 8, 4);
            System.out.print("\b".repeat(printStr.length()));
            System.out.print(printStr);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new Main();
    }
}
