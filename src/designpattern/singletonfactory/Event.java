package designpattern.singletonfactory;

public abstract class Event {
    protected String name;
    protected double price;

    public Event(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void getDetails();
}
