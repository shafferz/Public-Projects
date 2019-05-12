class BST {

	private class BTreeNode {
		private int value;
		private BTreeNode parent;
		private BTreeNode leftChild;
		private BTreeNode rightChild;

		public BTreeNode(int v, BTreeNode p, BTreeNode l, BTreeNode r) {
			value = v;
			parent = p;
			leftChild = l;
			rightChild = r;
		} //BTreeNode (constructor)

		public int getValue() {
			return value;
		} //getValue

		public void setValue(int v) {
			value = v;
		} //set Value

		public BTreeNode getParent() {
			return parent;
		} //getParent

		public void setParent(BTreeNode p) {
			parent = p;
		} //setParent

		public BTreeNode getLeftChild() {
			return leftChild;
		} //getLeftChild

		public void setLeftChild(BTreeNode l) {
			leftChild = l;
		} //setLeftChild

		public BTreeNode getRightChild() {
			return rightChild;
		} //getRightChild

		public void setRightChild(BTreeNode r) {
			rightChild = r;
		} //setRightChild

	} //BTreeNode (internal class)


	// start of BST class
	BTreeNode root;
	int size;

	public BST() {
		root = null;
		size = 0 ;
	} //BST (constructor)

	public int size() {
		return size;
	} //size

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		} //if-else
	} //isEmpty


	/*
	** This is the setup function for insert
	** It takes a value as input, and calls the recursive insert function starting at the root
	*/
	public void insert(int value) {
		
		if(root == null){
			root = new BTreeNode(value, null, null, null);
		} else {
			insert(value, root);
		}

		size++;

	} //add (setup)

	/*
	** This is the recursive function for insert
	** It takes a value and a BTreeNode as input, and either adds a node at the current location
	** (if null), or travels to the left or right child to try to insert there
	*/
	public void insert(int value, BTreeNode currentLocation) {

		if(value > currentLocation.getValue()){
			//going to attempt to add a right child if the node we are adding
			//is larger than the current position

			if(currentLocation.getRightChild() == null){
				//if there is no right child, make the child with the value
				//that we know is greater than the parent
				BTreeNode added = new BTreeNode(value, currentLocation, null, null);
				currentLocation.setRightChild(added);
			} else {
				//if there is a right child, we need to go to that child and
				//evaluate the insertion at that node
				insert(value, currentLocation.getRightChild());
			}//if-else has right child
		} else if (value < currentLocation.getValue()){
			//going to attempt to add a left child if the node we are adding
			//is smaller than the current position

			if(currentLocation.getLeftChild() == null){
				//if there is no right child, make the child with the value
				//that we know is greater than the parent
				BTreeNode added = new BTreeNode(value, currentLocation, null, null);
				currentLocation.setLeftChild(added);
			} else {
				//if there is a right child, we need to go to that child and
				//evaluate the insertion at that node
				insert(value, currentLocation.getLeftChild());
			}//if-else has left child

		} else {
			//you are attempting to add a node that already exists, which
			//will just tell you that you tried adding a node that already exists
			System.out.println("You tried adding a node that already exists. Node rejected.");
			size--;
			//since size gets incremented in the base case insertion function,
			//we need to decrement size when the node that already exists doesn't
			//get added to the BST.
		}

	} //add (recursive)



	/*
	** This is the setup function for get
	** It takes a value as input, and calls the recursive get function starting at the root
	**
	** If the value isn't found, let's return a -1
	*/
	public int get(int value) {

		if(isEmpty()){
			//if our tree is empty
			return -1;
			//the value that is being searched for
			//cannot exist, immediately return a -1 and crush the user's dreams
		} else if (root.getValue() == value){
			//if we know the value of the root is the same as the one we're looking for
			//don't bother searching the tree, it's right there!
			return root.getValue();
		} else {
			//alright, start looking by going left or right, based on size
			if(value > root.getValue()){
				//greater values on the right
				if(root.getRightChild() != null){
					//as long as the right child exists
					return get(value, root.getRightChild());
				} else {
					//if it doesn't exist, it can't be found
					return -1;
				}
			} else {
				//lesser values on the left
				if(root.getLeftChild() != null){
					//as long as the left child exists
					return get(value, root.getLeftChild());
				} else {
					//if it doesn't exist, it can't be found
					return -1;
				}//if-else left exists

			}//if-else comparing value to children
		
		}//if-else if-else base cases

	} //get (setup)

	/*
	** This is the recursive function for get
	** It takes a value and a BTreeNode as input, and either finds a node at the current location
	** (if value=currentLocation.getValue()), or travels to the left or right child to try to find it there
	**
	** If the value isn't found, let's return a -1
	*/
	public int get(int value, BTreeNode currentLocation) {

		if(currentLocation.getValue() == value){
			//we are at the correct value, return the value
			//at the current location
			return currentLocation.getValue();

		} else if(value > currentLocation.getValue()){
			//otherwise, we must search left and right 
			//greater values on the right
			if(currentLocation.getRightChild() != null){
				//as long as the right child exists
				return get(value, currentLocation.getRightChild());
			} else {
				//if it doesn't exist, it can't be found
				return -1;
			}
		} else {
			//lesser values on the left
			if(currentLocation.getLeftChild() != null){
				//as long as the left child exists
				return get(value, currentLocation.getLeftChild());
			} else {
				//if it doesn't exist, it can't be found
				return -1;
			}//if-else left exists

		}//if-else comparing value to current location or it's children

	} //get (recursive)


	/*
	** This is the setup function for remove
	** It takes a value as input, and calls the recursive remove function starting at the root
	*/
	public void remove(int value) {

		if(isEmpty()){
			//if our tree is empty
			System.out.println("The tree is empty!");
		} else if (root.getValue() == value){
			//trying to delete the root
			remove(value, root);
			//this seems redundant, but the remove function needs
			//to get to the recursive step in order to remove the
			//root because it is easier to do that than to
			//check how many children the root has in this function,
			//when the remove function handles both
			//determining the number of children 
		} else {
			//alright, start looking by going left or right, based on size
			if(value > root.getValue()){
				//greater values on the right
				if(root.getRightChild() != null){
					//as long as the right child exists
					remove(value, root.getRightChild());
				} else {
					//if it doesn't exist, it can't be found
					System.out.println("Node does not exist!");
				}
			} else {
				//lesser values on the left
				if(root.getLeftChild() != null){
					//as long as the left child exists
					remove(value, root.getLeftChild());
				} else {
					//if it doesn't exist, it can't be found
					System.out.println("Node does not exist!");
				}//if-else left exists

			}//if-else comparing value to children
		
		}//if-else if-else base cases

	} //remove (setup)

	/*
	** This is the recursive function for remove
	** It takes a value and a BTreeNode as input, and either removes the node at the current location
	** (if value=currentLocation.getValue()), or travels to the left or right child to try to remove from there
	*/
	public void remove(int value, BTreeNode currentLocation) {

		if(currentLocation.getValue() == value){
			//we are at the correct value, remove the value
			//at the current location
			if(currentLocation.getLeftChild() == null && currentLocation.getRightChild() == null){

				//removing a node with no children
				if(currentLocation.getValue() < currentLocation.getParent().getValue()){

					//if this is the left child of a node
					currentLocation.getParent().setLeftChild(null);

				} else {

					currentLocation.getParent().setRightChild(null);
				}//deletes the left or right child

			} else if(currentLocation.getLeftChild() != null && currentLocation.getRightChild() != null){

				//removing a node with two children
				removeTwoChildNode(currentLocation);
				//TODO: Extra Credit!

			} else {
				//has one child
	
				if(currentLocation.getLeftChild() != null){

					//if the one child is the left child
					currentLocation.getLeftChild().setParent(currentLocation.getParent());
					//set the location's child to have a new parent, then delete the node
					if(currentLocation.getValue() < currentLocation.getParent().getValue()){
						//if this is the left child of a node
						currentLocation.getParent().setLeftChild(currentLocation.getLeftChild());
					} else {
						currentLocation.getParent().setRightChild(currentLocation.getRightChild());
					}//deletes the left or right child

				} else {

					//else the one child is the right child
					currentLocation.getRightChild().setParent(currentLocation.getParent());
					//set current location's child to have a new parent
					if(currentLocation.getValue() < currentLocation.getParent().getValue()){
						//if this is the left child of a node
						currentLocation.getParent().setLeftChild(currentLocation.getLeftChild());
					} else {
						currentLocation.getParent().setRightChild(currentLocation.getRightChild());
					}//deletes the left or right child

				}//if-else determining which child node had

			}//if-else determining how many children the damn thing has

		} else if(value > currentLocation.getValue()){
			//otherwise, we must search left and right 
			//greater values on the right
			if(currentLocation.getRightChild() != null){
				//as long as the right child exists
				remove(value, currentLocation.getRightChild());
			} else {
				//if it doesn't exist, it can't be found
				System.out.println("Node doesn't exist!");
			}
		} else {
			//lesser values on the left
			if(currentLocation.getLeftChild() != null){
				//as long as the left child exists
				remove(value, currentLocation.getLeftChild());
			} else {
				//if it doesn't exist, it can't be found
				System.out.println("Node doesn't exist!");
			}//if-else left exists

		}//if-else comparing value to current location or it's children

	} //remove (recursive)

	private void removeTwoChildNode(BTreeNode currentLocation){

		BTreeNode rightSubtreeRoot = currentLocation.getRightChild();

		if(rightSubtreeRoot.getLeftChild() != null){
			//look for the successor
			removeTwoChildNode(currentLocation, rightSubtreeRoot.getLeftChild());
		} else {
			//bigger child has no children, therefore the successor
			int val = rightSubtreeRoot.getValue();
			remove(rightSubtreeRoot.getValue());
			currentLocation.setValue(val);
		}
	
	}//recursive removeTwoChildNode function for extra credit setup

	private void removeTwoChildNode(BTreeNode currentLocation, BTreeNode possibleSuccessor){
		
		if(possibleSuccessor.getLeftChild() == null){
			//we found the successor! huzzah!
			int val = possibleSuccessor.getValue();
			remove(possibleSuccessor.getValue());
			currentLocation.setValue(val);
		} else {
			//welp, lets keep hunting for it
			removeTwoChildNode(currentLocation, possibleSuccessor.getLeftChild());
		}

	}//recursive removeTwoChildNode function for extra credit method

} //BST
