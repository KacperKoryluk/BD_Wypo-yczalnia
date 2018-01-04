import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Application {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField loginField;
	private JTable clientsTable;

	/**
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
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
		btnClients.setBounds(105, 68, 125, 23);
		menuPanel.add(btnClients);
		
		JButton btnEquipment = new JButton("Baza sprz\u0119tu");
		btnEquipment.setBounds(105, 116, 125, 23);
		menuPanel.add(btnEquipment);
		
		JButton btnBooking = new JButton("Baza rezerwacji");
		btnBooking.setBounds(105, 162, 125, 23);
		menuPanel.add(btnBooking);
		
		JButton btnStatistics = new JButton("Statystyki");
		btnStatistics.setBounds(265, 68, 102, 23);
		menuPanel.add(btnStatistics);
		
		JButton btnMenuLogout = new JButton("Wyloguj");
		btnMenuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		btnMenuLogout.setBounds(345, 237, 89, 23);
		menuPanel.add(btnMenuLogout);
		menuPanel.setVisible(false);

		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 132, 169, 20);
		mainPanel.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(175, 51, 89, 14);
		mainPanel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Has\u0142o");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(175, 110, 89, 14);
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
		btnZaloguj.setBounds(175, 178, 89, 23);
		mainPanel.add(btnZaloguj);
		
		loginField = new JTextField();
		loginField.setBounds(137, 79, 169, 20);
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
		btnClientsLogout.setBounds(345, 237, 89, 23);
		clientsPanel.add(btnClientsLogout);
		
		JButton btnClientsBack = new JButton("Wr\u00F3\u0107");
		btnClientsBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientsPanel.setVisible(false);
				menuPanel.setVisible(true);
			}
		});
		btnClientsBack.setBounds(10, 237, 89, 23);
		clientsPanel.add(btnClientsBack);
		
		JLabel lblKlienci = new JLabel("Klienci");
		lblKlienci.setHorizontalAlignment(SwingConstants.CENTER);
		lblKlienci.setBounds(200, 11, 46, 14);
		clientsPanel.add(lblKlienci);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 270, 190);
		clientsPanel.add(scrollPane);
		
		clientsTable = new JTable();
		scrollPane.setViewportView(clientsTable);
		
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
		btnEquipmentLogout.setBounds(345, 237, 89, 23);
		equipmentPanel.add(btnEquipmentLogout);
		
		JButton btnEquipmentBack = new JButton("Wr\u00F3\u0107");
		btnEquipmentBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				equipmentPanel.setVisible(false);
			}
		});
		btnEquipmentBack.setBounds(10, 237, 89, 23);
		equipmentPanel.add(btnEquipmentBack);
		
		JLabel lblSprzt = new JLabel("Sprz\u0119t");
		lblSprzt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSprzt.setBounds(200, 11, 46, 14);
		equipmentPanel.add(lblSprzt);
		
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
		btnBookingLogout.setBounds(345, 237, 89, 23);
		bookingPanel.add(btnBookingLogout);
		
		JButton btnBookingBack = new JButton("Wr\u00F3\u0107");
		btnBookingBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				bookingPanel.setVisible(false);
			}
		});
		btnBookingBack.setBounds(10, 237, 89, 23);
		bookingPanel.add(btnBookingBack);
		
		JLabel lblRezerwacje = new JLabel("Rezerwacje");
		lblRezerwacje.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezerwacje.setBounds(186, 11, 79, 14);
		bookingPanel.add(lblRezerwacje);
		
		btnEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipmentPanel.setVisible(true);
				menuPanel.setVisible(false);
			}
		});
		
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookingPanel.setVisible(true);
				menuPanel.setVisible(false);
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
				
				if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
					passwordField.requestFocusInWindow();
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
				
				if (arg0.getKeyCode() == KeyEvent.VK_TAB) {
					loginField.requestFocusInWindow();
				}	
			}
		});
		
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				clientsPanel.setVisible(true);
			}
		});

	}
}
