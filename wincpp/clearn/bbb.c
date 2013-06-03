#include <stdio.h>

void func_in_cpp(void );
void call_C_speak(struct Stu* p);

int bbb_main(void ) {
	func_in_cpp();
	call_C_speak(NULL);
	printf("...");
	return 0;
}