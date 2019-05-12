class DoublyLinkedList {

	private static class Node {

		private int data;
		private Node next;
		private Node previous;

		public Node() {
			data = 0;
			next = null;
			previous = null;
		} //Node (constructor)

		public Node(int myData, Node newNext, Node newPrev) {
			data = myData;
			next = newNext;
			previous = newPrev;
		} //Node (constructor)

		public int getData() {
			return data;
		} //getValue

		public void setData(int myData) {
			data = myData;
		} //setValue

		public Node getNext() {
			return next;
		} //getNext

		public void setNext(Node newNext) {
			next = newNext;
		} //setNext

		public Node getPrevious(){
			return previous;
		}
		
		public void setPrevious(Node newPrev){
			previous = newPrev;
		}

	} //Node (inner class)



	// ------------------------------

	private Node head;
	private Node tail;
	private int size;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	} //DoublyLinkedList (constructor)

	public int size() {
		return size;
	} //size

	public void add(int myData) {

		if (head == null && tail == null){
			//ading the first node to an empty list
			Node temp = new Node(myData, null, null);
			head = temp;
			tail = temp;
		} else if (head != null && tail == null){
			//adding the second node to an empty list
			Node temp = new Node(myData, null, head);
			tail = temp;
		} else {
			//adding nodes after the second node
			Node temp = new Node(myData, null, tail);
			tail.setNext(temp);
			tail = temp;	
		}//if else

		size++;

	} //add

	public int get(int index) {

		if (index < 0) {
			System.exit(1);

		} else if (index >= size) {
			System.exit(2);

		} else {

			int i = 0;
			Node temp = head;

			while (i != index) {
				i++;
				temp = temp.getNext();
			} //while

			return temp.getData();

		} //if-else

		return -1;

	} //get

	public int getFromEnd(int index) {

		if (index < 0) {
			System.exit(1);

		} else if (index >= size) {
			System.exit(2);

		} else {

			int i = 0;
			Node temp = tail;

			while (i != index){
				i++;
				temp = temp.getPrevious();
			}//while

			return temp.getData();

		}//if-else

		return -1;

	} //getFromEnd

	public void remove(int index) {

		if (index == 0){
		//removing head
			
			if(head == tail){
			//If the head and the tail are the same,
			//and you try to remove the head, then
			//you're also removing the tail. To
			//prevent a phantom node from existing,
			//set both the head and the tail to 
			//null, thereby completely nullifying
			//the entire list.
				head = null;
				tail = null;
			} else { 
				head = head.getNext();
			}

		} else if (index == size-1){
		//removing tail

			Node previous = head;
			Node current = head.getNext();
			int i = 1;

			while(i != index){
				i++;
				previous = previous.getNext();
				current = current.getNext();
			}//while

			tail = previous;
			tail.setNext(null);
			current.setPrevious(null);
			current = null;

		} else {
		//removing anything in the middle

			Node previous = head;
			Node current = head.getNext();
			int i = 1;

			while(i != index){
				i++;
				previous = previous.getNext();
				current = current.getNext();
			}//while
			
			previous.setNext(current.getNext());
			current = current.getNext();
			current.setPrevious(previous);

		}//if-else

		size--;	

	} //remove

	public boolean testPreviousLinks() {
		Node current = tail;
		int count = 1;
		while (current.getPrevious() != null) {
			current = current.getPrevious();
			count++;
		} //while
		return ((current == head) && (count == size));
	} //testPreviousLinks

	public void makeCircular(){
		tail.setNext(head);
		head.setPrevious(tail);

		Node temp = head;
		
		for(int x = 0; x < 3; x++){
			for(int i = 0; i < size; i++){
				System.out.println(temp.getData());
				temp = temp.getNext();
			}//loop to print out the data in the list
		}//loop 3 times
	}


} //DoublyLinkedList (class)
