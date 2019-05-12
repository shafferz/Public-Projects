/**
 * Zachary Shaffer
 *
 * Simple C program to print leading line numbers for any given input
 * text file.
 *
 * To compile and run this on a data file named "myfile.txt", type:
 *
 *      gcc lineprinter.c -o lineprinter
 *      ./lineprinter  <  myfile.txt
 */

#include <stdio.h>

int main() {
  int c;
  int line = 1;

  printf("%3d: ", line);

  while((c = getchar()) != EOF) {
    char temp = c;
    if (temp == '\n') {
      line++;
      putchar(temp);
      printf("%3d: ", line);
    } else {
      putchar(temp);
    }//if-else
  }//while
  printf("\n");
  return 0;
}//main
