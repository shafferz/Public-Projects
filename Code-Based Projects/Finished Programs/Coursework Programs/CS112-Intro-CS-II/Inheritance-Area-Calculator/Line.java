class Line extends Shape {

	private double x1;
	private double x2;
	private double y1;
	private double y2;

	public Line (double xi, double yi, double xii, double yii){
		
		x1 = xi;
		x2 = xii;
		y1 = yi;
		y2 = yii;
	
	}//Line constructor

	public void calculateArea(){setArea(0.0);}//area of a line is always 0

	public void calculatePerimeter(){

		double math1 = Math.pow((x2-x1),2);
		//quantity of the differences of x, squared
		double math2 = Math.pow((y2-y1),2);
		//quantity of the differences of y, squared
		double math3 = Math.sqrt(math1+math2);
		//square root of the sum of the previous squared quantities
		double math4 = 2*math3;
		//twice the distance calculated in math step 3	    

		setPerimeter(math4);
	    //set perimeter to calculated perimeter
	}

}//Line sub-class of Shape
