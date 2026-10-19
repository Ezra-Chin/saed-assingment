package edu.curtin.texteditor;
import edu.curtin.texteditor.api.*;
import java.util.ResourceBundle;
import java.util.Locale;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

public class TextEditorService implements TextEditorServiceInterface{
    
    private ResourceBundle bundle;
    private TextArea textArea;
    private ToolBar toolBar;
    private Locale locale;
    private FunctionKeyPress functionKeyPress;
    private TextChange textChange;

    public TextEditorService(ResourceBundle bundle , TextArea textArea, ToolBar toolbar  , Locale locale , FunctionKeyPress functionKeyPress , TextChange textChange){
        this.bundle = bundle;
        this.textArea = textArea;
        this.toolBar = toolbar;
        this.locale = locale;
        this.functionKeyPress = functionKeyPress;
        this.textChange = textChange;
    }


    //STILL TO BE DETErmINEd ON HO W TO WIRE it 
    @Override
    public void addButton(String label , ButtonPressObserver o ){
        Button button = new Button(label);
        button.setOnAction(event -> o.buttonPressed());
        toolBar.getItems().add(button);
    }


    @Override
    public String getText(){
        return textArea.getText();
    }   
    @Override
    public void setText(String text){
        textArea.setText(text);
    }

    @Override
    public int getCaretPosition(){
        return textArea.getCaretPosition();
    }


    @Override
    public void setCaretPosition(int position){
        textArea.positionCaret(Math.max(0, Math.min(position, textArea.getLength())));
    }

    @Override
    public int getSelectionStart(){
        return textArea.getSelection().getStart();
    }
    @Override
    public int getSelectionEnd(){
        return textArea.getSelection().getEnd();
    }
    @Override
    public void setSelection(int start, int end){
        textArea.requestFocus();
        textArea.selectRange(Math.max(0, Math.min(start, textArea.getLength())), Math.max(0, Math.min(end, textArea.getLength())));
    }


    @Override
    public ResourceBundle getResourceBundle(){
        return bundle;
    }

    @Override
    public String getUserInput(){
        var dialog = new TextInputDialog();
        dialog.setTitle(bundle.getString("find_word"));
        dialog.setHeaderText(bundle.getString("word"));

        // 'showAndWait()' opens the dialog and waits for the user to press the 'OK' or 'Cancel' button. It returns an Optional, which is a whole other discussion, but we can call 'orElse(null)' on that to get the actual string entered if the user pressed 'OK', or null if the user pressed 'Cancel'.

        var inputStr = dialog.showAndWait().orElse(null);
        if(inputStr != null)
        {
            return inputStr;
            // new Alert(
            //     Alert.AlertType.INFORMATION,
            //     "You entered '" + inputStr + "'",
            //     ButtonType.OK).showAndWait();
        }
        return "";
    }
    @Override
    public Locale getLocale(){
        return locale;

    }
    @Override
    public void addFunctionKeyPressObserver(FunctionKeyPressObserver o ){
        functionKeyPress.addObserver(o);
    }
    @Override
    public void addTextChangeObserver(TextChangeObserver o ){
        textChange.addObserver(o);
    }

}
