#include <windows.h>
#include <conio.h>
#include <stdio.h>
#define HEART 3
#define ONEIN 45
void gotoxy(int x, int y);
void display();
void conDis(int n);
void zhu();
void tian();
void xia();
void ma();
void ma2();
void mu();
void qin();
void jie();
void kuai();
void le();
int main()
{  
        zhu();
        tian();
        xia();
        ma();
        ma2();
        mu();
        qin();
        jie();
        kuai();
        le();
 
        gotoxy(7,24);
        printf("I love you,Mom!");
        getchar();
    return 0;
 
}
void zhu()
{
        gotoxy(0,5);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(1,3);
        display();
        ::Sleep(ONEIN);
        conDis(3);
        gotoxy(2,5);
        display();
        gotoxy(3,4);
        display();;
        gotoxy(4,3);
        display();
        ::Sleep(ONEIN);
  
        gotoxy(3,5);
        display();
        gotoxy(4,5);
        display();
        gotoxy(5,5);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(3,6);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(0,8);
        display();
        gotoxy(1,8);
        display();
        gotoxy(2,8);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(0,9);
        display();
        gotoxy(0,10);
        display();
        gotoxy(0,11);
        display();
        gotoxy(0,12);
        display();
        gotoxy(1,12);
        display();
        gotoxy(2,12);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,9);
        display();
        gotoxy(2,10);
        display();
        gotoxy(2,11);
        display();
    ::Sleep(ONEIN);
 
        gotoxy(3,10);
        display();
        gotoxy(4,9);
        display();
        gotoxy(5,8);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(4,10);
        display();
        gotoxy(5,10);
        display();
        gotoxy(5,11);
        display();
        gotoxy(5,12);
        display();
        gotoxy(4,12);
        display();
        ::Sleep(ONEIN);
         
}

void tian()
{
        gotoxy(0,15);
        conDis(7);
        ::Sleep(ONEIN);
 
        gotoxy(2,15);
        conDis(7);
        ::Sleep(ONEIN);
 
        gotoxy(1,18);
        display();
        gotoxy(3,18);
        display();
        gotoxy(4,17);
        display();
        gotoxy(5,16);
        display();
        gotoxy(5,15);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(4,19);
        display();
        gotoxy(5,20);
        display();
        gotoxy(5,21);
        display();
        ::Sleep(ONEIN);
}
void xia()
{
        gotoxy(0,24);
        conDis(7);
        gotoxy(1,27);
        display();
        gotoxy(2,27);
        display();
        gotoxy(3,27);
        display();
        gotoxy(4,27);
        display();
        gotoxy(5,27);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,28);
        display();
        gotoxy(3,29);
        display();
        ::Sleep(ONEIN);
}
void ma()
{
        gotoxy(0,35);
        display();
        gotoxy(1,34);
        display();
        gotoxy(2,33);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(3,34);
        display();
        gotoxy(4,35);
        display();
        gotoxy(5,36);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,37);
        display();
        gotoxy(3,36);
        display();
        gotoxy(5,34);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,32);
        display();
        conDis(5);
        ::Sleep(ONEIN);
 
        gotoxy(0,39);
        conDis(5);
        gotoxy(1,43);
        display();
        gotoxy(2,43);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,39);
        display();
        gotoxy(3,39);
        display();
        conDis(4);
        gotoxy(4,43);
        display();
        gotoxy(5,43);
        display();
        gotoxy(5,42);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(4,38);
        conDis(5);
 
 
}
void ma2()
{
        gotoxy(0,49);
        display();
        gotoxy(1,48);
        display();
        gotoxy(2,47);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(3,48);
        display();
        gotoxy(4,49);
        display();
        gotoxy(5,50);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,51);
        display();
        gotoxy(3,50);
        display();
        gotoxy(5,48);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,46);
        display();
        conDis(5);
        ::Sleep(ONEIN);
 
        gotoxy(0,53);
        conDis(5);
        gotoxy(1,57);
        display();
        gotoxy(2,57);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(2,53);
        display();
        gotoxy(3,53);
        display();
        conDis(4);
        gotoxy(4,57);
        display();
        gotoxy(5,57);
        display();
        gotoxy(5,56);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(4,52);
        conDis(5);
        ::Sleep(ONEIN);
 
}
void mu()
{
        gotoxy(10,4);
        display();
        gotoxy(11,4);
        display();
        gotoxy(12,4);
        display();
        gotoxy(13,4);
        display();
        gotoxy(14,4);
        conDis(8);
        ::Sleep(ONEIN);
 
        gotoxy(10,4);
        conDis(8);
        gotoxy(11,11);
        display();
        gotoxy(12,11);
        display();
        gotoxy(13,11);
        display();
        gotoxy(14,11);
        display();
        gotoxy(15,11);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(11,7);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,3);
        conDis(10);
        ::Sleep(ONEIN);
 
        gotoxy(13,7);
        display();
        ::Sleep(ONEIN);
}
void qin()
{
        gotoxy(9,18);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(10,16);
        conDis(5);
        ::Sleep(ONEIN);
 
        gotoxy(11,17);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(11,19);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,15);
        conDis(7);
        ::Sleep(ONEIN);
 
        gotoxy(13,16);
        conDis(5);
        ::Sleep(ONEIN);
 
        gotoxy(14,18);
        display();
        gotoxy(15,18);
        display();
        gotoxy(15,17);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(14,15);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(14,21);
        display();
        ::Sleep(ONEIN);
 
}
void jie()
{
        gotoxy(10,24);
        conDis(7);
        ::Sleep(ONEIN);
 
        gotoxy(9,25);
        display();
        gotoxy(11,25);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(9,29);
        display();
        gotoxy(11,29);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,24);
        conDis(7);
        gotoxy(13,30);
        display();
        gotoxy(14,30);
        display();
        gotoxy(14,29);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(13,27);
        display();
        gotoxy(14,27);
        display();
        gotoxy(15,27);
        display();
        ::Sleep(ONEIN);
}
void kuai()
{
        gotoxy(12,33);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(9,34);
        display();
        gotoxy(10,34);
        display();
        gotoxy(11,34);
        display();
        gotoxy(12,34);
        display();
        gotoxy(13,34);
        display();
        gotoxy(14,34);
        display();
        gotoxy(15,34);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,35);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,33);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(10,38);
        conDis(5);
        gotoxy(11,42);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(12,37);
        conDis(7);
        ::Sleep(ONEIN);
 
        gotoxy(9,40);
        display();
        gotoxy(11,40);
        display();
        gotoxy(13,40);
        display();
        gotoxy(14,39);
        display();
        gotoxy(15,38);
        display();
        gotoxy(15,37);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(14,41);
        display();
        gotoxy(15,42);
        display();
        gotoxy(15,43);
        display();
        ::Sleep(ONEIN);
}
void le()
{
         
        gotoxy(9,47);
        conDis(9);
        ::Sleep(ONEIN);
 
        gotoxy(10,47);
        display();
        gotoxy(11,47);
        conDis(9);
        ::Sleep(ONEIN);
 
        gotoxy(10,51);
        display();
        gotoxy(12,51);
        display();
        gotoxy(13,51);
        display();
        gotoxy(14,51);
        display();
        gotoxy(15,51);
        display();
        gotoxy(15,50);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(13,48);
        display();
        gotoxy(14,47);
        display();
        ::Sleep(ONEIN);
 
        gotoxy(13,53);
        display();
        gotoxy(14,54);
        display();
        ::Sleep(ONEIN);
}
void display ()
{
        putchar(HEART);
        ::Sleep(ONEIN);
}
void conDis(int n)
{
        for (int i = 0; i < n; i++)
                display();
}
void gotoxy(int x, int y)
{
    COORD coord = {y, x};
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}