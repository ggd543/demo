// ***************************************************************
//  Name       : CC.CPP   
//  Created    : 11/30/2007 by frank
//  Description: C类的实现文件
//  version    :  1.0
//  Copyright (C) 2007 CaiTong - All Rights Reserved
// ***************************************************************
#include <iostream>
#include "cc.h" 

using namespace std;


double C::f(int i)
{
	add(i);
	printf("Hello World! \n%d\n",i);
	return i;
}

double C::f(double i)
{
	add(i);
	printf("Hello World! \n%f\n",i);
	return i;
}

void C::add(int &a)
{
	a += 1;
}

void C::add(double &a)
{
	a += 1.1; 
}

