import java.lang.*; //StringBuilder is in lang

class StringSpeedTest{
	
	public static void main(String[] args){

		final int TESTS = 5;
		//number of tests we will run for each type
		//of string and at each value
		long temp1 = 0;
		long temp2 = 0;

		findAvg(TESTS, temp1, temp2, 1000);
		findAvg(TESTS, temp1, temp2, 10000);
		findAvg(TESTS, temp1, temp2, 50000);
		findAvg(TESTS, temp1, temp2, 100000);

	}//main

	public static void findAvg(final int TESTS, long temp1, long temp2, int values){

		double avgs1 = 0;
		double avgsb1 = 0;
		final int N = values;
	
		for (int a = 0; a < TESTS; a++){

		long starts1 = System.nanoTime();//start the clock

		String s1 = new String();
		for (int i = 0; i < N; i++){
			s1 = s1 + "a";
		}//for i, add "a' to string s1

		long ends1 = System.nanoTime();//end the clock
		long elapseds1 = ends1-starts1;
		
		temp1 += elapseds1;

		long startsb1 = System.nanoTime();//start the clock

		StringBuilder sb1 = new StringBuilder();
		for (int j = 0; j < N; j++){
			sb1.append("a");
		}//for j, append "a" to sb1

		long endsb1 = System.nanoTime();
		long elapsedsb1 = endsb1-startsb1;

		temp2 += elapsedsb1;

		}//for a, runs first test 5 times
		//gets average of the 5 run time tests
		//for adding 1000 "a"s to the strings

		avgs1 = temp1/TESTS;
		avgsb1 = temp2/TESTS;

		System.out.println(N + " String Average: " + avgs1);
		System.out.println(N + " StringBuilder Average: " + avgsb1);
		//get the average of the number of tests ran
		//for both string and string builder and prints
	
	}//findAvg

}//StringSpeedTest
