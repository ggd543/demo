package demo;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pair p = new Pair<String>();
        p.setFirst(1);
        System.out.println(p.getFirst());
    }
}

class User{

}

class Admin extends  User{
    
}

class Pair<T> {
    //    public boolean equals(T obj){
//        return true;
//    }
    public void setFirst(T v) {
        this.first = v;
    }
    
    public T getFirst(){
        return this.first;
    }

    private T first;

}
