#include<iostream>
using namespace std;
int main()
{ 
    int n;
    while(cin >> n)
    {
        int a[10000]; //每个元素放5位的数字，也就是可以放50000位，因为10000！有35660位
        a[0] = 1;    //特殊的，输入0时，答案为1, 
        int t = 0; //标记一个数字在被拆分后放在了数组的几个位置 
        for(int i = 1; i <= n; ++i)
        {
               
            int c = 0;  //表示进位，如362880，大于100000了，进位为3，即c=3 
            for(int j = 0; j <= t; ++j)
            {
                a[j] = a[j]*i + c;//对于答案小于100000来说，这个循环就这一句起作用，其余的都没用，因为这是数字还没有拆分 
                c = a[j] / 100000;//if > 100000了时 
              
                a[j] %= 100000;
            }  
            if(c!=0)  // 如果有进位
            {
               t++;
               a[t] = c;
            }
            
        }
        //输出 
        cout << a[t];
        for(int i = t-1; i >= 0; --i)
           printf("%05d",a[i]);
           
        cout << endl;
   }
        
        return 0;
}