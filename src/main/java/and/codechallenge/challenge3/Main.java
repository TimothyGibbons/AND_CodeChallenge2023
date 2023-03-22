package and.codechallenge.challenge3;

import and.codechallenge.challenge3.consolecolour.Colours;

import java.io.IOException;

public class Main {

    private static final int SPACE = 4;
    
    public Main() throws InterruptedException {
        String text = "Good Morning Vietnam";
    
        scroll(text, 8, 100, 1000);
        
    }

    private void scroll(String output, int screenWidth, long sleep, int loopCount) {
        Utils utils = new Utils();
        
        for (int i = 0; i < loopCount; i++) {
            String printStr = utils.getViewString(output, i, screenWidth, SPACE);
            System.out.print("\b".repeat(printStr.length()));
            System.out.print(printStr);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new Main();
    }
}


//The quick brown fox jumped over the lazy dog    The quick brown fox jumped over the lazy dog
//       |        |