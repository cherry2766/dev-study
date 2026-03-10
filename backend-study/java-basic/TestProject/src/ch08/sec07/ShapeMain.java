package ch08.sec07;

public class ShapeMain {

	public static void main(String[] args) {
		DrawingObject[] shapes = { 
				new Line(), 
				new Circle(), 
				new Rect(), 
				new Poly(), };

		for (DrawingObject shape : shapes) {
			shape.draw();
		}

	}

}
