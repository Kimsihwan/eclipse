
import java.awt.Color;
import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author ±ËΩ√»Ø
 *
 */
public class Member_EditTest {

	/**
	 * @param args
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
}
