package acm;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午9:45
 * To change this template use File | Settings | File Templates.
 */
public class ECalculator {
    private Scanner scanner;

    public ECalculator(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public static void main(String[] args) {
        new ECalculator(System.in).execute();
    }

    public void execute() {
        System.out.println("n e");
        System.out.println("- -----------");
//        System.out.println("0 1");
//        System.out.println("1 2");
//        System.out.println("2 2.5");
//        System.out.println("3 2.666666667");
//        System.out.println("4 2.708333333");
//        System.out.println("5 2.716666667");
//        System.out.println("6 2.718055556");
//        System.out.println("7 2.718253968");
//        System.out.println("8 2.718278770");
//        System.out.println("9 2.718281526");
        double sum = 1;
        double powN = 1; // 缓存 n! ，已知 0! == 1
        System.out.println("0 1");
        powN *= 1;
        sum += 1 / powN;
        System.out.println("1 2");
        powN *= 2;
        sum += 1 / powN;
        System.out.println("2 2.5");
        for (int i = 3; i <= 9; i++) {
            powN *= i;
            sum += 1 / powN;
            System.out.println(String.format("%d %.9f", i, sum));
//
    }
}

}
