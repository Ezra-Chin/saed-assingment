package edu.curtin.texteditor.api;
import java.util.ResourceBundle;
import java.util.Locale;


public interface TextEditorServiceInterface{
    void addButton(String label, ButtonPressObserver o );

    String getText();    
    void setText(String text);

    int getCaretPosition();
    void setCaretPosition(int position);

    int getSelectionStart();
    int getSelectionEnd();
    void setSelection(int start, int end);
    ResourceBundle getResourceBundle();
    Locale getLocale(); 
    String getUserInput();
    // void addFunctionKeyPressObserver(FunctionKeyPressObserver o );
    
}
