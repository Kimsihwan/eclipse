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
		DefaultTableModel js = new DefaultTableModel(); //칼럼생성하기
		js.addColumn("피자번호");
		js.addColumn("도우");
		js.addColumn("소스");
		js.addColumn("토핑");
		js.addColumn("사이드메뉴");
		js.addColumn("음료수");
		String sql = "SELECT * FROM menu";
		//join1테이블에 있는 모든정보 검색하기
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
	//토핑조회하기
	
	public Boolean dateAdd(String dReturn)
	{
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm"); //컴퓨터 시계에 있는 년,월,일 나타내기
	 Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")); //아시아/서울 시간
 String fromDate = sdf.format(c.getTime()); //현재시간 출력하기

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
	//날짜추가하기
	
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
	//토핑추가하기
	
	 public Boolean joinDelete(String id, String pwd){
	  String sql = "DELETE FROM member WHERE email = '"+id+"' AND pwd='"+pwd+"'";
	  //'"+id_t.getText()+"' AND pwd='"+pwd_t.getText()+"'"
	  //join1테이블에 있는 아이디 삭제하기
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
	 //아이디 삭제하기
	 
	 public Boolean innerJoinAdd(String joinId, String bookNum)
	   {
	      String sql = "INSERT INTO date(pizzanum, email) Values('"+joinId+"','"+bookNum+"')";
	      //book테이블에 도서명, 저자명, 출판사, 장르 추가하기
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
	   //조인추가하기
	 
	 public Boolean joinUpdate(String email, String phone, String pwd, String pwda, String addr)
	 {
	  String sql = "UPDATE member SET phone ='"+phone+"', pwd ='"+pwd+"', pwda ='"+pwda+"', addr= '"+addr+"' WHERE email = '"+email+"'";
	  //join1테이블에 있는 아이디를 찾아서 비밀번호, 이름 수정하기
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
	 //조인업데이트
	 
	 public Boolean qnaAdd(String ea, String title, String qna){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm"); //컴퓨터 시계에 있는 년,월,일 나타내기
		 Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")); //아시아/서울 시간
	 String fromDate = sdf.format(c.getTime()); //현재시간 출력하기
	 
	      String sql = "INSERT INTO qna(time, title, contents) Values('"+fromDate+"', '"+title+"','"+qna+"')";
	      //book테이블에 도서명, 저자명, 출판사, 장르 추가하기
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
	   //문의하기추가하기

	 public DefaultTableModel qnasearch() {
			DefaultTableModel js = new DefaultTableModel(); //칼럼생성하기
			js.addColumn("시간");
			js.addColumn("제목");
			js.addColumn("내용");
			String sql = "SELECT * FROM qna";
			//join1테이블에 있는 모든정보 검색하기
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
		//문의조회하기
	 
	 public Boolean idsearch(String addr, String phone){
		  String sql = "SELECT * FROM member WHERE addr='"+addr+"' AND phone='"+phone+"'";
		  
		  //'"+id_t.getText()+"' AND pwd='"+pwd_t.getText()+"'"
		  //join1테이블에 있는 아이디 삭제하기
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
		 //아이디 삭제하기
	 
	 public Boolean orderDelete(String id)
	 {
	  String sql = "DELETE FROM date WHERE ornum = '"+id+"'";
	  String sql2 = "DELETE FROM time WHERE ornum = '"+id+"'";
	  //join1테이블에 있는 아이디 삭제하기
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
	 //회원삭제하기
}
