#include <Windows.h>

char m_title[10] = "MyTitle";

typedef struct TALL
{
	int x;
	int y;
	struct TALL* next;
}Tall;

Tall* h1 = NULL;//丶
Tall* e1 = NULL;

Tall* h2 = NULL;//フ
Tall* e2 = NULL;

Tall* h3 = NULL;//丨
Tall* e3 = NULL;

Tall* h4 = NULL;//丶
Tall* e4 = NULL;

Tall* h5 = NULL;//一
Tall* e5 = NULL;

Tall* h6 = NULL;//丨
Tall* e6 = NULL;

Tall* h7 = NULL;//┒
Tall* e7 = NULL;

Tall* h8 = NULL;//一
Tall* e8 = NULL;

Tall* h9 = NULL;//丨
Tall* e9 = NULL;

Tall* h10 = NULL;//┒
Tall* e10 = NULL;

Tall* h11 = NULL;//一
Tall* e11 = NULL;

Tall* h12 = NULL;//丨
Tall* e12 = NULL;

Tall* h13 = NULL;//一
Tall* e13 = NULL;

HINSTANCE hIns;
HDC hDc = NULL;

int DBH = 0;

LRESULT CALLBACK MyWNDProc(HWND hwnd,
						   UINT uMsg,
						   WPARAM wParam,
						   LPARAM lParam
						   );

void CALLBACK TimeProc(HWND hwnd,
						   UINT uMsg,
						   UINT_PTR idEvent,
						   DWORD dwTime
						   );


int CALLBACK WinMain( HINSTANCE hInstance,
					 HINSTANCE hPrevInstance,
					 LPSTR lpCmdLine,
					 int nShowCmd )
{
	hIns = hInstance;
	WNDCLASSEX wndclassex;
	wndclassex.cbClsExtra = 0;
	wndclassex.cbSize = sizeof(WNDCLASSEX);
	wndclassex.cbWndExtra = 0;
	wndclassex.hbrBackground = (HBRUSH)COLOR_WINDOW;
	wndclassex.hCursor = NULL;
	wndclassex.hIconSm = NULL;
	wndclassex.hIcon = NULL;
	wndclassex.hInstance = hIns;
	wndclassex.lpfnWndProc = MyWNDProc;
	wndclassex.lpszClassName = m_title;
	wndclassex.lpszMenuName = NULL;
	wndclassex.style = CS_HREDRAW | CS_VREDRAW;

	RegisterClassEx(&wndclassex);

	HWND hWnd = CreateWindow(m_title,"MyWindow",WS_OVERLAPPEDWINDOW,100,100,300+16,300+38,NULL,NULL,hIns,NULL);

	ShowWindow(hWnd,SW_SHOW);

	MSG msg;
	while (GetMessageW(&msg,hWnd,0,0))
	{
		TranslateMessage(&msg);
		DispatchMessageW(&msg);
	}
	return 0;
}


Tall* CreatePP(Tall* h, Tall* e,int BNumx, int BNumy)
{
	Tall* temp = new Tall;
	temp->x = BNumx;
	temp->y = BNumy;
	temp->next = NULL;
	
	h = temp;
	return h;
}

// Tall* FnEnd(Tall* h)
// {
// 	Tall* temp = h;
// 	while( temp->next != NULL)
// 	{
// 		temp = temp->next;
// 	}
// 	return temp;
// }

Tall* Add(Tall* e,int endNumx, int endNumy, int BH)
{
	if ( 1 == BH )
	{
		if ( e->x != endNumx && e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y + 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 2 == BH )
	{
		if ( 0 == DBH )
		{
			if ( e->x != endNumx )
			{
				Tall* temp = new Tall;
				temp->x = e->x + 10;
				temp->y = e->y;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//1
			}
		}
		if ( 1 == DBH )
		{
			if ( e->x != 20 && e->y != 190 )
			{
				Tall* temp = new Tall;
				temp->x = e->x - 10;
				temp->y = e->y + 10;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//2
			}
		}
	}
	if ( 3 == BH )
	{
		if (  e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x;
			temp->y = e->y + 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 4 == BH )
	{
		if (  e->x != endNumx && e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y + 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 5 == BH )
	{
		if (  e->x != endNumx )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 6 == BH )
	{
		if (  e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x;
			temp->y = e->y + 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 7 == BH )
	{
		if ( 2 == DBH )
		{
			if ( e->x != endNumx )
			{
				Tall* temp = new Tall;
				temp->x = e->x + 10;
				temp->y = e->y;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//3
			}
		}
		if ( 3 == DBH )
		{
			if (  e->y != 130 )
			{
				Tall* temp = new Tall;
				temp->x = e->x;
				temp->y = e->y + 10;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//4
			}
		}
	}
	if ( 8 == BH )
	{
		if ( e->x != endNumx )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 9 == BH )
	{
		if ( e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x ;
			temp->y = e->y+ 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 10 == BH )
	{
		if ( 4 == DBH )
		{
			if ( e->x != endNumx )
			{
				Tall* temp = new Tall;
				temp->x = e->x + 10;
				temp->y = e->y;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//5
			}
		}
		if ( 5 == DBH )
		{
			if ( e->y != 240 )
			{
				Tall* temp = new Tall;
				temp->x = e->x;
				temp->y = e->y + 10;
				temp->next = NULL;

				e->next = temp;
				e = temp;
			}
			else
			{
				++DBH;//6
			}
		}
	}
	if ( 11 == BH )
	{
		if ( e->x != endNumx )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 12 == BH )
	{
		if ( e->y != endNumy )
		{
			Tall* temp = new Tall;
			temp->x = e->x ;
			temp->y = e->y+ 10;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	if ( 13 == BH )
	{
		if ( e->x != endNumx )
		{
			Tall* temp = new Tall;
			temp->x = e->x + 10;
			temp->y = e->y;
			temp->next = NULL;

			e->next = temp;
			e = temp;
		}
	}
	return e;
}

void Show(Tall* h)
{
	Tall* fn = h;
	while ( fn != NULL )
	{
		Rectangle(hDc, fn->x, fn->y, fn->x+10, fn->y+10);
		fn = fn->next;
	}

}
LRESULT CALLBACK MyWNDProc(HWND hwnd,
						   UINT uMsg,
						   WPARAM wParam,
						   LPARAM lParam
						   )
{
	switch (uMsg)
	{
	case WM_CREATE:
		hDc = GetDC(hwnd);
		h1 = CreatePP(h1,e1,70,60);
		e1 = h1;

		h2 = CreatePP(h2,e2,40,90);
		e2 = h2;

		h3 = CreatePP(h3,e3,90,130);
		e3 = h3;

		h4 = CreatePP(h4,e4,100,150);
		e4 = h4;

		h5 = CreatePP(h5,e5,150,70);
		e5 = h5;

		h6 = CreatePP(h6,e6,160,90);
		e6 = h6;

		h7 = CreatePP(h7,e7,170,90);
		e7 = h7;

		h8 = CreatePP(h8,e8,170,130);
		e8 = h8;

		h9 = CreatePP(h9,e9,140,150);
		e9 = h9;

		h10 = CreatePP(h10,e10,150,150);
		e10 = h10;

		h11 = CreatePP(h11,e11,150,190);
		e11 = h11;

		h12 = CreatePP(h12,e12,195,160);
		e12 = h12;

		h13 = CreatePP(h13,e13,150,240);
		e13 = h13;
		break;
	case WM_PAINT:
		Rectangle(hDc, 0, 0, 400, 400);
		Show(h1);
		Show(h2);
		Show(h3);
		Show(h4);
		Show(h5);
		Show(h6);
		Show(h7);
		Show(h8);
		Show(h9);
		Show(h10);
		Show(h11);
		Show(h12);
		Show(h13);
		break;
	case WM_KEYDOWN:
		{
			switch(wParam)
			{
			case VK_RETURN:
				SetTimer(hwnd, 1, 100, TimeProc);
				SetTimer(hwnd, 2, 100, TimeProc);
				SetTimer(hwnd, 3, 100, TimeProc);
				SetTimer(hwnd, 4, 100, TimeProc);
				SetTimer(hwnd, 5, 100, TimeProc);
				SetTimer(hwnd, 6, 100, TimeProc);
				SetTimer(hwnd, 7, 100, TimeProc);
				SetTimer(hwnd, 8, 100, TimeProc);
				SetTimer(hwnd, 9, 100, TimeProc);
				SetTimer(hwnd, 10, 100, TimeProc);
				SetTimer(hwnd, 11, 100, TimeProc);
				SetTimer(hwnd, 12, 100, TimeProc);
				SetTimer(hwnd, 13, 100, TimeProc);
				
				break;
			case VK_SPACE:
				KillTimer(hwnd,1);
				KillTimer(hwnd,2);
				KillTimer(hwnd,3);
				KillTimer(hwnd,4);
				KillTimer(hwnd,5);
				KillTimer(hwnd,6);
				KillTimer(hwnd,7);
				KillTimer(hwnd,8);
				KillTimer(hwnd,9);
				KillTimer(hwnd,10);
				KillTimer(hwnd,11);
				KillTimer(hwnd,12);
				KillTimer(hwnd,13);
				break;
			}
		}
		break;
	case WM_DESTROY:
		ReleaseDC(hwnd,hDc);
		PostQuitMessage(0);
		break;
	}
	return DefWindowProc(hwnd,uMsg,wParam,lParam);
}


void CALLBACK TimeProc(HWND hwnd,
						   UINT uMsg,
						   UINT_PTR idEvent,
						   DWORD dwTime
							)
{
	switch(uMsg)
	{
	case WM_TIMER:
		//Rectangle(hDc, 0, 0, 400, 400);
		switch(idEvent)
		{
		case 1:
			//Rectangle(hDc, 0, 0, 400, 400);
			e1 = Add(e1, 90, 80, 1);
			Show(h1);
			break;
		case 2:
			//Rectangle(hDc, 0, 0, 400, 400);
			e2 = Add(e2, 130, 90, 2);
			Show(h2);
			break;
		case 3:
			e3 = Add(e3, 80, 250, 3);
			Show(h3);
			break;
		case 4:
			e4 = Add(e4, 120, 170, 4);
			Show(h4);
			break;
		case 5:
			e5 = Add(e5, 240, 70, 5);
			Show(h5);
			break;
		case 6:
			e6 = Add(e6, 190, 130, 6);
			Show(h6);
			break;
		case 7:
			e7 = Add(e7, 230, 90, 7);
			Show(h7);
			break;
		case 8:
			e8 = Add(e8, 220, 130, 8);
			Show(h8);
			break;
		case 9:
			e9 = Add(e9, 160, 240, 9);
			Show(h9);
			break;
		case 10:
			e10 = Add(e10, 250, 150, 10);
			Show(h10);
			break;
		case 11:
			e11 = Add(e11, 240, 190, 11);
			Show(h11);
			break;
		case 12:
			e12 = Add(e12, 195, 230, 12);
			Show(h12);
			break;
		case 13:
			e13 = Add(e13, 240, 240, 13);
			Show(h13);
			break;
		}
		break;
	}
}