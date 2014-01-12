#include <iostream>

using namespace std;

struct Err{
	int i;
};

class Exception{

};

void throwIt() throw(int, float){
	// throw 'a';
	//Err e={3};	
	// throw e;
	throw Exception();
	return ;
}

int main(){
	try{
		throwIt();
	}catch(int i){
		cout<<i<<endl;
	}catch(char ch){
		cout<<ch<<endl;
	}
	return EXIT_SUCCESS;
}