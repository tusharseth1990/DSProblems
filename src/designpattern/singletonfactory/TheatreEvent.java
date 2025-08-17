package designpattern.singletonfactory;

public class TheatreEvent extends Event {
    public TheatreEvent(String name, double price) { super(name, price); }
    public void getDetails() {
        System.out.println("Theatre: " + name + " Price: " + price);
    }
}
