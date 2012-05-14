package acm;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-11
 * Time: 下午11:30
 * To change this template use File | Settings | File Templates.
 */
public class APlusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            while(scanner.hasNextInt()){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(a+b);
            }
        }catch(Exception e){
            // do nothing 
        }
    }
}
