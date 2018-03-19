import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class QuestionView extends JFrame {

	private JPanel contentPane;
	private JTextField title_txt;
	private JTextField qna_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionView frame = new QuestionView();
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
	public QuestionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uBB38\uC758\uD558\uAE30");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel.setBounds(148, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uBB38\uC758\uC2E0\uCCAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = title_txt.getText();
				String qna = qna_txt.getText();
				if(title.isEmpty()) {
					JOptionPane.showMessageDialog(null, "제목 적어주세요");
				} else if(qna.isEmpty()) {
					JOptionPane.showMessageDialog(null, "내용을 적어주세요");
				}				
			else {
				JOptionPane.showMessageDialog(null, "문의신청이 완료되었습니다.");
				new Db().qnaAdd(null, title_txt.getText(), qna_txt.getText());				
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
				}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton.setBounds(72, 167, 91, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 11));
		button.setBounds(196, 167, 100, 36);
		contentPane.add(button);
		
		title_txt = new JTextField();
		title_txt.setBounds(72, 47, 224, 21);
		contentPane.add(title_txt);
		title_txt.setColumns(10);
		
		qna_txt = new JTextField();
		qna_txt.setColumns(10);
		qna_txt.setBounds(72, 78, 224, 79);
		contentPane.add(qna_txt);
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(41, 50, 35, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uB0B4\uC6A9");
		label.setFont(new Font("굴림", Font.PLAIN, 11));
		label.setBounds(41, 79, 35, 15);
		contentPane.add(label);
	}
}
