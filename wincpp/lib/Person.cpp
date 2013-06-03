#include <iostream>
#include "Person.h"
#include "Abc.cpp"

using namespace std;

Person::Person(){	
	Person::i=100;
}

void hello(){
	cout<<"fuxk"<<endl;
}

void Person::say(){
	hello();
	cout<<"i = "<<i<<endl;
}
