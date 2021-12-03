import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_out extends JFrame
{
	JButton navbar, homebutton;
	JButton enter = new JButton("Enter");
	JButton back = new JButton("Back");
	JLabel plate_number = new JLabel("Please enter plate number");
	JLabel ticket_code =  new JLabel("Please enter ticket code");
	JLabel error1 = new JLabel("Invalid plate number. Please try again");
	JLabel error2 = new JLabel("Invalid ticket code. Please try again");
	JTextField input1 = new JTextField(10);
	JTextField input2 = new JTextField(10);
	
	public Check_out() {

		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Check_out.png");
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
		
		back.setBounds(30,490,120,45);
		back.setFont(new Font("San serif", Font.PLAIN,30));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Check_in();
				dispose();
			}
		});

		//Print message
		plate_number.setBounds(220, 100, 500, 140);
		plate_number.setFont(new Font("San serif", Font.PLAIN, 40));

		//Print message
		ticket_code.setBounds(240, 250, 500, 140);
		ticket_code.setFont(new Font("San serif", Font.PLAIN, 40));

		error1.setBounds(200, 190, 500, 140);
		error1.setFont(new Font("San serif", Font.PLAIN, 15));
		error1.setForeground(Color.RED);
		error1.setVisible(false);

		error2.setBounds(200, 340, 500, 140);
		error2.setFont(new Font("San serif", Font.PLAIN, 15));
		error2.setForeground(Color.RED);
		error2.setVisible(false);

		//Set font for the text inside the textfield
		Font font = new Font("San serif", Font.PLAIN, 30);
		input1.setBounds(200, 200, 500, 50);
		input1.setFont(font);
		input2.setBounds(200, 350, 500, 50);
		input2.setFont(font);

		enter.setBounds(390, 450, 100, 45);
		enter.setFont(new Font("San serif", Font.PLAIN, 27));
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.setBorderPainted(false);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String plate = (input1.getText()).trim();
				String code = (input2.getText()).trim();
				boolean correct_plate = false;
				for (int i = 0 ; i < 5 ; i++) {
					if (Main.data[i].check_carPlate_availability(plate)){
						correct_plate = true;
						if (Main.data[i].check_ticketCode_with_carPlate(plate, code)) {
							Main.data[i].quit_vehicle(code);
							try {
								ResourceManager.save(Main.data, "data.txt");
							} catch (Exception ex) {
								System.out.println("Couldn't save: " + ex.getMessage());
							}

							try {
								ResourceManager.save(Main.record, "record.txt");
							} catch (Exception ex) {
								System.out.println("Couldn't save: " + ex.getMessage());
							}
							new Thank_you();
							dispose();
						}
					} else {
						if (i == 4) {
							if (correct_plate) {
								error1.setVisible(false);
								error2.setVisible(true);
							} else {
								error1.setVisible(true);
								error2.setVisible(false);
							}
						}
					}
				}
			}
		});

		add(back);
		add(error1);
		add(error2);
		add(enter);
		add(homebutton);
		add(navbar);
		add(plate_number);
		add(ticket_code);
		add(input1);
		add(input2);

		setSize(900, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}