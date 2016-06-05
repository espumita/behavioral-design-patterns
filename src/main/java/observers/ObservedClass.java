package observers;

import java.util.ArrayList;
import java.util.List;

public class ObservedClass implements Observable{
    private List<Observer> observers;
    private List<String> changesList;

    public ObservedClass() {
        this.observers = new ArrayList();
        this.changesList = new ArrayList();
    }

    public void change(String change) {
        changesList.add(change);
        actualizeAll(change);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void actualizeAll(String change) {
        observers.forEach( observer -> observer.update(change));
    }
}
