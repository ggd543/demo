#include <iostream>

using namespace std;

class Goal{
public:
	virtual void setGoal() =0;
};

class LearnGoal:public Goal{
public:
	 void setGoal();
};

void LearnGoal::setGoal(){
	cout<<"learn goal"<<endl;
}

class FuxkLearnGoal :public LearnGoal{
public:
	void setGoal();
};


void FuxkLearnGoal::setGoal(){
	cout<<"fuxk learn goal"<<endl;
}
 

int main(){
	Goal* g=new LearnGoal;
	g->setGoal();
	g=new FuxkLearnGoal();
	g->setGoal();
	return 0;
}
