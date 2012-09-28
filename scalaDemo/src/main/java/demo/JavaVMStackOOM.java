package demo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-17
 * Time: 下午10:07
 * To change this template use File | Settings | File Templates.
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM com = new JavaVMStackOOM();
        com.stackLeakByThread();
    }
}
