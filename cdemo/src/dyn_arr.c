//#include <stdio.h>
//#include <stdlib.h>
//
// int main(void ){
//  setbuf(stdout,NULL);
//  double* ptd;
//  int max;
//  int number;
//  int i=0;
//  puts("What is the maximum of type double entries? ");
//  scanf("%d",&max);
//  ptd=(double*)malloc(max* sizeof(double));
//  if (ptd == NULL ){
//	printf("Memory allocation failed");
//	exit(EXIT_FAILURE);
//  }else{
//     puts("Enter the values(q to quit)");
//	 int flag=1;
//	 while(i < max && flag != 0){
//		flag = scanf("%d",ptd[i]);
//		i++;
//	 }
//	 number = i;
//	 printf("here are you %d entries:\n", number);
//	 for (i =0; i < number; i++) {
//	     printf("%7.2d ",ptd[i]);
//	 }
//	 free(ptd);
//  }
//}
