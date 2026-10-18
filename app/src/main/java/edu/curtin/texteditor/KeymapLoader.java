package edu.curtin.texteditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;


public class KeymapLoader{

    public List<KeymapParser.ShortcutContext> loadKeymap (String filePath) throws IOException{
        String dslText = Files.readString(Path.of(filePath));
        KeymapLexer lexer = new KeymapLexer(CharStreams.fromString(dslText));
        KeymapParser parser = new KeymapParser(new CommonTokenStream(lexer));



       

            List<String> errors = new ArrayList<>();
            BaseErrorListener errorListener = new BaseErrorListener() 
            {
                @Override
                public void syntaxError(Recognizer<?,?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        RecognitionException e)
                {
                    String fullMsg = String.format("line %d, column %d: %s", line, charPositionInLine, msg);
                    errors.add(fullMsg);
                        
                }
            };

            lexer.removeErrorListeners();
            parser.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            parser.addErrorListener(errorListener);




        KeymapParser.KeymapContext keymapCtx = parser.keymap();

            if(!errors.isEmpty()){
                throw new IOException("Keymap file has error");
            }


        return keymapCtx.shortcut();

    }
    
}
