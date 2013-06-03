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

	virtual ~Person(){  // 如果析构函数不是虚函数，则通过基类指针来销毁子类对象时，子类对象的析构函数不会被调用
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

	void sayHi(char *str="good"){ // 如果基类的虚函数的参数给出了默认值，则子类重写时重新指定参数默认值是无效的，因为参数默认值是静态绑定
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
