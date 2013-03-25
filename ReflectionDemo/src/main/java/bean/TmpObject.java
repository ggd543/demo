/**
 * @Copyright (c) 2002-2012 Travelsky Limited. All rights reserved.
 */
package bean;

import bean.ID;

/**
 * @author 刘永健(liuyongjian@travelsky.com)
 * @since 2013/02/19
 */
public class TmpObject {
    public static ID createID() {
        return new ID();
    }
}

class User {
    private ID id;
    public String name;

    public User(ID id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
    private String firstName;

    public String getFirstName(){
        System.out.println("User.getFirstName");
        return "user.firstname";
    }

    public void setFirstName(String s){
        System.out.println("User.setFirstName");
    }
}


class Person {
    public ID id;
    public String name = "error";

    public String getFirstName() {
        System.out.println("Person.getFirstName");
        return "e";
    }

    public void setFirstName(String s) {
        System.out.println("Person.setFirstName");
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public ID getId() {
//        return id;
//    }

//    public void setId(ID id) {
//        this.id = id;
//    }


}




