package and.codechallenge.challenge2.model;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Board {
	private static Board single_instance = null;
	
	private static final Integer DEFAULT_LEAD = 0;
	private static final Integer DEFAULT_WIDTH = 1;
	private static final Integer DEFAULT_START = DEFAULT_WIDTH / 2;
	
	private final String GRID_VALUE_B = "*";
	private final String GRID_VALUE_W = ".";
	
	private final Integer BLACK = 1;
	private final Integer WHITE = -1;
	private final String WEST = "<";
	private final String EAST = ">";
	private final String NORTH = "^";
	private final String SOUTH = "v";
	private final String PRINT_BUFFER = " ";
	private boolean gridLock = false;
	
	private Integer lead;
	private Integer width;
	
	private HashMap<String, Integer> grid = new HashMap<>();
	
	
	private Board() {
		lead = DEFAULT_LEAD;
		width = DEFAULT_WIDTH;
	}
	
	public static Board getInstance()
	{
		if (single_instance == null)
			single_instance = new Board();
		
		return single_instance;
	}
	
	public void start(Ant ant) {
		ant.setCoordinate(new Coordinate(DEFAULT_START, DEFAULT_START));
		grid.put(ant.getCoordinate().stringValue(), WHITE);
		gridLock = true;
	}
	
	public void move(Ant ant) {
		Coordinate oldCoordinate = ant.getCoordinate();
		
		String oldCoordinateValue = oldCoordinate.stringValue();
		
		if(grid.containsKey(oldCoordinateValue)) {
			int oldGridVal = grid.get(oldCoordinateValue);
			
			
			if(oldGridVal == WHITE)
				ant.rotate(90);
			else
				ant.rotate(-90);
			
			Coordinate newCoordinate = ant.moveAntInCurrentDirection();
			if(newCoordinate.getX() < lead || newCoordinate.getX() >= width
				|| newCoordinate.getY() < lead || newCoordinate.getY() >= width)
				expandGrid();
			
			// toggle old value
			grid.put(oldCoordinateValue, grid.get(oldCoordinateValue) * -1);
			
			
			// create entry for new ant location
			int newGridVal = WHITE;
			if(grid.containsKey(ant.getCoordinate().stringValue())) {
				newGridVal = grid.get(ant.getCoordinate().stringValue());
			}
			grid.put(ant.getCoordinate().stringValue(), newGridVal);
		}
	}
	
	
	private void expandGrid() {
		lead--;
		width++;
	}
	
	
	public void printBoardConsole(Ant ant) {
		
		IntStream.range(lead, width).forEach(i -> {
			IntStream.range(lead, width).forEach(j -> {
				String printVal = GRID_VALUE_W;
				Coordinate co = new Coordinate(j, i);
				
				if (grid.containsKey(co.stringValue()))
					printVal = getPrintVal(grid.get(co.stringValue()));
				
				if (ant.getCoordinate().equals(co))
					printVal = getAntPrintVal(ant);
				
				System.out.print(PRINT_BUFFER + printVal + PRINT_BUFFER);
				
			});
			System.out.println();
		});
	}
	
	private String getPrintVal(Integer value) {
		if (value == BLACK)
			return GRID_VALUE_B;
		
		return GRID_VALUE_W;
	}
	
	private String getAntPrintVal(Ant ant) {
		int direction = ant.getDirection();
		
		switch (direction) {
			case 180:
				return WEST;
			case 0:
				return EAST;
			case 90:
				return NORTH;
			case 270:
				return SOUTH;
			default:
				break;
		}
		return "   ";
	}
	
	public void setGrid(int value) {
		if (gridLock)
			throw new IllegalStateException("Langant has already started. Grid cannot be set at this time");
		
		this.width = value;
	}
}
