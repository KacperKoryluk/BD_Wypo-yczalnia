import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AddBookingFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int hash;
	private JTable eqTable;
	private JTable booEqTable;
	private JTable clientTable;
	private JTextField dateField;

	public JTable getClientTable() {
		return clientTable;
	}
	
	public JTable getEqTable() {
		return eqTable;
	}
	
	public JTable getBooEqTable() {
		return booEqTable;
	}

	public void setHash(long var, int maxValue) {
		hash = GUIMethods.hashIDBoo(var, maxValue);
	}
	/**
	 * Create the frame.
	 */
	public AddBookingFrame(JFrame frame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 658, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, "name_77869557651666");
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JButton btnAdd = new JButton(">");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = eqTable.getSelectedRows();
				try {
					if (rows.length != 0) {
						
						for (int i = 0; i < rows.length; i++) {
							Application.functions.updateEquipment(eqTable.getValueAt(rows[i], 0).toString(),
																Integer.toString(hash),
																"DOSTEPNY",
																eqTable.getValueAt(rows[i], 1).toString(), 
																eqTable.getValueAt(rows[i], 2).toString());
						}
						
						
						
						String col[] = {"ID", "Kategoria", "Opis"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 0);
						DefaultTableModel tableModel2 = new DefaultTableModel(col, 0);
						
						
						ArrayList<String> resp = Application.functions.getEqByOrder(Integer.toString(hash));
						booEqTable.setModel(tableModel);
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel.addRow(data);
						}
						
						resp = Application.functions.getEqByOrderNull();
						eqTable.setModel(tableModel2);
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel2.addRow(data);
						}
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
				}
			}
		});
		btnAdd.setBounds(287, 141, 58, 36);
		mainPanel.add(btnAdd);
		
		JButton btnRem = new JButton("<");
		btnRem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = booEqTable.getSelectedRows();
				try {
					if (rows.length != 0) {
						
						Application.functions.freeEquipment(Integer.toString(hash));
						
						
						
						String col[] = {"ID", "Kategoria", "Opis"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 0);
						DefaultTableModel tableModel2 = new DefaultTableModel(col, 0);
						
						ArrayList<String> resp = Application.functions.getEqByOrderNull();
						eqTable.setModel(tableModel);
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel.addRow(data);
						}
						
						resp = Application.functions.getEqByOrder(Integer.toString(hash));
						booEqTable.setModel(tableModel2);
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel2.addRow(data);
						}
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
				}
			}
		});
		btnRem.setBounds(287, 187, 58, 36);
		mainPanel.add(btnRem);
		
		JButton btnBack2 = new JButton("Wr\u00F3\u0107");
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Application.functions.freeEquipment(Integer.toString(hash));
					
					Application.functions.deleteBooking(Integer.toString(hash));
					
					frame.setEnabled(true);
					dispose();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
				}
			}
		});
		btnBack2.setBounds(10, 381, 95, 31);
		mainPanel.add(btnBack2);
		
		JButton btnAcc = new JButton("Akceptuj");
		btnAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = booEqTable.getSelectedRows();
				try {
					if (rows.length != 0) {
						
						for (int i = 0; i < rows.length; i++) {
							Application.functions.updateEquipment(eqTable.getValueAt(rows[i], 0).toString(),
																Integer.toString(hash),
																"NIEDOSTEPNY",
																eqTable.getValueAt(rows[i], 1).toString(), 
																eqTable.getValueAt(rows[i], 2).toString());
						}
					}
					
					
					ArrayList<String> resp = Application.functions.getBookingsByStatus("OPLACONA");
					ArrayList<String> resp2 = Application.functions.getBookingsByStatus("NIEOPLACONA");
					String col[] = {"ID Rezewacji", "ID Sprzetu" , "Data rezerwacji", "Status", "Data wygasniecia"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					Application.getBookingTable().setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
					for (int i = 0; i < resp2.size(); i++) {
						String[] data = resp2.get(i).split("\t");
						tableModel.addRow(data);
					}
					
					
					resp = Application.functions.getBookingsByStatus("ARCHIWUM");
					DefaultTableModel tableModel2 = new DefaultTableModel(col, 0);
					
					Application.getBooArchTable().setModel(tableModel2);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel2.addRow(data);
					}
					
					frame.setEnabled(true);
					dispose();
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
				}
			}
		});
		btnAcc.setBounds(452, 381, 123, 31);
		mainPanel.add(btnAcc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 274, 359);
		mainPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		eqTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane.setViewportView(eqTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(348, 11, 274, 359);
		mainPanel.add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		booEqTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane_1.setViewportView(booEqTable);
		
		JPanel clientPanel = new JPanel();
		contentPane.add(clientPanel, "name_77873304381450");
		clientPanel.setLayout(null);
		clientPanel.setVisible(true);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 612, 318);
		clientPanel.add(scrollPane_2);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		clientTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clientTable.setCellSelectionEnabled(true);
		scrollPane_2.setViewportView(clientTable);
		
		dateField = new JTextField();
		dateField.setBounds(262, 380, 112, 32);
		clientPanel.add(dateField);
		dateField.setColumns(10);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Application.functions.deleteBooking(Integer.toString(hash));
				
				frame.setEnabled(true);
				dispose();
			}
		});
		btnBack.setBounds(0, 380, 104, 32);
		clientPanel.add(btnBack);
		
		JLabel lblExp = new JLabel("Data wygasniecia (YY-MM-DD)");
		lblExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblExp.setBounds(10, 337, 612, 32);
		clientPanel.add(lblExp);
		
		JButton btnAck = new JButton("Akceptuj");
		btnAck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblExp.setForeground(Color.BLACK);
				boolean correctData = true;
				if (dateField.getText().trim().compareTo("") == 0) { lblExp.setForeground(Color.RED); correctData = false; }
				try {
					if (correctData) {
					int row = clientTable.getSelectedRow();
					Application.functions.addBooking(Integer.toString(hash),
							clientTable.getValueAt(row, 0).toString(), 
							dateField.getText());
					clientPanel.setVisible(false);
					mainPanel.setVisible(true);
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
				}
			}
		});
		btnAck.setBounds(518, 380, 104, 32);
		clientPanel.add(btnAck);
		
		
		

	}
}
