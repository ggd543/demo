// ***************************************************************
//  Name       : cCallCppDemo.cpp   
//  Created    : 11/30/2007 by frank
//  Description: ����ʵ���ļ�
//  version    :  1.0
//  Copyright (C) 2007 CaiTong - All Rights Reserved
// ***************************************************************

#include <iostream>
using namespace std;

//��������Ϊ�ⲿ�ļ�����
extern "C" double call_C_f_i(struct C* p, int i); 
extern "C" double call_C_f_d(struct C* p, double i);
//�������������� double call_C_f_i(struct C* p, int i); ��
//extern double call_C_f_i(struct C* p, int i);���ַ�ʽ������
//���Ǳ��붼ͨ���������Ǹ�BJ�ĵ��г����һ���ط�
//���ڵ����ʣ���֪��������һ���Ƿ������VC�����������ԭ��ϣ���и��ְ�æ������

int main(int argc, char* argv[])
{
	double mm = call_C_f_i(NULL, 10);
	printf("%f\n",mm);

	mm = call_C_f_d(NULL, 10.0);
	printf("%f\n",mm);
	return 0;
}

//ע�����Ǳ��˵�һ��ʹ��C����CPP��Ա��������֪���Ƿ����Ҫ��ϣ��������C/C++�����߽���
//�������䣺frank.sunny@163.com
//ͬʱ�ǳ���лC++����԰�ϵ��������ģ�����������ϸ�ģ����Լ�Ҳ����ô���ƹ�ȥ�ˣ�^_^
