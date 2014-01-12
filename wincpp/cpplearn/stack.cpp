#ifndef STACK_CLASS
#define STACK_CLASS
#include <iostream>

using namespace std;
const int MAX_STACK_SIZE=10;

template <typename T>
class Stack{
private:
	T stackList[MAX_STACK_SIZE];
	int top;
public:
	Stack(void);
	void Push(const T& item);
	T& Pop(void);
	void Clear(void);
	const T& Peek(void) const;
	int IsEmpty(void ) const;
	int IsFull(void) const;

};

template <typename T>
void Stack<T>::Clear(void){
	top=-1;
}

template <typename T>
Stack<T>::Stack(void):top(-1){
}

template <typename T>
const T& Stack<T>::Peek(void) const{
	if (IsEmpty()){
		throw "Empty Stack";
	}
	return  stackList[top];	
}

template <typename T>
void Stack<T>::Push(const T& item){
	if (IsFull()){
		 throw "Stack overflow";
	}
	top++;
	stackList[top]=item;
}

template <typename T>
T& Stack<T>::Pop(void){
	T temp;
	if (IsEmpty()){		
		throw "Attempt to pop an empty stack!";
	}
	temp = stackList[top];
	top--;
	return temp;
}

template <typename T>
int Stack<T>::IsEmpty(void) const{
	return top == -1;
}

template <typename T>
int Stack<T>::IsFull(void ) const{
	return top == MAX_STACK_SIZE -1;
}

struct Score{
	int id;
	char name[30];
	double score;
};

int main(void){
	Stack<int> stack;
	cout<<stack.IsEmpty()<<endl;
	stack.Push(5);
	cout<<stack.Peek()<<endl;
	const int &tmp=stack.Peek();
	
	const int a=7;
	int b= a;

	Stack<Score> scoreStack;
	struct Score mathScore={1,"archer",78.5};	
	scoreStack.Push(mathScore);
	const Score &sc=scoreStack.Peek();	
	// sc.score=45;

	return EXIT_SUCCESS;
}


#endif