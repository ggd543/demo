#include <stdio.h>
#include <malloc.h>

int SIZE = 400;

int max(int a,int b){
		return a > b? a:b;
}

int sum(int i, int j, int k){
	return i + j + k;
}

struct Stu{

   int (*qfunc)(int,int,int);

};

typedef int (*XXX)(int,int);
typedef int YYY(int,int);

int main(){	
	void average(float *p, int n);
	void search(float (*p)[4], int n);

	int a[][3] ={{3,4,5},{5,6,7}};
	int (*p)[3] = a;


	int intArray[] = {1,2,3,4,5};
	int *pInt= intArray;

	int (*pfunc)(int ,int )=max;
	int (*qfunc)(int,int,int) = sum;

	struct Stu stu1;
	
    struct Stu *stu2 = (struct Stu *)malloc(sizeof(struct Stu));

	XXX xxx = max;
	YYY *yyy = max;

	int bb=54;
	int *aa=&bb;
	int **cc=&aa;

	printf("%x %x\n",aa,*aa);	

	printf("%d\n",xxx(3,5));
	printf("%d\n",yyy(3,5));
	printf("%d\n",(*yyy)(3,5));

	printf("\n");

	printf("%d\n",(*pfunc)(3,5));
	printf("%d\n",(pfunc)(3,5));	
	
	printf("\n");

	printf("%d\n",(*max)(3,5));
	printf("%d\n",(max)(3,5));
	printf("%d\n",(&max)(3,5));

	printf("\n");

	printf("%x %x %x\n",max,*max, &max);
	printf("%x %x %x %x\n",pfunc,*pfunc, &pfunc, &pfunc + 1);

	printf("\n");
	printf("%d\n",(*(&pfunc+1-1))(2,4));


	stu1.qfunc= sum;
	stu2->qfunc = sum;

	printf("%d\n",stu1.qfunc(7,8,9));
	printf("%d\n",stu2->qfunc(4,5,6));

	// qfunc = NULL;
	printf("%d\n",qfunc(3,4,5));
	printf("%d\n",pfunc(2,3));

	printf("%d\n",pInt[1]);

	printf("%d\n",a);
	printf("%d\n",*a);
	printf("%d\n",**a);

	

}




