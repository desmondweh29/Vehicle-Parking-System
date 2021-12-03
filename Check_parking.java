import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_parking extends JFrame
{
	JButton navbar, homebutton;
	JButton back = new JButton("Back");
	JButton ground_f = new JButton("Ground");
	JButton first_f = new JButton("Level 1");
	JButton second_f = new JButton("Level 2");
	JButton	third_f = new JButton("Level 3");
	JButton roof = new JButton("Roof");
	
	JLabel pick = new JLabel("Please pick a floor");
	
	public Check_parking()
	{
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Parking_Lot.png");
		navbar = new JButton(bar);
		navbar.setBounds(0,0,895, 50);
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
		
		//Ground floor JButton
		ground_f.setBounds(100,190,150,100);
		ground_f.setFont(new Font("San serif", Font.PLAIN,30));
		ground_f.setBackground(Color.GRAY);
		ground_f.setForeground(Color.WHITE);
		ground_f.setBorderPainted(false);
		ground_f.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
					new Record(0);
					dispose();
			}
		});
		
		//First floor JButton
		first_f.setBounds(380,190,150,100);
		first_f.setFont(new Font("San serif", Font.PLAIN,30));
		first_f.setBackground(Color.GRAY);
		first_f.setForeground(Color.WHITE); 
		first_f.setBorderPainted(false);
		first_f.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new Record(1);
				dispose();
			}
		});
		
		//Second floor JButton
		second_f.setBounds(660,190,150,100);
		second_f.setFont(new Font("San serif", Font.PLAIN,30));
		second_f.setBackground(Color.GRAY);
		second_f.setForeground(Color.WHITE); 
		second_f.setBorderPainted(false);
		second_f.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new Record(2);
				dispose();
			}
		});
		
		//Third floor JButton
		third_f.setBounds(240,360,150,100);
		third_f.setFont(new Font("San serif", Font.PLAIN,30));
		third_f.setBackground(Color.GRAY);
		third_f.setForeground(Color.WHITE);  
		third_f.setBorderPainted(false);
		third_f.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new Record(3);
				dispose();
			}
		});
		
		//Roof JButton
		roof.setBounds(520,360,150,100);
		roof.setFont(new Font("San serif", Font.PLAIN,30));
		roof.setBackground(Color.GRAY);
		roof.setForeground(Color.WHITE); 
		roof.setBorderPainted(false);
		roof.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new Record(4);
				dispose();
			}
		});
		
		//Print pick a floor
		pick.setBounds(300,70,300,100);
		pick.setFont(new Font("San serif", Font.PLAIN,36));
		
		add(back);
		add(homebutton);
		add(navbar);
		add(pick);
		add(ground_f);
		add(first_f);
		add(second_f);
		add(third_f);
		add(roof);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
