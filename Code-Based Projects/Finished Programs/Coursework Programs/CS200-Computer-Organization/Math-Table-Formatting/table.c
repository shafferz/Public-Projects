/*
 * Zachary Shaffer, Lab 2
 * A simple C program to take a number as input and print out a table of
 * values containing 1/x^3, log_3(x), sqrt(x), and 1.2^x.
 */

#include <stdio.h>
#include <math.h>

int main() {

  int input;
  char sampleChar = 'x';

  printf("Enter an integer between 1 and 50:\n");

  scanf("%d", &input);

  printf("\t%c\t", sampleChar);
  printf(" 1/%c^3\t\t", sampleChar);
  printf("sqrt(%c)\t\t", sampleChar);
  printf("log_3(%c)\t", sampleChar);
  printf("    1.2^%c\n", sampleChar);
  printf("\t-\t -----\t\t-------\t\t--------\t    -----\n");

  int i;
  for (i = 1; i <= input; i++) {
    printf("\t%d\t", i);
    printf("%7.5f\t\t", (1/(pow(i, 3.0))));
    printf("%7.5f\t\t", (sqrt(i)));
    printf("%7.5f\t\t", (log(i)/log(3.0)));
    printf("%10.5f\n", (pow(1.2, i)));
  }

  return 0;
}
