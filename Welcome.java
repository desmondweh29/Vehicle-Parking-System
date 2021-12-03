import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame
{
	JButton img;
	JButton admin = new JButton("Admin");
	JButton guest = new JButton("Guest");
	JButton exit = new JButton("Exit");
	JLabel welcome_note = new JLabel("<html>Welcome to Vehicle Parking System<html>");
	
	public Welcome()
	{
		//Car park image
		Icon carpark = new ImageIcon("Pic\\carpark.png");
		img = new JButton(carpark);
		img.setBounds(0,0, 450,600);
		img.setBorderPainted(false);
		img.setContentAreaFilled(false);
		
		//Print welcome message
		welcome_note.setBounds(530,100,300,160);
		welcome_note.setFont(new Font ("San serif" , Font.PLAIN, 40));
		
		//Admin JButton
		admin.setBounds(500,350,120, 45);
		admin.setFont(new Font("San serif", Font.PLAIN,30));
		admin.setBackground(Color.BLACK);
		admin.setForeground(Color.WHITE);
		admin.setBorderPainted(false);
		admin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Admin_login();
				dispose();
			}
		});
		
		//Guest JButton
		guest.setBounds(730,350,120, 45);
		guest.setFont(new Font("San serif", Font.PLAIN,30));
		guest.setBackground(Color.BLACK);
		guest.setForeground(Color.WHITE);
		guest.setBorderPainted(false);
		guest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Check_in();
				dispose();
			}
		});
		
		
		//Exit JButton
		exit.setBounds(500,450,350, 45);
		exit.setFont(new Font("San serif", Font.PLAIN,30));
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		add(img);
		add(welcome_note);
		add(admin);
		add(guest);
		add(exit);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
