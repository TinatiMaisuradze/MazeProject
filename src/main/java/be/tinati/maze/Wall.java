package be.tinati.maze;

public enum Wall {
	WALL("|","---"),
	NO(" ","   "),
	DOOR("D","-D-"),
	BREAKABLE("B","-B-"),
	FAKE ("F","-F-");
	private String horizontalVisualisation;
	private String verticalVisualisation;
	
	Wall(String horizontalVisualisation, String verticalVisualisation) {
		this.horizontalVisualisation = horizontalVisualisation;
		this.verticalVisualisation = verticalVisualisation;
	}
	
	public String getVerticalVisualisation() {
		return verticalVisualisation;
	}
	
	public String getHorizontalVisualisation() {
		return horizontalVisualisation;
	}
}
