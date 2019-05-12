class Oval extends Round {

	private double major;
	private double minor;

	public Oval(double ma, double mn){
	
		major = ma;
		minor = mn;
	
	}//oval constructor

	public void calculatePerimeter(){
	
		double math = Math.sqrt((Math.pow(major, 2)+Math.pow(minor, 2))/2);
		//complex part of the oval perimeter equation
		double p = 2*getPi()*math;
		//simple part of the oval perimeter equation
		setPerimeter(p);
		//sets perimeter to calculated perimeter
	
	}//calculate perimeter

	public void calculateArea(){
	
		double a = getPi()*major*minor;
		//area equation of an oval
		setArea(a);
		//sets area to calculated area
	
	}//calculate area

}//oval sub-class of round
