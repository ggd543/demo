#include <stdio.h>

int main(void){
	enum Weekday{
		sun=3,mon=1,tue, wed, thu,fri,sat
	};
	enum Weekday day1= sun;
	enum Weekday day2=wed;
	if (sun <= wed){
		printf("%d %d\n",sun,wed);
	}
	enum Weekday day3 = (enum Weekday)4;
	if (day3 == thu){
		printf("thu\n");
	}
	enum Weekday day4= (enum Weekday)3;
	if (day4 == sun){
		printf("sun\n");
	}
	if (day4 == wed){
		printf("web\n");
	}

	enum Fruit: char{
		apple='a', orange='o'
	};


	enum Fruit fa = apple;
	enum Fruit fo = (enum Fruit)'o';
	printf("%c",fa);
	printf("%c",fo);
	return 0;
}
