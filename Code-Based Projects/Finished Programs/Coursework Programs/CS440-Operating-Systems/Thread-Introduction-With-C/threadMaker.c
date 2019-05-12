#include<stdio.h>
#include<string.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>

pthread_t tid[2];

void *ProcA(void *arg){
  pthread_t id = pthread_self();
  if(pthread_equal(id,tid[0])){
    printf("\t\t+thread 1 from ProcA\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcA\n");
  }

  return NULL;
}

void *ProcB(void *arg){
  pthread_t id = pthread_self();
  if(pthread_equal(id,tid[0])){
    printf("\t\t+thread 1 from ProcB\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcB\n");
  }

  return NULL;
}

void *ProcC(void *arg){
  pthread_t id = pthread_self();
  if(pthread_equal(id,tid[0])){
    printf("\t\t+thread 1 from ProcC\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcC\n");
  }

  return NULL;
}

int main (void)
{
  printf("Program initialization\n");
  int i = 0;

  printf("\tRunning: ProcA:\n");
  while(i<2){
    pthread_create(&(tid[i]), NULL, &ProcA, NULL);
    i++;
  }

  sleep(3);

  int j = 0;

  printf("\tRunning: ProcB:\n");
  while(j<2){
    pthread_create(&(tid[j]), NULL, &ProcB, NULL);
    j++;
  }

  sleep(3);

  int k = 0;

  printf("\tRunning: ProcC:\n");
  while(k<2){
    pthread_create(&(tid[k]), NULL, &ProcC, NULL);
    k++;
  }

  sleep(3);

  printf("Program Termination\n");
  return 0;
}
