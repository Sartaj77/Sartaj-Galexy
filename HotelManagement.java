import java.sql.SQLException;
import java.util.*;
public class HotelManagement {
	Scanner sc;
	BookingList bl;
	CheckOut c;
	CheckOutList cl;
	//function for Home menu
	public void function()
	{
		
		 sc=new Scanner(System.in);
		System.out.println("Enter your choice \n 1.File 2.Booking 3.Room 4.Exit");
		int s=sc.nextInt();
		switch(s)
		{
			case 1:
				function();
				break;
			case 2:
			try {
				booking();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 3:
				  //still remaining
				break;
			default:
				System.exit(1);
		
		}
		
	}
	//function for booking menu
	public void booking() throws SQLException
	{
		System.out.println("Enter your choice \n 1.New Booking Ac 2.Booking List 3.Check Out 4.Check Out list");
		sc=new Scanner(System.in);
		int s=sc.nextInt();
		switch(s)
		{
			case 1:
				  BookingInfo b=new BookingInfo();
				  try {
					  	b.newBookAc();
				  	   } catch (Exception e) {
				
				  		   e.printStackTrace();
				  	   }
				   break;
				   
			
			case 2:
					bl=new BookingList();
					try {
							bl.getBookingList();
						} catch (SQLException e) {
					
							e.printStackTrace();
						}
				     break;
				   
			case 3:
				
					c=new CheckOut();
					c.checkOutInfo();
				    break;
				    
			case 4:
				    cl=new CheckOutList();
				    cl.showChout();
					break;
					
			default:
					function();
				
				    break;
			
		}
		
	}
	// Main function
	public static void main(String[] args) {
		
        HotelManagement h=new HotelManagement();
        h.function();
	}

}
