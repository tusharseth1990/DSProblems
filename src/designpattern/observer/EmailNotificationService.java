package designpattern.observer;

public class EmailNotificationService implements ObserverEvent{
    @Override
    public void update(EventInfo eventInfo) {
        System.out.println("Email notification about the Event"+eventInfo.toString());
    }
}
