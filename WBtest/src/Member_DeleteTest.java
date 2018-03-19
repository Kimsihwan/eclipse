
import java.awt.Color;
import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author ±ËΩ√»Ø
 *
 */
public class Member_DeleteTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_Delete frame = new Member_Delete();
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
