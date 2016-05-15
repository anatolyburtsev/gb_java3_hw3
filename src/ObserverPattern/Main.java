package ObserverPattern;

/**
 * Created by onotole on 14.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer(3);
        timer.addObserver(new Task("wake up!"));
        timer.addObserver(new IObserver() {
            @Override
            public void handleEvent() {
                System.out.println("anon observer");
            }
        });
        timer.start();
    }
}
