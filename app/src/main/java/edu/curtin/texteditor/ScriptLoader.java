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
import java.io.IOException;

public class ScriptLoader {

    //PMD not having a good day of me not closign the context, but script is not happy of me closing the context, so get supressed 
    @SuppressWarnings("PMD.CloseResource")
    public void loadScript(String scriptPath, TextEditorServiceInterface appService ) throws ReflectiveOperationException, IOException{
        String code = Files.readString(Path.of(scriptPath));
        var context = Context.newBuilder().allowAllAccess(true).build();
        var bindings = context.getBindings("js");
        bindings.putMember("app", appService);
        context.eval("js", code);
        // context.close();
    }
}
