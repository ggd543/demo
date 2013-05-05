// ***************************************************************
//  Name       : CC.H   
//  Created    : 11/30/2007 by frank
//  Description: C类的头文件
//  version    :  1.0
//  Copyright (C) 2007 CaiTong - All Rights Reserved
// ***************************************************************

#ifndef _CC_H_
#define _CC_H_

class C
{
	// ...
public://外部包装只能是公共的接口
	double f(int);
	double f(double);
private:
	void add(int & a);
	void add(double &a);
};

#endif