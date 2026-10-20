package edu.curtin.texteditor;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;


public class FileIO
{
    public String load(File file, String encoding) throws IOException 
    {
        String text = "";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding );
        try(BufferedReader br = new BufferedReader(isr))
        {
            String line;
            while((line = br.readLine()) != null) {
                text += line + "\n";
            }
        }
        return text;
    }
    
    public void save(File file, String text, String encoding ) throws IOException
    {
        // try(PrintWriter pw = new PrintWriter(file))
        // {
        //     pw.print(text);
        // }
        try( PrintWriter pw = new PrintWriter( new OutputStreamWriter( new FileOutputStream(file),encoding))){
            pw.print(text);
        }
    }
}
