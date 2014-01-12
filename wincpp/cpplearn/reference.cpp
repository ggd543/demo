#include <iostream>

using namespace std;

class Person{
private:
	int id;
public:
	Person(int id):id(id){

	}

	Person(const Person &p):id(p.id){
		cout<<"copy constructor id: "<<id<<endl;
	}

	~Person(){
		cout<<"deconstructor id: "<<id<<endl;
	}

	int GetId(){
		return id;
	}
};

template <typename T>
class Data{
public :
	T data;
	Data(const T& data):data(data){
		cout<<"T& data: "<<&data<<" , T data: "<<&(this->data)<<endl;
	}

	T& GetData(){
		return this->data;
	}
};

int main(){
	Data<Person>* d1=new Data<Person>(Person(1));
	Person &p=d1->GetData();
	cout<<"p1: "<<&p<<endl;
	p=Person(2);
	cout<<"p2: "<<&p<<endl;
	Person &p2=d1->GetData();
	cout<<"^p2: "<<&p2<<" id: "<<p2.GetId()<<endl;
	return EXIT_SUCCESS;
}
