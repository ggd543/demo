#include "node.h"
#include <iostream>

using namespace std;
template <typename T>
Node<T>::Node(){
	new(this) Node(NULL);
}

template <typename T>
Node<T>::Node(const T& item ):data(item),prev(NULL),next(NULL){
}

template <typename T>
T& Node<T>::GetData(void){
	return data;
}

template <typename T>
void Node<T>::InsertBefore(Node<T> * const p){		
	if (this->prev != NULL){
		this->prev->next = p
	}
	p->prev=this->prev;
	this->prev =p;
	p->next= this;
	
}


template <typename T>
void Node<T>::InsertAfter( Node<T> * const p){	 
	if (this->next != NULL){
		this->next->prev = p;
	}
	p->next=this->next;
	this->next=p;
	p->prev = this;
}

template <typename T>
void Node<T>::Delete(void){
	if (this->next != NULL){
		this->next->prev=this->prev;
	}
	if (this->prev != NULL){
		this->prev->next=this->next;
	}
	delete this;
}
  
template <typename T>
Node<T> *Node<T>::Next(void) {
	return this->next;	
}

template <typename T>
Node<T> *Node<T>::Before(void) {
	return this->prev;
}

