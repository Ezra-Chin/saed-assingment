package edu.curtin.texteditor;

import edu.curtin.texteditor.api.PluginService;
import edu.curtin.texteditor.api.TextEditorServiceInterface;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.IOException;


public class PluginLoader {
    @SuppressWarnings("PMD.CloseResource")
    public void loadPlugin(String pluginJarFile, String pluginClassName, TextEditorServiceInterface appService  )throws ReflectiveOperationException , IOException{
        ClassLoader classLoader = new URLClassLoader(new URL[] { new File(pluginJarFile).toURI().toURL()}, PluginLoader.class.getClassLoader());

        Class<?> cls = Class.forName(pluginClassName, true , classLoader );

        PluginService plugin = (PluginService ) cls.getConstructor().newInstance();
        plugin.start(appService);
    }
}
