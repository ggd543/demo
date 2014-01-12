// #include "linnkedList.h"
#include <iostream>
// #include "linkedlist.cpp"
#include "node.cpp"

using namespace std;

class Person{
private:
	int id;
public:
	Person(int id):id(id){

	}

	Person(const Person &p):id(p.id){
		cout<<"copy constructor for id: "<<id<<endl;
	}

	~Person(){
		cout<<"deconstructor id: "<<id<<endl;
	}

	int GetId(){
		return id;
	}

};

int main(void){	
	Node<int> *p;
	 Node<int> *head =new Node<int>();
	 head->InsertAfter(new Node<int>(1));
	 p=head->Next();
	 cout<<p->GetData()<<endl;
	 p->Delete();	  
	 head->Delete();

	 cout<<endl;
	 Person p1(1);
	 Node<Person> *pp=new Node<Person>(p1);
	 cout<<"start "<<endl;
	 Person &person=pp->GetData();	 	 
	 cout<<"person address: "<<&person<<endl;
	 cout<<endl;
	 Person p2(2);
	 cout<<"p2 address: "<<&p2<<endl;
	 person=p2;	 	 
	 cout<<"person address: "<<&person<<endl;
	 cout<<pp->GetData().GetId()<<" pp->GetData() address"<<&(pp->GetData())<<endl;

	 int  i=3;
	 int &j=i;
	 int &k=j;
	 cout<<"&i : "<<&i<<" &j: "<<&j<<" &k: "<<&k<<endl;

	// TestClass::printTest();
	return 0;
}
