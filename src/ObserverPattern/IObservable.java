package ObserverPattern;

/**
 * Created by onotole on 14.05.16.
 */
public interface IObservable {
    void notifyObservers();
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
}
