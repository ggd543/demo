#include <iostream>

using namespace std;

class PointX{
private:
	int x;	
public:
	PointX(int x):x(x){
		cout<<"PointX("<<x<<") constructor"<<endl;
	}
	PointX(PointX &obj){
		cout<<"PointX copy constructor"<<endl;
	}

	~PointX(){
		cout<<"Point X destructor"<<endl;
	}
};

class PointY{
	private:
	int y;
public:
	PointY(int y):y(y){
		cout<<"PointY("<<y<<") constructor"<<endl;
	}
	PointY(PointY &obj){
		cout<<"PointY copy constructor"<<endl;
	}

	~PointY(){
		cout<<"PointY destructor"<<endl;
	}
};

class PointZ{
	private:
	int z;
public:
	PointZ(int z):z(z){
		cout<<"PointZ("<<z<<") constructor"<<endl;
	}
	 
	PointZ(PointY &obj){
		cout<<"PointZ copy constructor"<<endl;
	}
 
	~PointZ(){
		cout<<"PointZ destructor"<<endl;
	}
};

class PointXY:public PointX, public PointY{
private :
	PointZ z;
	PointY y;	

public :
	PointXY(int x,int y):PointY(y),PointX(x+1),y(y+1),z(x+y){
		cout<<"PointXY("<<x<<","<<y<<") constructor"<<endl;
	}

	PointXY(PointXY &obj):y(y),z(z),PointY(obj),PointX(obj){
		cout<<"PointXY copy constructor"<<endl;
	}

	~PointXY(){
		cout<<"PointXY destructor"<<endl;
	}
};

int main(){
	PointXY pointxy(1,3);
	cout<<endl;
	PointXY p2=pointxy;

}
