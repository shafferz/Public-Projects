import java.util.*;

class GMNCP{

	public static void main(String[] args){
	
	Scanner keyboard = new Scanner(System.in);

	boolean cont = true;

	do{

		playGame(keyboard); //plays the game

		cont = checkCont(keyboard); //checks to see if the user wants to continue

	}while(cont == true); //while continue boolean is true
	
	}//main

	public static void playGame (Scanner keyboard){
	
		int low = 1;
		int high = 100;
		int userResponse;
		int compGuess = (low+high)/2;
		int tries = 0;
		boolean computer = false;
		
		//prompt the user for the game
		System.out.println("Hello user! Pick a number between 1 and 100.");
		System.out.println("My first guess is " + compGuess + ". How did I do?");

		do{

			userResponse = keyboard.nextInt();

			if (userResponse == 1){high = ((low+high)/2)-1;} //if the guess was too high, the new high value will be set to one less than the average of low and high
			else if (userResponse == -1){low = ((high+low)/2)+1;} //if the guess was too high, the new low value will be set to one more than the average of low and high
			else if (userResponse == 0){computer = true;} 
			else {System.out.println("Enter -1 if I was too low, 0 if I was correct, or 1 if I was too high!");}//if the user doesn't enter -1, 0, or 1
			//the user will be told what to enter

			tries++;//add one to the tries, including when the computer gets it correct

			compGuess = (low+high)/2;//calculate the new computer guess

			compResponse(userResponse, compGuess, tries);//generate a computer response
		
		}while(computer == false);

		System.out.println("Your number was: " + compGuess + "."); //Since the loop only breaks when the computer wins,
		//print the victory message with the computer's guess
		
	}//playGame

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

	public static void compResponse(int response, int guess, int tries){

		System.out.println();//decorative spacer, also clears the line from the keyboard scanner
	
		if (response > 0){System.out.println("Gah! My guess was too high!");}
		else if (response < 0){System.out.println("Gah! My guess was too low!");}
		else if (response == 0){System.out.println("Mwahahaha! I got it in " + tries + " tries!");}
		else{System.out.println("Quit foolin' around!");}

		if (response != 0)//only if the computer is not correct will he state his "next guess"
			System.out.println("My next guess is " + guess + ". How did I do?");
	
	}

}//class
