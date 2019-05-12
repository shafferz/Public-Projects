import java.util.Stack;

class PostfixCalculator{

	public static void main(String[] args){
	
		String postfix = "9732*-+";
		Stack<Integer> nums = new Stack<Integer>();
			
		for(int i = 0; i < postfix.length(); i++){

			if (postfix.charAt(i) == '+'){
				//do add operation
					int tempA = nums.pop();
					int tempB = nums.pop();
					int tempC = tempB+tempA;
					nums.push(tempC);
			} else if (postfix.charAt(i) == '-'){
				//do subtraction operation
					int tempA = nums.pop();
					int tempB = nums.pop();
					int tempC = tempB-tempA;
					nums.push(tempC);
			} else if (postfix.charAt(i) == '*'){
				//do multiplication operation
					int tempA = nums.pop();
					int tempB = nums.pop();
					int tempC = tempB*tempA;
					nums.push(tempC);
			} else if (postfix.charAt(i) == '/'){
				//do division operation
					int tempA = nums.pop();
					int tempB = nums.pop();
					int tempC = tempB/tempA;
					nums.push(tempC);
			} else {
				char ch = postfix.charAt(i);
				int chNum = ch-48;
				nums.push(chNum);
			}//if-else
		
		}//for

		System.out.println("The postfix input " + postfix + " calculates to: " + nums.pop());
	
	}//main

}//class
