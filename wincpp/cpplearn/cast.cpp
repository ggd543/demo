#include <iostream>

using namespace std;

int main(){
	double a=1.0;
	double b=2.0;
	double c=static_cast<int>(a+b);
	cout<<c<<endl;
	int i= -1;
	cout<<(i>>1)<<endl;  // ËãÊõÓÒÒÆ
	unsigned char ch = 255;
	cout<<(ch>>1)<<endl;
	char chh=255;
	cout<<(chh>>1)<<endl;
	int xi=0x12345678;
	cout<<(xi>>24)<<endl;
	int y1=0x12,y2=0x34, y3=0x56, y4=0x78;
	cout<<y1<<" "<<y2<<" "<<y3<<" "<<y4<<endl;
	return 0;
}
