class Square extends Rect{

	public Square(double w) {super(w, w);}//square constructor

	public void calculateArea(){
	
		double a = Math.pow(getWidth(), 2);
		//area of a square is any side squared
	
		setArea(a);
		//set area to calculated area 
	
	}//calculate area

	public void calculatePerimeter(){
	
		double p = 4*getWidth();
		//perimeter of a square is 4* a side
		
		setPerimeter(p);
		//set perimeter to calculated perimeter
	
	}//calculate perimeter

}//square subclass of Rect
