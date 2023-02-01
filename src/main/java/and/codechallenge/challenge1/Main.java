package and.codechallenge.challenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	
	private static final String CONT_C = "[CTRL+C]";
	private static final String CONT_V = "[CTRL+V]";
	private static final String CONT_X = "[CTRL+X]";
	
	public Main() throws FileNotFoundException {
		String output = readFile("src/main/java/and/codechallenge/challenge1/input.txt");
		
		String clipboard = "";
		
		
		while (output.contains(CONT_C) || output.contains(CONT_X) || output.contains(CONT_V)) {
			
			int c = output.indexOf(CONT_C);
			int x = output.indexOf(CONT_X);
			int v = output.indexOf(CONT_V);
			
			if (c == -1) c = Integer.MAX_VALUE;
			if (x == -1) x = Integer.MAX_VALUE;
			if (v == -1) v = Integer.MAX_VALUE;
			
			if (v < c && v < x) {
				output = output.substring(0, v)
						.concat(clipboard)
						.concat(output.substring(v + 8));
				continue;
			}
			
			clipboard = output.substring(0, c < x ? c : x);
			
			if (c < x) {
				output = clipboard.concat(output.substring(c + 8));
			} else {
				output = output.substring(x + 8);
			}
			
		}
		
		System.out.println(output);
	}
	
	private String readFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		
		Scanner scanner = new Scanner(file);
		List<String> lines = new ArrayList<>();
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if ("[".equals(line) || "]".equals(line))
				continue;
			
			line = line.trim().replace("\"","");
			
			lines.add(line);
		}
		
		return lines.stream().collect(Collectors.joining());
	}
	
	public static void main(String[] args) {
		try {
			new Main();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
