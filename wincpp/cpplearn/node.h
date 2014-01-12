#ifndef NODE_CLASS
#define NODE_CLASS


template <typename T>
class Node{
protected:	
	T data;  // ��ǰ�ڵ��������
	Node<T> *prev;  // ��һ���ڵ�
	Node<T> *next;  // ��һ���ڵ�
public:		
	inline Node();

	inline Node(const T& item); 	

	inline ~Node(){
		cout<<"deconstructor "<<data<<endl;
	}
	
	inline T& GetData(void);	 
 
	void InsertBefore(Node<T> * const p); //�ڽڵ�֮ǰ����ڵ�p

	void InsertAfter(Node<T> * const p); // �ڽڵ�֮�����ڵ�p
	
	void Delete(void);	 	

	inline Node<T> *Next(void) ;

	inline Node<T> *Before(void);
};	  

#endif