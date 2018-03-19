import java.awt.BorderLayout;
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
import java.awt.Color;
import javax.swing.JLabel;


public class OrderMenu extends JFrame {
	private JPanel contentPane;
	private JTable tabOrdList;
	private JScrollPane tabsOrdsList;
	static DefaultTableModel model;
	private JButton btnList;
	private JLabel eieie;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
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
	public OrderMenu() {
		setTitle("\uAD00\uB9AC\uC790 \uC870\uD68C\uCC3D");
		JFrame jFrame = new JFrame("JTable ����");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(226, 241, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainView frame = new MainView();
				frame.setUndecorated(true);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(214, 248, 97, 23);
		contentPane.add(btnNewButton);
		
		tabsOrdsList = new JScrollPane();
		tabsOrdsList.setBounds(14, 32, 466, 171);
		contentPane.add(tabsOrdsList);
		
		tabOrdList = new JTable();
		String[] data = {"���ڹ�ȣ", "����", "�ҽ�", "����", "���̵�޴�", "�����"};
		 model = new DefaultTableModel(data,0);
		tabOrdList.setModel(model); //table���ʿ� Į������
		tabsOrdsList.setViewportView(tabOrdList);
		
		btnList = new JButton("��ȸ");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel jTable = new Db().toppingSearch(); //Db class�� �ִ� ȸ����ȸ �ҷ�����
				tabOrdList.setModel(jTable); //table�� ȸ������ ��Ÿ����
			}
		});
		btnList.setBounds(406, 213, 74, 23);
		contentPane.add(btnList);
		
		eieie = new JLabel("\uBA54\uB274");
		eieie.setBounds(219, 10, 57, 15);
		contentPane.add(eieie);
	}
}
