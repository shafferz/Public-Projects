#include <stdio.h>
#include <math.h>

int main() {
  int i, j, n, x;
  int isPow = 0;

  printf("Hey! Welcome to the truth table generator. Please enter the number of rows: ");
  scanf("%d", &n);

  printf("\n");
  int temp = n;
  while(temp != 1) {
    if(temp%2 != 0){
      isPow = 1;
      break;
    }
    temp = temp/2;
  }//loop to check if n is a power of two

  if (n != 0 && isPow == 0) {
    //if n is not zero and is a power of two,
    x = ceil((log2(n)/log2(2)));
  } else {
    int y = 1;
    while(y < 64) {
      if (y < n) {
        y *= 2;
      } else {
        break;
      }
    }//while loop to find the highest power of 2 above 0
    x = ceil((log2(y)/log2(2)));
  }//if-else from pseudo-code in lab spec

  int table[n][x];

  for(i = 0; i < n; i++) {
    for(j = 0; j < x; j++) {

      table[i][j] = (i/(int)pow(2, j))%2;
    }
  }//loop to fill
  
  for(i = 0; i < n; i++) {
    for(j = 0; j < x; j++) {
      printf("%d\t", table[i][j]);
    }
    printf("\n");
  }//loop to print

  return 0;
}
