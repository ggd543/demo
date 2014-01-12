#ifndef NODE_CLASS
#define NODE_CLASS


template <typename T>
class Node{
protected:	
	T data;  // 当前节点的数据域
	Node<T> *prev;  // 上一个节点
	Node<T> *next;  // 下一个节点
public:		
	inline Node();

	inline Node(const T& item); 	

	inline ~Node(){
		cout<<"deconstructor "<<data<<endl;
	}
	
	inline T& GetData(void);	 
 
	void InsertBefore(Node<T> * const p); //在节点之前插入节点p

	void InsertAfter(Node<T> * const p); // 在节点之后插入节点p
	
	void Delete(void);	 	

	inline Node<T> *Next(void) ;

	inline Node<T> *Before(void);
};	  

#endif