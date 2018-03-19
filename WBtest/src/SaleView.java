import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SaleView extends JFrame {

	private JPanel contentPane;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleView frame = new SaleView();
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
	public SaleView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD560\uC778");
		lblNewLabel.setBounds(150, 10, 29, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC81C\uD488\uBA85");
		label.setFont(new Font("±¼¸²", Font.BOLD, 13));
		label.setBounds(24, 62, 57, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uC815\uC0C1\uAC00");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
		lblNewLabel_1.setBounds(142, 62, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBC29\uBB38\uD3EC\uC7A5 \uD560\uC778\uAC00");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 13));
		lblNewLabel_2.setBounds(226, 62, 104, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCE58\uC988\uD53C\uC790(M)");
		lblNewLabel_3.setBounds(24, 118, 69, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblm = new JLabel("\uD3EC\uD14C\uC774\uD1A0(M)2\uD310");
		lblm.setBounds(24, 143, 91, 15);
		contentPane.add(lblm);
		
		JLabel lbll = new JLabel("\uB354\uBE14\uD06C\uB7EC\uC2A4(L)");
		lbll.setBounds(24, 168, 91, 15);
		contentPane.add(lbll);
		
		JLabel lblNewLabel_4 = new JLabel("14,500");
		lblNewLabel_4.setBounds(142, 118, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("37,000");
		label_1.setBounds(142, 143, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("32,900");
		label_2.setBounds(142, 168, 57, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("30%");
		label_3.setBounds(226, 87, 29, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("10,150");
		label_4.setBounds(226, 118, 39, 15);
		contentPane.add(label_4);
		
		JLabel label_7 = new JLabel("23,030");
		label_7.setBounds(226, 168, 39, 15);
		contentPane.add(label_7);
		
		JLabel label_9 = new JLabel("25,900");
		label_9.setBounds(226, 143, 39, 15);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("20%");
		label_10.setBounds(291, 87, 29, 15);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("11,600");
		label_11.setBounds(291, 118, 39, 15);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("29,600");
		label_12.setBounds(291, 143, 39, 15);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("26,320");
		label_13.setBounds(291, 168, 39, 15);
		contentPane.add(label_13);
		
		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		btnNewButton.setBounds(191, 209, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderView frame = new OrderView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		btnNewButton_1.setBounds(88, 209, 91, 23);
		contentPane.add(btnNewButton_1);
	}
}
