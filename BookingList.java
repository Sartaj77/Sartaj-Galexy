import java.sql.*;
public class BookingList {

	ConnectionEst c;
	Connection con;
	Statement st;
	ResultSet rs;
	HotelManagement m;
	
	public void getBookingList() throws SQLException
	{
		try {
			c=new ConnectionEst();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con=(Connection)c.connection();
		st= con.createStatement();
		rs=st.executeQuery("select room.id,room.r_no,room.type,room.price,booking.name,booking.address,booking.city,booking.dist,booking.state,booking.mob_no,booking.email,booking.dip,booking.undip from room inner join booking where room.id=booking.id");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)+" "+rs.getString(13));
			
		}
		System.out.println("\n****************************************************");
		m=new HotelManagement();
		m.booking();
	}
}
