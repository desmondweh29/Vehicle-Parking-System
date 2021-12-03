import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Select_vehicle extends JFrame 
{
	JButton navbar, homebutton;
	JButton back = new JButton("Back");
	JButton light_vehicle, heavy_vehicle, motor;
	JLabel question = new JLabel("Please select your vehicle type");
	JLabel error1 = new JLabel("The parking lot is full");
	JLabel error2 = new JLabel("The parking lot is full");
	JLabel error3 = new JLabel("The parking lot is full");
	
	public Select_vehicle()
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
				new Check_in();
				dispose();
			}
		});
		
		//Print message
		question.setBounds(240,100,500,140);
		question.setFont(new Font("San serif", Font.PLAIN,30));
		
		error1.setBounds(130, 340, 500, 140);
		error1.setFont(new Font("San serif", Font.PLAIN,15));
		error1.setForeground(Color.RED);
		error1.setVisible(false);
		
		error2.setBounds(360, 340, 500, 140);
		error2.setFont(new Font("San serif", Font.PLAIN,15));
		error2.setForeground(Color.RED);
		error2.setVisible(false);
		
		error3.setBounds(590, 340, 500, 140);
		error3.setFont(new Font("San serif", Font.PLAIN,15));
		error3.setForeground(Color.RED);
		error3.setVisible(false);
		
		//Heavy vehicle JButton
		Icon heavy = new ImageIcon("Pic\\Heavy_Vehicle.png");
		heavy_vehicle = new JButton(heavy); 
		heavy_vehicle.setBounds(130,250,150,150);
		heavy_vehicle.setContentAreaFilled(false);  
		heavy_vehicle.setBorderPainted(false);      
		heavy_vehicle.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if (!Main.data[0].isFull()){
					String type = "HEAVY";
					new Check_in_with_plate(type, 0);
					dispose();
				} else {
					error1.setVisible(true);
				}
			}
			});
		
		//Light vehicle JButton
		Icon light = new ImageIcon("Pic\\Light_Vehicle.png");
		light_vehicle = new JButton(light);
		light_vehicle.setBounds(360,250,150,150);
		light_vehicle.setContentAreaFilled(false);  
		light_vehicle.setBorderPainted(false);      
		light_vehicle.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				for (int i = 1 ; i < 4 ; i++){
					if (!Main.data[i].isFull()){
						String type = "LIGHT";
						new Check_in_with_plate(type, i);
						dispose();
						return;
					}
				}
				error2.setVisible(true);
			}
			});
		
		//Motor JButton
		Icon motor_pic = new ImageIcon("Pic\\Motor.png");
		motor = new JButton(motor_pic);
		motor.setBounds(590,250,150,150);
		motor.setContentAreaFilled(false);  
		motor.setBorderPainted(false);      
		motor.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				if (!Main.data[4].isFull()){
					String type = "MOTOR";
					new Check_in_with_plate(type, 4);
					dispose();
				} else {
					error3.setVisible(true);
				}
			}
			});
		
		add(back);
		add(error1);
		add(error2);
		add(error3);
		add(homebutton);
		add(navbar);
		add(question);
		add(heavy_vehicle);
		add(light_vehicle);
		add(motor);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
	