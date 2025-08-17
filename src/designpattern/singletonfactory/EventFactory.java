package designpattern.singletonfactory;

public class EventFactory {
    public static Event createEvent(String type, String name, double price) {
        return switch (type.toLowerCase()) {
            case "concert" -> new ConcertEvent(name, price);
            case "sports" -> new SportsEvent(name, price);
            case "theatre" -> new TheatreEvent(name, price);
            default -> throw new IllegalArgumentException("Unknown event type");
        };
    }
}
