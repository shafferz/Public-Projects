/*
 * Zachary Shaffer
 * CS250 - Algorithms
 * 02/05/2016
 *
 * */

import java.io.*;
import java.util.*;

  public class FourSum {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    try{
      scan = new Scanner(new File(args[0]));
    } catch (FileNotFoundException FNFE) {
      FNFE.printStackTrace();
    }
    LinkedList<Integer> list = new LinkedList<Integer>();
    while(scan.hasNext()) {
      list.add(Integer.parseInt(scan.next()));
    }
    int[] a = new int[list.size()];
    for(int i = 0; i < a.length; i++) {
      a[i] = list.get(i);
    }

    long startTime = System.nanoTime();
    System.out.println("Quadruples: " + count(a));
    System.out.println("Elapsed time: " + (System.nanoTime()-startTime));
  } //main

 public static int count(int[] a) {

  int count = 0;

  for (int i = 0; i < a.length; i++) {
   for (int j = i+1; j < a.length; j++) {
    for (int k = j+1; k < a.length; k++) {
		for(int l = k+1; l < a.length; l++) {
     		if (a[i] + a[j] + a[k] + a[l] == 0) {
     		 count++;
     		} //if
		}//foursum loop added
    } //for
   } //for
  } //for

  return count;

 } //count

} //FourSum class
