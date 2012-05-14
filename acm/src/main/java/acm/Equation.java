package acm;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class Equation {
    private Scanner scanner;

    public Equation(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public static void main(String[] args) {
        new Equation(Equation.class.getResourceAsStream("/acm/equation.txt")).execute();
    }

    private boolean isInt(double s) {
        double q = (s - (int) s);
        return Math.abs(q) < 0.000001 ? true : false;
    }

    public boolean hasIntAnswer(int p, int q) {
        if (q == 0) {
            return true;
        }
        int delta = p * p - 4 * q;
        if (delta < 0) {
            return false;
        }
        double x1 = (p + Math.sqrt(delta)) / 2;
        double x2 = (p - Math.sqrt(delta)) / 2;
//        System.out.println("x1 = "+x1+ "  x2 = "+x2);
        return (isInt(x1) && isInt(x2)) ? true : false;
    }

    public void execute() {
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (p == 0 && q == 0) break;
            if (hasIntAnswer(p, q))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }


}
