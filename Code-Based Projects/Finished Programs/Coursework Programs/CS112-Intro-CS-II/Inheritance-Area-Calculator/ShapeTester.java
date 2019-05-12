public class ShapeTester {

    public static void main(String[] args) {

		System.out.println("\n\n");

		// LINE
		System.out.println("TESTING LINE SHAPE");
		System.out.println("------------------");

		// Line endpoints (x1,y1), (x2,y2), entered in that order.
		Line myLine = new Line(3, 6, 4, -2);

		// Calculate line area and perimeter.
		myLine.calculateArea();
		myLine.calculatePerimeter();

		// Run the functions to print the results.
		System.out.println("Line area = " + myLine.getArea());
		System.out.println("Line perimeter = " + myLine.getPerimeter());
		System.out.println();


		// OVAL
		System.out.println("TESTING OVAL SHAPE");
		System.out.println("------------------");

		// Oval constructor parameters are (major, minor)
		Oval myOval = new Oval(12, 6);

		// Calculate oval area and perimeter.
		myOval.calculateArea();
		myOval.calculatePerimeter();

		// Run the functions to print the results
		System.out.println("Oval area = " + myOval.getArea());
		System.out.println("Oval perimeter = " + myOval.getPerimeter());
		System.out.println();


		// CIRCLE
		System.out.println("TESTING CIRCLE SHAPE");
		System.out.println("--------------------");

		// Circle constructor only takes a radius parameter
		Circle myCircle = new Circle(3.14);

		// Run the functions to do the calculations
		myCircle.calculateArea();
		myCircle.calculatePerimeter();

		// Calculate circle area and perimeter.
		System.out.println("Circle area = " + myCircle.getArea());
		System.out.println("Circle perimeter = " + myCircle.getPerimeter());
		System.out.println();


		// RECT
		System.out.println("TESTING RECT SHAPE");
		System.out.println("------------------");

		// Rect constructor takes a width and height (order doesn't really matter)
		Rect myRect = new Rect(3, 14);

		// Calculate rectangle area and perimeter.
		myRect.calculateArea();
		myRect.calculatePerimeter();

		// Run the functions to print the results
		System.out.println("Rect area = " + myRect.getArea());
		System.out.println("Rect perimeter = " + myRect.getPerimeter());
		System.out.println();



		// TRAPZD
		System.out.println("TESTING TRAPZD SHAPE");
		System.out.println("--------------------");

		// Trapzd constructor order: base1, height, base2, side1, side2
		Trapzd myTrapzd = new Trapzd(5, 4, 3, 2, 1);

		// Calculate trapezoid area and perimeter.
		myTrapzd.calculateArea();
		myTrapzd.calculatePerimeter();

		// Run the functions to print the results
		System.out.println("Trapzd area = " + myTrapzd.getArea());
		System.out.println("Trapzd perimeter = " + myTrapzd.getPerimeter());
		System.out.println();


		// SQUARE
		System.out.println("TESTING SQUARE SHAPE");
		System.out.println("--------------------");

		// Square constructor only takes one side parameter
		Square mySquare = new Square(3.14);

		// Calculate square area and perimeter.
		mySquare.calculateArea();
		mySquare.calculatePerimeter();

		// Run the functions to print the results
		System.out.println("Square area = " + mySquare.getArea());
		System.out.println("Square perimeter = " + mySquare.getPerimeter());
		System.out.println();

    } //main

} //ShapeTester (class)
