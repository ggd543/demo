
#include "../dll/so_test.h"
#include "cpp.h"

// #define DLL_IMPORT __declspec(dllimport)

// DLL_IMPORT int  MAX_TIMES;  //ע�⣬ʹ�� .def �ļ��� DLL �е�������ʱ������Ҫ�ڱ�����ָ�� __declspec(dllexport)

 
int test(){
    test_a();
    test_b();
    test_c();
	printf("max_times: %d",MAX_TIMES);
    return 0;
}