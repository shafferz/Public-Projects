class lawnMower {

	private boolean collide = false;
	private boolean onGrass;
	private char squareOn = 'g';
	public static int y;
	public static int x;

	public lawnMower(int y, int x){
		//place lawn mower on grass and activate
		this.y = y;
		this.x = x;
		onGrass = true;

	}//generic constructor

	public boolean checkCollide(){return collide;}//checkCollide method

	public void detectObstacle(boolean o){

		if (o){
			collide = true;
		} else {
			collide = false;
		}//this represents checking in front of the machine for an obstacle

	}//detectObstacle method

	public boolean checkGrass(){return onGrass;}
	
	public void detectGrass(boolean g){
	
		if (g){
			onGrass = true;
		} else {
			onGrass = false;
		}//represents
	
	} //detectGrass method

	public void onSquare(char s){squareOn = s;}
	public char getSquare(){return squareOn;}

	public boolean cut(){
		detectGrass(squareOn == 'g');
		detectObstacle(squareOn == 'o');
		if(squareOn == 'g' || squareOn == 'x'){
			return true;
		} else {
			return false;
		}//if the mower is on grass, it will cut. Therefore, return true. Or the space is already cut, which is still a positive outcome. 
		//Otherwise, the square is an obstacle, and it will return false
	}//cut method

	public void setCoords(int y, int x){
		this.y = y;
		this.x = x;
	}//set the coordinates

}//class lawnMower
