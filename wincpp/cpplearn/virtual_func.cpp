#include <iostream>

using namespace std;

class Person{
public:
	Person(){
		say();
		cout<<"Person constructor"<<endl;
	}

	Person(Person &p){
		cout<<"Person copy constructor"<<endl;
	}

	virtual ~Person(){  // ����������������麯������ͨ������ָ���������������ʱ���������������������ᱻ����
		cout<<"Person destructor"<<endl;
	}

	virtual void say(){
		cout<<"Person.say"<<endl;
	}

	void say(char *str){
		cout<<"Person.say to "<<str<<endl;
	}

	virtual void sayHi(char *str="hello"){
		cout<<"say hi to "<<str<<endl;
	}

	void print(){		
		say();
	}
};

class Student:public Person{
public:
	Student(){
		cout<<"Student constructor"<<endl;
	}

	void say(){
		cout<<"Student.say"<<endl;
	}

	~Student(){
		cout<<"student destructor"<<endl;
	}

	void sayHi(char *str="good"){ // ���������麯���Ĳ���������Ĭ��ֵ����������дʱ����ָ������Ĭ��ֵ����Ч�ģ���Ϊ����Ĭ��ֵ�Ǿ�̬��
		cout<<"say hi to "<<str<<endl;  
	}

	void sayHi(){
		cout<<"say hi "<<endl;  
	}
};



int main(){
	Person *p;
	p=new Student;
	p->say();  // student.say
	delete p;
	cout<<endl;

	Person p2;
	Student s;
	p2=s;  // ???	
	p2.say();	 // person say
	Person p3=s;
	p3.say(); // person say
	p=&s;
	p->say(); // student.say
	p->sayHi(); 
	p->sayHi("fuxk"); 
	cout<<endl;
	// s.sayHi(); // compilation error
	p->say("fuxk");
	cout<<endl;
	p->print();

	return 0;
}
