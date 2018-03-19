

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

	private JPanel contentPane;
	String notice = LoginView.ntId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					MainView frame = new MainView();
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
	
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uC8FC\uBB38");
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order frame = new Order();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		btnNewButton.setBounds(16, 102, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
		button_1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage frame = new MyPage();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		button_1.setBounds(16, 145, 97, 23);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("\uBB38\uC758\uD558\uAE30");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionView frame = new QuestionView();
				frame.setUndecorated(true);
				frame.setVisible(true); 
				dispose();}
		});
		button_3.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		button_3.setBounds(242, 102, 97, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\uC8FC\uBB38\uB0B4\uC5ED");
		button_4.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderList frame = new OrderList();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		button_4.setBounds(242, 145, 97, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(null, LoginView.id_t.getText()+"´ÔÀÌ ·Î±×¾Æ¿ôÇÏ¼Ì½À´Ï´Ù.");
				LoginView frame = new LoginView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		button_5.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		button_5.setBounds(133, 102, 97, 23);
		contentPane.add(button_5);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uB274");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderMenu frame = new OrderMenu();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(133, 144, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel noticeId = new JLabel();
		noticeId.setHorizontalAlignment(SwingConstants.CENTER);
		noticeId.setText(notice+"´Ô ·Î±×ÀÎ");
		noticeId.setBounds(39, 10, 300, 15);
		contentPane.add(noticeId);
	}
}
