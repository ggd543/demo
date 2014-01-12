#include <iostream>

using namespace std;

enum Err{
	STACK_OVERFLOW, INDEX_OF_OUT_BOUND
};

class Obj{
public:
	Obj(){
		cout<<"默认构造Obj"<<endl;
	}

	Obj(Obj &o){
		cout<<"拷贝构造Obj"<<" from "<<&o<<" to " << this<<endl;
	}

	~Obj(){
		cout<<"析构Obj: "<<this<<endl;
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
