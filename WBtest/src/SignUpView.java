import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Color;
//

public class SignUpView extends JFrame implements ActionListener {
	

	private JPanel contentPane;
	private static JTextField email_t;
	private static JTextField phone_t;
	private static JPasswordField pwd_t;
	private static JPasswordField pwda_t;
	private static JTextField addr_t;
	JButton save;
	static String driver, url;
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static long count = 0;
	private JPasswordField passwordField;
	Connection con = null;
	boolean ID_check = false;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	
	public SignUpView(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel.setBounds(22, 35, 60, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_1.setBounds(130, 10, 60, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextField email_t = new JTextField();
		email_t.setBounds(22, 60, 126, 21);
		contentPane.add(email_t);
		email_t.setColumns(10);
		
		JTextField phone_t = new JTextField();
		phone_t.setColumns(10);
		phone_t.setBounds(22, 284, 145, 21);
		contentPane.add(phone_t);//
		
		JPasswordField pwd_t = new JPasswordField();
		pwd_t.setColumns(10);
		pwd_t.setBounds(22, 116, 126, 21);
		contentPane.add(pwd_t);
		
		JPasswordField pwda_t = new JPasswordField();
		pwda_t.setColumns(10);
		pwda_t.setBounds(22, 172, 126, 21);
		contentPane.add(pwda_t);
		
		JTextField addr_t = new JTextField();
		addr_t.setColumns(10);
		addr_t.setBounds(22, 228, 288, 21);
		contentPane.add(addr_t); 
		 
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(22, 91, 60, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setBounds(22, 147, 100, 15);
		contentPane.add(label_1);
		
		JButton save = new JButton("\uD68C\uC6D0\uAC00\uC785"); // 회원가입 버튼
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
			       if(email_t.getText().isEmpty())
			       {
			    	   JOptionPane.showMessageDialog(null, "이메일를 입력세요.");
			       } 
			       
			       else if(pwd_t.getText().isEmpty()) {
			    	   JOptionPane.showMessageDialog(null, "비밀번호를 입력세요.");
			       } 
			       else if(pwda_t.getText().isEmpty()) {
			    	   JOptionPane.showMessageDialog(null, "비밀번호확인를 입력세요.");
			       }
			       else if(phone_t.getText().isEmpty()) { 
			    	   JOptionPane.showMessageDialog(null, "휴대폰 번호를 입력세요.");
			       }
			       else if(addr_t.getText().isEmpty()) {
			    	   JOptionPane.showMessageDialog(null, "주소를 입력세요.");
			       }
			       else if(ID_check == false) {
			    	   JOptionPane.showMessageDialog(null, "중복확인을 눌러주세요");
			       }
					//num_t.setText(String.valueOf(rs.getLong("num")));
			       else if(!pwd_t.getText().equals(pwda_t.getText())) { // 출처 : http://egloos.zum.com/Esunny/v/2480590
		    	   JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다."); 
        		       }  
			       else  {
						if (e.getSource() == save) {
							dbConnect();
							try {
								query("insert", "insert into member(email, phone, pwd, pwda, addr)"
										+ " values('" + email_t.getText() +"','" + phone_t.getText() +"','" + pwd_t.getText() + "', '" + pwda_t.getText() +"', '" + addr_t.getText() + "')");
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
					    	JOptionPane.showMessageDialog(null, "회원가입완료");
							System.out.println("새항목 추가완료");
							dbDis();
 
							email_t.setText("");
							phone_t.setText("");
							pwd_t.setText("");
							pwda_t.setText("");
							addr_t.setText("");
							
							LoginView frame = new LoginView();
							frame.setUndecorated(true);
							frame.setVisible(true); 
							dispose();   
					}  	
			       }
			}
		});
	
		save.setBounds(24, 342, 126, 21);
		contentPane.add(save);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView frame = new LoginView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(156, 341, 66, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_3.setBounds(22, 259, 100, 15);
		contentPane.add(label_3);
		
		JLabel label_2 = new JLabel("\uC8FC\uC18C");
		label_2.setBounds(22, 203, 60, 15);
		contentPane.add(label_2);
		
		//초기화 버튼
		JButton reset = new JButton("\uCD08\uAE30\uD654");
		reset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				email_t.setText(null);
				pwd_t.setText(null);
				pwda_t.setText(null);
				addr_t.setText(null);
				phone_t.setText(null);
			}
		});
		reset.setBounds(228, 341, 84, 23);
		contentPane.add(reset);
		 
		//중복확인 버튼 
		JButton same_b = new JButton("\uC911\uBCF5\uD655\uC778");
		same_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    	driver = "com.mysql.jdbc.Drive";
				try {
				dbConnect();
	            String sql = "SELECT * FROM member WHERE email = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, email_t.getText());	            
				ResultSet res = ps.executeQuery();
				
				if(res.next()) {
					JOptionPane.showMessageDialog(null, "아이디가 존재합니다.");
					ID_check = false;
				} else {
					if(email_t.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "아이디 적어주세요.");
						ID_check = false;
					}
					else {
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						ID_check = true;
					}
					
				} 
				
				} catch(Exception e) {
		            System.out.println("데이터베이스 연결 실패!");
					e.printStackTrace();					
				}
			}
		});
		same_b.setBounds(165, 60, 94, 21);
		contentPane.add(same_b);
		

	}
	
	protected ResultSet executeQuery(String string) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	public static void dbConnect() {
    	driver = "com.mysql.jdbc.Drive";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		System.out.println("드라이버 검색 성공!");        
    	}catch(ClassNotFoundException e){
    		System.err.println("error = " + e);
    	}
        
    	
        url = "jdbc:mysql:pizzaordersystem";
        conn = null;
        stmt = null;
        rs = null;
        String url = "jdbc:mysql://localhost/pizzaordersystem?useUnicode=true&characterEncoding=UTF-8";
        String sql = "Select * From member";
		try {
         
            conn = DriverManager.getConnection(url,"root","apmsetup");

            stmt = conn.createStatement( );

            rs = stmt.executeQuery(sql);
            
            System.out.println("데이터베이스 연결 성공!");            
         
        }
        catch(Exception e) {
            System.out.println("데이터베이스 연결 실패!");
        }
	}
	
	
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		} 
		else {
			stmt.executeUpdate(sql);
		}
	}
	
	public static void viewData() throws SQLException {
		if(!rs.next()){
			System.out.println("!rs.next()");
			count--;
		}
		else{		
				System.out.println("rs.next()");
				//num_t.setText(String.valueOf(rs.getLong("num")));
				email_t.setText(String.valueOf(rs.getLong("email")));
				phone_t.setText(rs.getString("phone"));
				pwd_t.setText(rs.getString("pwd"));
				pwda_t.setText(rs.getString("pwda"));
				addr_t.setText(rs.getString("addr"));
				
		}
	}
	
	public static void main(String[] args) throws SQLException {

		new SignUpView("피자주문시스템");
		dbConnect();
		query("select", "select * from member");
		count = 1;
		viewData();
		dbDis();

	}
	
	public static void dbDis(){
		try {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			System.out.println("데이터베이스 연결 해제!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save) {
			dbConnect();
			try {
				query("insert", "insert into member(email, phone, pwd, pwda, addr) values('" + email_t.getText() +"','" + phone_t.getText() +"','" + pwd_t.getText() + "', '" + pwda_t.getText() +"', '" + addr_t.getText() + "')");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
			System.out.println("새항목 추가완료");
			dbDis();

			email_t.setText("");
			phone_t.setText("");
			pwd_t.setText("");
			pwda_t.setText("");
			addr_t.setText("");
	} 
	}
}
