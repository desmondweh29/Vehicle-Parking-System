import java.io.Serializable;
import java.time.LocalDateTime;

public class Parking_Slot implements Serializable {
	private static final long serialVersionUID = 1L;
	private int slot_number;
	private String status;
	private Vehicle vc;
	
	public Parking_Slot() {
		this.status = "AVAILABLE";
		Vehicle v = new Vehicle();
		this.vc = v;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void setSlot_number(int slot_number) { this.slot_number = slot_number; }

	public String getStatus() { return status; }
	public int getSlot_number() { return slot_number; }
	public String get_ticket_code() { return vc.getTicket_code(); }
	public String get_car_plate() { return vc.getPlate_number(); }
	public LocalDateTime get_entry_datetime() { return vc.getEntry_dateTime(); }


	public void parkVehicle(Vehicle vehicle) {
		vc = vehicle;
		setStatus("OCCUPIED");
	}

	public void exitVehicle(String lot_code) {
		vc.setExit_dateTime();
		vc.setParked_duration();
		vc.setSlot_number(lot_code, slot_number);
		Main.record.add(vc);
		setStatus("AVAILABLE");
	}
}
