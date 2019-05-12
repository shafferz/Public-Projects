# include <stdio.h>
# include <stdlib.h>
# include <limits.h>

int size;

int* createDummyArray();
void storeIntoArray(int* ptr);
void printArray(int* ptr);
int findMaxInArray(int* ptr);
int findMinInArray(int* ptr);

int main() {

  int* array = createDummyArray();
  storeIntoArray(array);
  printArray(array);

  printf("The max is: %d\n", findMaxInArray(array));
  printf("The min is: %d\n", findMinInArray(array));

  return 0;
}

int* createDummyArray() {
  printf("Enter the size of the One Dimensional array: ");
  scanf("%d", &size);

  int* array = (int*)malloc(size*sizeof(int));

  return array;
} //generate the array dynamically

void storeIntoArray(int* ptr) {
  printf("Enter the values of the array:\n");
  for (int i = 0; i < size; i++) {
    scanf("%d", &ptr[i]);
  }
} //store values into the array

void printArray(int* ptr) {
  for (int i = 0; i < size; i++) {
    printf("%d\t", ptr[i]);
  }
  printf("\n");
}//print the contents of the array

int findMaxInArray(int* ptr) {
  int max = INT_MIN;
  for (int i = 0; i < size; i++) {
    if (ptr[i] > max) {
      max = ptr[i];
    }
  }
  return max;
}//find max in array

int findMinInArray(int* ptr) {
  int min = INT_MAX;
  for (int i = 0; i < size; i++) {
    if (ptr[i] < min) {
      min = ptr[i];
    }
  }
  return min;
}//find max in array
