package demo;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-6-24
 * Time: 上午12:16
 * To change this template use File | Settings | File Templates.
 */
public  enum StaticClass {
    NEW,OLD
}

class A{
    
}

class B extends A{
    B() {
        super();
//        this(1);
    }
    B(int i ){
        
    }

    public void print(int i){
        System.out.println("abc");
    }
    
}


