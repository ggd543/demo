package acm;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */
public class BigInteger {
    private final char[] int2char = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Scanner scanner;

    public BigInteger(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public void execute() {

        int n =scanner.nextInt();
        for(int i =1; i<=n; i++){
            String a = scanner.next();
            String b = scanner.next();
            String c = add(a, b);
            System.out.println(String.format("Case %d:", i));
            System.out.println(String.format("%s + %s = %s", a, b, c));
            if (i < n)
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new BigInteger(BigInteger.class.getResourceAsStream("/acm/bigInteger.txt")).execute();
    }

    public String add(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        char[] cArray = new char[aArray.length > bArray.length ? aArray.length : bArray.length];

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int c = 0;  // 进制位
        int k = cArray.length - 1;
        while (i >= 0 && j >= 0) {
            int v = (aArray[i] - '0') + (bArray[j] - '0') + c;
            cArray[k--] = int2char[v % 10];
            c = v / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int v = (aArray[i] - '0') + c;
            cArray[k--] = int2char[v % 10];
            c = v / 10;
            i--;
        }
        while (j >= 0) {
            int v = (bArray[j] - '0') + c;
            cArray[k--] = int2char[v % 10];
            c = v / 10;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        if (c == 1) sb.append(1);
        sb.append(cArray);
        return sb.toString();
    }


}
