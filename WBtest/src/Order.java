import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ConnectionPropertiesTransform;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTextField txtPNum;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		
		setTitle("주문");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\uD53C\uC790\uBC88\uD638");
		label.setBounds(31, 95, 57, 15);
		contentPane.add(label);
		
		txtPNum = new JTextField();
		txtPNum.setColumns(10);
		txtPNum.setBounds(115, 92, 116, 21);
		contentPane.add(txtPNum);
		
		JLabel lblNumber = new JLabel("\uC544\uC774\uB514");
		lblNumber.setBounds(30, 61, 57, 15);
		contentPane.add(lblNumber);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(114, 58, 116, 21);
		contentPane.add(txtId);
		
		JButton btnNewButton = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				String id = txtId.getText();
				String pnum = txtPNum.getText();
	            try {
	               con = ConnectDatabase.makeConnection();
	            String sql = "select * from member where email = ?"; //join1테이블에 아이디가 있는지 비교하기
	            String sql2 = "select * from menu where pizzanum = ?";
	            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	            PreparedStatement pst2 = (PreparedStatement) con.prepareStatement(sql2);
	            pst.setString(1, id);
	            pst2.setString(1, pnum);
	            ResultSet rs = pst.executeQuery();
	            ResultSet rs2 = pst2.executeQuery();
	            String a = null;
	            String b = null;
	            while(rs.next()) {
	               a = rs.getString("email");
	            }
	               while(rs2.next()) {
	               b = rs2.getString("pizzanum");
	               }
	            if(id.equals(a)) { //아이디 확인하기
	               if(pnum.equals(b)) {
	                  new Db().innerJoinAdd(txtPNum.getText(), txtId.getText());
	                  new Db().dateAdd(null);
	               JOptionPane.showMessageDialog(null, "주문되었습니다");
	               OrderList frame = new OrderList();
					frame.setUndecorated(true);
					frame.setVisible(true);
	                  dispose(); //창닫기;
	            }else {
	               JOptionPane.showMessageDialog(null, "피자번호오류");
	            }
	            }else {
	               JOptionPane.showMessageDialog(null, "아이디 오류");
	            }
	            
	            
	               if(id.isEmpty()) { //아이디가 비어있으면
	                  JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
	               }else if(pnum.isEmpty()){
	                  JOptionPane.showMessageDialog(null, "피자번호를 입력해주세요");      
	         }
	            }catch(Exception ex) {
	               System.out.println(ex.getMessage());
	            }
			}
		});
		btnNewButton.setBounds(29, 171, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(132, 171, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38");
		lblNewLabel.setBounds(111, 21, 37, 15);
		contentPane.add(lblNewLabel);
	}
}
