#include <stdio.h>

int func(){
	int i=0;
	static int num = 3;
	num++;
	printf("%d %d\n",num, i);

}

int main(){
	func();
	func();

}
