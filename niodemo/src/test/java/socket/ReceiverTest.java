package socket;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-3
 * Time: 8:22:14
 * To change this template use File | Settings | File Templates.
 */
public class ReceiverTest {
    @Test
    public void testReceiver(){
        try {
            Receiver receiver=new Receiver();
            //receiver.stopWay=
            receiver.receive();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
