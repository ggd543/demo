package jsee.demo1;

import org.junit.Test;

import javax.script.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-10-3
 * Time: 19:41:27
 * To change this template use File | Settings | File Templates.
 */
public class ScriptDemoTest {
    @Test
    public void testScript1() {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        try {
            String script = "println('hello');" +
                    "function say(){  return  'hello'; }";
            se.eval(script);
            Invocable inv2 = (Invocable) se;
            Object retObj = inv2.invokeFunction("say");
            System.out.println("return value: "+retObj);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScript2() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        Bindings vars = new SimpleBindings();
        vars.put("demoVar", "value set in ScriptDemoTest.java");
        vars.put("strBuf", new StringBuffer("string buffer"));

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("js/a.js");
        System.out.println("Resource : " + is);

        Reader scriptReader = null;
        try {
            scriptReader = new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream("js/ScriptDemo.js"));
            engine.eval(scriptReader, vars);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (scriptReader != null)
                try {
                    scriptReader.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
        }// try .. catch .. finally

        // Get JavaScript variables
        Object demoVar = vars.get("demoVar");
        System.out.println("[Java] demoVar: " + demoVar);
        System.out.println("    Java object: " + demoVar.getClass().getName());
        System.out.println();
        Object strBuf = vars.get("strBuf");
        System.out.println("[Java] strBuf: " + strBuf);
        System.out.println("    Java object: " + strBuf.getClass().getName());
        System.out.println();
        Object newVar = vars.get("newVar");
        System.out.println("[Java] newVar: " + newVar);
        System.out.println("    Java object: " + newVar.getClass().getName());
        System.out.println();
    }

}