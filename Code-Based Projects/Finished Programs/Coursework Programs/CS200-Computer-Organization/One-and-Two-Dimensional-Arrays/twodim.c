# include <stdio.h>
# include <stdlib.h>
# include <limits.h>

int rowSize;
int colSize;

int* createDummyArray();
void storeIntoArray(int* ptr);
void printArray(int* ptr);
int findMaxInRow(int* ptr);
int findMaxInCol(int* ptr);
int findMinInRow(int* ptr);
int findMinInCol(int* ptr);

int main() {

  int* array = createDummyArray();
  storeIntoArray(array);
  printArray(array);

  int maxInRow = findMaxInRow(array);
  printf("The maximum number in that row is: %d\n", maxInRow);
  int maxInCol = findMaxInCol(array);
  printf("The maximum number in that column is: %d\n", maxInCol);
  int minInRow = findMinInRow(array);
  printf("The minimum number in that row is: %d\n", minInRow);
  int minInCol = findMinInCol(array);
  printf("The minimum number in that column is: %d\n", minInCol);

  return 0;
}

int* createDummyArray() {
  printf("Enter the row size of the Two Dimensional array: ");
  scanf("%d", &rowSize);

  printf("Enter the column size of the Two Dimensional array: ");
  scanf("%d", &colSize);

  int* array = (int*)malloc((rowSize*colSize)*sizeof(int));

  return array;
} //generate the array dynamically

void storeIntoArray(int* ptr) {
  for (int i = 0; i < rowSize; i++) {
    printf("Enter the values for row %d:\n", (i+1));
    for (int j = 0; j < colSize; j++) {
      scanf("%d", (ptr + (i*colSize) + j));
    }//cols
  }//rows
} //store values into the array

void printArray(int* ptr) {
  printf("Printhing 2D Array...\n");
  for (int i = 0; i < rowSize; i++) {
    for (int j = 0; j < colSize; j++) {
      printf("%d\t", *(ptr + (i*colSize) + j));
    }//cols
    printf("\n");
  }//rows
}//print the contents of the array

int findMaxInRow(int* ptr) {
  int max = INT_MIN;
  int row;
  printf("Enter the row in which you want to find the maximum: ");
  scanf("%d", &row);
  row--;
  for (int i = 0; i < colSize; i++) {
    int temp = *(ptr + (row*colSize) + i);
    if (temp > max) {
      max = temp;
    }
  }
  return max;
}

int findMaxInCol(int* ptr) {
  int max = INT_MIN;
  int col;
  printf("Enter the column in which you want to find the maximum: ");
  scanf("%d", &col);
  col--;
  for (int i = 0; i < rowSize; i++) {
    int temp = *(ptr + (i*colSize) + col);
    if (temp > max) {
      max = temp;
    }
  }
  return max;
}

int findMinInRow(int* ptr) {
  int min = INT_MAX;
  int row;
  printf("Enter the row in which you want to find the minimum: ");
  scanf("%d", &row);
  row--;
  for (int i = 0; i < colSize; i++) {
    int temp = *(ptr + (row*colSize) + i);
    if (temp < min) {
      min = temp;
    }
  }
  return min;
}

int findMinInCol(int* ptr) {
  int min = INT_MAX;
  int col;
  printf("Enter the column in which you want to find the minimum: ");
  scanf("%d", &col);
  col--;
  for (int i = 0; i < rowSize; i++) {
    int temp = *(ptr + (i*colSize) + col);
    if (temp < min) {
      min = temp;
    }
  }
  return min;
}
