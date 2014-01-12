#include <iostream>

using namespace std;

template <typename T> T abs(T a){
	return a > 0 ? a : -a;
}

template <typename T1, typename T2> T1 abs(T1 a,T2 b){
	return a > b? a: b;
}

template <typename T>
class Store{
private :
	T item;
	bool haveValue;

public:
	Store(T t):item(t){		
	}
	~Store(){
	}

	T getItem();
	void putItem(T item);
	void print();
	template <typename U> U abs(U u);
};

template <typename T>
T Store<T>::getItem(){
	return item;
}

template <typename T>
void Store<T>::putItem(T item){

}

template <typename T>
void Store<T>::print(){
	cout<<"item: "<<item<<endl;
}

template <typename T>
template <typename U>
U Store<T>::abs(U u){
	return u > 0 ? u : -u;
}

int main(){
	int a= abs(3);
	double c = (double)abs(3.5,2.4);
	cout<<a<<endl;
	cout << c<<endl;
	Store<int> s1(13);
	int item = s1.getItem();
	cout<<item<<endl;
	cout<<s1.abs(-2.4)<<endl;
	return 0;
}
