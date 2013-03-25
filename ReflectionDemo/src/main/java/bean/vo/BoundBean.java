/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean.vo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class BoundBean {
    private String message = "Hello";
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public BoundBean() {
        addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("old value:" + evt.getOldValue());
                System.out.println("new value: " + evt.getNewValue());
                System.out.println("source: " + evt.getSource());
            }
        });
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        String oldValue = this.message;
        this.message = message;
        changes.firePropertyChange("message", oldValue, message);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changes.removePropertyChangeListener(listener);
    }

    public static void main(String[] args) {
        BoundBean bb = new BoundBean();
        bb.setMessage("hello world");
    }

}


