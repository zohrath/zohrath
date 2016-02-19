#include <pthread.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define NUM_OF_THREADS 2
//int pthread_create(pthread_t *thread, const pthread attr t *attr, void *(*start_routine)(void*), void *arg);

void* worker(void *arg) {

}

int main(int argc, char const *argv[]) {
  pthread_t tid[NUM_OF_THREADS];
  int targ[NUM_OF_THREADS];
  pthread_attr_t attr;

  pthread_attr_init(&attr);
  printf("PID = <%ld> ==> Let's create some threads.n", (long) getpid());

  /* Create threads */
  for (size_t i = 0; i < NUM_OF_THREADS; i++) {
    targ[i] = i;
    pthread_create(&tid[i], &attr, worker, &targ[i]);
  }

  switch (fork()) {
    case -1:
    perror("Forked failed.");
    exit(EXIT_FAILURE);
    case 0:
    printf("PID = <%ld> ==> Child after fork()!\n", (long) getpid() );
    break;
    default:
    printf("PID = <%ld> ==> parent after fork()!\n", (long) getpid() );
  }

  /* Wait for all threads to terminate*/
  for (size_t i = 0; i < NUM_OF_THREADS; i++) {
    if (pthread_join(tid[i], NULL) == 0) {
      printf("PID = <%ld> ==> Joining thread %d.\n", (long) getpid() );
      else {
        printf("PID = <%ld> ==> No thread to join.\n", (long) getpid() );
      }
    }
  }
  return 0;
}
