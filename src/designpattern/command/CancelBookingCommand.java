package designpattern.command;

public class CancelBookingCommand implements Command {
    private final BookingService bookingService;
    private final String eventId;
    private final String userId;

    public CancelBookingCommand(BookingService service, String eventId, String userId) {
        this.bookingService = service;
        this.eventId = eventId;
        this.userId = userId;
    }

    public void execute() {
        bookingService.cancelBooking(eventId, userId);
    }
}
