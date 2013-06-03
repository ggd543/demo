#include <stdio.h>


extern void printName(){
	printf("archer\n");
}

extern void printMessage(){
	printf("greeting\n");
}

static void hi(){
	printf("hi c");
}
