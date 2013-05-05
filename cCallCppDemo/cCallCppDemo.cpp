// ***************************************************************
//  Name       : cCallCppDemo.cpp   
//  Created    : 11/30/2007 by frank
//  Description: 测试实现文件
//  version    :  1.0
//  Copyright (C) 2007 CaiTong - All Rights Reserved
// ***************************************************************

#include <iostream>
using namespace std;

//声明函数为外部文件定义
extern "C" double call_C_f_i(struct C* p, int i); 
extern "C" double call_C_f_d(struct C* p, double i);
//在这里曾尝试用 double call_C_f_i(struct C* p, int i); 和
//extern double call_C_f_i(struct C* p, int i);两种方式声明过
//但是编译都通不过，这是跟BJ文档有出入的一个地方
//现在的疑问，不知道关于这一点是否跟我在VC编译器里面的原因，希望有高手帮忙测试下

int main(int argc, char* argv[])
{
	double mm = call_C_f_i(NULL, 10);
	printf("%f\n",mm);

	mm = call_C_f_d(NULL, 10.0);
	printf("%f\n",mm);
	return 0;
}

//注：这是本人第一次使用C调用CPP成员函数，不知道是否符合要求，希望能与广大C/C++爱好者交流
//本人邮箱：frank.sunny@163.com
//同时非常感谢C++博客园上的梦在天涯，如果不是你的细心，我自己也就那么忽悠过去了，^_^
