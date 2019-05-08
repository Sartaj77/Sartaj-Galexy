import java.util.*;
import java.sql.*;
public class RoomInfo {

	 int id=1,pri,f=0,count=0,del,j;
    String r_no,type;
	PreparedStatement ps;
	Scanner sc;
	Statement t;
	ConnectionEst v;
	Connection con;
	ResultSet y;
	HotelManagement hm;
	public void getRoomInfo() throws SQLException
	{
		sc=new Scanner(System.in);  
		try {
			v=new ConnectionEst();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		con=(Connection)v.connection();
		try {
			ps= con.prepareStatement("Insert into room values(?,?,?,?)");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Enter Room Info:");
		//System.out.println("Enter id:");
		//id=sc.nextInt();
		t=con.createStatement();
		y=t.executeQuery("select * from room");
		while(y.next())
		{
			count++;
			
		}
		//id=y.getInt(1);
		id=count+1;
		
		System.out.println(id);
		System.out.println("Enter room no:");
		r_no=sc.next();
		while(f==0){
			System.out.println("Enter room type: 1. Ac  2. NonAc");
			type=sc.next();
			
			pri=price();
			if(pri==1) {
			
		         System.out.println("Enter correct type..");
		         
			}
			else
			f=1;
		}
		
		
			String p=Integer.toString(pri);
			System.out.println(p.getClass());
			ps.setInt(1,id);
			ps.setString(2,r_no);
			ps.setString(3,type);
			ps.setString(4,p);
			int u=ps.executeUpdate();
			System.out.println("Room info Inserted Successfully.."+u);
			System.out.println("Delete the  current info.  1.yes  2.no");
		
			 del=sc.nextInt();
			 if(del==1)
			 {
				 hm=new HotelManagement();
				 t=con.createStatement();
			    j=t.executeUpdate("delete from room order by id desc limit 1");
			    System.out.println(j+" Record deleted successfully..");
			    hm.function();
			    
			 }
			 else {
				 
				 
			 }
	}
	public int price() {
		
		if(type.equalsIgnoreCase("ac"))
			return 2000;
		
	     if(type.equalsIgnoreCase("NonAc"))
			return 1500;
		else
			return 1;
	}
}
