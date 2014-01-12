#include <iostream>

using namespace std;

enum Err{
	STACK_OVERFLOW, INDEX_OF_OUT_BOUND
};

class Obj{
public:
	Obj(){
		cout<<"Ĭ�Ϲ���Obj"<<endl;
	}

	Obj(Obj &o){
		cout<<"��������Obj"<<" from "<<&o<<" to " << this<<endl;
	}

	~Obj(){
		cout<<"����Obj: "<<this<<endl;
	}
};


struct Person{	
	Obj obj;
};

int main(){
	try{
		Err err=STACK_OVERFLOW;
		cerr<<&err<<endl;
		throw err;
	}catch(Err e){
		cerr<<&e<<endl;
	}

	cout<<endl;
	try{
		Person p;
		cerr<<&p<<endl;
		throw p;
	}catch(Person p){
		cout<<&p<<endl;
	}
	return EXIT_SUCCESS;

}
