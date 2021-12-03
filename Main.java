import java.util.ArrayList;

public class Main {
    public static int size_slot = 36;
    public static Parking_Slot [] slot1 = new Parking_Slot [size_slot];
    public static Parking_Slot [] slot2 = new Parking_Slot [size_slot];
    public static Parking_Slot [] slot3 = new Parking_Slot [size_slot];
    public static Parking_Slot [] slot4 = new Parking_Slot [size_slot];
    public static Parking_Slot [] slot5 = new Parking_Slot [size_slot];
    public static Parking_Lot ground = new Parking_Lot("Ground", "G", size_slot, slot1);
    public static Parking_Lot first = new Parking_Lot("First", "F", size_slot, slot2);
    public static Parking_Lot second = new Parking_Lot("Second", "S", size_slot, slot3);
    public static Parking_Lot third = new Parking_Lot("Third", "T", size_slot, slot4);
    public static Parking_Lot roof = new Parking_Lot("Roof", "R", size_slot, slot5);
    public static Parking_Lot[] data = new Parking_Lot[]{ground, first, second, third, roof};
    public static ArrayList <Vehicle> record = new ArrayList<Vehicle>();

    public static void main (String [] args){

        try {
            data = (Parking_Lot[]) ResourceManager.load("data.txt");
        } catch (Exception e) {
            System.out.println("Couldn't load saved data: " + e.getMessage());
        }

        try {
            record = (ArrayList <Vehicle>) ResourceManager.load("record.txt");
        } catch (Exception e) {
            System.out.println("Couldn't load saved data: " + e.getMessage());
        }

        new Welcome ();
        }
}
