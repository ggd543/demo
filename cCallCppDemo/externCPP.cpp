// ***************************************************************
//  Name       : externCPP.cpp   
//  Created    : 11/30/2007 by frank
//  Description: Cpp�İ�װ�ļ�
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

//��ע����װ�ļ����������ֻ�Ƕ�һ����ķ�װ����ô���Խ�����������ʵ���ļ���