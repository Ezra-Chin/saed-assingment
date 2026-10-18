package edu.curtin.texteditor.dateplugin;

import edu.curtin.texteditor.api.*;
import java.time.ZonedDateTime;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class DatePlugin implements PluginService{
    private TextEditorServiceInterface appService;

    @Override 
    public void start(TextEditorServiceInterface appService ){
        this.appService = appService;
        Locale locale = appService.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle( "dateplugin", locale);
        appService.addButton(bundle.getString("date_button"), this::handleDateButton);
    }

    private void handleDateButton(String buttonName){

        ZonedDateTime time = ZonedDateTime.now();
        Locale locale = appService.getResourceBundle().getLocale();
        DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale);
        String dateFmt = dtf1.format(time);


        String text = appService.getText();
        int position = appService.getCaretPosition();
        appService.setText(text.substring(0, position) + dateFmt + text.substring(position));
        appService.setCaretPosition(position + dateFmt.length());
        
    }
    
}
