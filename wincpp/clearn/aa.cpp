extern "C"{
#include "a.h"
}
#include "aa.h"
#include "stdio.h"

int AA::bar(int a, int b){ 
    printf("result=%d/n", ThisIsTest(a, b)); 
    return 0;
}