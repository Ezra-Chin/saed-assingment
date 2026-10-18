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

    public TextEditorService(ResourceBundle bundle , TextArea textArea, ToolBar toolbar  , Locale locale){
        this.bundle = bundle;
        this.textArea = textArea;
        this.toolBar = toolbar;
        this.locale = locale;


    }


    //STILL TO BE DETErmINEd ON HO W TO WIRE it 
    public void addButton(String label , ButtonPressObserver o ){
        Button button = new Button(label);
        button.setOnAction(event -> o.buttonPressed(label));
        toolBar.getItems().add(button);
    }


    public String getText(){
        return textArea.getText();
    }   
    public void setText(String text){
        textArea.setText(text);
    }

    public int getCaretPosition(){
        return textArea.getCaretPosition();
    }


    public void setCaretPosition(int position){
        textArea.positionCaret(Math.max(0, Math.min(position, textArea.getLength())));
    }

    public int getSelectionStart(){
        return textArea.getSelection().getStart();
    }
    public int getSelectionEnd(){
        return textArea.getSelection().getEnd();
    }
    public void setSelection(int start, int end){
        textArea.selectRange(Math.max(0, Math.min(start, textArea.getLength())), Math.max(0, Math.min(end, textArea.getLength())));
    }


    public ResourceBundle getResourceBundle(){
        return bundle;
    }

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
    public Locale getLocale(){
        return locale;

    }

}
