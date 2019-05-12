/*
  Zachary Shaffer
  Professor Oliver Bonham Carter
  Computer Science 440 - Operating Systems
  Laboratory Assignment #04
  Due: February 20, 2017
*/

#include <semaphore.h>
#include<stdio.h>
#include<string.h>
#include<pthread.h>
#include<stdlib.h>
#include<unistd.h>

sem_t Asem, Bsem, Csem;

//Procedure A method
void *ProcA(void *arg){
  sem_wait(&Asem);
  if(&arg == 0)
  {
    printf("\t\t+thread 1 from ProcA\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcA\n");
  }
  sem_post(&Bsem);
  return NULL;
}

//Procedure B method
void *ProcB(void *arg){
  sem_wait(&Bsem);
  if(&arg == 0)
  {
    printf("\t\t+thread 1 from ProcB\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcB\n");
  }
  sem_post(&Csem);
  return NULL;
}

//Procedure C method
void *ProcC(void *arg){
  sem_wait(&Csem);
  if(&arg == 0)
  {
    printf("\t\t+thread 1 from ProcC\n");
  }
  else
  {
    printf("\t\t+thread 2 from ProcC\n");
  }
  return NULL;
}

//main method
int main(void)
{
  printf("Program initialization\n");

	sem_init(&Asem, 0, 0);
	sem_init(&Bsem, 0, 1);
  sem_init(&Csem, 0, 2);
  /*
    Lines of code initialize my semaphores
    Semaphores will hold off all the other
    procedures at once.
  */

  printf("\tRunning: ProcA:\n");
  pthread_t A_thread_1, A_thread_2;
  pthread_create(&A_thread_1, NULL, &ProcA, 0);
  pthread_create(&A_thread_2, NULL, &ProcA, 1);
  pthread_join(A_thread_1, NULL);
  pthread_join(A_thread_2, NULL);
  /*
    Following the structure from the given code
    segments for reference, as given by the lab,
    I used a different pthread_create style from
    my last lab, due to the nature of how Semaphores
    work.
  */

  printf("\tRunning: ProcB:\n");
  pthread_t B_thread_1, B_thread_2;
  pthread_create(&B_thread_1, NULL, &ProcB, 0);
  pthread_create(&B_thread_2, NULL, &ProcB, 1);
  pthread_join(B_thread_1, NULL);
  pthread_join(B_thread_2, NULL);

  printf("\tRunning: ProcC:\n");
  pthread_t C_thread_1, C_thread_2;
  pthread_create(&C_thread_1, NULL, &ProcC, 0);
  pthread_create(&C_thread_2, NULL, &ProcC, 1);
  pthread_join(C_thread_1, NULL);
  pthread_join(C_thread_2, NULL);

  printf("Program Termination\n");
  return 0;

}
