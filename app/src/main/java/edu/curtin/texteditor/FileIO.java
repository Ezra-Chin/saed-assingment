package edu.curtin.texteditor;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;


public class FileIO
{
    public String load(File file) throws IOException 
    {
        String text = "";
        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                text += line + "\n";
            }
        }
        return text;
    }
    
    public void save(File file, String text) throws IOException
    {
        try(PrintWriter pw = new PrintWriter(file))
        {
            pw.print(text);
        }
    }
}
