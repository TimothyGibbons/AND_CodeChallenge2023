package and.codechallenge.challenge3;

public class Utils {

    private static final String EMPTY_PLACEHOLDER = " ";
    public static final String BOLD = "[B]";
    public static final String BOLD_END = "[/B]";
    public static final String UNDERLINE = "[B]";
    public static final String UNDERLINE_END = "[/B]";
    public static final String COLOUR = "(\\[C:)?#?([A-Fa-f0-9]{6})(\\])?";
    public static final String COLOUR_END = "[/C]";

    public String getViewString(String string,
                                int breakPoint,
                                int offset,
                                int screenWidth,
                                int space) {
        if (string == null)
            throw new NullPointerException("Input value cannot be null");

//        String processed = processString(string);

        String retString = extendString(string, screenWidth, space);

        int newOffset = (offset > breakPoint) ?
                (offset % (string.length() + space)) : offset;

        return retString.substring(newOffset, newOffset+screenWidth);
    }

//    private String processString(String string) {
//
//    }

    public String extendString(String string,
                               int screenWidth,
                               int space) {
        String retString = "";

        do {
            retString += string + EMPTY_PLACEHOLDER.repeat(space) + string + EMPTY_PLACEHOLDER.repeat(space);
        }
        while (retString.length() < screenWidth+1);

        return retString;
    }

}
