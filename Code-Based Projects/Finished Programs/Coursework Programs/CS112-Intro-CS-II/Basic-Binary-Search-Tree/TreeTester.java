/*
Output should appear as:

  Inserting 10 values

  Trying to find values
  Successfully found 12!
  Successfully found 42!
  Couldn't find 71, but it was never inserted, so OK.

  Removing a few values

  Trying to find values
  12 was deleted successfully!
  42 was deleted successfully!
  0 was still found!
*/

class TreeTester {

	public static void main(String args[]) {

		BST bTree = new BST();

		System.out.println("Inserting 10 values\n");
		bTree.insert(50);
		bTree.insert(25);
		bTree.insert(12);
		bTree.insert(6);
		bTree.insert(75);
		bTree.insert(45);
		bTree.insert(42);
		bTree.insert(63);
		bTree.insert(0);
		bTree.insert(123);

		/*
		  At this point, the tree should have the following structure:
		                __50__
		               /      \
		              25       75
		             /  \     /  \
		            12  45   63  123
		           /    /
		          6   42
		         /
		        0
		*/

		System.out.println("Trying to find values");

		int val = bTree.get(12);
		if (val == 12) {
			System.out.println("Successfully found 12!");
		} else {
			System.out.println("Couldn't find 12 :(");
		} //if-else

		val = bTree.get(42);
		if (val == 42) {
			System.out.println("Successfully found 42!");
		} else {
			System.out.println("Couldn't find 42 :(");
		} //if-else

		val = bTree.get(71);
		if (val == 71) {
			System.out.println("I found 71. Something is wrong.");
		} else {
			System.out.println("Couldn't find 71, but it was never inserted, so OK.");
		} //if-else


		System.out.println("\nRemoving a few values\n");
		bTree.remove(42);
		bTree.remove(12);

		/*
		  At this point, the tree should have the following structure:
		                __50__
		               /      \
		              25       75
		             /  \     /  \
		            6  45   63  123
		           /
		          0
		*/

		System.out.println("Trying to find values");

		val = bTree.get(12);
		if (val == 12) {
			System.out.println("I found 12, but it should have been deleted...");
		} else {
			System.out.println("12 was deleted successfully!");
		} //if-else

		val = bTree.get(42);
		if (val == 42) {
			System.out.println("I found 42, but it should have been deleted...");
		} else {
			System.out.println("42 was deleted successfully!");
		} //if-else

		val = bTree.get(0);
		if (val == 0) {
			System.out.println("0 was still found!");
		} else {
			System.out.println("Couldn't find 0 :(");
		} //if-else

		System.out.println("\nRemoving a few more values\n");
		bTree.remove(75);
		bTree.remove(25);

		System.out.println("Trying to find more values");

		val = bTree.get(75);
		if (val == 75) {
			System.out.println("I found 75, but it should have been deleted...");
		} else {
			System.out.println("75 was deleted successfully!");
		} //if-else

		val = bTree.get(25);
		if (val == 25) {
			System.out.println("I found 25, but it should have been deleted...");
		} else {
			System.out.println("25 was deleted successfully!");
		} //if-else

		val = bTree.get(0);
		if (val == 0) {
			System.out.println("0 was still found!");
		} else {
			System.out.println("Couldn't find 0 :(");
		} //if-else

		val = bTree.get(123);
		if (val == 123) {
			System.out.println("123 was still found!");
		} else {
			System.out.println("Couldn't find 123 :(");
		} //if-else

	} //main

} //TreeTester
