package edu.curtin.texteditor.api;
import java.util.ArrayList;
import java.util.List;

public class FunctionKeyPress {
    private List<FunctionKeyPressObserver> observers = new ArrayList<>();

    public void addObserver (FunctionKeyPressObserver o ){
        observers.add(o);
    }

    public void removeObserver (FunctionKeyPressObserver o){
        observers.remove(o);
    }

    public void notifyObservers(String newText){
        for (FunctionKeyPressObserver o : new ArrayList<>(observers)){
            o.functionKeyPress(newText);
        }
    }
}
