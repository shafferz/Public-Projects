import java.util.Random;

class reflex {

	public static void main(String[] args){
	
		char[][] field = new char[10][10];

		populate(field);
		printField(field);
		//first it creates a field to mow, and then prints it

		mowLawn(field);
	
	}//main method

	private static void populate(char[][] f){
		//this method populates an array with characters 'g' or 'o'
		//where 'g' represents grass and 'o' represents an obstacle
		//this method generates the Environment for the agent
		for(int i = 0; i < f.length; i++){
			for(int j = 0; j < f[i].length; j++){

				Random gen = new Random();
				int rand = gen.nextInt(10);

				if(rand > 0){
					f[i][j] = 'g';
				} else {
					f[i][j] = 'o';
				}//populate

				//this randomly populates the array with either grass (g) or an obstacle (o)
				//the random number generator chooses a number between 0-10, excluding 10,
				//and thus any given spot has a 10% chance of generating an obstacle

			}//inner for
		}//outer for

	}//populate method

	private static void printField(char[][] f){
	
		for(int i = 0; i < f.length; i++){
			for(int j = 0; j < f[i].length; j++){
				System.out.print(f[i][j]);
			}
			System.out.println();
		}//print the 2d array
	
	}//printField method

	private static void mowLawn(char[][] f){

		double initPerMowed = calculatePercent('x', f);
		double initPerObstacle = calculatePercent('o', f);
		double initPerGrass = calculatePercent('g', f);

		System.out.println("\n" + 100*initPerMowed + "% of the lawn is already mowed.");
		System.out.println("\n" + 100*initPerObstacle + "% of the lawn has an obstacle.");
		System.out.println("\n" + 100*initPerGrass + "% of the lawn is still grassy.\n");

		//TODO: Mowing Method, and recalculate percentages, and generate margin of error
		mow(f);
		System.out.println();
		printField(f);

		double endPerMowed = calculatePercent('x', f);
		double endPerObstacle = calculatePercent('o', f);
		double endPerGrass = calculatePercent('g', f);

		System.out.println("\n" + 100*endPerMowed + "% of the lawn is mowed.");
		System.out.println("\n" + 100*endPerObstacle + "% of the lawn is still an obstacle.");
		System.out.println("\n" + 100*endPerGrass + "% of the lawn is still grassy.");

		System.out.println("\n" + endPerGrass + " = Margin of Error!");

	}//agent for mowing the lawn

	private static double calculatePercent(char a, char[][] f){
		//calculates what percentage of a two dimmensional array (f) is made up of a character (a)
		int total = 0;
		int ctr = 0;
		for(int i = 0; i < f.length; i++){
			for(int j = 0; j < f[i].length; j++){
				total++;
				char x = f[i][j];
				if(x == a){ctr++;}
			}//inner loop
		}//outer loop
		
		double per = ((double)ctr/total);
		return per;
	}//calculatePercent

	private static void mow(char[][] f){
		//method to actually perform the mowing
		//this method represents the reflexive agent's process
		int endy = (f.length-1);
			//variable for the last row of the 2d array
		int endx = (f[endy].length-1);
			//variable for the last column of the last row of the 2d array
		int curx = 0;
		int cury = 0;
			//current x and y coordinates, always starting at the beginning (0,0)
		int ctr = 0;

		lawnMower lawnmower = new lawnMower(cury, curx);

		for(int i = cury; i <= endy; i++){
			for(int j = curx; j <= endx; j++){
				char location = f[i][j];
				lawnmower.onSquare(location);
				boolean tryCut = lawnmower.cut();
				if(tryCut){
					//successfully able to cut the space
					f[i][j] = 'x';
				} else {
					//unable to cut the space due to obstacle
					System.out.println("Encountered obstacle at (" + i + ", " + j + ")!");
				}//if-else to determine whether the square can be cut or not
			}//inner for
		}//outer for
			
		}//mow method
	
}//class
