class Circle extends Round {

	private double radius;

	public Circle (double r){radius = r;}

	public void calculatePerimeter(){
	
		double perim = 2*getPi()*radius;
		//circle perimeter equation
		setPerimeter(perim);
		//set perimeter to calculated perimeter
	
	}//calculate perimeter

	public void calculateArea(){
	
		double a = Math.pow(radius, 2)*getPi();
		//circle area equation
		setArea(a);
		//set area to calculated area
	
	}//calculate area

}//circle sub-class of Round
