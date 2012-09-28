package jvm;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-10
 * Time: 下午10:12
 * To change this template use File | Settings | File Templates.
 */
public class Dispatch {
    static class QQ {

    }

    static class QQ2010 extends QQ {

    }

    static class QQ2011 extends QQ {
    }

    static class _360 {

    }


    public static class Father {
        public void hardChoice(QQ qq) {
            System.out.println("father choose QQ");
        }

        public void hardChoice(QQ2010 qq) {
            System.out.println("Father choose QQ2010");
        }


        public void hardChoice(QQ2011 qq) {
            System.out.println("Father choose QQ2011");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ qq) {
            System.out.println("Son choose QQ");
        }

        public void hardChoice(QQ2010 qq) {
            System.out.println("Son choose QQ2010");
        }


        public void hardChoice(QQ2011 qq) {
            System.out.println("Son choose QQ2011");
        }

        public void hardChoice(_360 arg) {
            System.out.println("Son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        QQ qq = new QQ2010();
        father.hardChoice(qq);
        son.hardChoice(new _360());
    }

}


