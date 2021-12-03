import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Show_result_admin extends JFrame
{
	JButton navbar, homebutton;
	JButton back = new JButton("Back");
	JLabel plate_number = new JLabel("Plate Number");
	JLabel parking_slot =  new JLabel("Parking Slot");
	JTextField output1 = new JTextField(10);
	JTextField output2 = new JTextField(10);
	
	public Show_result_admin(String code)
	{
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Vehicle_Info.png");
		navbar = new JButton(bar);
		navbar.setBounds(0,0,890, 50);
		navbar.setBorderPainted(false);			//remove border
		navbar.setContentAreaFilled(false);		//remove background color

		//Home button (most left)
		Icon home = new ImageIcon("Pic\\homebutton.png");
		homebutton = new JButton(home);
		homebutton.setBounds(0,0,75,50);
		homebutton.setBorderPainted(false);
		homebutton.setContentAreaFilled(false);
		homebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Welcome();
				dispose();
			}
		});
		
		back.setBounds(30,490,120,45);
		back.setFont(new Font("San serif", Font.PLAIN,30));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Search_with_plate();
				dispose();
			}
		});
		
		//Print message
		plate_number.setBounds(320,100,500,140);
		plate_number.setFont(new Font("San serif", Font.PLAIN,40));
		
		//Print message
		parking_slot.setBounds(330,300,500,140);
		parking_slot.setFont(new Font("San serif", Font.PLAIN,40));
		
		//Set font for the text inside the textfield
		String plate = "";
		String slot = "";
		for (int i = 0 ; i < 5 ; i++) {
			plate = Main.data[i].get_carPlate_with_ticketCode(code);
			int slot_number = Main.data[i].get_slotNumber_with_ticketCode(code);
			slot = Main.data[i].getName() + " Floor, Slot " + slot_number;

			if (!plate.equals("") && !slot.equals("")) {
				break;
			}
		}
		
		Font font = new Font("San serif", Font.PLAIN,30);
		output1.setBounds(270,200,340,50);
		output1.setFont(font);
		output1.setText(plate);
		output1.setHorizontalAlignment(JTextField.CENTER);
		output1.setBackground(Color.WHITE);
		output1.setEditable(false);
		
		output2.setBounds(270,400,340,50);
		output2.setFont(font);
		output2.setText(slot);
		output2.setHorizontalAlignment(JTextField.CENTER);
		output2.setBackground(Color.WHITE);
		output2.setEditable(false);
		
		add(back);
		add(homebutton);
		add(navbar);
		add(plate_number);
		add(parking_slot);
		add(output1);
		add(output2);
		
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}