class CaesarCipher{

	public static void main(String[] args){
	
	char[] message = {'H', 'E', 'L', 'L', 'O', 'S', 'E', 'X', 'Y'};
	int offset = 7;

	//Just a prompt so we know the program is working
	//and we know what the program is doing
	System.out.println("I have a phrase.");
	System.out.println("It encodes to: ");
	message = encode(message, offset);
	printMessage(message);
	System.out.println("Which decodes to: ");
	message = decode(message, offset);
	printMessage(message);
	
	}//main

	public static char[] encode(char[] message, int offset){
	
		for(int i = 0; i < message.length; i++){
		
			if(message[i] <= 'Z'-offset){
				//If our message's offset won't go beyond Z
				message[i] += offset;
				//Just offset the number by the offset value
			} else {
				//Otherwise, instead of adding the offset
				message[i] -= (26-offset);	
				//we offset the value by 26 minus the offset
				//in the opposite direction
			}
		
		}
	
		return message;

	}//encode

	public static char[] decode(char[] message, int offset){
	
		for(int i = 0; i < message.length; i++){
		
			if(message[i] >= 'A'+offset){
				//If our message won't go beyond A
				message[i] -= offset;
				//Go back an offset distance to decode
			} else {
				//Otherwise, instead of subtracting offset
				message[i] += (26-offset);	
				//we offset the value by 26 minus the offset
				//in the opposite direction
			}
		
		}
	
		return message;	
	}//decode

	public static void printMessage(char[] message){

		for(int i = 0; i < message.length; i++){
			System.out.print(message[i]);
		}

		System.out.println();

	}//printMessage, make our message print out

}//class
