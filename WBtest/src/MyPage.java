import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;

public class MyPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage frame = new MyPage();
					Color c = new Color(226, 241, 236);
					frame.setBackground(c);
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
	public MyPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\uB9C8\uC774\uD398\uC774\uC9C0");
		label.setBounds(146, 10, 66, 15);
		contentPane.add(label);
		
		JButton button = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member_Delete frame = new Member_Delete();
				frame.setUndecorated(true);				
				frame.setVisible(true);
				dispose();
			}
		});
		button.setBounds(124, 105, 120, 23);
		contentPane.add(button);
		
		JButton button_2 = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member_Edit frame = new Member_Edit();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		button_2.setBounds(124, 52, 120, 23);
		contentPane.add(button_2);
		
		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		btnNewButton.setBounds(124, 159, 120, 23);
		contentPane.add(btnNewButton);
	}
}
