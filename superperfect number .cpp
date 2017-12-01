// ConsoleApplication1.cpp : Defines the entry point for the console application.
//let us say that 2 is superperfect number so 
// 2 +1 = 3 -- 3 +1 = 4 --  4/2 =2 
//
#include "stdS"

int _tmain(int argc, _TCHAR* argv[])
{
	int i, x, j, k;
	cin >> x;
	for (k = 1; k <= x; k++)
	{
		int y = 0, z = 0;
		for (i = 1; i <= k; i++)
		if (k%i == 0)
		{
			y = y + i;
		}
		for (j = 1; j <= y; j++)
		if (y%j == 0)
		{
			z = z + j;
		}
		if (z == (k * 2))
			cout << k << " is a super perfect no\n";
	}
	return 0;
}

