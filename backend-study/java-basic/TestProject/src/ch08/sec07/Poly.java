package ch08.sec07;

public class Poly extends DrawingObject{
	
	public Poly() {
		penColor = "yellow";
	}

	@Override
	public void draw() {
		System.out.println(penColor + "색상으로 다각형 그리기");
		
	}
	
	

}
