package acm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 上午12:21
 * To change this template use File | Settings | File Templates.
 */

public class Stone {
    public static boolean isLogLevelOn = false;

    private static int MAX_STONE = 20000;
    private static int MAX_VALUE = 6;
    private Scanner scanner;

    public Stone(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public boolean read(int[] stones) {
        boolean isStop = true;
        for (int i = 0; i < stones.length; i++) {
            stones[i] = scanner.nextInt();
            if (stones[i] > 0) isStop = false;
        }
        return isStop;
    }

    private int totalValue(int[] stones) {
        int sum = 0;
        for (int k = 0; k < stones.length; k++) {
            sum += (k + 1) * stones[k];  // 价值 *  数量
        }
        return sum;
    }

    public boolean canBeDivided(int[] stones) {
        int totalValue = totalValue(stones);
        if (isLogLevelOn)
            System.out.println("totalValue of Stones : " + totalValue);
        if (totalValue % 2 != 0) return false;

        int maxValueOfStore = 0;
        boolean[] flag = new boolean[MAX_STONE * MAX_VALUE + 1];
        flag[0] = true;  // f[k] 表示 方案“某人分得一堆总价值为k的石头" 是可行的
        int halfValue = totalValue / 2;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] > 0) {
                int valueOfStone = (i + 1);
                for (int k = maxValueOfStore; k >= 0; k--) {
                    if (flag[k]) {
                        for (int j = 0; j < stones[i]; j++) {
                            int value = valueOfStone * (j + 1);
                            if (value == halfValue) return true;
                            if (value > halfValue || flag[k +value]) break;  // 剪枝。如果可分得的石头价值超过总价值的一半
                            flag[k + value] = true;
                        }
                    }
                }
                maxValueOfStore += valueOfStone * stones[i];
                if (maxValueOfStore > halfValue) maxValueOfStore=halfValue;
            }
        }// for each stones[i]
        return flag[halfValue];
    }

    public void execute() {
        int testCaseN = 0;
        while (scanner.hasNextInt()) {
            int[] stones = new int[MAX_VALUE]; // stone[I] 表示 价值为 (i+1) 的石头数量
            boolean isStop = read(stones);
            if (isStop) break;
            testCaseN++;
            boolean canBeDivided = canBeDivided(stones);
            if (canBeDivided) {
                System.out.println(String.format("Collection #%d:\nCan be divided.", testCaseN));
            } else {
                System.out.println(String.format("Collection #%d:\nCan't be divided.", testCaseN));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.nanoTime();
        new Stone(Stone.class.getResourceAsStream("/acm/stones.txt")).execute();
        System.out.println((System.nanoTime() - start)/1000000 +" ms");
    }
}


