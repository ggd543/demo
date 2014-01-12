package com.uc.jldap.demo.pojo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 账号类（暴露给外部使用，不含密码）
 */
public class Account {
    /**
     * 表示账号的状态
     */
    public static enum Status {
        /**
         * 不可用
         */
        DISABLE,
        /**
         * 可用
         */
        ENABLE;

        public static int status2Int(Status s) {
            return s.ordinal();
        }

        public static Status int2Status(int i) {
            return Status.values()[i];
        }
    }

    /**
     * 用于显示的名字
     */
    @Attribute("displayName")
    private String displayName;
    /**
     * 备注
     */
    @Attribute("description")
    private String description;

    @Attribute({"cn","sn"})
    private String username;

    @Attribute("status")
    private Status status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Attribute("tel")
    public String telPhone;

    public static void main(String[] args) {
        Class clazz = Account.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a: annotations){
            System.out.println(a);
        }
        try {
            Field f= clazz.getField("telPhone");
            Annotation annotation = f.getAnnotation(Attribute.class);
            System.out.println(annotation);
            System.out.println(((Attribute)annotation).value());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
