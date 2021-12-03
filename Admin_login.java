import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_login extends JFrame
{
	JButton img;
	JButton login = new JButton("Login");
	JButton back = new JButton("Back");
	JLabel welcome = new JLabel("Welcome back!");
	JLabel id = new JLabel("ID");
	JLabel password = new JLabel("Password");
	JLabel question = new JLabel("<html>Please login to<br/> your account<html>");
	JLabel error = new JLabel("Invalid ID or password. Please try again.");
	JTextField input_id = new JTextField(10);
	JPasswordField input_password = new JPasswordField(10);
	
	
	public Admin_login()
	{
		//Car park image
		Icon carpark = new ImageIcon("Pic\\carpark.png");
		img = new JButton(carpark);
		img.setBounds(0,0, 450,600);
		img.setBorderPainted(false);
		img.setContentAreaFilled(false);
		
		//Print welcome back
		welcome.setBounds(500,20,300,140);
		welcome.setFont(new Font ("San serif" , Font.BOLD, 40));
		
		//Ask user login to account
		question.setBounds(500,100,300,140);
		question.setFont(new Font("San serif", Font.PLAIN, 30));
		
		//Show "ID"
		id.setBounds(500,185,300,140);
		id.setFont(new Font("San serif", Font.PLAIN, 25));
		
		//User input (ID)
		input_id.setBounds(500,270,300,40);
		input_id.setFont(new Font("San serif", Font.PLAIN,25));
		
		//Show "Password"
		password.setBounds(500,265,300,140);
		password.setFont(new Font("San serif", Font.PLAIN, 25));
		
		//User input (Password
		input_password.setBounds(500,350,300,40);
		input_password.setFont(new Font("San serif", Font.PLAIN,25));
		input_password.setEchoChar('*');
		
		error.setBounds(500, 330, 500, 140);
		error.setFont(new Font("San serif", Font.PLAIN,15));
		error.setForeground(Color.RED);
		error.setVisible(false);
		
		//Login JButton
		login.setBounds(500,450,120,45);
		login.setFont(new Font("San serif", Font.PLAIN,30));
		login.setBackground(Color.BLACK);  		
		login.setForeground(Color.WHITE); 		
		login.setBorderPainted(false);			
		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((input_id.getText().equals("vpsadmin")) && (input_password.getText().equals("Password777!")))
				{
					new Admin_options();
					dispose();
				}
				else
				{
					error.setVisible(true);
				}
			}
		});
		
		back.setBounds(700,450,120,45);
		back.setFont(new Font("San serif", Font.PLAIN,30));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Welcome();
				dispose();
			}
		});
		
		add(error);
		add(back);
		add(img);
		add(welcome);
		add(question);
		add(id);
		add(input_id);
		add(input_password);
		add(password);
		add(login);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
