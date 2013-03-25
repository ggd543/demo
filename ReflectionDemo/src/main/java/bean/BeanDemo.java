/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import bean.vo.Bean;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class BeanDemo {
    public static void main(String[] args) {
        Class clazz =Bean.getEmployeeClass();
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        try {
            Method method = clazz.getMethod("getName");
            System.out.println(Modifier.isPublic(method.getModifiers()));
            try {
                method.invoke(clazz.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InstantiationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
