import java.util.Stack;

class InfixConverter{

	public static void main(String[] args){
	
		String convertee = "(a-b)/c*(d-e)";
			//This is Output #2 in my Sample Output

		Parentheses check = new Parentheses(convertee);
			//makes sure the string is valid to save error catches later
		String converted;
			//initialize the string that will hold the converted from the convertee
			if(check.checkParentheses()){
				converted = convertString(convertee);
				//convert the string convertee, stored in converted
			} else {
				System.out.println("String failed to pass the Parentheses check.");
				converted = "Unavailable";
			}//if-else

			System.out.println(convertee + " in postfix notation is: " + converted);
			//calculation

	}//main

	public static String convertString(String cnvrt){
	
		Stack<Character> chars = new Stack<Character>();
		String postfix = "";
		//stack to hold characters, string to create the postfix notation

		for(int i = 0; i < cnvrt.length(); i++){
			if(cnvrt.charAt(i) == '('){
				chars.push(cnvrt.charAt(i));
				//open parentheses always get pushed
			} else if (cnvrt.charAt(i) == ')'){
				int temp = chars.size();
				while(temp > 0){
					if(chars.peek() == '('){
						break;
					} else {
					postfix = postfix + chars.pop();
					}//if-else
					temp--;
				}//while
				//loop goes through stack, popping characters to postfix
				//until it peeks at an open parenthesis.
				chars.pop();
				//discards the open parenthesis
			} else if (cnvrt.charAt(i) == '+' || cnvrt.charAt(i) == '-'){
				if(chars.peek() == '(' || chars.empty()){
					chars.push(cnvrt.charAt(i));
					//if the top thing in the stack is an open parenth,
					//or if the stack is empty, just push the + or -
				} else {
					//otherwise, append to postfix before pushing
					postfix = postfix + chars.pop();
					chars.push(cnvrt.charAt(i));
				}
			} else if (cnvrt.charAt(i) == '*' || cnvrt.charAt(i) == '/'){
				if(!chars.empty()){
					//as long as the stack isn't empty...
					if(chars.peek() == '*' || chars.peek() == '/'){
						//look at the top of the stack to see if / or *
						postfix = postfix + chars.pop();
						//then put it on the postfix if it is
					}
				}
				chars.push(cnvrt.charAt(i));
				//then always push to stack
			} else {
				//if it isn't + or - or * or / or (),
				//it must be an operand, and therefore can
				//be added to the postfix notation, no matter what
				postfix = postfix + cnvrt.charAt(i);
			}
		}//for as long as we have characters left in the string

		if(chars.empty()){
			return postfix;
		} else {
			for(int j = 0; j < chars.size(); j++){
				postfix = postfix + chars.pop();
			}
			return postfix;
		}
	
	}//convertString

}//class
