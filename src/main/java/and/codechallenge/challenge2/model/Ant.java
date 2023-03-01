package and.codechallenge.challenge2.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ant {
	
	private static Ant single_instance = null;
	private Coordinate coordinate;
	
	private Integer direction;
	
	private ImageView imageView;
	
	private Image image;
	
	private Ant(){
		this.direction = 0;
		this.image = new Image(getClass().getResourceAsStream("ant.png"), 200, 200, true, true);
		this.imageView = new ImageView(this.image);
	}
	
	public static Ant getInstance() {
		if (single_instance == null)
			single_instance = new Ant();
		
		return single_instance;
	}
	
	public Integer getDirection() {
		return direction;
	}
	
	public Image getImage() {
		return image;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
	
	public void setDirection(Integer direction) {
		if (direction == 360)
			this.direction = 0;
		else if (direction == -90)
			this.direction = 270;
		else
			this.direction = direction;
		
		imageView.rotateProperty().setValue(this.direction);
	}
	
	public void setDirection(String direction) {
		switch (direction) {
			case "RIGHT":
				this.direction = 90;
				break;
			case "DOWN":
				this.direction = 180;
				break;
			case "LEFT":
				this.direction = 270;
				break;
			default: // "UP"
				this.direction = 0;
				break;
		}
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate moveAntInCurrentDirection(){
		switch (direction) {
			case 0:
				coordinate.y--;
				break;
			case 90:
				coordinate.x++;
				break;
			case 180:
				coordinate.y++;
				break;
			case 270:
				coordinate.x--;
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
