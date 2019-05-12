import java.util.*; //linkedlists

class ArraySpeedTest{

	public static void main(String[] args){

		final int TESTS = 5;
		//number of tests we will run for each type
		//of string and at each value
		long temp1 = 0;
		long temp2 = 0;
		long temp3 = 0;

		findAddAvg(TESTS, temp1, temp2, temp3, 1000);
		findAddAvg(TESTS, temp1, temp2, temp3, 10000);
		findAddAvg(TESTS, temp1, temp2, temp3, 50000);
		findAddAvg(TESTS, temp1, temp2, temp3, 100000);

		findGetAvg(TESTS, temp1, temp2, temp3, 1000);
		findGetAvg(TESTS, temp1, temp2, temp3, 10000);
		findGetAvg(TESTS, temp1, temp2, temp3, 50000);
		findGetAvg(TESTS, temp1, temp2, temp3, 100000);

	}//main

	public static void findAddAvg(final int TESTS, long temp1, long temp2, long temp3, int val){
	
		double avgAr = 0;
		double avgLL = 0;
		double avgSL = 0;

		final int N = val;
	
		for (int a = 0; a < TESTS; a++){

		int[] ar = new int[N];

		long startAr = System.nanoTime();//start the clock
		for (int i = 0; i < N; i++){
			ar[i] = i;
		}//for i, populate the array

		long endAr = System.nanoTime();//end the clock
		long elapsedAr = endAr-startAr;
		
		temp1 += elapsedAr;

		LinkedList<Integer> myLL = new LinkedList<Integer>();
		long startLL = System.nanoTime();//start the clock
		for (int j = 0; j < N; j++){
			myLL.add(j);
		}//for j, populate the linked list

		long endLL = System.nanoTime();
		long elapsedLL = endLL-startLL;

		temp2 += elapsedLL;

		SinglyLinkedList mySL = new SinglyLinkedList();
		long startSL = System.nanoTime();//start the clock

		for (int k = 0; k < N; k++){
			mySL.add(k);
		}//for k, populate the singly linked list

		long endSL = System.nanoTime();
		long elapsedSL = endSL-startSL;

		temp3 += elapsedSL;

		}//for a, runs first test 5 times
		//gets average of the 5 run time tests
		//for adding 1000 "a"s to the strings

		avgAr = temp1/TESTS;
		avgLL = temp2/TESTS;
		avgSL = temp3/TESTS;

		System.out.println(N + " Array Add Average: " + avgAr);
		System.out.println(N + " LinkedList Add Average: " + avgLL);
		System.out.println(N + " SinglyLinkedList Add Average: " + avgSL);
		//get the average of the number of tests ran
		//for all test values and prints the outcome

	}//addAvg

	public static void findGetAvg(final int TESTS, long temp1, long temp2, long temp3, int val){

		double avgAr = 0;
		double avgLL = 0;
		double avgSL = 0;

		final int N = val;
	
		for (int a = 0; a < TESTS; a++){

		int[] ar = new int[N];
		for (int i = 0; i < N; i++){
			ar[i] = i;
		}//for i, populate the array

		long startAr = System.nanoTime();//start the clock
		for (int l = 0; l < N; l++){
			int something = ar[l];
		}//for l, get the values in the array
		long endAr = System.nanoTime();//end the clock

		long elapsedAr = endAr-startAr;
		
		temp1 += elapsedAr;

		LinkedList<Integer> myLL = new LinkedList<Integer>();
		for (int j = 0; j < N; j++){
			myLL.add(j);
		}//for j, populate the linked list

		long startLL = System.nanoTime();//start the clock
		for (int m = 0; m < N; m++){
			int otherThing = myLL.get(m);
		}//for m, get the values in the linked list
		long endLL = System.nanoTime();//end the clock

		long elapsedLL = endLL-startLL;

		temp2 += elapsedLL;

		SinglyLinkedList<Integer> mySL = new SinglyLinkedList<Integer>();
		for (int k = 0; k < N; k++){
			mySL.add(k);
		}//for k, populate the singly linked list

		long startSL = System.nanoTime();//start the clock
		for (int n = 0; n < N; n++){
			int somethingElse = mySL.get(n);
		}//for n, call the values in the singly linked list
		long endSL = System.nanoTime();//end the clock

		long elapsedSL = endSL-startSL;

		temp3 += elapsedSL;

		}//for a, runs first test 5 times
		//gets average of the 5 run time tests
		//for adding 1000 "a"s to the strings

		avgAr = temp1/TESTS;
		avgLL = temp2/TESTS;
		avgSL = temp3/TESTS;

		System.out.println(N + " Array Get Average: " + avgAr);
		System.out.println(N + " LinkedList Get Average: " + avgLL);
		System.out.println(N + " SinglyLinkedList Get Average: " + avgSL);
		//get the average of the number of tests ran
		//for all test values and prints the outcome
	
	}//getAvg

}//ArraySpeedTest
