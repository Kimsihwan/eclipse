import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

public class Member_Edit extends JFrame {

	private JPanel contentPane;
	private JTextField email_t;
	private JTextField phone_t;
	private JTextField addr_t;
	private JPasswordField pwd_t;
	private JPasswordField pwda_t;
	static Connection conn;
	String id = LoginView.ntId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_Edit frame = new Member_Edit();
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
	public Member_Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		lblNewLabel.setBounds(138, 10, 81, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1.setBounds(32, 38, 40, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC804\uD654\uBC88\uD638");
		label.setBounds(20, 80, 65, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setBounds(20, 122, 65, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		label_2.setBounds(12, 164, 81, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\uC8FC\uC18C");
		label_3.setBounds(40, 206, 32, 15);
		contentPane.add(label_3);
		
		email_t = new JTextField();
		email_t.setEditable(false);
		email_t.setText(id);
		email_t.setBounds(97, 35, 130, 21);
		contentPane.add(email_t);
		email_t.setColumns(10);
		
		phone_t = new JTextField();
		phone_t.setColumns(10);
		phone_t.setBounds(97, 77, 130, 21);
		contentPane.add(phone_t);
		
		pwd_t = new JPasswordField();
		pwd_t.setBounds(97, 119, 130, 21);
		contentPane.add(pwd_t);
		
		pwda_t = new JPasswordField();
		pwda_t.setBounds(97, 164, 130, 21);
		contentPane.add(pwda_t);
		
		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 String email = email_t.getText();
					 String phone = phone_t.getText();
					 String pwd = pwd_t.getText();
					 String pwda = pwda_t.getText();
					 String addr = addr_t.getText();
					 
				     Connection con = new ConnectDatabase().makeConnection();
				    String sql = "select * from member where email = ?"; //join1테이블에 아이디가 있는지 비교하기
				    PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
				    pst.setString(1, email);
				    ResultSet rs = pst.executeQuery();
				    String a = null;
				    while(rs.next()) {
				     a = rs.getString("email");
				    }
				    if(email.isEmpty()) {
				    	JOptionPane.showMessageDialog(null, "아이디를 적어주세요");
				    }
				    else if(phone.isEmpty()) {
				    	JOptionPane.showMessageDialog(null, "휴대폰번호를 적어주세요");
				    }else if(pwd.isEmpty()) {
				    	JOptionPane.showMessageDialog(null, "비밀번호를 적어주세요");
				    }else if(pwda.isEmpty()) {
				    	JOptionPane.showMessageDialog(null, "비밀번호확인을 적어주세요");
				    }else if(addr.isEmpty()) {
				    	JOptionPane.showMessageDialog(null, "주소를 적어주세요");
				    } else {			    
				    if(email.equals(a)) { //아이디 확인하기
				    	JOptionPane.showMessageDialog(null, "정보가 변경되었습니다.");
				    	MyPage frame = new MyPage();
						frame.setUndecorated(true);
						frame.setVisible(true);
				      dispose(); //창닫기;
				    }else {
				     JOptionPane.showMessageDialog(null, "아이디 오류");
				    }
				    }
				    }catch(Exception ex) {
				     System.out.println(ex.getMessage());
				    }
				    
				new Db().joinUpdate(email_t.getText(), phone_t.getText(), pwd_t.getText(), pwda_t.getText(), addr_t.getText());
				}
				 
				 
		}
			);
		
		addr_t = new JTextField();
		addr_t.setColumns(10);
		addr_t.setBounds(97, 203, 130, 21);
		contentPane.add(addr_t);
		btnNewButton.setBounds(267, 77, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPage frame = new MyPage();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();}
		});
		button.setBounds(267, 133, 65, 23);
		contentPane.add(button);
	}
}
