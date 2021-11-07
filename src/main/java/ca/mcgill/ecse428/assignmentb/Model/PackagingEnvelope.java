package ca.mcgill.ecse428.assignmentb.Model;

public class PackagingEnvelope {
	private double width;
	private double height;
	private double weight;

	public PackagingEnvelope() {}

	public PackagingEnvelope(double width, double height, double weight) {
		this.width = width;
		this.height = height;
		this.weight = weight;

	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
