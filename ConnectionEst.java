import java.sql.*;
import java.util.*;
public class ConnectionEst {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	String s;
	Scanner sc;
	
  public ConnectionEst() throws ClassNotFoundException, SQLException{
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  String url="jdbc:mysql://localhost:3306/hoteldesk";
	  con=DriverManager.getConnection(url,"root","Sartaj@777");
	  
  }
  public Object connection() {
	  return con;
	  
  }
  }
