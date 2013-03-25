/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.vo.Student;
import bean.vo.Tax;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/20
 */
public class BeanCloneDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Student student = new Student();
        Student cloneStudent = (Student) BeanUtils.cloneBean(student);
        System.out.println(student == cloneStudent);
        System.out.println(student.getScores() == cloneStudent.getScores());

//        int[] a= new int[]{1,2,3};
//        int[] b = (int[]) BeanUtils.cloneBean(a); // exception
//        System.out.println(a == b);
        System.out.println();
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
        List<Integer> cloneList = (List<Integer>) BeanUtils.cloneBean(list);
        System.out.println(list == cloneList);
        System.out.println(cloneList.size());

        System.out.println();
        Tax tax = new Tax();
        tax.amount = 123;
        tax.currency = "RMB";
        tax.type = "CN";
        Tax cloneTax = (Tax) BeanUtils.cloneBean(tax);
        System.out.println(cloneTax.currency);
        System.out.println();
        Map<?,?> props = BeanUtils.describe(tax);
        for(Map.Entry entry: props.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println();
        Field[] fields = tax.getClass().getFields();
        for(Field field: fields){
            System.out.println(field.getName());
        }
    }
}
