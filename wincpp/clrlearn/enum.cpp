#include <iostream>

using namespace System;

enum class Fruit:char {
	Apple='a', Orange, Banana
};

int a=1;

namespace A{
	namespace AA{
		int fp=78;
	}
}


int main(array<System::String^>^ args){
	const int a=9;
	Int32 i=0;
	Console::WriteLine(i);
	::Fruit fruit = ::Fruit::Apple;
	std::cout<<a<<std::endl;
	std::cout<<::a<<std::endl;
	std::cout<<A::AA::fp<<std::endl;
	Console::WriteLine(L"{0:D}",safe_cast<int>(fruit));
	Console::WriteLine(L"{0:G}",safe_cast<char>(fruit));
	int b=9;
	int c = (!(3>2))?(b=3):(b=5);	
	Console::WriteLine("{0},{1}",c,b);
	return 0;
}

