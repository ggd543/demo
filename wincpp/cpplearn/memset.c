#include <stdio.h>
#include <memory.h>

int main(){
	int i, a[20];
	memset(a,0x01 , sizeof(a));
	for(i=0;i<20;i++){
		printf("%x ",a[i]);
	}
	printf("\n");
	return 0;
}
