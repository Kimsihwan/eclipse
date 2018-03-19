import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class qnaSearch extends JFrame {

	private JPanel contentPane;
	private JTable qan;
	static DefaultTableModel model;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qnaSearch frame = new qnaSearch();
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
	public qnaSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 320, 148);
		contentPane.add(scrollPane);
		
		qan = new JTable();
		String[] data = {"시간", "제목", "내용"};
		 model = new DefaultTableModel(data,0);
		 qan.setModel(model); //table위쪽에 칼럼생성
		scrollPane.setViewportView(qan);
		
		btnNewButton = new JButton("\uC870\uD68C\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel jTable = new Db().qnasearch(); //Db class에 있는 회원조회 불러오기
				qan.setModel(jTable); //table에 회원정보 나타내기
			}
			
		});
		btnNewButton.setBounds(164, 208, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminview frame = new adminview();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(273, 208, 97, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("\uBB38\uC758\uC870\uD68C");
		lblNewLabel.setBounds(174, 10, 57, 15);
		contentPane.add(lblNewLabel);
	}
}
