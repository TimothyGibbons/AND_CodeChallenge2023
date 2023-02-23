package and.codechallenge.challenge2;

import and.codechallenge.challenge2.model.Ant;
import and.codechallenge.challenge2.model.Board;

public class Main {
	
	
	private Main () throws InterruptedException {
		Ant ant = Ant.getInstance();
		Board board = Board.getInstance();
		board.start(ant);
		
		int rounds = 10800;
		
		
//		board.printBoard(ant);
		do {
			
//			System.out.println("\n\n\n\n\n\n\n\n");
			board.move(ant);
//			board.printBoard(ant);
			
			
//			Thread.sleep(500);
		} while (rounds-- > 0);
		board.printBoardConsole(ant);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Main();
	}
}