import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_options extends JFrame
{
	JButton img;
	JButton check_parking = new JButton("Check Parking Lot");
	JButton check_vehicle = new JButton("Check Vehicle");
	JButton record = new JButton("Parking Record");
	JButton back = new JButton("Logout");
	
	public Admin_options()
	{
		//Car park image
		Icon carpark = new ImageIcon("Pic\\carpark1.png");
		img = new JButton(carpark);
		img.setBounds(0,0, 450,600);
		img.setBorderPainted(false);
		img.setContentAreaFilled(false);
		
		//Check vehicle JButton
		check_vehicle.setBounds(520,150,300,50); 
		check_vehicle.setFont(new Font("San serif", Font.PLAIN,30));
		check_vehicle.setBackground(Color.GRAY);
		check_vehicle.setForeground(Color.WHITE);
		check_vehicle.setBorderPainted(false);
		check_vehicle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Search_with_plate();
				dispose();
			}
		});
				
		//Check parking JButton
		check_parking.setBounds(520,250,300,50);
		check_parking.setFont(new Font("San serif", Font.PLAIN,30));
		check_parking.setBackground(Color.GRAY);		
		check_parking.setForeground(Color.WHITE);		
		check_parking.setBorderPainted(false);			
		check_parking.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Check_parking();
				dispose();
			}
		});
		
		record.setBounds(520,350,300,50);
		record.setFont(new Font("San serif", Font.PLAIN,30));
		record.setBackground(Color.GRAY);		
		record.setForeground(Color.WHITE);		
		record.setBorderPainted(false);			
		record.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Record_table();
				dispose();
			}
		});

		back.setBounds(480,480,120,45);
		back.setFont(new Font("San serif", Font.PLAIN,27));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Admin_login();
				dispose();
			}
		});

		add(record);
		add(back);
		add(img);
		add(check_parking);
		add(check_vehicle);

		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
