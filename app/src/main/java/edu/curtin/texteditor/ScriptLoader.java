package edu.curtin.texteditor;

import edu.curtin.texteditor.api.PluginService;
import edu.curtin.texteditor.api.TextEditorServiceInterface;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.graalvm.polyglot.Context;

public class ScriptLoader {
    public void loadScript(String scriptPath, TextEditorServiceInterface appService ) throws IOException{
        String code = Files.readString(Path.of(scriptPath));
        var context = Context.newBuilder().allowAllAccess(true).build();
        var bindings = context.getBindings("js");
        bindings.putMember("app", appService);
        context.eval("js", code);
        context.close();
    }
}
