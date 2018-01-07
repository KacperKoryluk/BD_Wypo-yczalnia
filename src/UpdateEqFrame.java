import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateEqFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField catField;
	private static JTextField descField;

	public JTextField getCatField() {
		return catField;
	}

	public JTextField getDescField() {
		return descField;
	}
	/**
	 * Create the frame.
	 */
	public UpdateEqFrame(JFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 465, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(236, 75, 141, 30);
		contentPane.add(comboBox);
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		comboBox.setModel(comboBoxModel);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(236, 34, 141, 24);
		contentPane.add(lblStatus);
		
		catField = new JTextField();
		catField.setBounds(53, 75, 123, 30);
		contentPane.add(catField);
		catField.setColumns(10);
		
		JLabel lblCat = new JLabel("Kategoria");
		lblCat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCat.setBounds(53, 37, 123, 19);
		contentPane.add(lblCat);
		
		descField = new JTextField();
		descField.setColumns(10);
		descField.setBounds(40, 179, 365, 38);
		contentPane.add(descField);
		
		JLabel lblDesc = new JLabel("Opis");
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc.setBounds(181, 145, 70, 23);
		contentPane.add(lblDesc);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 262, 99, 30);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Aktualizuj");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int row = Application.getEqDetailsTable().getSelectedRow();
				lblCat.setForeground(Color.black);
				lblDesc.setForeground(Color.black);
				
				boolean correctData = true;
				
				if (catField.getText().trim().compareTo("") == 0) { lblCat.setForeground(Color.RED); correctData = false; }
			if (correctData) {
				try {
					Application.functions.updateEquipment(Application.getEqDetailsTable().getValueAt(row, 0).toString(), 
														  Application.getEqDetailsTable().getValueAt(row, 1).toString(), 
														  comboBox.getSelectedItem().toString(), catField.getText(), descField.getText());
					
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
				
				frame.setEnabled(true);
				dispose();
			}

				

			}
		});
		btnUpdate.setBounds(316, 262, 123, 30);
		contentPane.add(btnUpdate);
		comboBoxModel.addElement("DOSTEPNY");
		comboBoxModel.addElement("NIEDOSTEPNY");
		comboBoxModel.addElement("USZKODZONY");
		comboBoxModel.addElement("KONSERWACJA");
	}

}
