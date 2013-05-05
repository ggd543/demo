// ***************************************************************
//  Name       : externCPP.cpp   
//  Created    : 11/30/2007 by frank
//  Description: Cpp的包装文件
//  version    :  1.0
//  Copyright (C) 2007 CaiTong - All Rights Reserved
// ***************************************************************
#include "cc.h"


extern "C" double call_C_f_i(C* p, int i) // wrapper function
{
	return p->f(i);
}

extern "C" double call_C_f_d(C* p, double i)// wrapper function
{
	return p->f(i);
}

//另注：包装文件的内容如果只是对一个类的封装，那么可以将其放置在类的实现文件中