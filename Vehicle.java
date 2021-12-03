import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
    private String slot_number;
    private String plate_number;
    private String ticket_code;
    private LocalDateTime entry_dateTime;
    private LocalDateTime exit_dateTime;
    private Duration parked_duration;

    public Vehicle() {
        this.type = "";
        this.plate_number = "";
        this.ticket_code = "";
        this.entry_dateTime = null;
    }

    public Vehicle(String type, String plate_number, String ticket_code, LocalDateTime entry_dateTime) {
        this.type = type;
        this.plate_number = plate_number;
        this.ticket_code = ticket_code;
        this.entry_dateTime = entry_dateTime;
    }

    public void setSlot_number (String code, int number) {
        slot_number = code + number;
    }

    public void setExit_dateTime () {
        exit_dateTime = LocalDateTime.now();
    }

    public void setParked_duration () {
        parked_duration = Duration.between(entry_dateTime, exit_dateTime);
    }

    public String get_type() { return type; }

    public String getSlot_number () { return slot_number; };

    public String getPlate_number() { return plate_number; }

    public String getTicket_code() { return ticket_code; }

    public LocalDateTime getEntry_dateTime() {
        return entry_dateTime;
    }

    public LocalDateTime getExit_dateTime() { return exit_dateTime; }

    public String getParked_duration() {
        String duration = String.format("%02d:%02d:%02d",
                parked_duration.toHours(),
                parked_duration.toMinutesPart(),
                parked_duration.toSecondsPart());
        return duration;
    }


}
