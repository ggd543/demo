#include <stdio.h>
#include <stdlib.h>


int main(){
	int res;
	FILE *fp;
	  
	fp=fopen("./a.txt","r");
	printf("%d", (fp == NULL));
	res= ferror(fp);
	if (res != 0){	
		printf("%d\n",ferror(fp));
		exit(1);
	}
	res=fclose(fp);
	printf("%d %d\n",res, ferror(fp));
}
