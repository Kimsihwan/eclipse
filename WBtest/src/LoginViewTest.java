
import java.awt.Color;
import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author user
 *
 */
public class LoginViewTest {

	/**
	 * @param args
	 */

		// TODO Auto-generated method stub
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginView frame = new LoginView();
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


