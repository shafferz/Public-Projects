public class Student implements Comparable{

	private String grade;
	private String name;
	private String disability;
	private double credits;
	private String prevHall;
	private int prevRoomDraw;
	private int drawNum;
	private int minNum;
	private int maxNum;
	//variables

	public Student(String a, String b, String c, String d, String e, String f){
		grade = a;
		name = b;
		disability = c;
		credits = Double.parseDouble(d);
		prevHall = e;
		prevRoomDraw = Integer.parseInt(f);
		drawNum = 0;
		minNum = 0;
		maxNum = 0;
	}//constructor (specific)

	public Student(){
		grade = null;
		name = null;
		disability = null;
		credits = 0;
		prevHall = null;
		prevRoomDraw = 0;
		drawNum = 0;
		minNum = 1;
		maxNum = 0;
	}//constructor (default)

    public String getGrade() {
        return grade;
    }

    public void setGrade(String g) {
        grade = g;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String d) {
        disability = d;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double c) {
        credits = c;
    }

    public String getPrevHall() {
        return prevHall;
    }

    public void setPrevHall(String p) {
        prevHall = p;
    }

    public int getPrevRoomDraw() {
        return prevRoomDraw;
    }

    public void setPrevRoomDraw(int p) {
        prevRoomDraw = p;
    }

    public int getDrawNum() {
        return drawNum;
    }

    public void setDrawNum(int d) {
        drawNum = d;
    }

    public int getMin() {
        return minNum;
    }

    public void setMin(int m) {
        minNum = m;
    }

    public int getMax() {
        return maxNum;
    }

    public void setMax(int m) {
        maxNum = m;
    }

    @Override 
    public int compareTo(Object comp) {
    	int compare=((Student)comp).getDrawNum();
        return (this.drawNum-compare);
    }

    public String toString() {
    	String str = name;
	str += " ";
	str += Integer.toString(drawNum);
	str += " (";
	str += Integer.toString((prevRoomDraw-drawNum)*-1);
	str += ")";
	return str;
    }

}//class
