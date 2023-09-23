package student_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class phone extends JFrame implements ActionListener{
	JTextField rl,grdtext;
	JButton delete,back;
	phone(){
		setLayout(null);
		setTitle("UPDATE EMAIL");
		JLabel lb=new JLabel("UPADTE EMAIL");
		lb.setBounds(150,20,350,30);
		lb.setForeground(Color.white);
		lb.setFont(new Font("Raleway",Font.BOLD,30));
		add(lb);
		JLabel rol=new JLabel("Enter student Admission Number");
		rol.setBounds(50,70,350,50);
		rol.setForeground(Color.white);
		rol.setFont(new Font("Raleway",Font.BOLD,20));
		add(rol);
		rl=new JTextField();
		rl.setBounds(60,120,350,50);
		rl.setFont(new Font("Raleway",Font.BOLD,20));
		add(rl);
		JLabel grd=new JLabel("Enter Phone Number");
		grd.setBounds(50,200,350,50);
		grd.setForeground(Color.white);
		grd.setFont(new Font("Raleway",Font.BOLD,20));
		add(grd);
		grdtext=new JTextField();
		grdtext.setBounds(60,250,350,50);
		grdtext.setFont(new Font("Raleway",Font.BOLD,20));
		add(grdtext);
		delete =new JButton("PHONE NO");
		delete.setBounds(80,350,150,50);
		delete.setForeground(Color.black);
		delete.setFont(new Font("Raleway",Font.BOLD,20));
		add(delete);
		delete.addActionListener(this);
		back =new JButton("Back");
		back.setBounds(250,350,130,50);
		back.setForeground(Color.black);
		back.setFont(new Font("Raleway",Font.BOLD,20));
		add(back);
		back.addActionListener(this);
		setLocation(450,200);
		setSize(550,500);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		connection con=new connection();
		if(e.getSource()==delete) {
			try {
				String rol=rl.getText();
				String grd=grdtext.getText();
				ResultSet rs=con.stm.executeQuery("select * from add_student where Roll_no = '"+rol+"'"); 
				if(rs.next()) {
					con.stm.executeUpdate("update add_student set phone_no = '"+grd+"' where Roll_no = '"+rol+"'");
					JOptionPane.showMessageDialog(null, "Successfully UPDATED");
					new update();
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Roll Number");
				}
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}
		if(e.getSource()==back) {
			new update();
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new phone();
	}

	

}
