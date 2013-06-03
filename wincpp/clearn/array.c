#include <stdio.h>
#include <malloc.h>


int main(void){	
	int a;
	int p[3][4] = {{1},{0},{3}};
	int pp[2][3][4] = {{1},{2}};

	int* q = (int *)malloc(4 * sizeof(int));
	q[3]=23;
	printf("%d",q[3]);

	printf("sizeof(short): %d\n",sizeof(short));
	printf("sizeof(int): %d\n",sizeof(int));
	printf("sizeof(long): %d\n",sizeof(long));
	printf("sizeof(float): %d\n",sizeof(float));
	printf("sizeof(double): %d\n",sizeof(double));

	printf("a[0,1]=%d\n",p[0][1]); // 0	
		
	printf("a[0,1]=%d\n",pp[0][1]);	// 0
	printf("a[1,0]=%d\n",pp[1][0]);	// 2
	printf("a[1,1]=%d\n",pp[1][1]);	// 2
	scanf("%d",&a);
	return 0;
}


