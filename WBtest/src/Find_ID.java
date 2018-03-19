import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Find_ID extends JFrame {

	private JPanel contentPane;
	private JTextField id_t;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	String sendId = Find_IDPW.ids;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Find_ID frame = new Find_ID();
				
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Find_ID() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(40, 113, 24, 15);
		contentPane.add(lblNewLabel);
		
		id_t = new JTextField();
		id_t.setEnabled(false);
		id_t.setBounds(76, 110, 116, 21);
		contentPane.add(id_t);
		id_t.setColumns(10);
		
		lblNewLabel_1 = new JLabel("ID\uCC3E\uAE30");
		lblNewLabel_1.setBackground(new Color(226, 241, 236));
		lblNewLabel_1.setBounds(149, 20, 74, 15);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id_t.setText(sendId);
			}
		});
		btnNewButton.setBounds(204, 109, 64, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(277, 109, 64, 23);
		contentPane.add(btnNewButton_1);
	}
}
