#include "node.h"
#include <iostream>

using namespace std;

template <typename T>
Node<T>::Node(const T& item, Node<T> *ptnext=NULL){
	data=item;
	next=ptnext;

}

template <typename T>
void Node<T>::InsertAfter(const Node<T> *p){		
	p->next = next;
	next=p;
}

template <typename T>
Node<T> Node<T>::*DeleteAfter(void){
	if (next == NULL){
		return NULL;
	} 
	Node<T> *deleteNode =next;
	next=deleteNode->next;
	return deleteNode;
}

template <typename T>
Node<T>* Node<T>::NextNode(void) const{
	return next;
}

template <typename T>
Node<T>* Node<T>::CreateNode(const  T& data, Node<T>* nextPtr){
	return NULL;
}

 
template <typename T>
void Node<T>::FreeNode(Node<T> *p){
	return NULL;
 }
