#ifndef LINKED_LIST
#define LINKED_LIST

#include "node.h"

template <typename T>
class LinkedList{
private:
	Node<T> *front, *rear; //表头和表尾指针
	Node<T> *prevPtr, *currPtr;  // 前一个节点指针和当前节点指针
	Node<T> *markPtr;
	int size;	

public:
	LinkedList(void); //构造一个空链表

	LinkedList(const LinkedList<T> &L); 

	~LinkedList(void); 

	LinkedList<T>& operator =(const LinkedList<T> &L);

	int ListSize(void) const;

	int IsEmpty(void ) const ;	

	void Next(void);  // 使prevPtr和currPtr移动到下一个节点

	void IsEndOfList(void) const;

	void Mark(void);

	void Mark(int pos);

	void Reset(void ) ; 

	void InsertFront(const T& item);  // 在表头插入节点

	void InsertRear(const T& item); // 在表尾插入节点

	void InsertBefore(const T& item);  // 在当前节点之前插入节点

	void InsertAfter(const T& item);  // 在当前节点之后插入节点

	Node<T> *DeleteFront(void );

	void RemoveFront(void);

	Node<T> *DeleteRear(void);

	void RemoveRear(void);

	Node<T> *DeleteCurrent(void);

	void RemoveCurrent(void);

	T& CurrentData(void) const ;

	void ClearList(void);

	const Node<T>& Get(int pos) const;


};


#endif