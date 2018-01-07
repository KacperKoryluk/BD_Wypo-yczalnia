import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClients, lblClientsCount, lblEq, lblEqCount, lblBoo, lblBooPayed, lblBooPayedCount, lblBooNotPayed, lblBooNotPayedCount, lblBooArch, lblBooArchCount;

	public JLabel getLblClientsCount() {
		return lblClientsCount;
	}
	
	public JLabel getLblEqCount() {
		return lblEqCount;
	}
	
	public JLabel getLblBooPayedCount() {
		return lblBooPayedCount;
	}
	
	public JLabel getLblBooNotPayedCount() {
		return lblBooNotPayedCount;
	}
	
	public JLabel getLblBooArchCount() {
		return lblBooArchCount;
	}
	/**
	 * Create the frame.
	 */
	public StatisticsFrame(JFrame frame) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 458, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClients = new JLabel("Ilo\u015B\u0107 klient\u00F3w:");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setBounds(95, 28, 110, 28);
		contentPane.add(lblClients);
		
		lblClientsCount = new JLabel("");
		lblClientsCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientsCount.setBounds(212, 28, 98, 28);
		contentPane.add(lblClientsCount);
		
		lblEq = new JLabel("Ilo\u015B\u0107 sprz\u0119tu:");
		lblEq.setHorizontalAlignment(SwingConstants.CENTER);
		lblEq.setBounds(95, 77, 110, 28);
		contentPane.add(lblEq);
		
		lblEqCount = new JLabel("");
		lblEqCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEqCount.setBounds(212, 77, 98, 28);
		contentPane.add(lblEqCount);
		
		lblBoo = new JLabel("Ilo\u015B\u0107 rezerwacji");
		lblBoo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoo.setBounds(152, 128, 110, 28);
		contentPane.add(lblBoo);
		
		lblBooPayed = new JLabel("Op\u0142aconych:");
		lblBooPayed.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooPayed.setBounds(80, 161, 110, 28);
		contentPane.add(lblBooPayed);
		
		lblBooPayedCount = new JLabel("");
		lblBooPayedCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooPayedCount.setBounds(225, 161, 98, 28);
		contentPane.add(lblBooPayedCount);
		
		lblBooNotPayed = new JLabel("Nieop\u0142aconych:");
		lblBooNotPayed.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooNotPayed.setBounds(80, 200, 110, 28);
		contentPane.add(lblBooNotPayed);
		
		lblBooNotPayedCount = new JLabel("");
		lblBooNotPayedCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooNotPayedCount.setBounds(225, 200, 98, 28);
		contentPane.add(lblBooNotPayedCount);
		
		lblBooArch = new JLabel("Archiwalnych:");
		lblBooArch.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooArch.setBounds(80, 239, 110, 28);
		contentPane.add(lblBooArch);
		
		lblBooArchCount = new JLabel("");
		lblBooArchCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooArchCount.setBounds(225, 239, 98, 28);
		contentPane.add(lblBooArchCount);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setEnabled(true);
				dispose();
			}
		});
		btnBack.setBounds(168, 316, 98, 28);
		contentPane.add(btnBack);
	}
}
