#include <windows.h>
#include <stdio.h>
#include <malloc.h>

int BLOCK_SIZE=1* 1024* 1024;

int main(void){
        
		int*p;
		int i;

		setbuf(stdout,NULL);
        for(i=0; i<2000; i++){
			p= (int*)malloc(BLOCK_SIZE);
			if (p == NULL){
				break;
			}else{
				printf("malloc 1M, address: %x\n",p);
				Sleep(10);
			}
		}

		printf("allocate %dM totally",i);
        Sleep(100000000L);
        return 1;
}
