import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Thank_you extends JFrame
{
	JButton img;
	JLabel thankyou = new JLabel("Thank You!");
	JLabel come_back = new JLabel("Come back again ~");
	JButton homepage = new JButton("Back to homepage");
	
	
	public Thank_you()
	{
		//Car park image
		Icon carpark = new ImageIcon("Pic\\500x580.png");
		img = new JButton(carpark);
		img.setBounds(0,0, 500,600);
		img.setBorderPainted(false);
		img.setContentAreaFilled(false);
		
		//Print "Thank You!"
		thankyou.setBounds(555,100,300,140);
		thankyou.setFont(new Font("San serif", Font.BOLD, 50));
		
		//Print "Come back again ~"
		come_back.setBounds(570,240,300,140);
		come_back.setFont(new Font("San serif", Font.PLAIN, 30));
		
		homepage.setBounds(520,400,350,50);
		homepage.setFont(new Font("San serif", Font.PLAIN, 30));
		homepage.setBorderPainted(false);
		homepage.setBackground(Color.GRAY);
		homepage.setForeground(Color.WHITE);
		homepage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					ResourceManager.save(Main.data, "data.txt");
				} catch (Exception ex) {
					System.out.println("Couldn't save: " + ex.getMessage());
				}
				new Welcome();
				dispose();
			}
		});
		
		add(homepage);
		add(img);
		add(thankyou);
		add(come_back);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
