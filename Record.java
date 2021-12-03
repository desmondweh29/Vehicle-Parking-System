import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Record extends JFrame
{
	int current_slot = 0;
	
	public Record(int current_lot)
	{
		JButton navbar, homebutton;
		JButton back = new JButton("Back");
		JButton button []  = new JButton[36];
		JTextArea output = new JTextArea();
		JButton reserved = new JButton("Mark as reserve");
		JButton available = new JButton("Mark as available");
		JLabel text = new JLabel(Main.data[current_lot].getName() + " Floor");

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
		
		back.setBounds(730,490,120,45);
		back.setFont(new Font("San serif", Font.PLAIN,30));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBorderPainted(false);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Check_parking();
				dispose();
			}
		});

		reserved.setBounds(600,320,250,40);
		reserved.setFont(new Font("San serif", Font.PLAIN, 25));
		reserved.setBackground(Color.YELLOW);
		reserved.setBorderPainted(false);
		reserved.setVisible(false);
		reserved.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Main.data[current_lot].setSlot_reserved(current_slot);
				button[current_slot].setBackground(Color.YELLOW);
				button[current_slot].setContentAreaFilled(true);
				reserved.setVisible(false);
				available.setVisible(true);
				try {
					ResourceManager.save(Main.data, "data.txt");
				} catch (Exception ex) {
					System.out.println("Couldn't save: " + ex.getMessage());
				}
			}
		});

		available.setBounds(600,320,250,40);
		available.setFont(new Font("San serif", Font.PLAIN, 25));
		available.setBackground(Color.YELLOW);
		available.setBorderPainted(false);
		available.setVisible(false);
		available.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Main.data[current_lot].setSlot_available(current_slot);
				button[current_slot].setContentAreaFilled(false);
				reserved.setVisible(true);
				available.setVisible(false);
				try {
					ResourceManager.save(Main.data, "data.txt");
				} catch (Exception ex) {
					System.out.println("Couldn't save: " + ex.getMessage());
				}
			}
		});

		Font font = new Font("TimesRoman", Font.PLAIN, 11);
		Font output_font = new Font("San serif", Font.PLAIN, 20);
		
		text.setBounds(350,30,400,140);
		text.setFont(new Font("San serif", Font.PLAIN,40));

		for (int i = 0 ; i < 36 ; i++) {
			JButton b = new JButton(Main.data[current_lot].getCode()+i);
			b.setFont(font);
			button[i] = b;
			if ((Main.data[current_lot].get_slot_status(i)).equals("OCCUPIED")) {
				button[i].setBackground(Color.RED);
				button[i].setForeground(Color.WHITE);
			} else if ((Main.data[current_lot].get_slot_status(i)).equals("RESERVED")) {
				button[i].setBackground(Color.YELLOW);
			} else {
				button[i].setContentAreaFilled(false);
			}

			int index = i;
			button[index].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					current_slot = index;
					Main.data[current_lot].get_slot_details(index, output);

					if ((Main.data[current_lot].get_slot_status(index)).equals("AVAILABLE")){
						reserved.setVisible(true);
						available.setVisible(false);

					} else if ((Main.data[current_lot].get_slot_status(index)).equals("RESERVED")){
						reserved.setVisible(false);
						available.setVisible(true);
					} else {
						reserved.setVisible(false);
						available.setVisible(false);
					}
				}
			});
		}
		
		button[0].setBounds(100,160,55,55);
		button[1].setBounds(100,215,55,55);
		button[2].setBounds(100,270,55,55);
		button[3].setBounds(100,325,55,55);
		button[4].setBounds(100,380,55,55);
		button[5].setBounds(100,435,55,55);
		button[6].setBounds(155,160,55,55);
		button[7].setBounds(155,215,55,55);
		button[8].setBounds(155,270,55,55);
		button[9].setBounds(155,325,55,55);
		button[10].setBounds(155,380,55,55);
		button[11].setBounds(155,435,55,55);
		button[12].setBounds(265,160,55,55);
		button[13].setBounds(265,215,55,55);
		button[14].setBounds(265,270,55,55);
		button[15].setBounds(265,325,55,55);
		button[16].setBounds(265,380,55,55);
		button[17].setBounds(265,435,55,55);
		button[18].setBounds(320,160,55,55);
		button[19].setBounds(320,215,55,55);
		button[20].setBounds(320,270,55,55);
		button[21].setBounds(320,325,55,55);
		button[22].setBounds(320,380,55,55);
		button[23].setBounds(320,435,55,55);
		button[24].setBounds(430,160,55,55);
		button[25].setBounds(430,215,55,55);
		button[26].setBounds(430,270,55,55);
		button[27].setBounds(430,325,55,55);
		button[28].setBounds(430,380,55,55);
		button[29].setBounds(430,435,55,55);
		button[30].setBounds(485,160,55,55);
		button[31].setBounds(485,215,55,55);
		button[32].setBounds(485,270,55,55);
		button[33].setBounds(485,325,55,55);
		button[34].setBounds(485,380,55,55);
		button[35].setBounds(485,435,55,55);

		output.setBounds(600,160,250,140);
		output.setFont(output_font);
		output.setEditable(false);

		add(back);
		add(homebutton);
		add(reserved);
		add(available);
		add(navbar);
		add(text);

		for (int i = 0 ; i < 36 ; i++) {
			add (button[i]);
		}
		add(output);
		
		setSize(900,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
