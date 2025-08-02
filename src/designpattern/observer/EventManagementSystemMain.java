package designpattern.observer;

public class EventManagementSystemMain {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        //register events
        eventManager.registerEvent(new EmailNotificationService());
        EventInfo eventInfo = new EventInfo("xxx@gmail.com","Concert", "c1");
        eventManager.notifyEvents(eventInfo);
    }
}
