/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class IntrospectDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        testIntrospect();
    }

    private static void testCopyProperties() throws InvocationTargetException, IllegalAccessException {
        ID id = new ID();
        Person person = new Person();
        User user = new User(id,"Mary");
        BeanUtils.copyProperties(user, person);
        System.out.println(person.id == id);
        System.out.println(person.name);
    }

    private static void testIntrospect(){
        ID id = TmpObject.createID();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(ID.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
            System.out.println(descriptors.length);
            System.out.println(methodDescriptors.length);
            PropertyDescriptor pd = descriptors[2];
            System.out.println("name: "+pd.getName());
            System.out.println("displayName: "+pd.getDisplayName());
            System.out.println("shortDescription: "+pd.getShortDescription());
            System.out.println("property's type: "+pd.getPropertyType());
            MyList myList = new MyList();
            PropertyDescriptor[] pds = Introspector.getBeanInfo(MyList.class).getPropertyDescriptors();

            try {
                System.out.println("id: "+pd.getReadMethod().invoke(id));
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (InvocationTargetException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

class MyList extends ArrayList<String>{

}

class AbstractID {
    public int id = 35;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class ID extends AbstractID {
    private Map<String , String > maps;
    private List<Integer> lists;
    private String name = "Archer";
    private Integer[] arrays;

    public Integer[] getArrays() {
        return arrays;
    }

    public void setArrays(Integer[] arrays) {
        this.arrays = arrays;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }

    public String getFirstName() {
        return "hello";
    }

    public void setFirstName(String s) {
        this.name = s;
    }

    public int[] ids = {1, 2, 3};


    public String getIds() {
        return "fuxk";
    }

    public void say() {
        System.out.println("say");
    }


}
