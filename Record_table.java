import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class Record_table extends JFrame
{
	JPanel topPanel = new JPanel();
	JButton navbar, homebutton;

	JPanel bottomPanel = new JPanel();
	JButton back = new JButton("Back");

	JTable table;
	DefaultTableModel tableModel;

	JPanel basePanel = new JPanel();

	public Record_table()
	{
		//Navigation bar
		Icon bar = new ImageIcon("Pic\\Parking_record.PNG");
		navbar = new JButton(bar);
		navbar.setBounds(0,0,900, 50);
		navbar.setBorderPainted(false);            //remove border
		navbar.setContentAreaFilled(false);        //remove background color

		//Home button (most left)
		Icon home = new ImageIcon("Pic\\homebutton2.png");
		homebutton = new JButton(home);
		navbar.setBounds(0,0,75, 50);
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

		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

		Object [] columnNames = { "No.", "Parking Slot","Vehicle Plate Number", "Vehicle Type", "Ticket Code", "Entry Date", "Entry Time",
				"Exit Date", "Exit Time", "Duration parked"};

		Object[][] rowData = new Object[Main.record.size()][columnNames.length];

		for (int i = 0 ; i < Main.record.size() ; i++) {
			rowData[i][0] = i+1;
			rowData[i][1] = Main.record.get(i).getSlot_number();
			rowData[i][2] = Main.record.get(i).getPlate_number();
			rowData[i][3] = Main.record.get(i).get_type();
			rowData[i][4] = Main.record.get(i).getTicket_code();
			rowData[i][5] = Main.record.get(i).getEntry_dateTime().toLocalDate();
			rowData[i][6] = Main.record.get(i).getEntry_dateTime().format(format);
			rowData[i][7] = Main.record.get(i).getExit_dateTime().toLocalDate();
			rowData[i][8] = Main.record.get(i).getExit_dateTime().format(format);
			rowData[i][9] = Main.record.get(i).getParked_duration();
		}

		 tableModel = new DefaultTableModel(rowData, columnNames);
		 

		 table = new JTable(tableModel);
		 table.getTableHeader().setResizingAllowed(false);
		 table.getTableHeader().setReorderingAllowed(false);
		 table.setDefaultEditor(Object.class, null);
		 table.setBounds(100, 143, 500, 183);
		 JScrollPane sp = new JScrollPane(table);
		 
		 table.getColumnModel().getColumn(0).setPreferredWidth(27);
		 table.getColumnModel().getColumn(1).setPreferredWidth(80);
		 table.getColumnModel().getColumn(2).setPreferredWidth(130);
		 table.getColumnModel().getColumn(3).setPreferredWidth(85);
		 table.getColumnModel().getColumn(4).setPreferredWidth(75);
		 table.getColumnModel().getColumn(5).setPreferredWidth(75);
		 table.getColumnModel().getColumn(6).setPreferredWidth(70);
		 table.getColumnModel().getColumn(7).setPreferredWidth(75);
		 table.getColumnModel().getColumn(8).setPreferredWidth(70);
		 table.getColumnModel().getColumn(9).setPreferredWidth(100);
		 
		 back.setBounds(720,490,100,45);
		 back.setFont(new Font("San serif", Font.PLAIN,27));
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

		 basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
		 topPanel.setLayout(new GridBagLayout());
		 GridBagConstraints c = new GridBagConstraints();
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.gridwidth = 2;
		 c.gridx = 1;
	 	 c.gridy = 0;
	 	 topPanel.add(homebutton, c);
		 c.weightx = 1;
		 c.gridx = 2;
		 c.gridy = 0;
		 topPanel.add(navbar, c);
		 bottomPanel.setAlignmentX(CENTER_ALIGNMENT);
		 bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		 bottomPanel.add(Box.createRigidArea(new Dimension(0,10)));
		 bottomPanel.add(back);
		 bottomPanel.add(Box.createRigidArea(new Dimension(0,13)));
		 basePanel.add(topPanel);
		 basePanel.add(sp);
		 basePanel.add(bottomPanel);
		 add (basePanel);

		 setSize(900,600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true); 
	}
}
