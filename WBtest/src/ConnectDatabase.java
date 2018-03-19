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
         System.out.println("드라이버 연결 성공!");
         con = DriverManager.getConnection(url, id, password);
         System.out.println("데이터베이스 연결 성공!");
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버를 찾을 수 없습니다.");
      } catch (SQLException e) {
         System.out.println("드라이버 연결에 실패하였습니다.");
      }
      return con;
   }
   
   public static void main(String[] args) throws SQLException {
      Connection con = makeConnection();
   }
}
