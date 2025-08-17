package designpattern.singletonfactory;

public class ConcertEvent extends Event {
    public ConcertEvent(String name, double price) { super(name, price); }
    public void getDetails() {
        System.out.println("Concert: " + name + " Price: " + price);
    }
}
