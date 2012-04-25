package demo;

import java.io.*;

/**
 * User: 刘永健
 * Date: 12-3-22
 * Time: 上午9:32
 * To change this template use File | Settings | File Templates.
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        double d = Math.random();
//        System.out.println("d = " + d);

        FileOutputStream fos = new FileOutputStream("oos.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Bat bat = createBat();
        oos.writeObject(bat);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("oos.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Bat new_bat = (Bat) ois.readObject();
        ois.close();
        System.out.println("canFly: " + new_bat.isCanFly());
        System.out.println("age: " + new_bat.getAge());
        System.out.println("sex: " + new_bat.getSex());
        System.out.println("name: " + new_bat.getName());
        System.out.println("password: " + new_bat.getPassword());
    }

    private static Bat createBat() {
        Bat bat = new Bat();
        bat.setCanFly(true);
        bat.setAge(30);
        bat.setSex('F');
        bat.setName("Archer");
        Password password = new Password();
        password.setPassword("abc");
        bat.setPassword(password);
        return bat;
    }
}

class Animal {
    private String name;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Password implements Serializable {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream oos) {
        try {
            ObjectOutputStream.PutField fields = oos.putFields();
            fields.put("password", "123");
            oos.writeFields();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public String toString() {
        return this.password;
    }
}

class Bat extends Animal implements Serializable {
    private Boolean canFly;
    private Password password;

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(Boolean canFly) {
        this.canFly = canFly;
    }


}