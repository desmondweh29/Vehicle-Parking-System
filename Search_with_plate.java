import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_with_plate extends JFrame 
{
	JButton navbar, homebutton;
	JButton back = new JButton("Back");
	JButton enter = new JButton("Enter");
	JLabel enter_ticket = new JLabel("Please enter ticket code");
	JLabel error = new JLabel("Invalid ticket code. Please try again");
	JTextField input = new JTextField(10);
	
	public Search_with_plate()
	{
		
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Check_Vechicle.png");
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
				new Admin_options();
				dispose();
			}
		});
		
		//Print message
		enter_ticket.setBounds(230,100,500,140);
		enter_ticket.setFont(new Font("San serif", Font.PLAIN,40));
		
		error.setBounds(190,240,500,140);
		error.setFont(new Font("San serif", Font.PLAIN,15));
		error.setForeground(Color.RED);
		error.setVisible(false);
		
		//Set font for the text inside the textfield
		Font font = new Font("San serif", Font.PLAIN, 30);
		input.setBounds(190,250,500,50);
		input.setFont(font);
		
		//Enter JButton
		enter.setBounds(380,350,100,45);
		enter.setFont(new Font("San serif", Font.PLAIN,27));
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.setBorderPainted(false);
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String code = (input.getText()).trim();

				for (int i = 0 ; i < 5 ; i++){
					if (Main.data[i].check_ticketCode_availability(code)) {
						new Show_result_admin(code);
						dispose();
						break;
					}
				} error.setVisible(true);
			}
		});
		
		add(back);
		add(error);
		add(homebutton);
		add(navbar);
		add(enter_ticket);
		add(input);
		add(enter);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}

