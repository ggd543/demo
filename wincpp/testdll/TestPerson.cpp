#include <iostream>
#include "../lib/Person.h"

extern "C" int max(int a , int b);
extern "C" void test();

using namespace std;

int main(void){
	Person p = Person();
	cout<<max(1,2)<<endl;	
	test();
	p.say();
	return 0;
}
