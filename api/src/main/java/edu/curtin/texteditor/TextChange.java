package edu.curtin.texteditor.api;
import java.util.ArrayList;
import java.util.List;

public class TextChange {
    private List<TextChangeObserver> observers = new ArrayList<>();

    public void addObserver (TextChangeObserver o ){
        observers.add(o);
    }

    public void removeObserver (TextChangeObserver o){
        observers.remove(o);
    }

    public void notifyObservers(String newText){
        for (TextChangeObserver o : new ArrayList<>(observers)){
            o.textChanged(newText);
        }
    }
}
