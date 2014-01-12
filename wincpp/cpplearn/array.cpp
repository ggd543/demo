#ifndef ARRAY_CLASS
#define ARRAY_CLASS

#include <iostream>
#include <cstdlib>

using namespace std;

#ifndef NULL
const int NUL =0;
#endif

enum ErrorType{
	invalidArraySize, memoryAllocationError, indexOutOfRange
};

const char * const errorMsg[]={
	"Invalid array size" ,"Memory allocation error","Invalid Index"
};

template <class T>
class Array{
private : 
	T* alist; 
	int size;
	void Error(ErrorType error, int badIndex =0) const;
	void copyFrom(T a[],int n);
public:
	Array(int sz=50);
	 Array(T a[],int n);
	Array(const Array<T>& A);
	~Array(void);
 
	Array<T>& operator =(const Array<T>& rhs);
	T& operator [](int i);
	operator T*(void) const;
	int getSize(void) const;
	void resize(int sz);
	void print();
	Array<T> clone();
};

template <typename T>
int Array<T>::getSize(void) const{
	return size;
}

template <typename T>
Array<T> Array<T>::clone(){
	return *this;
}

template <typename T>
void Array<T>::copyFrom(T a[], int n){
	int sz = (n > size)? size: n;
	for(int i=0; i< sz; i++){
		alist[i]=a[i];
	}
}

template <typename T>
void Array<T>::print(){
	for(int i=0;i<size; i++){
		cout<<alist[i]<<" ";
	}
	cout<<endl;
}

  
template <typename T>
Array<T>::Array(T a[],int n){	 
	new(this) Array(n);	 
	copyFrom(a,n);	
}
 

template <class T>
void Array<T>::Error(ErrorType error, int badIndex) const{
	cout<<errorMsg[error];
	if (error == indexOutOfRange){
		cout<<badIndex;
	}
	cout<<endl;
	exit(1);
}

template <typename T>
Array<T>::Array(int sz){
	if (sz <= 0){
		Error(invalidArraySize);
	}
	size=sz;
	alist=new T[size];
	memset(alist,0,sizeof(T)*size);
	if (alist == NULL){
		Error(memoryAllocationError);
	}	
}


template <typename T>
Array<T>::Array(const Array<T>& X){
	cout<<"拷贝构造函数"<<endl;
	int n=X.size;
	size=n;
	alist=new T[n];
	if (alist == NULL){
		Error(memoryAllocationError);
	}

	T* scrptr= X.alist;
	T* destptr= alist;
	while(n--){
		*destptr++=*scrptr++;
	}
}

template <typename T>
Array<T>::~Array(void){
	delete[] alist;
}

template <typename T>
Array<T>& Array<T>::operator =(const Array<T>& rhs){
	cout<<"数组赋值操作"<<endl;
	int n=rhs.size;
	if (size != n){
		delete []alist;
		alist=new T[n];
		if (alist == NULL){
			Error(memoryAllocationError);
		}
		size=n;
	}
	T* destptr= alist;
	T* srcptr=rhs.alist;
	while(n--){
		*destptr++ = *srcptr++;
	}
	return *this;
}

template <typename T>
T& Array<T>::operator [](int n){
	if (n<0 || n> size-1){
		Error(indexOutOfRange);
	}
	return alist[n];
}

template <typename T>
Array<T>::operator T*(void) const{
	cout<<"T* operator"<<endl;
	return alist;
}

template <typename T>
void Array<T>::resize(int sz){
	if (sz <=0 ){
		Error(invalidArraySize);
	}
	if (sz == size){
		return ;
	}
	T* newList=new T[sz];
	if (newList == NULL){
		Error(memoryAllocationError);
	}

	int n= (sz <= size)? sz:size;	
	T* srcprt= alist;
	T* destptr= newList;
	memset(destptr,0,sizeof(T)*sz);
	while(n--){
		*destptr++ = *srcprt++;
	}	
	delete []alist;
	alist=newList;
	size=sz;

}



int main(){
	int a[]={1,2,3,4,5};	
	Array<int> intArray1(a,5);	
	Array<int> intArray2=intArray1;
	Array<int> intArray3;
	intArray3=intArray1;

	intArray1.print();
	intArray3[2]=122;
	
	intArray3.print();
	cout<<"clone Array<T>"<<endl;

	Array<int> cloneArray= intArray3.clone();  // 只调用一次拷贝构造函数
	Array<int> &cloneArray2= intArray3.clone(); // 调用一次拷贝构造函数
	int *ptr=cloneArray;
	cout<<ptr[0]<<endl;

	cout<<"size of intArray1: "<<intArray1.getSize()<<endl;
	intArray1.resize(30);
	intArray1[23]=23;
	cout<<"size of intArray1: "<<intArray1.getSize()<<endl;
	intArray1.print();

	 

	return 0;
}

#endif