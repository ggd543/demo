/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

import java.beans.BeanInfo;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class IndexedBean {
    private int[] _dataSet = {1, 2, 3, 4, 5, 6}; // dataSet是一个indexed属性(索引属性)


    public void setDataSet(int[] x) {
        _dataSet = x;
    }

    public int[] getDataSet() {
        return _dataSet;
    }

    public void setDataSet(int index, int x) {
        _dataSet[index] = x;
    }

    public int getDataSet(int x) {
        return _dataSet[x];
    }


    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(IndexedBean.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        PropertyDescriptor pd = pds[1];
        System.out.println(pd instanceof IndexedPropertyDescriptor); // true
        if (pd instanceof IndexedPropertyDescriptor) {
            IndexedPropertyDescriptor ipd = (IndexedPropertyDescriptor) pd;
            System.out.println(ipd.getIndexedPropertyType()); // int
        }
        pd = new PropertyDescriptor("dataSet", IndexedBean.class);
        System.out.println(pd.getReadMethod());
        System.out.println(pd.getWriteMethod());
        System.out.println(pd instanceof IndexedPropertyDescriptor);
        try {
            pd = new IndexedPropertyDescriptor("arrays", IndexedBean.class);
            System.out.println(pd);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
