package jsee.demo1;

import javax.script.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-10-4
 * Time: 8:12:24
 * To change this template use File | Settings | File Templates.
 */
public abstract  class ScriptCache {
    public static final String ENGINE_NAME = "JavaScript";
    private Compilable scriptEngine;
    private LinkedHashMap<String, CachedScript> cacheMap;

    public ScriptCache(final int maxCachedScripts) {
        ScriptEngineManager manager = new ScriptEngineManager();
        scriptEngine = (Compilable) manager.getEngineByName(ENGINE_NAME);
        cacheMap = new LinkedHashMap<String, CachedScript>(
                maxCachedScripts, 1, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxCachedScripts;
            }
        };
    }

    public abstract File getScriptFile(String key);

    public synchronized CompiledScript getScript(String key)
            throws ScriptException, IOException {
        CachedScript script = cacheMap.get(key);
        if (script == null) {
            script = new CachedScript(scriptEngine, getScriptFile(key));
            cacheMap.put(key, script);
        }
        return script.getCompiledScript();
    }

    public ScriptEngine getEngine() {
        return (ScriptEngine) scriptEngine;
    }
}
