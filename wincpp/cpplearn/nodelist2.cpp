#include <iostream>
#include "node.h"

using namespace std;

void invoke(void){
	Node<double>* doubleNode= Node<double>::CreateNode(2.5,NULL);
	Node<double>::FreeNode(doubleNode);
}
