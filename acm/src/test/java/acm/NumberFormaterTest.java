package acm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public class NumberFormaterTest {
    private NumberFormater tester;

    @Before
    public void setUp(){
        tester = new NumberFormater();
    }

    @Test
    public void testFormat(){

        Assert.assertEquals("0.00", tester.format("0"));
        Assert.assertEquals("-0.00", tester.format("-0"));

        Assert.assertEquals("1.00", tester.format("1"));
        Assert.assertEquals("-1.00", tester.format("-1"));

        Assert.assertEquals("123.00", tester.format("123"));
        Assert.assertEquals("-123.00", tester.format("-123"));

        Assert.assertEquals("24.50", tester.format("24.5"));
        Assert.assertEquals("-24.50", tester.format("-24.5"));

        Assert.assertEquals("24.54", tester.format("24.54"));
        Assert.assertEquals("-24.54", tester.format("-24.54"));

        Assert.assertEquals("24.55", tester.format("24.554"));
        Assert.assertEquals("-24.55", tester.format("-24.554"));

        Assert.assertEquals("24.56", tester.format("24.555"));
        Assert.assertEquals("-24.56", tester.format("-24.555"));

        Assert.assertEquals("25.00", tester.format("24.995"));
        Assert.assertEquals("-25.00", tester.format("-24.995"));

        Assert.assertEquals("100.00", tester.format("99.995"));
        Assert.assertEquals("-100.00", tester.format("-99.995"));

        Assert.assertEquals("0.20", tester.format("0.20"));
        Assert.assertEquals("-0.20", tester.format("-0.20"));

        Assert.assertEquals("0.00", tester.format("0.001"));
        Assert.assertEquals("-0.00", tester.format("-0.001"));

        Assert.assertEquals("0.01", tester.format("0.007"));
        Assert.assertEquals("-0.01", tester.format("-0.007"));

        Assert.assertEquals("0.15", tester.format(".15"));
        Assert.assertEquals("-0.15", tester.format("-.15"));

        Assert.assertEquals("1.00", tester.format("1."));
        Assert.assertEquals("-1.00", tester.format("-1."));
    }

    @Test
    public void testAbsFormat(){
        Assert.assertEquals("1.0", tester.abs("1.0"));
        Assert.assertEquals("1.02", tester.abs("-1.02"));
        Assert.assertEquals(".02", tester.abs(".02"));
        Assert.assertEquals(".02", tester.abs("-.02"));
    }

    @Test
    public void testDoubleFormat(){
        Assert.assertEquals("12.35", tester.format(12.345));
    }
    
}
