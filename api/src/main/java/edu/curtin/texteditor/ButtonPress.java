package edu.curtin.texteditor.api;
import java.util.ArrayList;
import java.util.List;

public class ButtonPress {
    private List<ButtonPressObserver> observers = new ArrayList<>();

    public void addObserver (ButtonPressObserver o ){
        observers.add(o);
    }

    public void removeObserver (ButtonPressObserver o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for (ButtonPressObserver o : new ArrayList<>(observers)){
            o.buttonPressed();
        }
    }
}
