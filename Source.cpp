#include <omp.h>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>

#define NRA 10                 /* number of rows in matrix A */
#define NCA 10                /* number of columns in matrix A */
#define NCB 10                /* number of columns in matrix B */

int main(int argc, char *argv[])
{
	int	tid, nthreads, i, j, k, chunk;
	double	a[NRA][NCA],           /* matrix A to be multiplied */
		b[NCA][NCB],           /* matrix B to be multiplied */
		c[NRA][NCB];           /* result matrix C */

	chunk = 10;                    /* set loop iteration chunk size */


#pragma omp parallel shared(a,b,c,nthreads,chunk) private(tid,i,j,k)
	{
		tid = omp_get_thread_num();
		if (tid == 0)
		{
			nthreads = omp_get_num_threads();
			printf("Initializing matrices...\n");
		}
		/*** Initialize matrices ***/
		srand(time(NULL));
#pragma omp for schedule (static, chunk) 
		for (i = 0; i < NRA; i++)
			for (j = 0; j < NCA; j++)
				a[i][j] = rand();
#pragma omp for schedule (static, chunk)
		for (i = 0; i < NCA; i++)
			for (j = 0; j < NCB; j++)
				b[i][j] = rand();
#pragma omp for schedule (static, chunk)
		for (i = 0; i < NRA; i++)
			for (j = 0; j < NCB; j++)
				c[i][j] = 0;

	}

#pragma omp parallel shared(a,b,c,nthreads,chunk) private(tid,j,k)
{
	tid = omp_get_thread_num();
	printf("Thread %d starting matrix multiply...\n", tid);
	#pragma omp for schedule (static, chunk)
		for (i = 0; i < NRA; i++)
		{
			printf("Thread=%d did row=%d\n", tid, i);
			for (j = 0; j < NCB; j++)
				for (k = 0; k < NCA; k++)
					c[i][j] += a[i][k] * b[k][j];
		}
	/*** End of parallel region ***/
}
		/*** Print results ***/
	printf("******************************************************\n");
	printf("Result Matrix:\n");
	for (i = 0; i<NRA; i++)
	{
		for (j = 0; j<NCB; j++)
			printf("%6.2f   ", c[i][j]);
		printf("\n");
	}


	system("PAUSE");

}
