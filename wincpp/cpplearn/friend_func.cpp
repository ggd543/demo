#include <iostream>
#include <cmath>

using namespace std;

class Point{
private :
	double x,y;
public:
	Point(double x,double y):x(x),y(y){}
	friend double computeDistince(Point p,Point y);
	friend Point operator+(Point p1,Point p2);
	Point operator-(Point p);
	Point operator-();
	Point operator++(int i ){
		cout<<"ºóÖÃ++ÔËËã·û"<<endl;
		return Point(this->x+1,this->y+1);
	}
	Point operator++(){
		this->x++;
		this->y++;
		return *this;
	}

	static void print(Point p);
};

Point Point::operator-(){
	return Point(-this->x,-this->y);
}

Point operator+(Point p1,Point p2){
	return Point(p1.x+p2.x,p1.y+p2.y);
}

Point Point::operator-(Point p){
	return Point(this->x-p.x,this->y-p.y);
}


void Point::print(Point p){
	cout<<p.x<<" "<<p.y<<endl;
}

double computeDistince(Point p1,Point p2){
	return sqrt(pow(p1.x-p2.x,2)+pow(p1.y-p2.y,2));
}

int main(){
	Point p1(1,2),p2(3,5);
	cout<<computeDistince(p1,p2)<<endl;
	Point::print(p1);
	Point::print(p2);	
	Point p3=p1 + p2;
	Point p4=p1 - p2;
	Point::print(p3);
	Point::print(p4);
	Point p5=-p1;
	Point::print(p5);
	Point p6=p1.operator-(p2);
	Point::print(p6);
	cout<<endl;
	Point p7=p6++;
	Point::print(p6);
	Point::print(p7);
	Point::print(++p7);
	Point::print(p7);
	return EXIT_SUCCESS;
}