package designpattern.composite;

// Leaf
public class SingleEvent implements EventComponent {
    private String name;

    public SingleEvent(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Single Event: " + name);
    }
}
