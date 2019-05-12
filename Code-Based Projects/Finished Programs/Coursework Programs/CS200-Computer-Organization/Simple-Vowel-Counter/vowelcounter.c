/**
 * Zachary Shaffer
 *
 * Simple C program to count the total number of vowels and Consonants
 * in a given input text file.
 *
 * To compile and run this on a data file named "myfile.txt", type:
 *
 *      gcc vowelcounter.c -o vowelcounter
 *      ./vowelcounter  <  myfile.txt
 */
#include <stdio.h>

int main() {
  int c, vow = 0, con = 0;

  while((c = getchar()) != EOF) {
    char temp = c;
    if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) {
      //if the character is a letter
      switch (temp) {
        case 'a':
          vow++;
          break;
        case 'A':
          vow++;
          break;
        case 'e':
          vow++;
          break;
        case 'E':
          vow++;
          break;
        case 'i':
          vow++;
          break;
        case 'I':
          vow++;
          break;
        case 'o':
          vow++;
          break;
        case 'O':
          vow++;
          break;
        case 'u':
          vow++;
          break;
        case 'U':
          vow++;
          break;
        default:
          con++;
          break;
      }//switch
    }//if-condition
  }//while
  printf("Consonants in text: %4d\nVowels in text: %4d\n", con, vow);
  return 0;
}//main
