import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class Application {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField loginField;
	private static JTable clientsTable;
	private static JTable equipmentTable;
	private static JTable bookingTable;
	static public DBFunctions functions = new DBFunctions();
	private static JTable eqDetailsTable;
	private static JTable booArchTable;

	public static JTable getBooArchTable() {
		return booArchTable;
	}
	public static JTable getEqDetailsTable() {
		return eqDetailsTable;
	}
	public static JTable getClientsTable() {
		return clientsTable;
	}
	
	public static JTable getEquipmentTable() {
		return equipmentTable;
	}
	
	public static JTable getBookingTable() {
		return bookingTable;
	}
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GenerateData.generateClients();
		GenerateData.generateBoo();
		GenerateData.generateEq();
		
		Font font1 = new Font("Tahoma", Font.PLAIN, 18);
		Font font2 = new Font("Tahoma", Font.PLAIN, 11);
		UIManager.put("Button.font", font1);
	//	UIManager.put("ToggleButton.font", /* font of your liking */);
	//	UIManager.put("RadioButton.font", /* font of your liking */);
	//	UIManager.put("CheckBox.font", /* font of your liking */);
	//	UIManager.put("ColorChooser.font", /* font of your liking */);
	//	UIManager.put("ComboBox.font", /* font of your liking */);
		UIManager.put("Label.font", font1);
	//	UIManager.put("List.font", /* font of your liking */);
	//	UIManager.put("MenuBar.font", /* font of your liking */);
	//	UIManager.put("MenuItem.font", /* font of your liking */);
	//	UIManager.put("RadioButtonMenuItem.font", /* font of your liking */);
	//	UIManager.put("CheckBoxMenuItem.font", /* font of your liking */);
	//	UIManager.put("Menu.font", /* font of your liking */);
	//	UIManager.put("PopupMenu.font", /* font of your liking */);
	//	UIManager.put("OptionPane.font", /* font of your liking */);
	//	UIManager.put("Panel.font", /* font of your liking */);
	//	UIManager.put("ProgressBar.font", /* font of your liking */);
	//	UIManager.put("ScrollPane.font", /* font of your liking */);
	//	UIManager.put("Viewport.font", /* font of your liking */);
	//	UIManager.put("TabbedPane.font", /* font of your liking */);
		UIManager.put("Table.font", font2);
		UIManager.put("TableHeader.font", font2);
		UIManager.put("TextField.font", font1);
		UIManager.put("PasswordField.font", font1);
	//	UIManager.put("TextArea.font", /* font of your liking */);
	//	UIManager.put("TextPane.font", /* font of your liking */);
	//	UIManager.put("EditorPane.font", /* font of your liking */);
	//	UIManager.put("TitledBorder.font", /* font of your liking */);
	//	UIManager.put("ToolBar.font", /* font of your liking */);
	//	UIManager.put("ToolTip.font", /* font of your liking */);
	//	UIManager.put("Tree.font", /* font of your liking */);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 655, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_231990567351519");
		mainPanel.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		frame.getContentPane().add(menuPanel, "name_249115105937907");
		menuPanel.setEnabled(false);
		menuPanel.setLayout(null);
		
		JButton btnClients = new JButton("Baza klient\u00F3w");
		btnClients.setBounds(321, 110, 174, 63);
		menuPanel.add(btnClients);
		
		JButton btnEquipment = new JButton("Baza sprz\u0119tu");
		btnEquipment.setBounds(94, 242, 174, 63);
		menuPanel.add(btnEquipment);
		
		JButton btnBooking = new JButton("Baza rezerwacji");
		btnBooking.setBounds(94, 110, 174, 63);
		menuPanel.add(btnBooking);
		
		JButton btnStatistics = new JButton("Statystyki");
		btnStatistics.setBounds(321, 242, 174, 63);
		menuPanel.add(btnStatistics);
		
		JButton btnMenuLogout = new JButton("Wyloguj");
		btnMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		btnMenuLogout.setBounds(472, 412, 122, 51);
		menuPanel.add(btnMenuLogout);
		menuPanel.setVisible(false);

		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 230, 236, 38);
		mainPanel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(263, 83, 89, 25);
		mainPanel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Has\u0142o");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(263, 181, 89, 27);
		mainPanel.add(lblPassword);
		
		JButton btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					lblLogin.setForeground(Color.BLACK);
					lblPassword.setForeground(Color.BLACK);
					
					if (loginField.getText().compareTo("admin") == 0) {

						try {
							char[] pass = {'a', 'd', 'm', 'i', 'n'};
							if (Arrays.equals(pass, passwordField.getPassword())) {
								
								mainPanel.setVisible(false);
								menuPanel.setVisible(true);
								
								loginField.setText("");
								passwordField.setText("");
								
							}else {
								lblLogin.setForeground(Color.RED);
								lblPassword.setForeground(Color.RED);
							}
						}
						catch(Exception e){
							lblLogin.setForeground(Color.RED);
							lblPassword.setForeground(Color.RED);
						}
					}else {
						lblLogin.setForeground(Color.RED);
						lblPassword.setForeground(Color.RED);
					}
				}
				
				if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
					loginField.requestFocusInWindow();
				}
			}
		});
		btnZaloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblLogin.setForeground(Color.BLACK);
				lblPassword.setForeground(Color.BLACK);
				
				if (loginField.getText().compareTo("admin") == 0) {

					try {
						char[] pass = {'a', 'd', 'm', 'i', 'n'};
						if (Arrays.equals(pass, passwordField.getPassword())) {
							
							mainPanel.setVisible(false);
							menuPanel.setVisible(true);
							
							loginField.setText("");
							passwordField.setText("");
							
						}else {
							lblLogin.setForeground(Color.RED);
							lblPassword.setForeground(Color.RED);
						}
					}
					catch(Exception e){
						lblLogin.setForeground(Color.RED);
						lblPassword.setForeground(Color.RED);
					}
				}else {
					lblLogin.setForeground(Color.RED);
					lblPassword.setForeground(Color.RED);
				}

			}
		});
		btnZaloguj.setBounds(246, 311, 137, 52);
		mainPanel.add(btnZaloguj);
		
		loginField = new JTextField();
		loginField.setBounds(196, 119, 236, 38);
		mainPanel.add(loginField);
		loginField.setColumns(10);
		
		
		JPanel clientsPanel = new JPanel();
		frame.getContentPane().add(clientsPanel, "name_254040213900164");
		clientsPanel.setLayout(null);
		
		JButton btnClientsLogout = new JButton("Wyloguj");
		btnClientsLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				clientsPanel.setVisible(false);
			}
		});
		btnClientsLogout.setBounds(490, 459, 149, 33);
		clientsPanel.add(btnClientsLogout);
		
		JButton btnClientsBack = new JButton("Wr\u00F3\u0107");
		btnClientsBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientsPanel.setVisible(false);
				menuPanel.setVisible(true);
			}
		});
		btnClientsBack.setBounds(10, 459, 89, 33);
		clientsPanel.add(btnClientsBack);
		
		JLabel lblKlienci = new JLabel("Klienci");
		lblKlienci.setHorizontalAlignment(SwingConstants.CENTER);
		lblKlienci.setBounds(281, 0, 82, 25);
		clientsPanel.add(lblKlienci);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 629, 363);
		clientsPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		clientsTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		clientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(clientsTable);
		clientsTable.setCellSelectionEnabled(true);
		clientsTable.setColumnSelectionAllowed(false);
		
		JButton btnAddClient = new JButton("Dodaj");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddClientFrame frame2 = new AddClientFrame(frame);
				frame2.setVisible(true);
				frame.setEnabled(false);
			}
		});
		btnAddClient.setBounds(98, 398, 89, 45);
		clientsPanel.add(btnAddClient);
		
		JButton btnDeleteClient = new JButton("Usu\u0144");
		btnDeleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = clientsTable.getValueAt(clientsTable.getSelectedRow(), 0).toString();
				try {
					functions.deleteClient(ID);
					ArrayList<String> resp = functions.getTableContent("KLIENCI");
					String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					clientsTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteClient.setBounds(431, 398, 90, 45);
		clientsPanel.add(btnDeleteClient);
		
		JButton btnUpdate = new JButton("Aktualizuj");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateClientFrame frame2 = new UpdateClientFrame(frame);
				int row = clientsTable.getSelectedRow();
				frame2.getNameField().setText(clientsTable.getValueAt(row, 1).toString());
				frame2.getSurnameField().setText(clientsTable.getValueAt(row, 2).toString());
				frame2.getEmailField().setText(clientsTable.getValueAt(row, 4).toString());
				frame2.getPeselField().setText(clientsTable.getValueAt(row, 3).toString());
				frame2.getPhoneField().setText(clientsTable.getValueAt(row, 5).toString());
				frame2.setVisible(true);
				frame.setEnabled(false);
			}
		});
		btnUpdate.setBounds(228, 398, 161, 45);
		clientsPanel.add(btnUpdate);
		
		
		JPanel equipmentPanel = new JPanel();
		equipmentPanel.setLayout(null);
		frame.getContentPane().add(equipmentPanel, "name_254713404240285");
		
		JButton btnEquipmentLogout = new JButton("Wyloguj");
		btnEquipmentLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				equipmentPanel.setVisible(false);
			}
		});
		btnEquipmentLogout.setBounds(477, 458, 162, 34);
		equipmentPanel.add(btnEquipmentLogout);
		
		JButton btnEquipmentBack = new JButton("Wr\u00F3\u0107");
		btnEquipmentBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				equipmentPanel.setVisible(false);
			}
		});
		btnEquipmentBack.setBounds(10, 458, 89, 34);
		equipmentPanel.add(btnEquipmentBack);
		
		JLabel lblSprzt = new JLabel("Sprz\u0119t");
		lblSprzt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSprzt.setBounds(252, 0, 96, 25);
		equipmentPanel.add(lblSprzt);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 244, 367);
		equipmentPanel.add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		equipmentTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		equipmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		equipmentTable.setCellSelectionEnabled(true);
		scrollPane_1.setViewportView(equipmentTable);		
		
		equipmentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            
	        	int row = equipmentTable.getSelectedRow();
				if (row != -1) {
					try {
						ArrayList<String> resp = functions.getEqByCategory(equipmentTable.getValueAt(row, 0).toString());
						
						String col[] = {"ID_SPRZETU", "ID_REZERWACJI", "STATUS", "KATEGORIA", "OPIS_SPRZETU"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 0);
						
						eqDetailsTable.setModel(tableModel);
						
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel.addRow(data);
						}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	        }
	    });
		
		JButton btnAddEq = new JButton("Dodaj");
		btnAddEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEqFrame frame2 = new AddEqFrame(frame);
				frame2.setVisible(true);
				frame.setEnabled(false);
			}
		});
		btnAddEq.setBounds(75, 402, 89, 37);
		equipmentPanel.add(btnAddEq);
		
		eqDetailsTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		eqDetailsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnDeleteEq = new JButton("Usu\u0144");
		btnDeleteEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String ID = eqDetailsTable.getValueAt(eqDetailsTable.getSelectedRow(), 0).toString();
				String category = eqDetailsTable.getValueAt(eqDetailsTable.getSelectedRow(), 3).toString();
				functions.deleteEquipment(ID);
				try {
					ArrayList<String> resp = functions.getEqByCategory();
					String col[] = {"Kategoria", "Iloœæ"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					equipmentTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					ArrayList<String> resp = functions.getEqByCategory(category);
					
					String col[] = {"ID_SPRZETU", "ID_REZERWACJI", "STATUS", "KATEGORIA", "OPIS_SPRZETU"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					eqDetailsTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteEq.setBounds(346, 402, 89, 37);
		equipmentPanel.add(btnDeleteEq);
		
		JButton btnUpdateEq = new JButton("Aktualizuj");
		btnUpdateEq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEqFrame frame2 = new UpdateEqFrame(frame);
				int row = eqDetailsTable.getSelectedRow();
				frame2.getCatField().setText(eqDetailsTable.getValueAt(row, 3).toString());
				frame2.getDescField().setText(eqDetailsTable.getValueAt(row, 4).toString());
				frame2.setVisible(true);
				frame.setEnabled(false);
			}
		});
		btnUpdateEq.setBounds(463, 402, 145, 37);
		equipmentPanel.add(btnUpdateEq);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(346, 24, 262, 367);
		equipmentPanel.add(scrollPane_3);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		eqDetailsTable.setCellSelectionEnabled(true);
		scrollPane_3.setViewportView(eqDetailsTable);
		
		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(null);
		frame.getContentPane().add(bookingPanel, "name_254714656406594");
		
		JButton btnBookingLogout = new JButton("Wyloguj");
		btnBookingLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				bookingPanel.setVisible(false);
			}
		});
		btnBookingLogout.setBounds(477, 459, 162, 33);
		bookingPanel.add(btnBookingLogout);
		
		JButton btnBookingBack = new JButton("Wr\u00F3\u0107");
		btnBookingBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				bookingPanel.setVisible(false);
			}
		});
		btnBookingBack.setBounds(10, 459, 89, 33);
		bookingPanel.add(btnBookingBack);
		
		JLabel lblRezerwacje = new JLabel("Rezerwacje");
		lblRezerwacje.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezerwacje.setBounds(255, 0, 120, 25);
		bookingPanel.add(lblRezerwacje);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 24, 307, 379);
		bookingPanel.add(scrollPane_2);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		bookingTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		bookingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookingTable.setCellSelectionEnabled(true);
		scrollPane_2.setViewportView(bookingTable);
		
		JButton btnAddBoo = new JButton("Dodaj");
		btnAddBoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookingFrame frame2 = new AddBookingFrame(frame);
				String col[] = {"ID", "Kategoria", "Opis"};
				DefaultTableModel tableModel = new DefaultTableModel(col, 0);
				
				frame2.setHash(System.currentTimeMillis(), 99999);
				
				ArrayList<String> resp = functions.getEqByOrderNull();
				JTable eqTable = frame2.getEqTable();
				eqTable.setModel(tableModel);
				
				for (int i = 0; i < resp.size(); i++) {
					String[] data = resp.get(i).split("\t");
					tableModel.addRow(data);
				}
				
				
					 resp = functions.getTableContent("KLIENCI");
					
					String col2[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
					DefaultTableModel tableModel2 = new DefaultTableModel(col2, 0);
					
					frame2.getClientTable().setModel(tableModel2);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel2.addRow(data);
					}


				frame2.setVisible(true);
				frame.setEnabled(false);
				
			}
		});
		btnAddBoo.setBounds(350, 415, 108, 33);
		bookingPanel.add(btnAddBoo);
		
		JButton btnPay = new JButton("Op\u0142a\u0107");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = bookingTable.getSelectedRow();

				
				functions.updateBooking(bookingTable.getValueAt(row, 0).toString(),
										bookingTable.getValueAt(row, 1).toString(),
										bookingTable.getValueAt(row, 2).toString().split("\\.")[0],
										"OPLACONA",
										bookingTable.getValueAt(row, 4).toString().split("\\.")[0]);
				
				try {
					ArrayList<String> resp = functions.getBookingsByStatus("OPLACONA");
					ArrayList<String> resp2 = functions.getBookingsByStatus("NIEOPLACONA");
					String col[] = {"ID Rezewacji", "ID Klienta" , "Data rezerwacji", "Status", "Data wygasniecia"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					bookingTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
					for (int i = 0; i < resp2.size(); i++) {
						String[] data = resp2.get(i).split("\t");
						tableModel.addRow(data);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPay.setBounds(20, 415, 101, 33);
		bookingPanel.add(btnPay);
		
		JButton btnArchive = new JButton("Archiwizuj");
		btnArchive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = bookingTable.getSelectedRow();

				
				functions.updateBooking(bookingTable.getValueAt(row, 0).toString(),
										bookingTable.getValueAt(row, 1).toString(),
										bookingTable.getValueAt(row, 2).toString().split("\\.")[0],
										"ARCHIWUM",
										bookingTable.getValueAt(row, 4).toString().split("\\.")[0]);
				
				functions.freeEquipment(bookingTable.getValueAt(row, 0).toString());
				
				
				try {
					ArrayList<String> resp = functions.getBookingsByStatus("OPLACONA");
					ArrayList<String> resp2 = functions.getBookingsByStatus("NIEOPLACONA");
					String col[] = {"ID Rezewacji", "ID Klienta" , "Data rezerwacji", "Status", "Data wygasniecia"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					bookingTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
					for (int i = 0; i < resp2.size(); i++) {
						String[] data = resp2.get(i).split("\t");
						tableModel.addRow(data);
					}
					
					
					resp = functions.getBookingsByStatus("ARCHIWUM");
					
					DefaultTableModel tableModel2 = new DefaultTableModel(col, 0);
					
					booArchTable.setModel(tableModel2);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel2.addRow(data);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnArchive.setBounds(131, 415, 162, 33);
		bookingPanel.add(btnArchive);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(327, 24, 312, 379);
		bookingPanel.add(scrollPane_4);
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		booArchTable = new JTable() {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		booArchTable.setCellSelectionEnabled(true);
		booArchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(booArchTable);
		
		JButton btnDeleteBoo = new JButton("Usu\u0144");
		btnDeleteBoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = booArchTable.getSelectedRow();
				
				functions.deleteBooking(booArchTable.getValueAt(row, 0).toString());
				
				ArrayList<String> resp = functions.getBookingsByStatus("ARCHIWUM");
				String col[] = {"ID Rezewacji", "ID Klienta" , "Data rezerwacji", "Status", "Data wygasniecia"};
				DefaultTableModel tableModel = new DefaultTableModel(col, 0);
				
				booArchTable.setModel(tableModel);
				
				
				for (int i = 0; i < resp.size(); i++) {
					String[] data = resp.get(i).split("\t");
					tableModel.addRow(data);
				}
				
			}
		});
		btnDeleteBoo.setBounds(488, 415, 101, 33);
		bookingPanel.add(btnDeleteBoo);
		
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentPanel.setVisible(true);
				menuPanel.setVisible(false);			
				
				try {
					ArrayList<String> resp = functions.getEqByCategory();
					String col[] = {"Kategoria", "Iloœæ"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					equipmentTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookingPanel.setVisible(true);
				menuPanel.setVisible(false);
				
				
				try {
					ArrayList<String> resp = functions.getBookingsByStatus("OPLACONA");
					ArrayList<String> resp2 = functions.getBookingsByStatus("NIEOPLACONA");
					String col[] = {"ID Rezewacji", "ID Klienta" , "Data rezerwacji", "Status", "Data wygasniecia"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					bookingTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
					for (int i = 0; i < resp2.size(); i++) {
						String[] data = resp2.get(i).split("\t");
						tableModel.addRow(data);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					ArrayList<String> resp = functions.getBookingsByStatus("ARCHIWUM");
					String col[] = {"ID Rezewacji", "ID Klienta" , "Data rezerwacji", "Status", "Data wygasniecia"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					booArchTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					lblLogin.setForeground(Color.BLACK);
					lblPassword.setForeground(Color.BLACK);
					
					if (loginField.getText().compareTo("admin") == 0) {

						try {
							char[] pass = {'a', 'd', 'm', 'i', 'n'};
							if (Arrays.equals(pass, passwordField.getPassword())) {
								
								mainPanel.setVisible(false);
								menuPanel.setVisible(true);
								
								loginField.setText("");
								passwordField.setText("");
								
							}else {
								lblLogin.setForeground(Color.RED);
								lblPassword.setForeground(Color.RED);
							}
						}
						catch(Exception e){
							lblLogin.setForeground(Color.RED);
							lblPassword.setForeground(Color.RED);
						}
					}else {
						lblLogin.setForeground(Color.RED);
						lblPassword.setForeground(Color.RED);
					}
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					lblLogin.setForeground(Color.BLACK);
					lblPassword.setForeground(Color.BLACK);
					
					if (loginField.getText().compareTo("admin") == 0) {

						try {
							char[] pass = {'a', 'd', 'm', 'i', 'n'};
							if (Arrays.equals(pass, passwordField.getPassword())) {
								
								mainPanel.setVisible(false);
								menuPanel.setVisible(true);
								
								loginField.setText("");
								passwordField.setText("");
								
							}else {
								lblLogin.setForeground(Color.RED);
								lblPassword.setForeground(Color.RED);
							}
						}
						catch(Exception e){
							lblLogin.setForeground(Color.RED);
							lblPassword.setForeground(Color.RED);
						}
					}else {
						lblLogin.setForeground(Color.RED);
						lblPassword.setForeground(Color.RED);
					}
				}	
			}
		});
		
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuPanel.setVisible(false);
				clientsPanel.setVisible(true);
				
				try {
					ArrayList<String> resp = functions.getTableContent("KLIENCI");
					
					String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
					DefaultTableModel tableModel = new DefaultTableModel(col, 0);
					
					clientsTable.setModel(tableModel);
					
					
					for (int i = 0; i < resp.size(); i++) {
						String[] data = resp.get(i).split("\t");
						tableModel.addRow(data);
					}
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

	}
}
