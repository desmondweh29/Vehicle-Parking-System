import java.time.LocalDateTime;

public class LightVehicle extends Vehicle{
    public LightVehicle(String plate_number, String ticket_code ,LocalDateTime entry_dateTime) {
        super("LIGHT", plate_number, ticket_code,entry_dateTime);
    }
}
