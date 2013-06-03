include <iostream>

namespace MyStuff{
	int value = 9;
	int main(){
		std::cout<<"MyStuff::main"<<std::endl;
		return 1;
	}
}

namespace YouStuff{
	void doSomething(){
		MyStuff::main();
	}
}

namespace MyStuff{
	int vvl= value;
}

int main(){
	std::cout<<MyStuff::value<<std::endl;
	std::cout<<"hello world"<<std::endl;
	std::cout<<MyStuff::vvl<<std::endl;
	MyStuff::main();
	return 0;
}
