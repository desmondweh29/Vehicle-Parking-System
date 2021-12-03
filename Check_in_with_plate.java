import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_in_with_plate extends JFrame
{
	JButton navbar, homebutton;
	JButton enter = new JButton("Enter");
	JButton back = new JButton("Back");
	JLabel enter_vehicle = new JLabel("Please enter vehicle");
	JLabel enter_vehicle1 = new JLabel("registration plate number");
	JLabel error = new JLabel("Invalid car plate format. Please try again.");
	JLabel error2 = new JLabel("Vehicle with same plate number is parked. Please try again.");
	JTextField input = new JTextField(10);
	
	public Check_in_with_plate(String type, int lot_index)
	{
		
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Check_in.png");
		navbar = new JButton(bar);
		navbar.setBounds(0,0,900, 50);
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
				new Select_vehicle();
				dispose();
			}
		});
		
		//Print message
		enter_vehicle.setBounds(260,80,500,140);
		enter_vehicle.setFont(new Font("San serif", Font.PLAIN,40));
		enter_vehicle1.setBounds(220, 140,500,140);
		enter_vehicle1.setFont(new Font("San serif", Font.PLAIN,40));
		
		error.setBounds(190, 290, 500, 140);
		error.setFont(new Font("San serif", Font.PLAIN,15));
		error.setForeground(Color.RED);
		error.setVisible(false);

		error2.setBounds(190, 290, 500, 140);
		error2.setFont(new Font("San serif", Font.PLAIN,15));
		error2.setForeground(Color.RED);
		error2.setVisible(false);
		
		//Set font for text inside the textfield
		Font font = new Font("San serif", Font.PLAIN, 30);
		input.setBounds(190, 300, 500, 50);
		input.setFont(font);
		
		
		//Enter JButton
		enter.setBounds(380,400,100,45);
		enter.setFont(new Font("San serif", Font.PLAIN,27));
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.setBorderPainted(false);
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String plateNumber = (input.getText()).trim();
				if (plateNumber.matches("[A-Z]{1,3}[0-9]{1,4}")) {
					boolean unique = false;
					for (int i = 0; i < 5; i++) {
						if (Main.data[i].check_carPlate_availability(plateNumber)) {
							break;
						}
						if (i == 4) {
							unique = true;
						}
					}
					if (unique) {
						new Show_result(type, plateNumber, lot_index);
						dispose();
					} else {
						error.setVisible(false);
						error2.setVisible(true);
					}
				} else {
					error.setVisible(true);
					error2.setVisible(false);
				}
			}			
		});
		
		add(back);
		add(error);
		add(error2);
		add(homebutton);
		add(navbar);
		add(enter_vehicle);
		add(enter_vehicle1);
		add(input);
		add(enter);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
