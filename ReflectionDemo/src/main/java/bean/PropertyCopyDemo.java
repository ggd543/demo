/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean;

import java.lang.reflect.InvocationTargetException;

import bean.vo.Student;
import bean.vo.Teacher;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/20
 */
public class PropertyCopyDemo{
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        student.setId(23);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, student);
        System.out.println(teacher.getId());
        teacher.setId(1234);
        BeanUtils.copyProperties( student, teacher);
        System.out.println(student.getId());
    }
}
