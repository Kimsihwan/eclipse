import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectDatabase {
   public static Connection makeConnection() {
      String url = "jdbc:mysql://localhost/pizzaordersystem?useUnicode=true&characterEncoding=utf8";
      
      String id = "root";
      String password = "apmsetup";
      Connection con = null;
      PreparedStatement psmt = null;
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("����̹� ���� ����!");
         con = DriverManager.getConnection(url, id, password);
         System.out.println("�����ͺ��̽� ���� ����!");
      } catch (ClassNotFoundException e) {
         System.out.println("����̹��� ã�� �� �����ϴ�.");
      } catch (SQLException e) {
         System.out.println("����̹� ���ῡ �����Ͽ����ϴ�.");
      }
      return con;
   }
   
   public static void main(String[] args) throws SQLException {
      Connection con = makeConnection();
   }
}
