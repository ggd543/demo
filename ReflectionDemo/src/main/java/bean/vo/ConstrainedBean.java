/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class ConstrainedBean {
    private String message = "Hello";
    private VetoableChangeSupport vetos=new VetoableChangeSupport(this);

    public ConstrainedBean() {
       addVetoableChangeListener(new VetoableChangeListener(){
           public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
               throw new PropertyVetoException("fuxk",evt);
           }
       });
    }

    public void addVetoableChangeListener(VetoableChangeListener listener){
        vetos.addVetoableChangeListener(listener);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        String oldValue = this.message;
        try {
            vetos.fireVetoableChange("message", oldValue, message);
            this.message = message;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConstrainedBean cb = new ConstrainedBean();
        cb.setMessage("hello world");
        System.out.println(cb.getMessage());
    }
}
