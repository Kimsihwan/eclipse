import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.IIOImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.EventQueue;

public class LoginView extends JFrame {

	private JPanel contentPane;
	public static JTextField id_t;
	private JPasswordField passwordField;
	private JPasswordField pwd_t;
	private final JButton login_b = new JButton("\uB85C\uADF8\uC778");
	static String driver, url;
	static String ntId = null;
	private JTextField admin_t;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	
	
	
	public LoginView() {
		
		
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 91, 57, 15);
		contentPane.add(lblNewLabel);
		
		id_t = new JTextField();
		id_t.setBounds(90, 88, 116, 21);
		contentPane.add(id_t);
		id_t.setColumns(10);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("굴림", Font.PLAIN, 12));
		label.setBounds(25, 132, 57, 15); 
		contentPane.add(label);
		
		pwd_t = new JPasswordField(); 
		pwd_t.setColumns(10);
		pwd_t.setBounds(90, 129, 116, 21);
		contentPane.add(pwd_t);
		
		login_b.setFont(new Font("굴림", Font.PLAIN, 12));
		login_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ntId = id_t.getText();
		    	driver = "com.mysql.jdbc.Drive";
		    	try{
		    		Class.forName("com.mysql.jdbc.Driver");
		    		System.out.println("드라이버 검색 성공!");        
		    	}catch(ClassNotFoundException e){
		    		System.err.println("error = " + e);
		    	}
		    	  
				try {
				Connection conn;
				String dbuser = "root";
				String dbpassw = "apmsetup";
				String databaseName = "pizzaordersystem";
				String url = "jdbc:mysql://localhost/pizzaordersystem?useUnicode=true&characterEncoding=UTF-8";
				Class.forName("com.mysql.jdbc.Driver"); //Very important!
				conn = DriverManager.getConnection(url, dbuser, dbpassw);
	            System.out.println("데이터베이스 연결 성공!");   
				Statement st = conn.createStatement();
				ResultSet res = st.executeQuery("SELECT * FROM member WHERE email='"+id_t.getText()+"' AND pwd='"+pwd_t.getText()+"'");
				if(res.next()) {
					String num = admin_t.getText();
					if(num.equals("1111")) {
					JOptionPane.showMessageDialog(null, "관리자님이 로그인 하셨습니다!");
					dispose();
					adminview frame = new adminview();
					frame.setUndecorated(true);
					frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, id_t.getText()+"님이 로그인 하셨습니다!");
						dispose();
						MainView frame = new MainView();
						frame.setUndecorated(true);
						frame.setVisible(true);
					}
				   }
				else if(id_t.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "아이디를 적어주세요");
				} else if(pwd_t.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "비밀번호를 적어주세요");
				} else {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀렸습니다.");
				}
				
				} catch(Exception e) { 
		            System.out.println("데이터베이스 연결 실패!");
					e.printStackTrace();					
				}
			}
		});
		login_b.setBounds(244, 72, 102, 34);
		contentPane.add(login_b);
		
		
		JButton btnNewButton_1 = new JButton("\uD68C\uC6D0\r\n\uAC00\uC785");
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpView frame = new SignUpView(null);
				frame.setUndecorated(true);
				frame.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(244, 173, 102, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pizza.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(66, 10, 76, 68);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD53C\uC790\uC8FC\uBB38\uC2DC\uC2A4\uD15C");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(138, 21, 96, 40);
		contentPane.add(lblNewLabel_2);
		
		admin_t = new JTextField();
		admin_t.setBounds(90, 179, 116, 21);
		contentPane.add(admin_t);
		admin_t.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uAD00\uB9AC\uC790\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(25, 182, 68, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ID/PW\r\n\uCC3E\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find_IDPW frame = new Find_IDPW();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNewButton.setBounds(244, 121, 102, 34);
		contentPane.add(btnNewButton);
	}
}
