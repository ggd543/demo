// clrlearn.cpp: 主项目文件。

#include "stdafx.h"

using namespace System;
 

int main(array<System::String ^> ^args)
{
	int apple=34;
    Console::WriteLine(L"Hello World");
	Console::WriteLine(apple);
	int a=3,b=3;
	Console::WriteLine("a={0}, b={1}",a,b);
	
	Console::WriteLine("0,3:F3: {0,3:F3}",2.5);
	Console::WriteLine("0,3:D6: {0,3:D6}",2523);
	Console::WriteLine("0,3:D: {0,3:D}",2523);
	Console::WriteLine("0,3:D: {0,3:D}",123213231231232523);
	Console::WriteLine("0,3:G6: {0,3:G6}",2523);
	Console::WriteLine("0,3:G2: {0,3:G2}",2523);
	Console::WriteLine("0,3:N2: {0,3:N2}",123456);
	 
	
	String^ line = Console::ReadLine();
	Console::WriteLine(line);
	char ch = Console::Read();
	Console::WriteLine(ch);
	ConsoleKeyInfo keyPress= Console::ReadKey();
	Console::WriteLine(keyPress.KeyChar);
    return 0;
}
