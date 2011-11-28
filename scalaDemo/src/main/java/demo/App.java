package demo;

import java.util.Date;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Pair<? extends String> p = new Pair<String>();
        Pair p = new Pair<String>(null, "Jack");
        Pair<Integer> pp = (Pair<Integer>) p;
        System.out.println(((Pair<Integer>) p).getFirst());
        System.out.println(((Pair<Integer>) p).getSecond() instanceof Object);
//        p.setFirst(1);
//        p.setFirst("a");
//        System.out.println(((Pair<Date>) p).getFirst());
//        System.out.println(p.getFirst() instanceof  Date);
        System.out.println(pp.getClass() == p.getClass());
        System.out.println((p instanceof Pair<?>));  // compile error : p instanceof Pair<String>
        System.out.println((pp instanceof Pair<?>));
        System.out.println(p.getFirst() instanceof String);
        System.out.println(p.getFirst() instanceof Object);
        System.out.println((Object) p.getFirst());
        print(p);
//        Pair<User> pp = new Pair<Admin>(); // compile error
        say(new Date());

        System.out.println("---------------");
        System.out.println(null instanceof String);
        System.out.println(null instanceof Integer);

        System.out.println("---------------");
//        new ParamTypeTest<RuntimeException>().doSomething();
//        new TestPojo().print("Hello world");
    }

    private static void print(Pair<?> p) {
        System.out.println(p.getFirst());
//        p.setFirst("a");
    }

    private static <T extends Object> void say(T obj) {
        System.out.println(obj);
    }
}

class MyException<T> {

}

class User {

}

class Admin extends User {

}


class Pair<T extends Object> {
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T v) {
        this.first = v;
    }

    public void setSecond(T v) {
        this.second = v;
    }

    public <U extends RuntimeException> T getFirst() throws U {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    private T first;
    private T second;
}

class Employee {
    public String name;
}

class Manager extends Employee {
}

