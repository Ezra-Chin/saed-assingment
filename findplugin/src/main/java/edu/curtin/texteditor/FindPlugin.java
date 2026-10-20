package edu.curtin.texteditor;

import edu.curtin.texteditor.api.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.Normalizer;


public class FindPlugin implements PluginService, FunctionKeyPressObserver {
    private TextEditorServiceInterface appService;
    @Override 
    public void start(TextEditorServiceInterface appService ){
        this.appService = appService;
        appService.addFunctionKeyPressObserver(this);
        Locale locale = appService.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "findplugin", locale);
        appService.addButton(bundle.getString("find_button"), this::handleFindButton);
    }

    private void handleFindButton(){
        String searchText = appService.getUserInput();
        if (searchText.isEmpty()){
            return;
        }
        String text = appService.getText();
        int caret = appService.getCaretPosition();


        String target = Normalizer.normalize(searchText, Normalizer.Form.NFC);
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFC);


        int normalizedCaret = Normalizer.normalize(text.substring(0,caret), Normalizer.Form.NFC).length();

        //basically searching for target from normalized Craet Position
        int index = normalizedText.indexOf(target, normalizedCaret);
        if (index != -1 ){
            appService.setSelection(index, index + target.length());
            // appService.setCaretPosition(index);
        }

    }

    @Override
    public void functionKeyPress(String keyNumber){
        if(keyNumber.equals("F3")){
            handleFindButton();
        }

    }
    
}
