import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Member_Delete extends JFrame {

	private JPanel contentPane;
	private JTextField id_t;
	private JPasswordField pwd_t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_Delete frame = new Member_Delete();
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
	public Member_Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uD0C8\uD1F4");
		lblNewLabel.setBounds(150, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1.setBounds(43, 75, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		id_t = new JTextField();
		id_t.setBounds(100, 72, 138, 21);
		contentPane.add(id_t);
		id_t.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(30, 130, 57, 15);
		contentPane.add(label);
		
		pwd_t = new JPasswordField();
		pwd_t.setBounds(100, 127, 138, 21);
		contentPane.add(pwd_t);
		
		JButton btnNewButton = new JButton("\uD0C8\uD1F4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = id_t.getText();
				String pwd = pwd_t.getText();
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				}
				else if(pwd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
				} else {
				
	          String [] options= {"예", "아니요"}; // 메시지 버튼 이름 (0, 1)
			  int answ = JOptionPane.showOptionDialog(null, "삭제하시겠습니까?", "삭제확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			  if(answ == 0) {
			  new Db().joinDelete(id, pwd);
			  LoginView frame = new LoginView();
			   frame.setUndecorated(true);
			  frame.setVisible(true);
			  dispose();
			  }
			  
				}
			}
		});
		btnNewButton.setBounds(277, 71, 69, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage frame = new MyPage();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		button.setBounds(277, 126, 69, 23);
		contentPane.add(button);
	}

}
