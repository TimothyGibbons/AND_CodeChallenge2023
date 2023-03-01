package and.codechallenge.challenge2.model;

import java.util.HashMap;
import java.util.stream.IntStream;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Board {
	private static Board single_instance = null;
	
	private static final Integer DEFAULT_LEAD = 0;
	private static final Integer DEFAULT_WIDTH = 5;
	private static final Integer DEFAULT_START = DEFAULT_WIDTH / 2;
	
	private final String GRID_VALUE_B = "*";
	private final String GRID_VALUE_W = ".";
	
	public final Integer BLACK_VAL = 1;
	public final Integer WHITE_VAL = -1;
	private final String WEST = "<";
	private final String EAST = ">";
	private final String NORTH = "^";
	private final String SOUTH = "v";
	private final String PRINT_BUFFER = " ";
	
	
	public final Background BLACK = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
	public final Background WHITE = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
	
	private Integer leadingEdgeValue;
	private IntegerProperty gridSize;
	
	private HashMap<String, Integer> grid = new HashMap<>();
	private HashMap<Integer, HashMap<Integer, StackPane>> gridPaneMap = new HashMap<>();
	
	private static Ant ant;
	
	private int rounds;
	private int stepsPerRound;
	private long delay;
	
	private StackPane antCurrentPane;
	
	
	private Board() {
		this.ant = Ant.getInstance();
		leadingEdgeValue = DEFAULT_LEAD;
		this.gridSize = new SimpleIntegerProperty(DEFAULT_WIDTH);
		ant.setCoordinate(new Coordinate(DEFAULT_WIDTH/2, DEFAULT_WIDTH/2));
		setGridMap(this.gridSize.get());
	}
	
	public static Board getInstance()
	{
		if (single_instance == null)
			single_instance = new Board();
		
		return single_instance;
	}
	
	public void setup(int gridSize, int rounds, int stepsPerRound, long delay) {
		setGridSize(gridSize);
		setRounds(rounds);
		setStepsPerRound(stepsPerRound);
		setDelay(delay);
		
		setGridMap(gridSize);
	}
	
	
	private void setGridMap(int gridSize) {
		gridPaneMap = new HashMap<>();
		for (int i = 0; i < gridSize; i++) {
			HashMap<Integer, StackPane> row = new HashMap<>();
			for (int j = 0; j < gridSize; j++) {
				StackPane node = new StackPane();
				node.setBackground(WHITE);
				
				if(i == ant.getCoordinate().getX() && j == ant.getCoordinate().getY()) {
					antCurrentPane = node;
				}
				
				row.put(j, node);
			}
			gridPaneMap.put(i, row);
		}
	}
	
	public void reset(String direction, int gridSize) {
		setup(gridSize, rounds, stepsPerRound, delay);
		ant.setCoordinate(new Coordinate(DEFAULT_START, DEFAULT_START));
		ant.setDirection(direction);
	}
	
	
//	public void expandGrid() {
//		leadingEdgeValue--;
//
//		// First row
//		for (int i = 0; i < gridSize.getValue(); i++) {
//			StackPane node = new StackPane();
//			node.setBackground(WHITE);
//			node.setBorder(Border.stroke(Paint.valueOf("#111111")));
//
//			HashMap<Integer, StackPane> row = new HashMap<>();
//			row.put(i, node);
//			gridPaneMap.put(leadingEdgeValue, row);
//		}
//
//		// last row
//		for (int i = 0; i < gridSize.getValue(); i++) {
//			StackPane node = new StackPane();
//			node.setBorder(Border.stroke(Paint.valueOf("#111111")));
//
//			HashMap<Integer, StackPane> row = new HashMap<>();
//			row.put(i, node);
//			gridPaneMap.put(gridSize.getValue(), row);
//		}
//
//		// first column
//		for (int i = 1; i < gridSize.getValue()-1; i++) {
//			StackPane node = new StackPane();
//			node.setBorder(Border.stroke(Paint.valueOf("#111111")));
//
//			HashMap<Integer, StackPane> row = new HashMap<>();
//			row.put(leadingEdgeValue, node);
//			gridPaneMap.put(i, row);
//		}
//
//		// last column
//		for (int i = 1; i < gridSize.getValue()-1; i++) {
//			StackPane node = new StackPane();
//			node.setBorder(Border.stroke(Paint.valueOf("#111111")));
//
//			HashMap<Integer, StackPane> row = new HashMap<>();
//			row.put(gridSize.getValue(), node);
//			gridPaneMap.put(i, row);
//		}
//		gridSize.setValue(gridPaneMap.size());
//	}
	
	
	public void printBoardConsole() {
		System.out.println("\n");
		
		IntStream.range(leadingEdgeValue, gridSize.intValue()).forEach(i -> {
			IntStream.range(leadingEdgeValue, gridSize.intValue()).forEach(j -> {
				String printVal = GRID_VALUE_W;
				Coordinate co = new Coordinate(j, i);
				
				if (grid.containsKey(co.stringValue()))
					printVal = getPrintVal(grid.get(co.stringValue()));
				
				if (ant.getCoordinate().equals(co))
					printVal = getAntPrintVal();
				
				System.out.print(PRINT_BUFFER + printVal + PRINT_BUFFER);
				
			});
			System.out.println();
		});
	}
	
	private String getPrintVal(Integer value) {
		if (value == BLACK_VAL)
			return GRID_VALUE_B;
		
		return GRID_VALUE_W;
	}
	
	private String getAntPrintVal() {
		int direction = ant.getDirection();
		
		switch (direction) {
			case 0:
				return NORTH;
			case 90:
				return EAST;
			case 180:
				return SOUTH;
			case 270:
				return WEST;
			default:
				break;
		}
		return "   ";
	}
	
	public HashMap<String, Integer> getGrid() {
		return grid;
	}
	
	public IntegerProperty getGridSize() {
		return gridSize;
	}
	
	public void setGridSize(int gridSize) throws IllegalStateException{
		if (gridSize < 1)
			gridSize = 1;
		
		ant.setCoordinate(new Coordinate(gridSize/2, gridSize/2));
		setGridMap(gridSize);
		
		this.gridSize.setValue(gridSize);
	}
	
	public void setRounds(int rounds) {
		if (rounds < 0)
			rounds = 10;
		this.rounds = rounds;
	}
	
	public void setStepsPerRound(int stepsPerRound) {
		if (stepsPerRound < 0)
			stepsPerRound = 1;
		this.stepsPerRound = stepsPerRound;
	}
	
	private void setDelay(long delay) {
		if (delay < 0L)
			delay = 1000L;
		this.delay = delay;
	}
	
	
	public Coordinate placeAnt() {
		int value = this.gridSize.intValue();
		return new Coordinate(value/2, value/2);
	}
	
	
	public HashMap<Integer, HashMap<Integer, StackPane>> getGridPaneMap() {
		return gridPaneMap;
	}
	
	public StackPane getAntCurrentPane() {
		return antCurrentPane;
	}
	
	public void setAntCurrentPane(StackPane antCurrentPane) {
		this.antCurrentPane = antCurrentPane;
	}
	
	
	public int getRounds() {
		return rounds;
	}
	
	
	public int getStepsPerRound() {
		return stepsPerRound;
	}
	
	
	public long getDelay() {
		return delay;
	}
	
	
	public Integer getEdge() {
		return leadingEdgeValue;
	}
}
