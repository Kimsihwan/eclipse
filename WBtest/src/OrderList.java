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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;


public class OrderList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel model;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList frame = new OrderList();
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
	public OrderList() {
		setTitle("\uC0AC\uC6A9\uC790 \uC870\uD68C\uCC3D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 35, 410, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] data = {"주문번호", "아이디", "도우", "소스", "토핑", "사이드메뉴", "음료수", "주문시간"};
		 model = new DefaultTableModel(data,0);
		 table.setModel(model); //table위쪽에 칼럼생성
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(337, 200, 85, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uC870\uD68C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
	            String profname = textField.getText();
	            String sql = "SELECT time.ornum as 주문번호, member.email as 아이디, menu.dough as 도우, menu.sauce 사이드메뉴, menu.beverage as 음료수, time.ortime as 주문시간 "
	            		+ " FROM date inner join time on date.ornum = time.ornum inner join menu on date.pizzanum = menu.pizzanum inner join member on member.email = date.email  where member.email = ?";
	            try {
	               con = ConnectDatabase.makeConnection();
	               PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	               pst.setString(1, profname);
	               ResultSet rs = pst.executeQuery();
	               table.setModel(DbUtils.resultSetToTableModel(rs));
	            }catch(Exception e){
	               System.out.println(e.getMessage());
	            }
			}
		});
		btnNewButton_1.setBounds(144, 200, 85, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(15, 201, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED");
		lblNewLabel.setBounds(165, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String [] options= {"예", "아니요"}; // 메시지 버튼 이름 (0, 1)
					int answ = JOptionPane.showOptionDialog(null, "취소하시겠습니까?", "삭제확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					//yes, no 메시지
					if(answ==0) { //왼쪽버튼이면 삭제
						int index=table.getSelectedRow(); //table 행 선택하기
						String num = table.getValueAt(index, 0).toString(); 
						if(new Db().orderDelete(num));{ //Db class에 있는 도서반납 불러오기
							JOptionPane.showMessageDialog(null, "취소되었습니다."); //정상적으로 삭제가 될시
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "취소할 주문을 선택하세요."); //선택이 안되어있으면
				}
			}
		});
		btnNewButton_2.setBounds(241, 200, 85, 23);
		contentPane.add(btnNewButton_2);
	}
}
