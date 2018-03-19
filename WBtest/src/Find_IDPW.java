import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Find_IDPW extends JFrame {

	private JPanel contentPane;
	private JTextField addr_t;
	private JLabel label;
	private JTextField phone_t;
	private JButton btnNewButton;
	private JButton button;
	private JLabel label_1;
	private JTextField id_t;
	private JLabel label_2;
	private JTextField ph_t;
	static String driver, url;
	static String ids = null;
	static String pwds = null;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_IDPW frame = new Find_IDPW();
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
	/**226, 241, 236
	 * Create the frame.
	 */
	public Find_IDPW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(32, 72, 37, 15);
		contentPane.add(lblNewLabel_1);
		
		addr_t = new JTextField();
		addr_t.setBounds(81, 69, 116, 21);
		contentPane.add(addr_t);
		addr_t.setColumns(10);
		
		label = new JLabel("\uC804\uD654\uBC88\uD638");
		label.setFont(new Font("굴림", Font.PLAIN, 11));
		label.setBounds(29, 96, 57, 15);
		contentPane.add(label);
		
		phone_t = new JTextField();
		phone_t.setColumns(10);
		phone_t.setBounds(81, 96, 116, 21);
		contentPane.add(phone_t);
		
		btnNewButton = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver = "com.mysql.jdbc.Drive";
		    	try{
		    		Class.forName("com.mysql.jdbc.Driver");
		    		System.out.println("드라이버 검색 성공!");        
		    	}catch(ClassNotFoundException e1){
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
				ResultSet res = st.executeQuery("SELECT * FROM member WHERE addr='"+addr_t.getText()+"' AND phone='"+phone_t.getText()+"'");
				if(res.next()) {
					ids = res.getString("email");
					Find_ID frame = new Find_ID();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				   } else if(addr_t.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "주소를 적어주세요.");
				} else if(phone_t.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "전화번호를 적어주세요.");
				} else {
					JOptionPane.showMessageDialog(null, "전화번호나 주소가 틀렸습니다.");
				}
				}
				catch(Exception e2) { 
		            System.out.println("데이터베이스 연결 실패!");
					e2.printStackTrace();					
				}
				}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton.setBounds(209, 68, 116, 47);
		contentPane.add(btnNewButton);
		
		button = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver = "com.mysql.jdbc.Drive";
		    	try{
		    		Class.forName("com.mysql.jdbc.Driver");
		    		System.out.println("드라이버 검색 성공!");        
		    	}catch(ClassNotFoundException e1){
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
				ResultSet res = st.executeQuery("SELECT * FROM member WHERE email='"+id_t.getText()+"' AND phone='"+ph_t.getText()+"'");
				if(res.next()) {
					pwds = res.getString("pwd");
					Find_PW frame = new Find_PW();
					frame.setUndecorated(true);
					frame.setVisible(true);
					dispose();
					
				   } else if(addr_t.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "주소를 적어주세요.");
				} else if(phone_t.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "전화번호를 적어주세요.");
				} else {
					JOptionPane.showMessageDialog(null, "아이디나 전화번호가 틀렸습니다.");
				}
				}
				catch(Exception e2) { 
		            System.out.println("데이터베이스 연결 실패!");
					e2.printStackTrace();					
				}
				
				Find_PW frame = new Find_PW();

			}
		});
		button.setFont(new Font("굴림", Font.PLAIN, 11));
		button.setBounds(209, 140, 116, 47);
		contentPane.add(button);
		
		label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setFont(new Font("굴림", Font.PLAIN, 11));
		label_1.setBounds(29, 140, 57, 15);
		contentPane.add(label_1);
		
		id_t = new JTextField();
		id_t.setColumns(10);
		id_t.setBounds(81, 140, 116, 21);
		contentPane.add(id_t);
		
		label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setFont(new Font("굴림", Font.PLAIN, 11));
		label_2.setBounds(29, 168, 57, 15);
		contentPane.add(label_2);
		
		ph_t = new JTextField();
		ph_t.setColumns(10);
		ph_t.setBounds(81, 168, 116, 21);
		contentPane.add(ph_t);
		
		lblNewLabel = new JLabel("ID/PW\uCC3E\uAE30");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 358, 15);
		contentPane.add(lblNewLabel);
	}

}
