#include <iostream>

using namespace std;

int main(){
	const int MAX=5;
	char buffer[MAX];
	int count=0;
	char msg1[] = "i want to go home";
	char* const str1 = msg1; // 常量指针，不能指向其他对象，但可以修改所指的对象
	str1[1]='a';
	const char* str2=msg1;   // 指向常量的指针，可以指向其他对象，但不能修改所指的对象
	str2="apple";
	

	

	cout<<"Enter a string of less than "<<MAX<<" characters"<<endl;
	cin.getline(buffer,MAX,'\n');
	cout<<buffer<<endl;

}