//I Refered to here cz the material given is too scarce to even give how to make a dialog box in javafx
//https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html
package edu.curtin.texteditor;

import edu.curtin.texteditor.api.TextEditorServiceInterface;

import java.io.File;
import java.util.ResourceBundle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;





public class PluginDialog {

    private final PluginLoader pluginLoader;
    private final ScriptLoader scriptLoader;
    private final TextEditorServiceInterface appService;
    private final Stage owner;
    private final ResourceBundle bundle;

    private final ObservableList<String> listModel = FXCollections.observableArrayList();
    private final ListView<String> listView = new ListView<>(listModel);

    public PluginDialog( Stage owner, PluginLoader pluginLoader, ScriptLoader scriptLoader, TextEditorServiceInterface appService , ResourceBundle bundle ){
        this.owner = owner;
        this.pluginLoader = pluginLoader;
        this.scriptLoader = scriptLoader;
        this.appService = appService;
        this.bundle = bundle ;

    }
    public void showDialog(){
        Dialog<Void> dialog = new Dialog<>();
        dialog.initOwner(owner);
        dialog.setTitle(bundle.getString("plugin"));
        dialog.setHeaderText(bundle.getString("plugin_list"));



        Button loadPluginButton = new Button(bundle.getString("load_plugin"));
        Button loadScriptButton = new Button(bundle.getString("load_script"));
        // Button closeButton = new Button(bundle.getString("close"));
        ToolBar toolBar = new ToolBar(loadPluginButton, loadScriptButton );

        loadPluginButton.setOnAction(event -> loadPlugin());
        loadScriptButton.setOnAction(event -> loadScript());
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        // 'ObservableList' is a list that's also an Observer Pattern subject, while 'ListView'
        // shows the list contents on-screen, and registers itself as an observer, so it knows
        // when the list changes.
 

        BorderPane box = new BorderPane();
        box.setTop(toolBar);
        box.setCenter(new ScrollPane(listView));

        dialog.getDialogPane().setContent(box);
        dialog.showAndWait();
    }

    private void loadPlugin() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(bundle.getString("select_plugin"));
        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter("JAR Files", "*.jar"));

        File file = fileChooser.showOpenDialog(owner);

        if (file == null) {
            return;
        }

        TextInputDialog classDialog = new TextInputDialog();
        classDialog.setTitle("Plugin Entry Point");
        classDialog.setHeaderText("Enter the plugin's fully-qualified class name");
        classDialog.setContentText("Class name:");

        classDialog.showAndWait().ifPresent(className -> {

            if (className.trim().isEmpty()) {
                return;
            }

            try {
                pluginLoader.loadPlugin(file.getAbsolutePath(),className.trim(),appService);

                listModel.add( className.trim());

            } catch (Exception exception) {
                showError("Failed to load plugin", exception);
            }
        });
    }

    private void loadScript() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Script");
        fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter( "Groovy Scripts", "*.groovy"));

        File file = fileChooser.showOpenDialog(owner);

        if (file == null) {
            return;
        }

        try {
            scriptLoader.loadScript(file.getAbsolutePath(), appService );

            listModel.add( file.getName());

        } catch (Exception exception) {
            showError("Failed to load script", exception);
        }
    }

    private void showError(String message, Exception exception) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(owner);
        alert.setTitle("Loading Error");
        alert.setHeaderText(message);
        alert.setContentText(exception.getMessage());
        alert.showAndWait();
    }
}
