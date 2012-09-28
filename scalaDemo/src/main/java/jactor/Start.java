package jactor;

/**
 * User: 刘永健
 * Date: 12-9-25
 * Time: 下午7:05
 * To change this template use File | Settings | File Templates.
 */
import org.agilewiki.jactor.*;
import org.agilewiki.jactor.lpc.*;

public class Start extends Request<Object, Test> {
    public static final Start req = new Start();

    public void processRequest(JLPCActor targetActor, RP rp)
            throws Exception {
        Test a = (Test) targetActor;
        a.start();
        rp.processResponse(null);
    }

    public boolean isTargetType(Actor targetActor) {
        return targetActor instanceof Test;
    }
}