package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

// Composite
public class EventGroup implements EventComponent {
    private List<EventComponent> events = new ArrayList<>();

    public void addEvent(EventComponent event) {
        events.add(event);
    }

    public void removeEvent(EventComponent event) {
        events.remove(event);
    }

    @Override
    public void showDetails() {
        for (EventComponent e : events) {
            e.showDetails();
        }
    }
}
