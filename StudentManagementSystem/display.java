package student_management_system;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.*;
public class display extends JFrame{
	display(){
		connection  con=new connection();
		
		try {
			String[] col= {"Name","Roll Number","Grade","Phone Number","Email Id","Attendance Percentage","Course"};
			ResultSet rs=con.stm.executeQuery("select * from add_student");
			JTable tb=new JTable();
			DefaultTableModel model=(DefaultTableModel) tb.getModel();
			model.setColumnIdentifiers(col);
			
			while(rs.next()) {
				String name=rs.getString("student_name");
				String rol=rs.getString("Roll_no");
				String grade=rs.getString("grade");
				String phone=rs.getString("phone_no");
				String email=rs.getString("email_id");
				String attendance=rs.getString("attendance_per");
				String course=rs.getString("course");
				String row[]={name,rol,grade,phone,email,attendance,course};
				model.addRow(row);
			
				}
			
			add(new JScrollPane(tb));
			setLocation(200,20);
			setSize(1000,750);
			setVisible(true);
			getContentPane().setBackground(Color.white);
			
			
		}catch(Exception e) {
		System.out.println(e);
	}

		
		
	}
	public static void main(String[] args) {
		new display();

	}

}

