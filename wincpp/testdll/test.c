
#include "../dll/so_test.h"
#include "cpp.h"

// #define DLL_IMPORT __declspec(dllimport)

// DLL_IMPORT int  MAX_TIMES;  //注意，使用 .def 文件从 DLL 中导出变量时，不需要在变量上指定 __declspec(dllexport)

 
int test(){
    test_a();
    test_b();
    test_c();
	printf("max_times: %d",MAX_TIMES);
    return 0;
}