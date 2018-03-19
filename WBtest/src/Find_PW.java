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

public class Find_PW extends JFrame {

	private JPanel contentPane;
	private JTextField pw_t;
	String sendPwd = Find_IDPW.pwds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_PW frame = new Find_PW();
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
	public Find_PW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPw_1 = new JLabel("PW");
		lblPw_1.setBounds(32, 117, 24, 15);
		contentPane.add(lblPw_1);
		
		pw_t = new JTextField();
		pw_t.setEnabled(false);
		pw_t.setColumns(10);
		pw_t.setBounds(80, 114, 116, 21);
		contentPane.add(pw_t);
		
		JLabel lblPw = new JLabel("PW\uCC3E\uAE30");
		lblPw.setBounds(147, 25, 63, 15);
		contentPane.add(lblPw);
		
		JButton button = new JButton("\uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw_t.setText(sendPwd);
			}
		});
		button.setBounds(208, 113, 64, 23);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(282, 113, 64, 23);
		contentPane.add(btnNewButton);
	}

}
