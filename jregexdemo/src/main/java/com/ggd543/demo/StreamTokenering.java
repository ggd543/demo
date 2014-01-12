package com.ggd543.demo;

import java.io.*;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-7
 * Time: 下午8:38
 * To change this template use File | Settings | File Templates.
 */
public class StreamTokenering {
    public static void main(String[] args) {
        try {
            InputStream is = StreamTokenering.class.getResourceAsStream("/input.txt");
            StreamTokenizer in = new StreamTokenizer(new InputStreamReader(is));

            in.ordinaryChar('.');
            in.ordinaryChar('\'');
            int wordCount = 0, numCount = 0, punctionCount = 0, count = 0;
            double token;
            while ((token = in.nextToken()) != StreamTokenizer.TT_EOF) {
                count++;
                if (token == StreamTokenizer.TT_WORD) {
                    wordCount++;
                } else if (token == StreamTokenizer.TT_NUMBER) {
                    numCount++;
                } else {
                    punctionCount++;
                }
                System.out.println(in.toString());
            }
            System.out.println("单词总数为：" + count);
            System.out.println("单词数为：" + wordCount);
            System.out.println("数字数为：" + numCount);
            System.out.println("标点符号数为：" + punctionCount++);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
