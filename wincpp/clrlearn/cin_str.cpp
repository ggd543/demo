#include <iostream>

using namespace std;

int main(){
	const int MAX=5;
	char buffer[MAX];
	int count=0;
	char msg1[] = "i want to go home";
	char* const str1 = msg1; // ����ָ�룬����ָ���������󣬵������޸���ָ�Ķ���
	str1[1]='a';
	const char* str2=msg1;   // ָ������ָ�룬����ָ���������󣬵������޸���ָ�Ķ���
	str2="apple";
	

	

	cout<<"Enter a string of less than "<<MAX<<" characters"<<endl;
	cin.getline(buffer,MAX,'\n');
	cout<<buffer<<endl;

}