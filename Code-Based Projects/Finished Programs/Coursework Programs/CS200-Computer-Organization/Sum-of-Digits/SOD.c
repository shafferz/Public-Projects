#include <stdio.h>

int sumDigits(int, int);

int main() {
  int input;

  printf("Enter a positive, 5-digit integer: ");
  scanf("%d", &input);

  int sum = sumDigits(input, 10000);

  printf("The sum of the digits in %d is %d.\n", input, sum);

  return 0;
}

int sumDigits(int x, int mod) {
  int sum = 0;
  if(mod == 1) {
    // Base case, reached the ones place,
    // so sum will be the ones place and passed up the recursive tree.
    sum = (x/mod);
  } else {
    //Add the digit for the modulo mod in x to the next lowest place of digits
    sum = (x/mod) + sumDigits((x%mod), (mod/10));
  }
  return sum;
}//recursive sumDigits method
