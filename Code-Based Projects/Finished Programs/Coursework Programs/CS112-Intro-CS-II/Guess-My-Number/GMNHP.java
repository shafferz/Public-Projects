import java.util.*; //Import all of java's utilities, includes Random and Scanner

class GMNHP{

	public static void main(String[] args){

		Scanner keyboard = new Scanner(System.in);
	
		boolean cont = true;

		while(cont == true){
		
			playGame(keyboard); //plays the game

			cont = checkCont(keyboard); //checks if the user wants to keep playing
			
		}//play game while cont is true, cont is if player wants to continue playing

	}

	public static void playGame(Scanner keyboard){

		Random gen = new Random();
		
		boolean correct = false;
		int compNum;
		int playerGuess;
		int tries = 0;

		//prompt the user for the game
		System.out.println("Hello user! I'm thinking of a number between 1 and 100.");
		System.out.println("See if you can guess it!");
		System.out.println();

		compNum = gen.nextInt(100)+1; //Generate's the computer's number to be guessed, between 1 and 100

		do{
			
			System.out.print("Your guess: ");
			playerGuess = keyboard.nextInt();
			
			correct = checkGuess(playerGuess, compNum);
			//check for correctness

			tries++;//adds 1 try to the tries count, including the correct try

		}while(correct == false);//while the user is not correct, the game will continue to prompt the user for guesses

		System.out.println();
		System.out.println("Correct! You got it in " + tries + " tries!");

		
	}//playGame

	public static boolean checkGuess(int pG, int cN){
	
		if (pG > cN){System.out.println("Your guess was too high!");} //if the players guess was higher than the generated computer guess
		else if (pG < cN){System.out.println("Your guess was too low!");} //if the players guess was lower
		else{return true;}//if the players guess was exactly correct, return true

		return false;//return false by default
	
	}//checkGuess

	public static boolean checkCont(Scanner keyboard){
	
		char yn;

		System.out.println();
		System.out.print("Would you like to play again (y/n)?: ");

		yn = keyboard.next().charAt(0);//take the string the user enters, reading only the char at the first position (0)

		if (yn == 'y') {return true;} //if the first char of the user's entered string was a y, play again (true)
		else if (yn == 'n') {return false;} //if the first char of the user's entered string was an n, don't play again (false)
		else {System.out.println("That wasn't a 'y' or an 'n'! I don't wanna play with you anymore!");} //if the user is a jerk, the default will be to not play anymore

		return false;
	
	}//checkCont
	

}//class
