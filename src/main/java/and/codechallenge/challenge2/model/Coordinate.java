package and.codechallenge.challenge2.model;

import java.util.Objects;

public class Coordinate {
	protected Integer x;
	protected Integer y;
	
	
	public Coordinate(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	
	public Integer getX() {
		return x;
	}
	
	
	public void setX(Integer x) {
		this.x = x;
	}
	
	
	public Integer getY() {
		return y;
	}
	
	
	public void setY(Integer y) {
		this.y = y;
	}
	
	public String stringValue() {
		return getX() + "|" + getY();
	}
	
	
	@Override
	public String toString() {
		return "Coordinate{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Coordinate that = (Coordinate) o;
		return x.equals(that.x) && y.equals(that.y);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	@Override
	public Coordinate clone() {
		return new Coordinate(x, y);
	}
}
