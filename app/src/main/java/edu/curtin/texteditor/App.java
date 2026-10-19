package edu.curtin.texteditor;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import edu.curtin.texteditor.api.*;



public class App extends Application
{
    private static ResourceBundle bundle;
    private List<KeymapParser.ShortcutContext> shortcuts;
    private TextChange textChange = new TextChange();
    private FunctionKeyPress functionKeyPress = new FunctionKeyPress();
    private static Locale locale;

    public static void main(String[] args)
    {
        if(args.length > 0 ){
            locale = Locale.forLanguageTag(args[0]);
        }else{
            locale = Locale.getDefault();
        }




        bundle = ResourceBundle.getBundle("bundle", locale);
        Application.launch(args);
    }

    public static final int FONT_SIZE = 20;
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage)
    {
        KeymapLoader keymapLoader = new KeymapLoader(); 
        try{
            shortcuts = keymapLoader.loadKeymap("keymap.txt");

        }catch(IOException e ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(bundle.getString("keymap_error"));
            alert.setHeaderText(bundle.getString("failed_to_load_keymap"));
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        stage.setTitle(bundle.getString("window"));
        stage.setMinWidth(800);
        stage.setMinHeight(600);

       //currently trying to connect load UI and FileIO and APP  
        FileIO fileIO = new FileIO();
        LoadSaveUI loadSaveUI = new LoadSaveUI(stage,textArea, fileIO , bundle);
        // Create toolbar
        Button loadButton = new Button(bundle.getString("load"));
        Button saveButton = new Button(bundle.getString("save"));
        Button pluginButton = new Button(bundle.getString("plugin"));
        ToolBar toolBar = new ToolBar(loadButton, saveButton, pluginButton);

        // Subtle user experience tweaks
        toolBar.setFocusTraversable(false);
        toolBar.getItems().forEach(btn -> btn.setFocusTraversable(false));
        textArea.setStyle(String.format(
            "-fx-font-family: 'monospace'; -fx-font-size: %d;",
            FONT_SIZE)); // Set the font

        // Add the main parts of the UI to the window.
        BorderPane mainBox = new BorderPane();
        mainBox.setTop(toolBar);
        mainBox.setCenter(textArea);
        Scene scene = new Scene(mainBox);
        TextEditorService textEditorService = new  TextEditorService(bundle,textArea, toolBar ,locale, functionKeyPress,textChange );
        PluginLoader pluginLoader = new PluginLoader();
        ScriptLoader scriptLoader = new ScriptLoader();
        PluginDialog pluginDialog = new PluginDialog(stage, pluginLoader, scriptLoader, textEditorService, bundle);

        // Button event handlers.
        loadButton.setOnAction(event -> loadSaveUI.load());
        saveButton.setOnAction(event -> loadSaveUI.save());
        pluginButton.setOnAction( event -> pluginDialog.showDialog());
        // pluginButton.setOnAction( event -> pluginDialog.showPluginDialog());
        // pluginButton.setOnAction(event -> toolBar.getItems().add(new Button("ButtonN")));


//!!!USED FOR API FOR AREA TEXT CHANGE 
        textArea.textProperty().addListener((object, oldValue, newValue) ->
        {
            textChange.notifyObservers(newValue);
        });

        textArea.setText("This is some\ndemonstration text\nTry pressing F1, ctrl+b, ctrl+shift+b or alt+b.");
        textArea.selectRange(8, 16); // Select a range of text (and move the caret to the end)


//!!!KEY PRESSED HERE , REFER HERE FOR SHORTCUT IN THE FUTURE 
//REMEMERBE TO ADD KEY MAP LAODER 

        scene.setOnKeyPressed(keyEvent ->
        {
            KeyCode code = keyEvent.getCode();
            if(code.isFunctionKey()){
                functionKeyPress.notifyObservers(code.getName());
                keyEvent.consume();
                return;
            }

            boolean ctrl = keyEvent.isControlDown();
            boolean shift = keyEvent.isShiftDown();
            boolean alt = keyEvent.isAltDown();

            for (KeymapParser.ShortcutContext shortcut : shortcuts ){

                List<String> modifiers = new ArrayList<>();
                for (KeymapParser.ModifierContext modctx : shortcut.modifier()){
                    modifiers.add(modctx.getText());
                }
                boolean matchedModifiers = ctrl == modifiers.contains("ctrl") && shift == modifiers.contains("shift") && alt == modifiers.contains("alt");

                boolean keyPressed = keyEvent.getCode().getName().equalsIgnoreCase(shortcut.LETTER().getText());

                if (matchedModifiers && keyPressed ){
                    executeShortcut(shortcut);
                    keyEvent.consume();
                    break;
                }
            }




        });

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private void executeShortcut(KeymapParser.ShortcutContext shortcut ){
        String action = shortcut.action().getText();
        String text = shortcut.STRING().getText();
        text = text.substring(1, text.length() - 1 );
        int position = textArea.getCaretPosition();
        int temp = textArea.getCaretPosition();
        String caretPosition = shortcut.caretPosition().getText();
        if (caretPosition.equals("atstartofline")){
            String currentText = textArea.getText();
            // int lastNewLine = currentText.lastIndexOf('\n', position - 1);
            position = currentText.lastIndexOf('\n', position -1 ) + 1; 
        }
        if (action.equals("insert")){
            textArea.insertText(position,text);
            // textArea.positionCaret(position + text.length());
            textArea.positionCaret(temp + text.length());
        }
        if (action.equals("delete")){
            String currentText = textArea.getText();
            if (currentText.startsWith(text,position)){
                textArea.deleteText(position, position + text.length());
                // textArea.positionCaret(position);
                if (caretPosition.equals("atstartofline")){
                    textArea.positionCaret(temp - text.length());
                }else if (caretPosition.equals("atcaret")){
                    textArea.positionCaret(temp);
                }
                
            }
        }
    }



}