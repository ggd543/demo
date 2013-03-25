/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

import java.beans.BeanInfo;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;

import org.apache.commons.beanutils.MappedPropertyDescriptor;

/**
 * <b>MappedPropertyDescriptor  不是java.beans默认提供的</b>
 *
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class MappedBean {
    private Map tb = new java.util.Hashtable();

    public Map getTb() {
        return tb;
    }

    public void setTb(Map tb) {
        this.tb = tb;
    }

    public void setTb(String key, String x) {
        tb.put(key, x);
    }
//
    public String getTb(String  key) {
        return tb.get(key).toString();
    }

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(MappedBean.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        PropertyDescriptor pd = pds[1];
        System.out.println(pd instanceof MappedPropertyDescriptor); // false; MappedPropertyDescriptor 是commons-beanutils
        System.out.println(new MappedPropertyDescriptor("tb",MappedBean.class));  // ok
    }
}
