import java.util.*;
import java.sql.*;
public class BookingInfo {

	ConnectionEst e;
	Scanner sc;
	RoomInfo r;
	Connection con;
	PreparedStatement ps;
	HotelManagement hm;
	int id;
	 String r_no;
	 String name;
     String add;
    String city;
    String dist;
    String state;
     String mob_no;
    String email;
    int dip;
     int undip;
    
	
	public void newBookAc()throws Exception
	{

		r=new RoomInfo();
		r.getRoomInfo();
		sc=new Scanner(System.in);
		e=new ConnectionEst();
		con=(Connection)e.connection();
		ps= con.prepareStatement("Insert into booking values(?,?,?,?,?,?,?,?,?,?,?)");
		System.out.println("Enter your booking info.");
		//System.out.println("Enter id:");
		//id=sc.nextInt();
		id=r.id;
		r_no=r.r_no;
		//System.out.println("Enter room no.");
		//r_no=sc.next();
		System.out.println("Enter your name:");
		name=sc.next();
		System.out.println("Enter address:");
		add=sc.next();
		System.out.println("Enter city:");
		city=sc.next();
		System.out.println("Enter district:");
		dist=sc.next();
		System.out.println("Enter state:");
		state=sc.next();
		System.out.println("Enter mob_no:");
		mob_no=sc.next();
		System.out.println("Enter your email:");
		email=sc.next();
		//System.out.println("Enter deposited amount:");
		//dip=sc.nextInt();
		dip=r.pri;
		int u=r.price()-(dip);
		undip=u;
		String m=Integer.toString(dip);
		String n=Integer.toString(undip);
		
		ps.setInt(1, id);
		ps.setString(2,r_no);
		ps.setString(3,name);
		ps.setString(4,add);
		ps.setString(5,city);
		ps.setString(6,dist);
		ps.setString(7,state);
		ps.setString(8,mob_no);
		ps.setString(9,email);
		ps.setString(10,m);
		ps.setString(11,n);
		int i=ps.executeUpdate();
		System.out.println(r_no+" Room is booked successfully..."+i);
		hm=new HotelManagement();
		System.out.println("\n****************************************************");
		hm.booking();
	}
}
