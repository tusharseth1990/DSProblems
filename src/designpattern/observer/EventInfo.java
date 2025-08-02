package designpattern.observer;

public class EventInfo {


    private final String email;

    private final String name;

    private final String userId;

    public EventInfo(String email, String name, String userId) {
        this.email = email;
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
