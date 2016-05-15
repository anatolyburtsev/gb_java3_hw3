package ObserverPattern;

/**
 * Created by onotole on 14.05.16.
 */
public class Task implements IObserver {
    private String msg;

    public Task(String msg) {
        this.msg = msg;
    }

    @Override
    public void handleEvent() {
        System.out.println("Event handled: message " + msg);
    }
}
