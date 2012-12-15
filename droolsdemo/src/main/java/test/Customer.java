/**
 * Created with IntelliJ IDEA.
 * User: 刘永健
 * Date: 12-12-15
 * Time: 下午11:35
 * To change this template use File | Settings | File Templates.
 */
package test;

public class Customer {    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}