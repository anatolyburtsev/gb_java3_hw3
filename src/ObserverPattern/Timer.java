package ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by onotole on 14.05.16.
 */
public class Timer implements IObservable {
    private int delay;
    private List<IObserver> observers = new ArrayList<>();

    public Timer(int delay) {
        this.delay = delay;
    }

    @Override

    public void notifyObservers() {
        for (IObserver observer: observers) {
            observer.handleEvent();
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void start() {
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            notifyObservers();
        }
    }

}
