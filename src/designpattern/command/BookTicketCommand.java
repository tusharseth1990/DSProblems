package designpattern.command;

public class BookTicketCommand implements Command {
    private final BookingService bookingService;
    private final String eventId;
    private final String userId;

    public BookTicketCommand(final BookingService service, final String eventId, final String userId) {
        this.bookingService = service;
        this.eventId = eventId;
        this.userId = userId;
    }

    public void execute() {
        bookingService.bookTicket(eventId, userId);
    }
}
