#ifndef LINKED_LIST
#define LINKED_LIST

#include "node.h"

template <typename T>
class LinkedList{
private:
	Node<T> *front, *rear; //��ͷ�ͱ�βָ��
	Node<T> *prevPtr, *currPtr;  // ǰһ���ڵ�ָ��͵�ǰ�ڵ�ָ��
	Node<T> *markPtr;
	int size;	

public:
	LinkedList(void); //����һ��������

	LinkedList(const LinkedList<T> &L); 

	~LinkedList(void); 

	LinkedList<T>& operator =(const LinkedList<T> &L);

	int ListSize(void) const;

	int IsEmpty(void ) const ;	

	void Next(void);  // ʹprevPtr��currPtr�ƶ�����һ���ڵ�

	void IsEndOfList(void) const;

	void Mark(void);

	void Mark(int pos);

	void Reset(void ) ; 

	void InsertFront(const T& item);  // �ڱ�ͷ����ڵ�

	void InsertRear(const T& item); // �ڱ�β����ڵ�

	void InsertBefore(const T& item);  // �ڵ�ǰ�ڵ�֮ǰ����ڵ�

	void InsertAfter(const T& item);  // �ڵ�ǰ�ڵ�֮�����ڵ�

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