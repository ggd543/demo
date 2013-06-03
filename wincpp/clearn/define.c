#include <stdio.h>

#if 1
#define PI 3.14

int main(){
#define R(r) PI * (r) * (r)
	int a=3;
	int b=5;
	double s=R(a+b);
	printf("%f",s);
#undef R

}

#undef PI

#endif