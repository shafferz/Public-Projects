class SelectionSort {

	public static void main(String[] args){
	
		int[] array = {8, 3, 4, 2, 1, 9, 5, 7, 6, 0};
		//array of number 0-9, jumbled

		printArray(array);
		//print what the array starts as

		for(int i = 0; i < array.length; i++){

		int temp = 0;
		//temporary storage variable
		int position = i;
		//temporary position variable, starting at i

			for(int j = i+1; j < array.length; j++){
		
				if(array[position] > array[j]){	

					position = j;

					/* if we find a number smaller than
					 * what we started with, then we
					 * store the position of that #
					 * and proceed to check that #
					 * against the rest of the numbers,
					 * until we've found the smallest 
					 */

				}
		
			}//inner for-loop

			temp = array[i];
			array[i] = array[position];
			array[position] = temp;

			/* store the number in first position
			 * in temp and then set that position
			 * equal to the smallest number that we
			 * found the position of, then set the
			 * position where the smallest was to temp
			 * which was our stored value
			 */

			printArray(array);
		}
	
	}//main

	public static void printArray(int[] array){
	
		for(int x = 0; x < array.length; x++){
			
			System.out.print(array[x]);
		
		}//for-loop

		System.out.println();
		//decorative println
	
	}//printArray, print numbers out neatly

}//class
