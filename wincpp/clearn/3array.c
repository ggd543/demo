#include <stdio.h>
#include <malloc.h>

int main(void){
	int ((*p)[2])[3];
	p=(int ((*)[2])[3])malloc(2* sizeof(int ((*)[2])[3]));
	p[1][1][2]=34;
	printf("%d",p[1][1][2]);
}
