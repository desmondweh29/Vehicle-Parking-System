import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Show_result extends JFrame
{
	JButton navbar, homebutton;
	JButton done = new JButton("Done");
	JLabel parking_slot = new JLabel("Your parking slot is");
	JLabel ticket_code =  new JLabel("Your ticket code is");
	JTextField output1 = new JTextField(10);
	JTextField output2 = new JTextField(10);
	
	public Show_result(String type, String plateNumber, int lot_index) {
		String t_code;
		boolean unique = false;
		do {
			int random_int = (int)Math.floor(Math.random()*(99999-10000+1)+10000);

			if (type.equals("HEAVY")){
				t_code = "H" + random_int;
			} else if (type.equals("LIGHT")){
				t_code = "L" + random_int;
			} else {
				t_code = "M" + random_int;
			}

			for (int i = 0 ; i < 5 ; i++) {
				if (Main.data[i].check_ticketCode_availability(t_code)){
					break;
				}

				if (i == 4) {
					unique = true;
				}
			}
		} while (!unique);

		LocalDateTime time = LocalDateTime.now();

		Vehicle v;

		if (type.equals("HEAVY")) {
			v = new HeavyVehicle(plateNumber, t_code, time);
		} else if (type.equals("LIGHT")) {
			v = new LightVehicle(plateNumber, t_code, time);
		} else { //type == "MOTOR"
			v = new Motorcycle(plateNumber, t_code, time);
		}

		int slot_number = Main.data[lot_index].get_available_parking_slot();
		Main.data[lot_index].park_vehicle(slot_number, v);

		String slot_name = Main.data[lot_index].getName() + " Floor, Slot " + slot_number;

		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Parking_info.png");
		navbar = new JButton(bar);
		navbar.setBounds(0, 0, 900, 50);
		navbar.setBorderPainted(false);            //remove border
		navbar.setContentAreaFilled(false);        //remove background color

		//Home button (most left)
		Icon home = new ImageIcon("Pic\\homebutton.png");
		homebutton = new JButton(home);
		homebutton.setBounds(0, 0, 75, 50);
		homebutton.setBorderPainted(false);
		homebutton.setContentAreaFilled(false);
		homebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Welcome();
				dispose();
			}
		});

		try {
			ResourceManager.save(Main.data, "data.txt");
		} catch (Exception e) {
			System.out.println("Couldn't save: " + e.getMessage());
		}

		//Print message
		parking_slot.setBounds(280, 100, 500, 140);
		parking_slot.setFont(new Font("San serif", Font.PLAIN, 40));

		//Print message
		ticket_code.setBounds(280, 300, 500, 140);
		ticket_code.setFont(new Font("San serif", Font.PLAIN, 40));

		//Set font for the text inside the textfield
		Font font = new Font("San serif", Font.PLAIN, 30);
		output1.setBounds(280, 200, 340, 50);
		output1.setFont(font);
		output1.setText(slot_name);
		output1.setHorizontalAlignment(JTextField.CENTER);
		output1.setBackground(Color.WHITE);
		output1.setEditable(false);

		output2.setBounds(280, 400, 340, 50);
		output2.setFont(font);
		output2.setText(t_code);
		output2.setHorizontalAlignment(JTextField.CENTER);
		output2.setBackground(Color.WHITE);
		output2.setEditable(false);

		done.setBounds(730,480,120,45);
		done.setFont(new Font("San serif", Font.PLAIN,30));
		done.setBackground(Color.BLACK);
		done.setForeground(Color.WHITE);
		done.setBorderPainted(false);
		done.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Welcome();
				dispose();
			}
		});

		add(done);
		add(homebutton);
		add(navbar);
		add(parking_slot);
		add(ticket_code);
		add(output1);
		add(output2);

		setSize(900, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}