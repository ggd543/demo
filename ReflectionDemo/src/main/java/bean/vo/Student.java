/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class Student {
    private int id = 12;
    private String name = "tree";
    private int[] scores = new int[]{1,3,3};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("student.setId");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("student.setName");
        this.name = name;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        System.out.println("student.setScores");
        this.scores = scores;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "archer");
        map.put("id", 123);
        map.put("scores", new int[]{1,4,6,7});
        Student student = new Student();
        try {
            BeanUtils.copyProperties(student, map);
            System.out.println(student.getName());
            System.out.println(student.getId());
            System.out.println(Arrays.toString(student.getScores()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
