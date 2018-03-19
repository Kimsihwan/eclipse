import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class adminview extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminview frame = new adminview();
					frame.setVisible(true);
					frame.setUndecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uBA54\uB274\uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderView frame = new OrderView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(98, 93, 97, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBB38\uC758\uD655\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qnaSearch frame = new qnaSearch();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(207, 93, 97, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790");
		lblNewLabel.setBounds(378, 10, 44, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();				
			}
		});
		btnNewButton_2.setBounds(154, 149, 97, 48);
		contentPane.add(btnNewButton_2);
	}
}
