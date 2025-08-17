package designpattern.singletonfactory;

public class SportsEvent extends Event {
    public SportsEvent(String name, double price) { super(name, price); }
    public void getDetails() {
        System.out.println("Sports: " + name + " Price: " + price);
    }
}
