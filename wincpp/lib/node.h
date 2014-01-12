#ifndef NODE_CLASS
#define NODE_CLASS

template <typename T>
class Node{
private:
	Node<T> *next;  // 下一个节点
public:	
	T data;  // 当前节点的数据域
	Node(const T& item, Node<T> *ptnext=NULL); 	
	void InsertAfter(const Node<T> *p); // 在当前节点之后插入节点p
	Node<T> *DeleteAfter(void);  //删除当前节点的后继节点，并返回其地址
	Node<T> *NextNode(void) const;  // 返回当前节点的下一个节点的地址

	static Node<T>* CreateNode(const T& data, Node<T>* nextPtr = NULL);  // 创建一个Node节点

	static void FreeNode(Node<T> *p);
};
 
#endif

