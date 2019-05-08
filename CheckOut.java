import java.sql.*;
import java.util.*;
public class CheckOut {

	 int i;
	 String name;
	 String r_no;
	 Scanner sc;
	 Connection con;
	 ResultSet rs;
	 Statement st;
	 ConnectionEst c;
	 ArrayList<Object> ar;
	 CheckOutList cl;
	 public void checkOutInfo() throws SQLException
	 {
		 try {
			c=new ConnectionEst();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sc=new Scanner(System.in);
		 System.out.println("Enter your id:");
		 i=sc.nextInt();
		 
		 con=(Connection)c.connection();
		 st=con.createStatement();
		 
		 rs=st.executeQuery("select room.id,room.r_no,room.type,room.price,booking.name,booking.address,booking.city,booking.dist,booking.state,booking.mob_no,booking.email,booking.dip,booking.undip from room inner join booking where room.id='"+i+"' and booking.id='"+i+"'");
       /* while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
				
			}*/
       // System.out.println(rs.getString(2));
        ar=new ArrayList<Object>();
      while(rs.next())
      {
		ar.add(rs.getInt(1));
		ar.add(rs.getString(2));
		ar.add(rs.getString(3));
		ar.add(rs.getString(4));
		ar.add(rs.getString(5));
		ar.add(rs.getString(6));
		ar.add(rs.getString(7));
		ar.add(rs.getString(8));
		ar.add(rs.getString(9));
		ar.add(rs.getString(10));
		ar.add(rs.getString(11));
		ar.add(rs.getString(12));
		ar.add(rs.getString(13));
      } 
      
      int j=st.executeUpdate("delete from room where id='"+i+"'");
      
		cl=new CheckOutList();
		try {
			cl.getCheckOutList(ar);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(j+"check out Successfully done of id "+i);
	 }
}
