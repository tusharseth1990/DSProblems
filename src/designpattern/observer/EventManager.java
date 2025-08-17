package designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    private final List<ObserverEvent> observerEventList = new CopyOnWriteArrayList<>();
    //Thread safety
    //registering
    public void registerEvent(ObserverEvent observerEvent){
       observerEventList.add(observerEvent);
    }

    //notifying
    public void notifyEvents(EventInfo eventInfo){
        observerEventList.forEach(observerEvent -> observerEvent.update(eventInfo));
    }

}
