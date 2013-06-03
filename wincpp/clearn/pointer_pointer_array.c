#include <stdio.h>
#include <malloc.h>

int main(void){
		
	int array13[][3]={{1,2,3}};
	int array23[][3]={{4,5,6}};
	int (*(*p)[2])[3];
	p=(int (*(*)[2])[3])malloc(1 * sizeof(int (*(*)[2])[3]));
	p[0][0]=array13;
	p[0][1]=array23;
	printf("%d\n",p[0][0][0][1]);   //2
	printf("%d\n",p[0][1][0][1]);  // 5

}
