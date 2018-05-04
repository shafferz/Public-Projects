import java.util.*;

public class DrawCalc{

	private ArrayList<Student> data;
	private int median;
	private int numOfStudents;
	private int[] roomDrawNums;
	private double avgCreds;

	public DrawCalc(ArrayList<Student> data){
		this.data = data;
		numOfStudents = data.size();
		median = ((numOfStudents+1)/2);
		roomDrawNums = new int[numOfStudents];
		for(int i = 0; i < roomDrawNums.length; i++){
			//initialize all slots of the room draw nums array to be -1
			roomDrawNums[i] = -1;
		}
		avgCreds = findCreditAverage();
		minMax();
	}//constructor

	private void minMax(){
		for(int i = 0; i < data.size(); i++){
			if((data.get(i).getPrevRoomDraw()) < median){
				data.get(i).setMin(median);
				data.get(i).setMax(numOfStudents-1);
			} else {
				data.get(i).setMin(0);
				data.get(i).setMax(median);
			}//if-else
		}//set mins and maxes for each student
	}//minMax method, generates min and max values for each student

	private void tryNum(int rmnum, int snum){
		for(int i = rmnum; i < roomDrawNums.length; i++){
			if(i == (roomDrawNums.length)-1){
				if(roomDrawNums[i] == -1){
					roomDrawNums[i] = snum;
					break;
				}
				i = 0;
			}
			if(roomDrawNums[i] == -1){
				roomDrawNums[i] = snum;
				break;
			}
		}
	}//iterative tryNum method

	private boolean isHandicapped(int snum){
		if((data.get(snum).getDisability()).equals("SD") || (data.get(snum).getDisability()).equals("PD")){
			return true;
		} else {
			return false;
		}
	}//isHandicapped, returns true if a student is permanently or severely handicapped

	private void getHouseScore(int snum){
		if((data.get(snum).getPrevHall()).equals("AGC")){
			data.get(snum).setMax(data.get(snum).getMax());
		} else if((data.get(snum).getPrevHall()).equals("BLD")){
			data.get(snum).setMax(data.get(snum).getMax()-5);
		} else if((data.get(snum).getPrevHall()).equals("BRK")){
			data.get(snum).setMin(data.get(snum).getMin()+5);
		} else if((data.get(snum).getPrevHall()).equals("CRW")){
			data.get(snum).setMax(data.get(snum).getMax()-5);
		} else if((data.get(snum).getPrevHall()).equals("CFL")){
			data.get(snum).setMin(data.get(snum).getMin()+5);
		} else if((data.get(snum).getPrevHall()).equals("CRT")){
			data.get(snum).setMax(data.get(snum).getMax());
		} else if((data.get(snum).getPrevHall()).equals("EDW")){
			data.get(snum).setMax(data.get(snum).getMax());
		} else if((data.get(snum).getPrevHall()).equals("NVO")){
			data.get(snum).setMin(data.get(snum).getMin()+15);
		} else if((data.get(snum).getPrevHall()).equals("NVT")){
			data.get(snum).setMin(data.get(snum).getMin()+15);
		} else if((data.get(snum).getPrevHall()).equals("RVN")){
			data.get(snum).setMax(data.get(snum).getMax()-20);
		} else if((data.get(snum).getPrevHall()).equals("SCH")){
			data.get(snum).setMax(data.get(snum).getMax()-15);
		} else if((data.get(snum).getPrevHall()).equals("WKA")){
			data.get(snum).setMax(data.get(snum).getMax());
		} else if((data.get(snum).getPrevHall()).equals("WLK")){
			data.get(snum).setMin(data.get(snum).getMin()+5);
		} else {
			data.get(snum).setMax(data.get(snum).getMax());
		}
	}//adjusts min/max window based on previous dorms

	private double findCreditAverage(){
		double total = 0.0;
		for(int i = 0; i < data.size(); i++){
			total += data.get(i).getCredits();
		}
		total = total/(double)numOfStudents;
		return total;
	}//findCreditAverage method, just gets the average amount of credits for this specific class

	private void getCreditScore(int snum){
		if((data.get(snum).getCredits()) < avgCreds-2.0){
			//if student has less than 2 whole credits below average
			data.get(snum).setMin(data.get(snum).getMin()+5);
		} else if((data.get(snum).getCredits()) > avgCreds-2.0){
			//if student has more than 2 whole credits above average
			data.get(snum).setMax(data.get(snum).getMax()-5);			
		} else {
			//else, student is about average
			data.get(snum).setMax(data.get(snum).getMax());
		}
	}//penalizes or rewards more/less credits than average

	public ArrayList<Student> calculate(){
		Random generator = new Random();
		int handiCounter = 0;
		for(int i = 0; i < data.size(); i++){
			Student temp = data.get(i);
			if(isHandicapped(i)){
				//if student is in dire need of handicap-accessible living, try to place them in the first slot possible.
				if(roomDrawNums[handiCounter] == -1){
					roomDrawNums[handiCounter] = i;
				} else {
					int tempNum = roomDrawNums[handiCounter];
					roomDrawNums[handiCounter] = i;
					tryNum((handiCounter+1), tempNum);
				}
				handiCounter++;
			} else {
				getHouseScore(i); //adjust the students' min/max based on house
				getCreditScore(i); //adjust the students' min/max based on credits
				int gen = generator.nextInt(temp.getMax()-temp.getMin()+1)+temp.getMin();
				//generate the random number based on min/max of the student
				tryNum(gen, i);
			}//if-else
		}//for-loop
		System.out.println("Finalizing class room draw numbers...");
		applyNewNumbers();
		return data;
	}//calculate method, the method that does it all

	private void applyNewNumbers(){
		for(int i = 0; i < roomDrawNums.length; i++){
			data.get(roomDrawNums[i]).setDrawNum(i+1);
		}
	}//applyNewNumbers method, applies new room draw numbers to student objects

}//Draw calc class
