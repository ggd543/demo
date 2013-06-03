#include<iostream>
#include<windows.h>
using namespace std;
void show()
{
cout<<"*";
Sleep(20);
}
int main()
{
int i,j;
//1
for(j=1;j<=56;j++)
{
  
  if(j==7||j==21||j==35||j==44||j>=49&&j<=51)
  {
   show();
   continue;
  }
  cout<<" ";
}
cout<<endl;
//2
for(j=1;j<=46;j++)
{
  if(j%14==0)
  {cout<<" ";continue;}
  show();
}
cout<<endl;
//3
for(j=1;j<+55;j++)
{

  if(j==7||j>=18&&j<=25||j>=34&&j<=36||j==45||j>=47&&j<=53)
  {
   show();
   continue;
  }
  cout<<" ";
}
cout<<endl;
//4
for(j=1;j<=55;j++)
{
  
  if(j>=5&&j<=9||j==16||j==18||j==23||j>=30&&j<=40||j==44||j>=43&&j<=45||j==49||j==51)
   
  {
   show();continue;
  }
  cout<<" ";
}
cout<<endl;
//5
for(j=1;j<=55;j++)
{
  if(j==3||j==18||j==22||j==30||j>=34&&j<=36||j==40||j==44||j==49||j==51)
  {
   show();continue;
  }
  cout<<" ";
}
cout<<endl;
//6
for(j=1;j<=55;j++)
{
  if(j==1||j==3||j==7||j==11||j==13||j==18||j>=20&&j<=24||j==30||j>=34&&j<=36||j==39||j==40||j==43||j==48||j==51||j==52||j==53)
  {
   show();continue;
  }
  cout<<" ";
}
cout<<endl;
///7
for(j=1;j<=55;j++)
{
  if(j>=4&&j<=10||j==18||j==22||j==30||j==40||j>=44&&j<=54)
  {show();continue;}
  cout<<" ";
}
cout<<endl<<endl;
return 0;
}