import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Db {
	String Url = "jdbc:mysql://localhost:3306/pizzaordersystem?useUnicode=true&characterEncoding=UTF-8";
	String User = "root";
	String Upassword = "apmsetup";
	
	public DefaultTableModel toppingSearch() {
		DefaultTableModel js = new DefaultTableModel(); //Į�������ϱ�
		js.addColumn("���ڹ�ȣ");
		js.addColumn("����");
		js.addColumn("�ҽ�");
		js.addColumn("����");
		js.addColumn("���̵�޴�");
		js.addColumn("�����");
		String sql = "SELECT * FROM menu";
		//join1���̺� �ִ� ������� �˻��ϱ�
		try {
			Connection con = DriverManager.getConnection(Url, User, Upassword);
			
			java.sql.Statement s = con.prepareStatement(sql);
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String tNum = rs.getString(1);
				String tName = rs.getString(2);
				String tPrice = rs.getString(3);
				String tType = rs.getString(4);
				String tDate= rs.getString(5);
				String tjus = rs.getString(6);
				js.addRow(new String[] {tNum, tName, tPrice, tType, tDate, tjus});
			}
			return js;
	
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	//������ȸ�ϱ�
	
	public Boolean dateAdd(String dReturn)
	{
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm"); //��ǻ�� �ð迡 �ִ� ��,��,�� ��Ÿ����
	 Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")); //�ƽþ�/���� �ð�
 String fromDate = sdf.format(c.getTime()); //����ð� ����ϱ�

		String sql = "INSERT INTO time(ortime) Values('"+fromDate+"')"; 
		try {
			Connection con = DriverManager.getConnection(Url, User, Upassword);
			
			Statement s = con.prepareStatement(sql);
			
			s.execute(sql);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//��¥�߰��ϱ�
	
	public Boolean toppingAdd(String dou, String soc, String topping, String side, String jus, String size)
	{
		String sql = "INSERT INTO menu(dough, sauce, topping, sidemenu, beverage, size) Values('"+dou+"','"+soc+"','"+topping+"','"+side+"','"+jus+"', '"+size+"')";
		
		try {
			Connection con = DriverManager.getConnection(Url, User, Upassword);
			
			Statement s = con.prepareStatement(sql);
			
			s.execute(sql);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//�����߰��ϱ�
	
	 public Boolean joinDelete(String id, String pwd){
	  String sql = "DELETE FROM member WHERE email = '"+id+"' AND pwd='"+pwd+"'";
	  //'"+id_t.getText()+"' AND pwd='"+pwd_t.getText()+"'"
	  //join1���̺� �ִ� ���̵� �����ϱ�
	  try {
	   Connection con = DriverManager.getConnection(Url, User, Upassword);
	   
	   java.sql.Statement s = con.prepareStatement(sql);
	   
	   s.execute(sql);
	   return true;
	   
	  }catch(Exception ex) {
	   ex.printStackTrace();
	   return false;
	  }  
}
	 //���̵� �����ϱ�
	 
	 public Boolean innerJoinAdd(String joinId, String bookNum)
	   {
	      String sql = "INSERT INTO date(pizzanum, email) Values('"+joinId+"','"+bookNum+"')";
	      //book���̺� ������, ���ڸ�, ���ǻ�, �帣 �߰��ϱ�
	      try {
	         Connection con = DriverManager.getConnection(Url, User, Upassword);
	         
	         Statement s = con.prepareStatement(sql);
	         
	         s.execute(sql);
	         return true;
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
	   //�����߰��ϱ�
	 
	 public Boolean joinUpdate(String email, String phone, String pwd, String pwda, String addr)
	 {
	  String sql = "UPDATE member SET phone ='"+phone+"', pwd ='"+pwd+"', pwda ='"+pwda+"', addr= '"+addr+"' WHERE email = '"+email+"'";
	  //join1���̺� �ִ� ���̵� ã�Ƽ� ��й�ȣ, �̸� �����ϱ�
	  try {
	    Connection con = DriverManager.getConnection(Url, User, Upassword);
	 
	    Statement s = con.prepareStatement(sql);
	    s.execute(sql); 
	    return true;
	   }catch(SQLException ex) {
	    ex.printStackTrace();
	    return false;
	  }
	 }
	 //���ξ�����Ʈ
	 
	 public Boolean qnaAdd(String ea, String title, String qna){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm"); //��ǻ�� �ð迡 �ִ� ��,��,�� ��Ÿ����
		 Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")); //�ƽþ�/���� �ð�
	 String fromDate = sdf.format(c.getTime()); //����ð� ����ϱ�
	 
	      String sql = "INSERT INTO qna(time, title, contents) Values('"+fromDate+"', '"+title+"','"+qna+"')";
	      //book���̺� ������, ���ڸ�, ���ǻ�, �帣 �߰��ϱ�
	      try {
	         Connection con = DriverManager.getConnection(Url, User, Upassword);
	         
	         Statement s = con.prepareStatement(sql);
	         
	         s.execute(sql);
	         return true;
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }
	   //�����ϱ��߰��ϱ�

	 public DefaultTableModel qnasearch() {
			DefaultTableModel js = new DefaultTableModel(); //Į�������ϱ�
			js.addColumn("�ð�");
			js.addColumn("����");
			js.addColumn("����");
			String sql = "SELECT * FROM qna";
			//join1���̺� �ִ� ������� �˻��ϱ�
			try {
				Connection con = DriverManager.getConnection(Url, User, Upassword);
				
				java.sql.Statement s = con.prepareStatement(sql);
				ResultSet rs = s.executeQuery(sql);
				
				while(rs.next()) {
					String time = rs.getString(1);
					String title = rs.getString(2);
					String contents = rs.getString(3);
					
					
					js.addRow(new String[] {time, title, contents});
				}
				return js;
		
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}
		//������ȸ�ϱ�
	 
	 public Boolean idsearch(String addr, String phone){
		  String sql = "SELECT * FROM member WHERE addr='"+addr+"' AND phone='"+phone+"'";
		  
		  //'"+id_t.getText()+"' AND pwd='"+pwd_t.getText()+"'"
		  //join1���̺� �ִ� ���̵� �����ϱ�
		  try {
		   Connection con = DriverManager.getConnection(Url, User, Upassword);
		   
		   java.sql.Statement s = con.prepareStatement(sql);
		   
		   s.execute(sql);
		   return true;
		   
		  }catch(Exception ex) {
		   ex.printStackTrace();
		   return false;
		  }  
	}
		 //���̵� �����ϱ�
	 
	 public Boolean orderDelete(String id)
	 {
	  String sql = "DELETE FROM date WHERE ornum = '"+id+"'";
	  String sql2 = "DELETE FROM time WHERE ornum = '"+id+"'";
	  //join1���̺� �ִ� ���̵� �����ϱ�
	  try {
	   Connection con = DriverManager.getConnection(Url, User, Upassword);
	   
	   java.sql.Statement s = con.prepareStatement(sql);
	   java.sql.Statement s2 = con.prepareStatement(sql2);
	   
	   s.execute(sql);
	   s2.execute(sql2);
	   
	   return true;
	   
	  }catch(Exception ex) {
	   ex.printStackTrace();
	   return false;
	  }
	  
	   
	 }
	 //ȸ�������ϱ�
}
