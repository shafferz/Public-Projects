#include <stdio.h>
#include <math.h>

void addBinaryNos(int *larray, int *rarray, int lsize, int *sum);
void twosComplement(int *array, int size);
int calculateDecimal(int *array, int arraySize);
void reverseArray(int *array, int arraySize);

int main() {
  int i, j, n, x;
  int in1, in2;
  int isPow = 0;
  n = 32;

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

  printf("Loaded 32-length Truth Table.\n");
  printf("Enter no. 1: ");
  scanf("%d", &in1);
  printf("Enter no. 2: ");
  scanf("%d", &in2);

  int arraySize = (sizeof(table[in1])/sizeof(table[in1][0]));
  int X[arraySize], Y[arraySize];

  for (i = 0; i < x; i++) {
    X[i] = table[in1][i];
  }//fill X array
  reverseArray(X, arraySize);

  for (i = 0; i < x; i++) {
    Y[i] = table[in2][i];
  }//fill Y array
  reverseArray(Y, arraySize);

  twosComplement(Y, arraySize);

  int sum[(sizeof(X)/sizeof(X[0]))];
  int sumSize = (sizeof(X)/sizeof(X[0]));
  addBinaryNos(X, Y, arraySize, sum);

  int oneArray[arraySize];
  for (i = 0; i < arraySize; i++) {
    if (i == arraySize-1) {
      oneArray[i] = 1;
    } else {
      oneArray[i] = 0;
    }
  }//generate an array of the same size as array with the binary value 1
  addBinaryNos(sum, oneArray, arraySize, sum);

  int sumDec = calculateDecimal(sum, sumSize);

  printf("The difference the given numbers is: %d (", sumDec);
  for (i = 0; i < sumSize; i++) {
    printf("%d", sum[i]);
  }
  printf(")\n");

  return 0;
} //main

void addBinaryNos(int *larray, int *rarray, int lsize, int *sum) {
  int carry = 0;
  for (int i = lsize-1; i >= 0; i--) {
    if (larray[i] == 0 && rarray[i] == 0) {
      sum[i] = carry;
      carry = 0;
    } else if (larray[i] == 0 && rarray[i] == 1) {
      if (carry == 0) {
        sum[i] = 1;
      } else {
        sum[i] = 0;
        carry = 1;
      }//carry if-else
    } else if (larray[i] == 1 && rarray[i] == 0) {
      if (carry == 0) {
        sum[i] = 1;
      } else {
        sum[i] = 0;
        carry = 1;
      }//carry if-else
    } else if (larray[i] == 1 && rarray[i] == 1) {
      if (carry == 0) {
        sum[i] = 0;
        carry = 1;
      } else {
        sum[i] = carry;
      }
    }//logic for addition
  }//loop through arrays
}//add binary Nos

void twosComplement(int *array, int size) {
  for (int i = 0; i < size; i++) {
    if (array[i] == 0) {
      array[i] = 1;
    } else {
      array[i] = 0;
    }
  }//loop to invert the given array, first step of two's complement

  int oneArray[size];
  for (int i = 0; i < size; i++) {
    if (i == size-1) {
      oneArray[i] = 1;
    } else {
      oneArray[i] = 0;
    }
  }//generate an array of the same size as array with the binary value 1

  int twosArray[size];
  addBinaryNos(array, oneArray, size, twosArray); //add 1 to the one's complement
  twosArray[0] = 0;

  array = twosArray; //turn the one's complement into the two's complement
}

int calculateDecimal(int *array, int arraySize) {
  int decimal = 0;
  int factor = 1;
  for (int i = arraySize-1; i >= 0; i--) {
    if (array[i] == 1) {
      decimal += factor;
    }
    factor *= 2;
  }
  return decimal;
}

void reverseArray(int *array, int arraySize) {
  int start = 0;
  int end = arraySize-1;
  while (start < end)
    {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        start++;
        end--;
    }
}
