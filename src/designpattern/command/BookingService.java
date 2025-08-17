package designpattern.command;

// Receiver
public class BookingService {
    public void bookTicket(String eventId, String userId) {
        System.out.println("Booking ticket for Event: " + eventId + " for User: " + userId);
    }

    public void cancelBooking(String eventId, String userId) {
        System.out.println("Cancelling booking for Event: " + eventId + " for User: " + userId);
    }
}
