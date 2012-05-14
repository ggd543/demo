package acm;

import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class NumberFormater {
    private final Scanner scanner;
    public static final int DEFAULT_DECIMAL_COUNT = 2; // 小数后默认四舍五入保留的位数
    private final int decimalCount;
    private final char[] int2char = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public NumberFormater() {
        this(System.in);
    }

    public NumberFormater(InputStream is) {
        this(is, DEFAULT_DECIMAL_COUNT);
    }

    public NumberFormater(InputStream is, int decimalCount) {
        this.scanner = new Scanner(is);
        this.decimalCount = decimalCount;
    }

    public void execute() {
        while (scanner.hasNext()) {
            System.out.println(getAbsFormat(scanner.next()));
        }
    }

    public String format(String input) {
        if (input == null || input.length() == 0) throw new IllegalArgumentException("input is empty");
        char[] num = input.toCharArray();

        int endPos = 0;
        int integerCount = 0; // 整数部分长度
        int decimalCount = 0;  // 小数部分长度
        boolean hasDot = false; // 是否含有点(.)
        for (int i = 0; i < num.length; i++) {
            char ch = num[i];
            if (ch == '.') {
                hasDot = true;
            } else if (hasDot) {
                if (decimalCount < 2) decimalCount++;
                else break;
            } else if (ch >= '0' && ch <= '9') {
                integerCount++;
            }
            endPos++;
        }
        assert (endPos <= num.length);
        int c = 0; // 进位数字
        if (decimalCount >= 2 && endPos < num.length) {
            if (num[endPos] - '0' > 4) {
                // 四舍五入
                c = 1;
                for (int i = endPos - 1; i >= 0; i--) {
                    if (num[i] >= '0' && num[i] <= '9') {
                        int v = (num[i] - '0') + c;
                        num[i] = int2char[v % 10];
                        c = v / 10;
                        if (c == 0) break;
                    }
                }
            }
        }
        assert (c >= 0 && c <= 1);
        StringBuilder sb = new StringBuilder();
        if (num[0] == '-') sb.append("-");
        if (c == 1) sb.append("1");
        if (c == 0 && integerCount == 0) sb.append("0");
        if (num[0] == '-') {
            sb.append(num, 1, endPos - 1);
        } else {
            sb.append(num, 0, endPos);
        }
        if (!hasDot) sb.append(".");
        for (int k = 0; k < 2 - decimalCount; k++) {
            sb.append("0");
        }
        return sb.toString();        //[符号位][进位数字1](至少一位整数)(.)(两位小数)
    }

    public String getAbsFormat(String input) {
        return abs(format(input));
    }

    public String abs(String str) {
        if (str.charAt(0) == '-') return str.substring(1);
        else return str;
    }

    public String format(double d) {
        return format(String.format("%f", d));
    }

    public String format(int i) {
        return format(String.format("%d", i));
    }

    public double parse(String str) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        new NumberFormater(NumberFormater.class.getResourceAsStream("/acm/absNumber.txt")).execute();
    }
}
