import java.io.*;
import java.util.ArrayList;

class QuestionExtractor {

  public static void main(String[] args){

    String fileReadName = args[0];
    String fileWriteName = args[1];
    String line = null;
    ArrayList<String> responses = new ArrayList<String>();

    try {
        FileReader fileReader = new FileReader(fileReadName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int i = 0;
        while((line = bufferedReader.readLine()) != null) {
          line = line.substring(line.lastIndexOf(':')+1);
          line = line.replaceAll("}", "");
          line = line.replaceAll("\"", "");
          line = line.replaceAll("\'", "");
          //get rid of all single or double quotation marks and strange delimiters,
          //and reduce the lines of the file to just the answer responses
          System.out.println(line); //prints the line to see what I'm getting for my own visualization purposes
          responses.add(line);
        } //while

        bufferedReader.close();  //close the file
    }//try
    catch(FileNotFoundException ex) {
        ex.printStackTrace();
    }//catch
    catch(IOException ex) {
        ex.printStackTrace();
    }//catch

    try {
      FileWriter fileWriter = new FileWriter(fileWriteName);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      int j = 0;
      while(j < responses.size()){
        bufferedWriter.write(responses.remove(j)); //remove files from array list and write them to file lines
        bufferedWriter.newLine();
        j++;
      }//while

      bufferedWriter.close();
    }//try
    catch(IOException ex) {
      ex.printStackTrace();
    }//catch

  }//main

}//class
