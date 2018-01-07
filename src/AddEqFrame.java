import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddEqFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField catField;
	private JTextField descField;

	/**
	 * Create the frame.
	 */
	public AddEqFrame(JFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 466, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		catField = new JTextField();
		catField.setColumns(10);
		catField.setBounds(142, 81, 149, 38);
		contentPane.add(catField);
		
		descField = new JTextField();
		descField.setColumns(10);
		descField.setBounds(41, 164, 365, 38);
		contentPane.add(descField);
		
		JLabel lblCat = new JLabel("Kategoria");
		lblCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCat.setBounds(142, 40, 149, 30);
		contentPane.add(lblCat);
		
		JLabel lblDesc = new JLabel("Opis");
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc.setBounds(181, 130, 70, 23);
		contentPane.add(lblDesc);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 231, 89, 30);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("Dodaj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblCat.setForeground(Color.black);
				String text;
				boolean correctData = true;
				if (catField.getText().trim().compareTo("") == 0) { lblCat.setForeground(Color.RED); correctData = false; }
				if ((text = descField.getText().trim()).compareTo("") == 0)  text = "";

				
				if (correctData) {
					String ID = Integer.toString(GUIMethods.hashIDEq(catField.getText(), text , 99999));
					
					Application.functions.addEquipment(ID, null, "DOSTEPNY", catField.getText(), text);
					
					
					try {
						ArrayList<String> resp = Application.functions.getEqByCategory();
						String col[] = {"Kategoria", "Iloœæ"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 0);
						
						Application.getEquipmentTable().setModel(tableModel);
						
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel.addRow(data);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ArrayList<String> resp = Application.functions.getEqByCategory(catField.getText().trim());
						
						String col[] = {"ID_SPRZETU", "ID_REZERWACJI", "STATUS", "KATEGORIA", "OPIS_SPRZETU"};
						DefaultTableModel tableModel = new DefaultTableModel(col, 0);
						
						Application.getEqDetailsTable().setModel(tableModel);
						
						
						for (int i = 0; i < resp.size(); i++) {
							String[] data = resp.get(i).split("\t");
							tableModel.addRow(data);
						}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					catField.setText("");
					descField.setText("");
					
				}
				
			}
		});
		btnAdd.setMnemonic(KeyEvent.VK_ENTER);
		btnAdd.setBounds(341, 231, 99, 30);
		contentPane.add(btnAdd);
	}
}
