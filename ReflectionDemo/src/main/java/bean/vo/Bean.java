/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class Bean {
    public static Employee  createEmployee(){
        return  new Employee();
    }

    public static Class<?> getEmployeeClass(){
        return Employee.class;
    }
}


class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
