/*
 * Zachary Shaffer and Tara Douglass
 * Lab 8 - Banker's Algorithm Implementation
 *
 * This work is ours unless otherwise cited.
 *
 */

import java.util.Scanner;

public class BankersAlgorithm {

  private static class Borrower {

    private int required;
    private int allocated;
    private int needs;

    private Borrower(int r, int a, int n){
      required = r;
      allocated = a;
      needs = n;
    }//class constructor

    //getters
    private int getReq(){return required;}
    private int getAllocated(){return allocated;}
    private int getNeeds(){return needs;}

    //setters
    private void setReq(int r){required = r;}
    private void setAllocated(int a){allocated = a;}
    private void setNeeds(int n){needs = n;}

  }//class Borrower

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    boolean successful = true;

    System.out.println("Welcome to the Bankers Algorithm program!");

    System.out.println("Enter information for the first borrower:");
    Borrower b1 = getBorrowerInfo();

    System.out.println("Enter information for the second borrower:");
    Borrower b2 = getBorrowerInfo();

    System.out.println("Enter information for the third borrower:");
    Borrower b3 = getBorrowerInfo();

    System.out.println("Enter information for the fourth borrower:");
    Borrower b4 = getBorrowerInfo();

    System.out.print("Enter the amount of resources the banker has: ");
    int resources = Integer.parseInt(keyboard.nextLine());

    int lendable = (resources-b1.getAllocated()-b2.getAllocated()-b3.getAllocated()-b4.getAllocated());

    System.out.print("The order of borrowers is: ");
    while((b1.getNeeds() > 0) || (b2.getNeeds() > 0) || (b3.getNeeds() > 0) || (b4.getNeeds() > 0)){
      //while all of the borrowers are still needy af
      //terminal condition, if the banker cannot satisfy anyone else
      if((lendable < b1.getNeeds()) && (lendable < b2.getNeeds()) && (lendable < b3.getNeeds()) && (lendable < b4.getNeeds())){
        successful = false;
        break;
      }
      if (lendable >= b1.getNeeds() && b1.getNeeds() != 0){
        b1.setAllocated(b1.getAllocated()+lendable);
        b1.setNeeds(0);
        lendable += b1.getAllocated();
        b1.setAllocated(0);
        System.out.print("Borrower 1, ");
      } else if (lendable >= b2.getNeeds() && b2.getNeeds() != 0){
        b2.setAllocated(b2.getAllocated()+lendable);
        b2.setNeeds(0);
        lendable += b2.getAllocated();
        b2.setAllocated(0);
        System.out.print("Borrower 2, ");
      } else if (lendable >= b3.getNeeds() && b3.getNeeds() != 0){
        b3.setAllocated(b3.getAllocated()+lendable);
        b3.setNeeds(0);
        lendable += b3.getAllocated();
        b3.setAllocated(0);
        System.out.print("Borrower 3, ");
      } else if (lendable >= b4.getNeeds() && b4.getNeeds() != 0){
        b4.setAllocated(b4.getAllocated()+lendable);
        b4.setNeeds(0);
        lendable += b4.getAllocated();
        b4.setAllocated(0);
        System.out.print("Borrower 4, ");
      }
    }//while loop
    System.out.println("end.");
    if(successful){
      System.out.println("Algorithm succeeded - No deadlock occurred!");
    } else {
      System.out.println("Algorithm failed - Deadlock occurred!");
    }
  }//main method

  public static Borrower getBorrowerInfo(){
    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the amount required by this borrower (integer): ");
    int required = Integer.parseInt(keyboard.nextLine());

    System.out.print("Enter the amount allocated to this borrower (integer): ");
    int allocated = Integer.parseInt(keyboard.nextLine());

    System.out.print("Enter the amount this borrower needs (integer): ");
    int needs = Integer.parseInt(keyboard.nextLine());

    return (new Borrower(required, allocated, needs));
  }//getBorrowerInfo method

}//class BankersAlgorithm
