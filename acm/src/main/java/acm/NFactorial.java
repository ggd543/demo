package acm;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午1:11
 * To change this template use File | Settings | File Templates.
 */
public class NFactorial {
    private final int MAX_SIZE = 100000;  // 作用：定义数组的最大尺寸，
    private final int MAX = 100000; // 每个数组元素的最大位数
    private final Scanner scanner;

    public NFactorial() {
        this.scanner = new Scanner(System.in);
    }

    public NFactorial(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public void execute() {
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String res = compute(n);
            System.out.println(res);
        }//while hasNextInt
    }

    public String compute(int n) {
        if (n == 0) return "1";
        int m = 0;  // 指示数组num已被使用到第几位
        int[] num = new int[MAX_SIZE];  // 用于保存阶乘的结果，数组中的每个整数最多表示100000以内的数字
        num[0] = 1;  // 0! == 1
        for (int i = 1; i <= n; i++) {
            int numSize = m;
            int c = 0; // 进位数字
            for (int j = 0; j <= numSize; j++) {
                int v = num[j] * i + c;
                c = v / MAX; // 进位数字
                num[j] = v % MAX;
            }
            if (c > 0) {
                num[++m] = c;
            }
        }// compute n!
        String res = getResult(num, m);
        return res;
    }

    private String getResult(int num[], int m) {
        StringBuilder sb = new StringBuilder();
        sb.append(num[m]);
        for (int i = m - 1; i >= 0; i--) {
            sb.append(String.format("%05d", num[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        new NFactorial(NFactorial.class.getResourceAsStream("/acm/nfactorial.txt")).execute();
        System.out.println((System.nanoTime() - start) / 1000000 + " ms");
    }
}
