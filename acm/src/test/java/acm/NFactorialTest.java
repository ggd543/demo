package acm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午1:38
 * To change this template use File | Settings | File Templates.
 */
public class NFactorialTest {
    private NFactorial obj;

    @Before
    public void setUp() {
        obj = new NFactorial();
    }


    @Test(timeout=10000)
    public void testCompute() {
        Assert.assertEquals("1", obj.compute(0));
        Assert.assertEquals("1", obj.compute(1));
        Assert.assertEquals("6", obj.compute(3));
        Assert.assertEquals("720", obj.compute(6));
        Assert.assertEquals("15511210043330985984000000", obj.compute(25));
        Assert.assertEquals("2432902008176640000", obj.compute(20));
        obj.compute(1000);
        obj.compute(10000);

    }

    @Test(timeout=15000)
    public void testCompute30000(){
         obj.compute(30000);
    }
}


