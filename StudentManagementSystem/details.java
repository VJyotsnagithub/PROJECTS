package student_management_system;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
public class details extends JFrame{
	details(String roll){
		connection  con=new connection();
		
		try {
			ResultSet rs=con.stm.executeQuery("select * from add_student where Roll_no = '"+roll+"'");
			if(rs.next()) {
				String name=rs.getString("student_name");
				String rol=rs.getString("Roll_no");
				String grade=rs.getString("grade");
				String phone=rs.getString("phone_no");
				String email=rs.getString("email_id");
				String attendance=rs.getString("attendance_per");
				String course=rs.getString("course");
				Object[][] row= {{name,rol,grade,phone,email,attendance,course}};
				String[] col= {"Name","Roll Number","Grade","Phone Number","Email Id","Attendance Percentage","Course"};
				JTable table=new JTable(row,col);
				add(new JScrollPane(table));
				setLocation(200,200);
				setSize(900,100);
				setVisible(true);
				getContentPane().setBackground(Color.white);
				
	}
			
		}catch(Exception e) {
		System.out.println(e);
	}
		
		
	}
	public static void main(String[] args) {
		new details("");

	}

}
