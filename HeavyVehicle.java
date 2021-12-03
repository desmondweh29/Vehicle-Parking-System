import java.time.LocalDateTime;

public class HeavyVehicle extends Vehicle{
    public HeavyVehicle(String plate_number, String ticket_code, LocalDateTime entry_dateTime) {
        super("HEAVY", plate_number, ticket_code,entry_dateTime);
    }
}
