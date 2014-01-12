#ifndef NODE_CLASS
#define NODE_CLASS

template <typename T>
class Node{
private:
	Node<T> *next;  // ��һ���ڵ�
public:	
	T data;  // ��ǰ�ڵ��������
	Node(const T& item, Node<T> *ptnext=NULL); 	
	void InsertAfter(const Node<T> *p); // �ڵ�ǰ�ڵ�֮�����ڵ�p
	Node<T> *DeleteAfter(void);  //ɾ����ǰ�ڵ�ĺ�̽ڵ㣬���������ַ
	Node<T> *NextNode(void) const;  // ���ص�ǰ�ڵ����һ���ڵ�ĵ�ַ

	static Node<T>* CreateNode(const T& data, Node<T>* nextPtr = NULL);  // ����һ��Node�ڵ�

	static void FreeNode(Node<T> *p);
};
 
#endif

