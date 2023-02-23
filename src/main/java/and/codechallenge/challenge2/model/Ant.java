package and.codechallenge.challenge2.model;

public class Ant {
	
	private static Ant single_instance = null;
	private Coordinate coordinate;
	
	private Integer direction;
	
	private Ant(){
		direction = 0;
	}
	
	public static Ant getInstance() {
		if (single_instance == null)
			single_instance = new Ant();
		
		return single_instance;
	}
	
	public Integer getDirection() {
		return direction;
	}
	
	public void setDirection(Integer direction) {
		if (direction == 360)
			this.direction = 0;
		else if (direction == -90)
			this.direction = 270;
		else
			this.direction = direction;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate moveAntInCurrentDirection(){
		switch (direction) {
			case 180:
				coordinate.x--;
				break;
			case 0:
				coordinate.x++;
				break;
			case 90:
				coordinate.y--;
				break;
			case 270:
				coordinate.y++;
				break;
			default:
				break;
		}
		return coordinate;
	}
	
	
	public void rotate(int rotateAngle) {
		setDirection(direction + rotateAngle);
	}
}
