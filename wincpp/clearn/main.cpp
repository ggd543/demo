#include "aa.h"

int maincpp_main(int argc, char** argv){ 
  int a = 1; 
  int b = 2; 
  AA* aa = new AA(); 
  aa->bar(a, b); 
  delete(aa);
  return(0); 
}
 