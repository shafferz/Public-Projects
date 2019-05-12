#include <stdio.h>

void reverse(char[], char*, int, int);
int checkPalindrome(char[], char[], int);

int main() {

  char firstString[20];
  char secondString[20];
  int strLength = 0;

  printf("Input a string to be checked: ");
  scanf("%s", firstString);

  while(firstString[strLength] != '\0') {
    strLength++;
  } // Get the size of the string

  reverse(firstString, secondString, 0, (strLength - 1));
  int isPalindrome = checkPalindrome(firstString, secondString, (strLength -1));

  if (isPalindrome == 1) {
    printf("The string %s is a palindrome!\n", firstString);
  } else {
    printf("The string %s is not a palindrome!\n", firstString);
  }

  return 0;
}

void reverse(char s[20], char *r, int start, int end) {
  r[end] = s[start]; //Place the character
  if (end == 0) {
    // Base case, we reached the end of the first string
    return;
  } else {
    // Recursion case, push end and start towards each other
    reverse(s, r, ++start, --end);
  }//if-else
} //reverse method

int checkPalindrome(char s[20], char r[20], int end) {
    int boolean = 1;
    if (end == 0) {
      if (s[end] != r[end]) {
        return 0;
      } //base case, either the ends don't match and we can return 0 up the tree, or 1 will be returned by default
    } else {
      //Recursive case
      if (s[end] != r[end]) {
        //if we have inequality ever, we can return false up the recursive tree
        return 0;
      } else {
        //otherwise, this letter pair matches, and we can move inwards towards the center
        boolean = checkPalindrome(s, r, --end);
      }
    }//if-else for base or recursive case
    return boolean;
}//check_palindrom method
