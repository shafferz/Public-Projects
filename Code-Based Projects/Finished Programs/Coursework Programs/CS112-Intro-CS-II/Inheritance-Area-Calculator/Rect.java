class Rect extends Quad {

	public Rect(double wd, double ht){
	
		setWidth(wd);
		setHeight(ht);
	
	}//rect constructor

	public void calculateArea(){
	
		double wide = getWidth();
		double high = getHeight();

		setArea(wide*high);
		//area is width * height
	
	}//calculate area

	public void calculatePerimeter(){
	
		double w = getWidth();
		double h = getHeight();

		setPerimeter((2*(w+h)));
		//perimeter is 2 * quantity of width plus height
	
	}//calculate perimeter

}//rect sub-class of quad
