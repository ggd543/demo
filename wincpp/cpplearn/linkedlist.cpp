#include "linkedlist.h"
#include <iostream>

using namespace std;

template <typename T>
LinkedList<T>::LinkedList(void){
	front=rear=prevPtr=currPtr=markPtr=NULL;
	size=0;
	
}

template <typename T>
LinkedList<T>::LinkedList(const LinkedList<T> &L){
	new(this) LinkedList();
	if (L.IsEmpty()){
		return ;
	}
	size=L.size;
	front=rear=currPtr=Node<T>::CloneNode(L.front);
	currPtr->next=NULL;	
	Node<T> *p=L.front->next;
	while(p!=NULL){
		Node<T> *q=p->next;
		Node<T> *newNode=Node<T>::CloneNode(p);		
		currPtr->next=newNode;		
		currPtr=newNode;
		currPtr->next=NULL;
		p=q;
	}	
	currPt=front;
}

template <typename T>
LinkedList<T>::~LinkedList(void){
	ClearList();
}

template <typename T>
LinkedList<T>& LinkedList<T>::operator =(const LinkedList<T> &L){
	ClearList();
	return *(new LinkedList<T>(L));
}

template <typename T>
void LinkedList<T>::ClearList(void){
	if (IsEmpty()){
		return ;
	}
	Node<T> *p=front;	
	while(p!=NULL){
		Node<T> *q=p->next;
		Node<T>::FreeNode(p);
		p=q;		
	}
	front=rear=currPtr=prevPtr=markPtr=NULL;
	size=0;
	pos=-1;
}

template <typename T>
int LinkedList<T>::ListSize(void) const{
	return size;
}

template <typename T>
int LinkedList<T>::IsEmpty(void) const{
	return size == 0;
}

template <typename T>
void LinkedList<T>::Next(void) {	
	if (!IsEndOfList()){
		prevPtr = currPtr;
		currPtr = currPtr->next;
	}
}

template <typename T>
void LinkedList<T>::IsEndOfList(void ) const{
	return this->IsEmpty() || currPtr->next == NULL;
}

template <typename T>
void LinkedList<T>::Mark(void){
	markPtr=currPtr;
}

template <typename T>
void LinkedList<T>::Mark(int pos){
	if (pos
}





