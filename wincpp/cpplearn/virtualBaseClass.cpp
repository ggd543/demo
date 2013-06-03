#include <iostream>

using namespace std;

class S0{
public :
	S0(char *str){
		cout<<"S0 constructor from "<<str<<endl;
	}
	~S0(){
		cout<<"S0 deconstructor"<<endl;
	}
};

class S1:virtual public S0{
public:
	S1():S0("S1"){
		cout<<"S1 constructor"<<endl;
	}
	~S1(){
	}
};

class Object{
public :
	Object(char *str){
		cout<<"Object constructor from "<<str<<endl;
	}
};

class Base{	
public :
	int id;
	Base(int id):id(id){
		cout<<"Base constructor"<<endl;
	}

	~Base(){
		cout<<"Base deconstructor"<<endl;
	}
	void print(){
		cout<<"Base::print"<<endl;
	}

};

class B1:virtual public Base,public Object{
public:
	B1():Base(1),Object("B1"){
		cout<<"B1 constructor"<<endl;
	}

	~B1(){
		cout<<"B1 deconstructor"<<endl;
	}
};

class B2:virtual public Base,public Object{
public:
	B2():Base(2),Object("B2"){
		cout<<"B2 constructor"<<endl;
	}
	~B2(){
		cout<<"B2 deconstructor"<<endl;
	}
};


class D :public S1, public B1, public B2{
public:
	D():S0("D"),Base(3){
		cout<<"D constructor"<<endl;
	}
	
	~D(){
		cout<<"D deconstructor"<<endl;
	}
};


class X{
public :
	int x;
	X(int x):x(x){
		cout<<"X constructor"<<endl;
	}
};

class Y:public X{
public:
	int y;
	Y(int y):y(y+1),X(y+1){
		cout<<"Y constructor"<<endl;
	}
};

class Z:public Y{
public:
	int z;
	Z(int z):z(z),Y(z+1){
		cout<<"Z constructor"<<endl;
	}

};


int main(){
	D* d=new D;
	cout<<endl;
	d->print();
	d->Base::print();
	delete d;

	cout<<endl;
	Z* z=new Z(3);

	return EXIT_SUCCESS;
}
