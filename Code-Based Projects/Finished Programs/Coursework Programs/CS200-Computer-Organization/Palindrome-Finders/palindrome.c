/*
 * Zachary Shaffer, Lab 2
 * Simple C program to take a string as an input and say whether or not
 * said string is palindromic (meaning it is a palindrome).
 */

#include <stdio.h>

int main() {
  char firstString[20];
  char secondString[20];
  int strLen = -1;
  int boolean = 1; //int to represent true/false for palindromicy

  printf("Enter a string as input: ");
  scanf("%19s", firstString);

  int i = 0;
  while(firstString[i] != '\0') {
    strLen++;
    i++;
  }//count the length of the character array

  int j = 0;
  while(firstString[j] != '\0') {
    secondString[strLen-j] = firstString[j];
    j++;
  }//insert the characters of firstString into secondString in reverse order
  secondString[j] = '\0';

  int k = 0;
  while(firstString[k] != '\0') {
    if (firstString[k] != secondString[k]) {
      boolean = 0;
    }//if there is ever a character in the two arrays that are not the same, is not palindrome
    k++;
  }// compare the strings

  printf("%s is ", firstString);
  if (boolean == 1) {
    printf("palindromic.\n");
  } else {
    printf("not palindromic.\n");
  }//if-else to say whether or not we found a palindrome

  return 0;
}
