package student_management_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class connection {
      Statement stm;
      Connection con;
	public connection() {
    	  
    	 try {
    		  Class.forName("com.mysql.cj.jdbc.Driver");
  			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem","root","root");
  		      stm=con.createStatement();
  		     
  		}catch(Exception ae) {
  			System.out.println(ae);
  		}
      }
	public static void main(String[] args) {
		
		new connection();
	}

}
