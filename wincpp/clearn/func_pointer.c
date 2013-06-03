#include <stdio.h>
#include <malloc.h>

int max(int a, int b){
	return a>b?a:b;
}

typedef  int FUNC(int a, int b);
typedef  int (*FUND)(int a, int b);

int main(){
	int (*p)(int,int);
	FUNC *f;
	FUNC ff;
	FUND g;	
	
	f=max;
	g=max;
	p=max;

	printf("%d %d %d\n",max(2,3),(&max)(2,3),(*max)(2,3));
	printf("%d %d \n",p(2,3),(*p)(2,3));
	
	printf("%d %d \n",f(2,3),(*f)(2,3));
	
	printf("%d %d \n",g(2,3),(*g)(2,3));

	// (&p)(2,3); //±‡“Î¥ÌŒÛ
	return 0;
}
