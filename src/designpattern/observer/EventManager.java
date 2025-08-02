package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<ObserverEvent> observerEventList = new ArrayList<>();
    //registering
    public void registerEvent(ObserverEvent observerEvent){
       observerEventList.add(observerEvent);
    }

    //notifying
    public void notifyEvents(EventInfo eventInfo){
        observerEventList.forEach(observerEvent -> observerEvent.update(eventInfo));
    }

}
