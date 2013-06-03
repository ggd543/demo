#include <stdio.h>
#include "test.h"

char add1[]="addr1";
char add2[]="addr2";
int i=100;

int main()
{
   test1();
   printf("ok/n");
   test2();
   printf("%d/n",i);
   return 0;
}