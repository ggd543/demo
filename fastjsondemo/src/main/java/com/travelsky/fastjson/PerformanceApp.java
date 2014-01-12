package com.travelsky.fastjson;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by ggd543 on 14-1-4.
 */
public class PerformanceApp {
    private static String generateIP() {
        StringBuilder url = new StringBuilder();
        Random random = new Random();
        int n = random.nextInt(255);
        url.append(n);
        url.append(".");

        n = random.nextInt(255);
        url.append(n);
        url.append(".");

        n = random.nextInt(255);
        url.append(n);
        url.append(".");

        n = random.nextInt(255);
        url.append(n);
        return url.toString();
    }

    public static void main(String[] args) {
        Set<String> set=  new HashSet<String>();
        for(int i=0; i< 2000000; i++){
            set.add(generateIP());
            if (i % 100 == 0){
                System.out.println(i);
            }
        }
        System.out.println();
        System.out.println(set.size());
    }
}
