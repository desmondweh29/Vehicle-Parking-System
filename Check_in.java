import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_in extends JFrame
{
	JButton navbar, homebutton;
	JLabel question = new JLabel("<html>Do you wish to enter<br/> or exit the car park?<html>");
	JButton enter = new JButton("Enter");
	JButton exit = new JButton("Exit");
	
	public Check_in()
	{
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Check_in_out.png");
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
		
		//Print question
		question.setBounds(260,150,400,140);
		question.setFont(new Font("San serif", Font.PLAIN,40));
		
		//Enter JButton
		enter.setBounds(250, 330,100,45);
		enter.setFont(new Font("San serif", Font.PLAIN,27));
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.setBorderPainted(false);
		enter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Select_vehicle();
				dispose();
			}
		});
		
		//Exit JButton
		exit.setBounds(525,330,100,45);
		exit.setFont(new Font("San serif", Font.PLAIN,27));
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Check_out();
				dispose();
			}
		});
		
		add(homebutton);
		add(navbar);
		add(enter);
		add(exit);
		add(question);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}

