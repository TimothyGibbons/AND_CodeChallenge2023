package and.codechallenge.challenge1;

public class Main {
	
	String input = "[\n"
			+ "  \"the big red[CTRL+C] fox jumps over [CTRL+V] lazy dog.\",\n"
			+ "  \"[CTRL+V]the tall oak tree towers over the lush green meadow.\",\n"
			+ "  \"the sun shines down[CTRL+C] on [CTRL+V][CTRL+C] the busy [CTRL+V].\",\n"
			+ "  \"[CTRL+V]the tall oak tree towers over the lush green meadow.\",\n"
			+ "  \"a majestic lion[CTRL+C] searches for [CTRL+V] in the tall grass.\",\n"
			+ "  \"the shimmering star[CTRL+X]Twinkling in the dark, [CTRL+V] shines bright.\",\n"
			+ "  \"[CTRL+X]a fluffy white cloud drifts [CTRL+V][CTRL+C] across the sky, [CTRL+V]\",\n"
			+ "]";
	
	private static final String CONT_C = "[CTRL+C]";
	private static final String CONT_V = "[CTRL+V]";
	private static final String CONT_X = "[CTRL+X]";
	
	public Main() {
		String output = input;
		while (output.contains(CONT_C)) {
		
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
