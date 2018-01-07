import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class AddClientFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField peselField;
	private JTextField emailField;
	private JTextField phoneField;


	/**
	 * Create the frame.
	 */
	public AddClientFrame(JFrame frame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 455, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.setMnemonic(KeyEvent.VK_ESCAPE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 278, 105, 29);
		contentPane.add(btnBack);
		
		JLabel lblName = new JLabel("Imie");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(113, 11, 56, 23);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Nazwisko");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setBounds(89, 93, 105, 23);
		contentPane.add(lblSurname);
		
		JLabel lblPesel = new JLabel("PESEL");
		lblPesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesel.setBounds(113, 176, 56, 23);
		contentPane.add(lblPesel);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(289, 49, 56, 23);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Nr. telefonu");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(250, 139, 139, 23);
		contentPane.add(lblPhone);		
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
							String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
							String text = emailField.getText().trim();
							if (text.compareTo("") == 0)
								text = null;
							Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
							
							nameField.setText("");
							surnameField.setText("");
							peselField.setText("");
							emailField.setText("");
							phoneField.setText("");
							
								ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
						}
					}
				}
		});
		nameField.setBounds(89, 45, 105, 38);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					try {
					boolean correctData = true;
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					
						if (correctData) {
							String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
							String text = emailField.getText().trim();
							if (text.compareTo("") == 0)
								text = null;
							Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
							
							nameField.setText("");
							surnameField.setText("");
							peselField.setText("");
							emailField.setText("");
							phoneField.setText("");
							
								ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
						}
					}
				}
			
		});
		surnameField.setText("");
		surnameField.setBounds(89, 127, 105, 38);
		contentPane.add(surnameField);
		surnameField.setColumns(10);			
		
		peselField = new JTextField();
		peselField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					try {
						boolean correctData = true;
						if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
						if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
						if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
						if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
						
						if (correctData) {
							String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
							String text = emailField.getText().trim();
							if (text.compareTo("") == 0)
								text = null;
							Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
							
							nameField.setText("");
							surnameField.setText("");
							peselField.setText("");
							emailField.setText("");
							phoneField.setText("");
							
	
								ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
						}
					}
				}
			
		});
		peselField.setBounds(89, 207, 105, 39);
		contentPane.add(peselField);
		peselField.setColumns(10);
		
		emailField = new JTextField();
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					try {
						boolean correctData = true;
						if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
						if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
						if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
						if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
						
						if (correctData) {
							String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
							String text = emailField.getText().trim();
							if (text.compareTo("") == 0)
								text = null;
							Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
							
							nameField.setText("");
							surnameField.setText("");
							peselField.setText("");
							emailField.setText("");
							phoneField.setText("");
							
								ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
						}
					}
				}
		});
		emailField.setBounds(240, 83, 149, 38);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					try {
						boolean correctData = true;
						if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
						if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
						if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
						if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
						
						if (correctData) {
							String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
							String text = emailField.getText().trim();
							if (text.compareTo("") == 0)
								text = null;
							Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
							
							nameField.setText("");
							surnameField.setText("");
							peselField.setText("");
							emailField.setText("");
							phoneField.setText("");
							
	
								ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
						}
					}
				}
		});
		phoneField.setBounds(240, 169, 149, 38);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Dodaj");
		btnAdd.setMnemonic(KeyEvent.VK_ENTER);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblName.setForeground(Color.BLACK);
				lblPesel.setForeground(Color.BLACK);
				lblPhone.setForeground(Color.BLACK);
				lblSurname.setForeground(Color.BLACK);
				try {
					boolean correctData = true;
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					
					if (correctData) {
						String ID = Integer.toString(GUIMethods.hashIDClients(peselField.getText(), surnameField.getText(), 99999));
						String text = emailField.getText().trim();
						if (text.compareTo("") == 0)
							text = null;
						
						Application.functions.addClient(ID, nameField.getText(), surnameField.getText(), peselField.getText(), text, phoneField.getText());
						
						nameField.setText("");
						surnameField.setText("");
						peselField.setText("");
						emailField.setText("");
						phoneField.setText("");
						
	
							ArrayList<String> resp = Application.functions.getTableContent("KLIENCI");
							String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
							DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	
							Application.getClientsTable().setModel(tableModel);
							
							
							for (int i = 0; i < resp.size(); i++) {
								String[] data = resp.get(i).split("\t");
								tableModel.addRow(data);
							}
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst¹pi³ b³¹d, operacja nie powiod³a siê!");
					}
				}
		});
		btnAdd.setBounds(324, 278, 105, 29);
		contentPane.add(btnAdd);
	}
}
