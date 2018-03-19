
import java.awt.Color;
import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author user
 *
 */
public class QuestionViewTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionView frame = new QuestionView();
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
