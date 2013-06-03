#include <iostream>
using namespace std;

class Stu{
public:
	void speak();
};

void Stu::speak(){
	cout<<"speaking"<<endl;
}

extern "C" {
void  call_C_speak(Stu* p){
	return p->speak();	
}
}


extern "C"  {

void func_in_cpp(void){
	cout<<"func_in_cpp"<<endl;	
}

}
