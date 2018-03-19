import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

public class OrderView extends JFrame {
	

	Connection con = null;
	java.sql.PreparedStatement ps = null;
	String sql = null;
	ResultSet rs = null;
	String gender = null; 
	private JPanel contentPane;
	static String driver, url;
	private JTextField txtOrdDou;
	private JTextField txtOrdSoc;
	private JTextField txtOrdTop;
	private JTextField txtOrdSide;
	private JTextField txtOrdJus;
	private JTextField txtOrdsize;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView();
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
	public OrderView() {
		setTitle("\uAD00\uB9AC\uC790 \uC8FC\uBB38\uCC3D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC6B0");
		lblNewLabel.setBounds(23, 85, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC18C\uC2A4");
		lblNewLabel_1.setBounds(23, 113, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uD1A0\uD551");
		lblNewLabel_2.setBounds(23, 141, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC0AC\uC774\uB4DC\uBA54\uB274");
		lblNewLabel_3.setBounds(23, 169, 87, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC74C\uB8CC\uC218");
		lblNewLabel_4.setBounds(23, 197, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uBA54\uB274\uCD94\uAC00");
		lblNewLabel_5.setBounds(185, 23, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("�߰�");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dou = txtOrdDou.getText(); //������ �Է�
				String soc = txtOrdSoc.getText(); //���ڸ� �Է�
				String topping = txtOrdTop.getText(); //���ǻ� �Է�
				String sideMenu = txtOrdSide.getText(); //�帣 �Է�
				String jus = txtOrdJus.getText(); //�帣 �Է�
				String size = txtOrdsize.getText();
				
				if(dou.isEmpty()) { //�������� �������
					JOptionPane.showMessageDialog(null, "���츦 �Է����ּ���.");
				} else if(soc.isEmpty()) {//���ڸ��� �������
					JOptionPane.showMessageDialog(null, "�ҽ��� �Է����ּ���.");
				} else if(topping.isEmpty()) {//���ǻ�� �������
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.");
				} else if(sideMenu.isEmpty()) {//�帣�� �������
						JOptionPane.showMessageDialog(null, "���̵�޴��� �Է����ּ���.");
				}else if(jus.isEmpty()) {//�帣�� �������
							JOptionPane.showMessageDialog(null, "�꽺�� �Է����ּ���.");					
		        }else if(size.isEmpty()) {//�帣�� �������
			JOptionPane.showMessageDialog(null, "����� �Է����ּ���.");
	}
				else{
				if(new Db().toppingAdd(txtOrdDou.getText(), txtOrdSoc.getText(), txtOrdTop.getText(), txtOrdSide.getText(), txtOrdJus.getText(), txtOrdsize.getText()))
				{ //Db class�� �ִ� �����߰��ϱ� �ҷ�����
					JOptionPane.showMessageDialog(null, "�߰�����");
					System.out.println("�߰�����");
					txtOrdDou.setText("");
					txtOrdSoc.setText("");
					txtOrdTop.setText("");
					txtOrdSide.setText("");
					txtOrdJus.setText("");
					txtOrdsize.setText("");
					
				}else {
					JOptionPane.showMessageDialog(null, "����");
				}
				
			}
			}
		});
		btnNewButton.setBounds(275, 82, 97, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminview frame = new adminview();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(275, 205, 97, 35);
		contentPane.add(btnNewButton_1);
		
		txtOrdDou = new JTextField();
		txtOrdDou.setBounds(100, 82, 116, 21);
		contentPane.add(txtOrdDou);
		txtOrdDou.setColumns(10);
		
		txtOrdSoc = new JTextField();
		txtOrdSoc.setColumns(10);
		txtOrdSoc.setBounds(100, 110, 116, 21);
		contentPane.add(txtOrdSoc);
		
		txtOrdTop = new JTextField();
		txtOrdTop.setColumns(10);
		txtOrdTop.setBounds(100, 138, 116, 21);
		contentPane.add(txtOrdTop);
		
		txtOrdSide = new JTextField();
		txtOrdSide.setColumns(10);
		txtOrdSide.setBounds(100, 166, 116, 21);
		contentPane.add(txtOrdSide);
		
		txtOrdJus = new JTextField();
		txtOrdJus.setColumns(10);
		txtOrdJus.setBounds(100, 194, 116, 21);
		contentPane.add(txtOrdJus);
		
		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtOrdDou.setText(null);
				txtOrdSoc.setText(null);
				txtOrdTop.setText(null);
				txtOrdSide.setText(null);
				txtOrdJus.setText(null);
				
			}
		});
		button.setBounds(275, 141, 97, 35);
		contentPane.add(button);
		
		JLabel lblNewLabel_6 = new JLabel("\uC0AC\uC774\uC988");
		lblNewLabel_6.setBounds(23, 225, 43, 15);
		contentPane.add(lblNewLabel_6);
		
		txtOrdsize = new JTextField();
		txtOrdsize.setBounds(100, 222, 116, 21);
		contentPane.add(txtOrdsize);
		txtOrdsize.setColumns(10);
	}
}
