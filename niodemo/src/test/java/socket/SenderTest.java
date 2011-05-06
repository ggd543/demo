package socket;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-3
 * Time: 8:21:54
 * To change this template use File | Settings | File Templates.
 */
public class SenderTest {
    @Test
    public void testSender(){
        try {
            Sender sender=new Sender();
            sender.send();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
