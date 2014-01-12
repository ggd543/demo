#include <iostream>

using namespace std;

class Exception{	
public:
	Exception(){		
	}

	Exception(Exception &E){
		cout<<"拷贝"<<&E<<" 构造函数 for exception: "<<this<<endl;
	}

	~Exception(){
		cout<<"析构 exception: "<<this<<endl;
	}

	void printMessage(){
		cout<<"exception message "<<endl;
	}
};

void doIt(){
	Exception e;
	cerr<<&e<<endl;
	throw e;
}


int main(){
	try{
		doIt();
	}catch(Exception &e){
		cerr<<&e<<endl;
	}  
	cout<<endl;
	try{
		Exception e;
		cerr<<&e<<endl;
		throw e;
	}catch(Exception e){
		cerr<<&e<<endl;
	}

	cout<<endl;
	try{
		Exception e;
		cerr<<&e<<endl;
		throw e;
	}catch(Exception &e){
		cerr<<&e<<endl;
	}

	cout<<endl;
	try{
		Exception e;
		cerr<<&e<<endl;
		throw &e;
	}catch(Exception *e){
		cerr<<e<<endl;
		e->printMessage();
	}

	cout<<endl;
	try{
		Exception *e = new Exception;
		cerr<<e<<endl;
		throw e;
	}catch(Exception *e){
		cerr<<e<<endl;
		e->printMessage();
	}

	Exception *e =new Exception;
	delete e;
	e->printMessage();// wrong usage
	 
	char *str=new char[25];
	str[0]='a';
	str[1]='\0';
	cout<<str<<endl;
	 delete str;
	//cout<<str<<endl;
	return EXIT_SUCCESS;


}
