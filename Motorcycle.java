import java.time.LocalDateTime;

public class Motorcycle extends Vehicle{
    public Motorcycle(String plate_number, String ticket_code, LocalDateTime entry_dateTime) {
        super("MOTOR", plate_number, ticket_code, entry_dateTime);
    }
}
