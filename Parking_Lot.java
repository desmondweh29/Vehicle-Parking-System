import javax.swing.*;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Parking_Lot implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String lot_code;
	final private int size;
	private int number_parked = 0;
	private int number_reserved = 0;
	private Parking_Slot[] ps;
	
	public Parking_Lot(String name, String lot_code, int size, Parking_Slot[] slot)
	{
		this.name = name;
		this.lot_code = lot_code;
		this.size = size;
		this.ps = slot;
		setParking_Slot();
	}

	public void setParking_Slot() {
		for (int i = 0 ; i < size ; i++) {
			Parking_Slot slot = new Parking_Slot();
			ps[i] = slot;
			ps[i].setSlot_number(i);
		}
	}

	public void setSlot_reserved(int slot_number) {
		ps[slot_number].setStatus("RESERVED");
		number_reserved++;
	}

	public void setSlot_available(int slot_number) {
		ps[slot_number].setStatus("AVAILABLE");
		number_reserved--;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCode() {
		return lot_code;
	}
	
	public int getSize() {
		return size;
	}

	public int getNumber_parked () { return number_parked; }
	public int getNumber_reserved () { return number_reserved; }

	public int get_available_parking_slot() {
		for (int i = 0 ; i < size ; i++) {
			if ((ps[i].getStatus()).equals("AVAILABLE")) {
				return i;
			}
		} return -1;
	}

	public String get_carPlate_with_ticketCode (String code) {
		for (int i = 0 ; i < size ; i++) {
			if ((ps[i].getStatus()).equals("OCCUPIED")) {
				if (code.equals(ps[i].get_ticket_code())) {
					return ps[i].get_car_plate();
				}
			}
		} return "";
	}

	public int get_slotNumber_with_ticketCode (String code) {
		for (int i = 0 ; i < size ; i++) {
			if ((ps[i].getStatus()).equals("OCCUPIED")) {
				if (code.equals(ps[i].get_ticket_code())) {
					return ps[i].getSlot_number();
				}
			}
		} return -1;
	}

	public JTextArea get_slot_details (int slot_number, JTextArea output) {
		//JTextArea output = new JTextArea();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		if (ps[slot_number].getStatus().equals("OCCUPIED")) {
			output.setText("  Slot code: " + getCode() + slot_number + "\n" +
					       "  Car plate: " + ps[slot_number].get_car_plate() + "\n" +
					       "  Ticket code: " + ps[slot_number].get_ticket_code() + "\n" +
					       "  Entry date: " + ps[slot_number].get_entry_datetime().toLocalDate() + "\n" +
					       "  Entry time: " + ps[slot_number].get_entry_datetime().format(format));
		} else {
			output.setText("  Slot code: " + getCode() + slot_number + "\n" +
					"  Car plate: -\n" +
					"  Ticket code: -\n" +
					"  Entry date: -\n" +
					"  Entry time: -\n");
		}
		return output;
	}

	public String get_slot_status (int slot_number) {
		return ps[slot_number].getStatus();
	}

	public boolean isFull() {
		if ((number_parked+number_reserved) == size) {
			return true;
		} return false;
	}

	public boolean check_ticketCode_availability(String code) {
		for (int i = 0 ; i < size ; i++){
			if ((ps[i].getStatus()).equals("OCCUPIED")) {
				if (code.equals(ps[i].get_ticket_code())){
					return true;
				}
			}
		} return false;
	}

	public boolean check_carPlate_availability(String plate) {
		for (int i = 0 ; i < size ; i++){
			if ((ps[i].getStatus()).equals("OCCUPIED")) {
				if (plate.equals(ps[i].get_car_plate())){
					return true;
				}
			}
		} return false;
	}

	public boolean check_ticketCode_with_carPlate (String plate, String code) {
		for (int i = 0 ; i < size ; i++) {
			if ((ps[i].getStatus()).equals("OCCUPIED")) {
				if (plate.equals(ps[i].get_car_plate())) {
					if (code.equals(ps[i].get_ticket_code())) {
						return true;
					}
				}
			}
		} return false;
	}

	public void park_vehicle(int slot_number, Vehicle v) {
		ps[slot_number].parkVehicle(v);
		number_parked++;
	}

	public void quit_vehicle (String code) {
		for (int i = 0 ; i < size ; i++){
			if (code.equals(ps[i].get_ticket_code())){
				ps[i].exitVehicle(lot_code);
				number_parked--;
				break;
			}
		} return;
	}
}
