package classloader;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-4
 * Time: 下午11:52
 * To change this template use File | Settings | File Templates.
 */
public class DeadLoopClass {
    static {
        // 如果不加上这个if 语句，编译器提示"Initializer does not complete normally"
//        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {
                break;
            }
//        }
    }

    public void doThing(){
            while (true){

            }
        }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run.over");
            }
        };
        Thread t1 = new Thread(script);
        Thread t2 = new Thread(script);
        t1.start();
        t2.start();
    }


}
