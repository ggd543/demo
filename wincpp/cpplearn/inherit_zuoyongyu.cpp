#include <iostream>

using namespace std;

class B0{
public:
	void print(){
		cout<<"B0.print"<<endl;
	}
};

class X{
public :
	void say(){
		cout<<"X say so"<<endl;
	}
};

class B1:public B0{
private :
	int id;
public:
	 B1():id(1){
	 }
	int getId(){
		cout<<"B1.getId"<<endl;
		return id;
	}
};

class B2:public B0,public X{
private:
	int id;
public:
	B2():id(2){}
	 
	int getId(){
		cout<<"B2.getId"<<endl;
		return id;
	}
	 
};

class D:public B1,public B2{
private:
	int id;
public :
	D():id(90){
	}
	
	int getId(int x){
		cout<<"D.getId"<<endl;
		return x;
	}

};

int main(){
	D* d= new D;
	d->getId(2);
	d->B1::getId();
	d->B2::getId();

	// d->B0::print(); // 基类“B0"不明确
	d->B2::print();
	d->B1::print();
	d->X::say();
	d->say();
	return 0;
}
