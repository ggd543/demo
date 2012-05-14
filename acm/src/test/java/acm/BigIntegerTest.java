package acm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-12
 * Time: 下午9:32
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Parameterized.class)
public class BigIntegerTest {
    private String a;
    private String b;
    private String c;
    private BigInteger obj;

    public BigIntegerTest(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection getDataSet() {
        return Arrays.asList(new Object[][]{
                {"1", "2", "3"},
                {"1100", "111", "1211"},
                {"112233445566778899", "998877665544332211", "1111111111111111110"}
        });
    }

    @Before
    public void setUp() {
        this.obj = new BigInteger(System.in);
    }


    @Test
    public void testAdd() {
        Assert.assertEquals(c, obj.add(a, b));
    }
}
