class SinglyLinkedList<Key> {

	public class Node<Key> {
		private Key data;
		private Node next;

		public Node() {
			data = null;
			next = null;
		} //Node (constructor)

		public Node(Key myData, Node newNext) {
			data = myData;
			next = newNext;
		} //Node (constructor)

		public Key getData() {
			return data;
		} //getData

		public void setData(Key myData) {
			data = myData;
		} //setData

		public Node getNext() {
			return next;
		} //getNext

		public void setNext(Node newNext) {
			next = newNext;
		} //setNext

	} //Node (inner class)


	// ----------------------------
	private Node<Key> head;
	private Node<Key> tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	} //SinglyLinkedList (constructor)

	public int size() {
		return size;
	} //size

	public void add(Key myData) {

		if (head == null) {
			// adding the first node to an empty list
			Node<Key> temp = new Node(myData, null);
			head = temp;
			tail = temp;
			size++;

		} else {
			// adding a node to the end of a list
			Node<Key> temp = new Node(myData, null);
			tail.setNext(temp);
			tail = temp;
			size++;

		} //if-else

	} //add

	public void addFirst(Key myData) {

		if (head == null) {
			// adding the first node to an empty list
			Node<Key> temp = new Node(myData, null);
			head = temp;
			tail = temp;
			size++;

		} else {
			// adding a node to the beginning of a list
			Node<Key> temp = new Node(myData, head);
			head = temp;
			size++;

		} //if-else

	} //addFirst

	public Key get(int index) {

		// user gives us stupid input (index = -1)
		if (index < 0) {
			System.exit(1);

		// user gives us stupid input #2 (index > size)
		} else if (index >= size) {
			System.exit(2);

		// normal case
		} else {
			int i = 0;
			Node<Key> temp = head;

			while (i != index) {
				i++;
				temp = temp.getNext();
			} //while

			return temp.getData();

		} //if-else

		return null;

	} //get

	public void remove(int index) {

		if (index == 0) {
			// remove head
			head = head.getNext();
			
		} else if (index == size-1) {
			// remove tail
			Node<Key> previous = head;
			Node<Key> current = head.getNext();
			int i = 1;

			while (i != index) {
				i++;
				previous = previous.getNext();
				current = current.getNext(); 
			} //while

			tail = previous;
			tail.setNext(null);
			current = null;

		} else {
			// removing something in the middle
			Node<Key> previous = head;
			Node<Key> current = head.getNext();
			int i = 1;

			while (i != index) {
				i++;
				previous = previous.getNext();
				current = current.getNext();
			} //while

			previous.setNext(current.getNext());
			
		} //if-else

		size--;

	} //remove

} //SinglyLinkedList (class)
