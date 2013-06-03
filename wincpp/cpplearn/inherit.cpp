#include <iostream>

using namespace std;

class D1{
private : 
public:
	D1(){
		cout<<"D1 constructor"<<endl;
	}
	~D1(){
		cout<<"d1 deconstructor"<<endl;
	}
};

class D2{
private : 
public:
	D2(){
		cout<<"D2 constructor"<<endl;
	}
	~D2(){
		cout<<"D2 deconstructor"<<endl;
	}
};

class B0{
private : 
public:
	B0(){
		cout<<"B0 constructor"<<endl;
	}
	~B0(){
		cout<<"B0 deconstructor"<<endl;
	}
	void display(){
		cout<<"B0.display"<<endl;
	}
};


class B1{
private : 
public:
	B1(){
		cout<<"B1 constructor"<<endl;
	}
	~B1(){
		cout<<"B1 deconstructor"<<endl;
	}
	void display(){
		cout<<"B1.display()"<<endl;
	}
};

class B2: public B1,public B0{
private:
	D1 d1;
	D2 *d2;
public:
	B2(){
		d2=new D2;
		cout<<"B2 constructor"<<endl;
	}

	~B2(){
		delete d2;
		cout<<"B2 deconstructor"<<endl;
	}
	void display(){
		cout<<"B2.display"<<endl;
	}
};





int main(){
	B2* b2=new B2();
	B0 *p= b2;
	p->display();
	delete b2;

	return 0;
}