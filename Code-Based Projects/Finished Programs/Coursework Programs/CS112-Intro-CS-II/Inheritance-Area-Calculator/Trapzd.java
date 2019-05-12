class Trapzd extends Quad {

	private double otherBase;
	private double side1;
	private double side2;

	public Trapzd (double w, double h, double b, double s1, double s2){
	
		setWidth(w);
		setHeight(h);
		otherBase = b;
		side1 = s1;
		side2 = s2;
	
	}//trapezoid constructor

	public void calculateArea(){
	
		double math1 = (getWidth()+otherBase)/2;
		//complex part of trapezoid area equation
		double math2 = getHeight()*math1;
		//simple part of trapezoid area equation

		setArea(math2);
		//set area to calculated area
	
	}//calculate area

	public void calculatePerimeter(){
	
		double p = getWidth()+otherBase+side1+side2;
		//calculate perimeter
		
		setPerimeter(p);
		//set perimeter to calculated perimeter
	
	}//calculate perimeter

}
