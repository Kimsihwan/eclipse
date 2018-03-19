
import java.awt.Color;
import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author user
 *
 */
public class Find_PWTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find_PW frame = new Find_PW();
					Color c = new Color(226, 241, 236);
					frame.setBackground(c);
					frame.setVisible(true);
					frame.setUndecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
