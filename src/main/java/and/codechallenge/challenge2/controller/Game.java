package and.codechallenge.challenge2.controller;

import and.codechallenge.challenge2.model.Ant;
import and.codechallenge.challenge2.model.Board;
import and.codechallenge.challenge2.model.Coordinate;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class Game {
	
	private static Ant ant;
	private static Board board;
	
	public Game(Ant ant, Board board) {
		this.ant = ant;
		this.board = board;
	}
	
	public void start() {
		play(board.getRounds(), board.getStepsPerRound(), board.getDelay());
	}
	
	public void play(int rounds, int stepsPerRound, long delay) {
		Platform.runLater(() -> {
			int count = rounds;
			do {
				moveAnt();
				if (rounds%stepsPerRound == 0) {
					try {
//						board.printBoardConsole();
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}

				}
			} while (count-- >= 0);
		});
		
	}
	
	public void moveAnt() {
		
		if(board.getAntCurrentPane().getBackground() == board.WHITE) {
			ant.rotate(90);
			board.getAntCurrentPane().setBackground(board.BLACK);
		}
		else {
			ant.rotate(-90);
			board.getAntCurrentPane().setBackground(board.WHITE);
		}
		

		Coordinate newCoordinate = ant.moveAntInCurrentDirection();
		
		
		// Expand the grid if required
		if(newCoordinate.getX() < board.getEdge() || newCoordinate.getX() >= board.getGridSize().intValue()
				|| newCoordinate.getY() < board.getEdge() || newCoordinate.getY() >= board.getGridSize().intValue()) {
//			board.reset("UP", 5);
			return;
		}
		
		
		board.getAntCurrentPane().getChildren().remove(ant.getImageView());
		board.setAntCurrentPane(board.getGridPaneMap().get(newCoordinate.getX()).get(newCoordinate.getY()));
		board.getAntCurrentPane().getChildren().add(ant.getImageView());
		
	}
}
