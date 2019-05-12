/*
 * Zachary Shaffer
 * CompSci 250 - Algorithms
 * Eight Queens (really N-Queens) solution lab
 * 03/03/2016
 *
 */

class EightQueens {

	private static int solutions = 0; //solutions variable counter

	public static void main(String[] args) {

		int N = Integer.parseInt(args[0]); //take a number in the compiler as a value
		int[] board = new int[N]; //board is a single N-size array, will just print out the arrays N times to make NxN board

		placeQueens(0, board);

		System.out.println("Solutions found: " + solutions); //solutions variable print-out, at the end of everything

	}//main

	public static void placeQueens(int row, int[] board) {

		int col = board.length;

		if (row == col) {
			printBoard(board);
		} else {
			for(int i = 0; i < col; i++) {
				board[row] = i; //sets board[row] = i, this will tell printBoard where Queens are
				if(validQueen(board, row)) {
					placeQueens(row+1, board);
				}//if valid move, go deeper
				board[row] = 0; //resets the row such that Q will get replaced to find all solutions of N-Queens
			}//for loop

		}//if-else

	}//placeQueens method

	public static void printBoard(int[] board) {

		int col = board.length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i] == j) {
                	//recursive method is set up to set board[i] to
                	//the location of a queen in that column
                	System.out.print("Q ");
                }
                else {
                	System.out.print("- ");
				}//if-else
            }//inner for-loop
            System.out.println();
        }//outer for-loop
        System.out.println();

        solutions++; // every time a board is printed, the solution count gets incremented, because printBoard only gets called once per correct output

	}//printBoard

	public static boolean validQueen(int[] q, int n) {
        for (int i = 0; i < n; i++) {

            if (q[i] == q[n]) {
            	return false;
            }  //column checker
            if ((q[i] - q[n]) == (n - i)) {
            	return false;
            } //l-r diagonal checker
            if ((q[n] - q[i]) == (n - i)) {
            	return false;
            } //r-l diagonal checker
        }
        return true;
    }//validQueen method

}//class EightQueens
