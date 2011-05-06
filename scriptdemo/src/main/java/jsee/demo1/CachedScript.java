package jsee.demo1;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-10-4
 * Time: 9:09:09
 * To change this template use File | Settings | File Templates.
 */
public class CachedScript {
    private Compilable scriptEngine;
    private File scriptFile;
    private CompiledScript compiledScript;
    private Date compiledDate;

    public CachedScript(Compilable scriptEngine, File scriptFile) {
        this.scriptEngine = scriptEngine;
        this.scriptFile = scriptFile;
    }

    public CompiledScript getCompiledScript()
            throws ScriptException, IOException {
        Date scriptDate = new Date(scriptFile.lastModified());
        if (compiledDate == null || scriptDate.after(compiledDate)) {
            Reader reader = new FileReader(scriptFile);
            try {
                compiledScript = scriptEngine.compile(reader);
                compiledDate = scriptDate;
            } finally {
                reader.close();
            }
        }
        return compiledScript;
    }
}
