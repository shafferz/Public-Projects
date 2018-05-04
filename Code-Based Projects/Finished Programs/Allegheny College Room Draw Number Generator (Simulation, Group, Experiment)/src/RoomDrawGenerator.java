/*
 * Zachary Shaffer and Adam Spence
 * Room Draw Number Generator - Final Project
 *
 * Purpose: Enhance the room draw system at Allegheny with a better implementation
 * that is not completely random, but is rather "considerate" of other factors.
 *
 */
import java.util.*;
import java.io.*;

class RoomDrawGenerator{

	public static void main(String[] args) throws IOException{
		
		ArrayList<Student> sophomores = getListFromFile("soIn5.txt");
		Collections.shuffle(sophomores);
		ArrayList<Student> juniors = getListFromFile("jrIn5.txt");
		Collections.shuffle(juniors);
		ArrayList<Student> seniors = getListFromFile("srIn5.txt");
		Collections.shuffle(seniors);
		//get the students from files and then shuffle the arraylists

		Stopwatch timer = new Stopwatch();
		//start timer
		System.out.println("Generating sophomore room draw numbers...");	
		DrawCalc soCalc = new DrawCalc(sophomores);
		sophomores = soCalc.calculate();
		System.out.println("Generation complete! (1/3)");
		System.out.println("Generating junior room draw numbers...");
		DrawCalc jrCalc = new DrawCalc(juniors);
		juniors = jrCalc.calculate();
		System.out.println("Generation complete! (2/3)");
		System.out.println("Generating senior room draw numbers...");
		DrawCalc srCalc = new DrawCalc(seniors);
		seniors = srCalc.calculate();
		System.out.println("Generation complete! (3/3)");
		//end timer
		System.out.println("Generated in " + timer.elapsedTime() + " seconds!");

		Collections.sort(sophomores);
		Collections.sort(juniors);
		Collections.sort(seniors);

		printListToFile("soOut.txt", sophomores);
		printListToFile("jrOut.txt", juniors);
		printListToFile("srOut.txt", seniors);
		
	}//main

	public static ArrayList<Student> getListFromFile(String fname) {

		ArrayList<String> studentInfo = new ArrayList<String>();
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			FileInputStream fstream = new FileInputStream("data/" + fname);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String info = new String();

			while ((info = br.readLine()) != null){
 				studentInfo.add(info);
 			}//while loop

			br.close();
		} catch(Exception e) {
			System.out.println("Error encountered in file reading process!");
			e.printStackTrace();
		}

		for(int i = 0; i < studentInfo.size(); i++){
			//goes through the array list of strings
			String[] parts = new String[6];
			parts = (studentInfo.get(i)).split(",", 0);
			//splits the lines from the text into substrings around the delimiter ',' and puts them in a String array
				
			Student stu = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
			//creates a student with all of the appropriate info
			students.add(stu);
		}//for-loop

		return students;
	}//getListFromFile method

	public static void printListToFile(String fname, ArrayList<Student> stu){
		try{
			File file = new File(fname);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for(int i = 0; i < stu.size(); i++){
				bw.write(stu.get(i).toString());
				bw.write("\n");
			}

			bw.close();
		} catch	(Exception e) {
			System.out.println("Error while writing to file!");
			e.printStackTrace();
		}
	}//printListToFile method

}//class
