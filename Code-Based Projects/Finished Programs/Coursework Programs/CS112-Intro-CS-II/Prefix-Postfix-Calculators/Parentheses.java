import java.util.Stack;

class Parentheses {

	private	Stack<Character> myStack;
	private String delim;

	public Parentheses(String d){
	
		myStack = new Stack<Character>();
		delim = d;

	}//constructor

	public boolean checkParentheses(){

		for (int i = 0; i < delim.length(); i++) {
			char current = delim.charAt(i);

			if (current == '(' || current == '[' || current == '{') {
				myStack.push(current);
			} else if (current == ')') { 
				if (myStack.empty()) {
					return false;	
				} //if
				
				if (myStack.pop() != '(') {
					return false;	
				} //if

			} else if (current == ']') {
				if (myStack.empty()) {
					return false;	
				} //if
				
				if (myStack.pop() != '[') {
					return false;
				} //if

			} else if (current == '}') {
				if (myStack.empty()) {
					return false;
				} //if
				
				if (myStack.pop() != '{') {
					return false;
				} //if

			} //if-else

		} //for

		if (myStack.empty()) {
			return true;
		} else {
			return false;
		} //if-else

	} //checkParenth

}// Parentheses
