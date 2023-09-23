package student_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class delete extends JFrame implements ActionListener{
	JTextField rl;
	JButton delete,back;
	delete(){
		setLayout(null);
		setTitle("Delect Student Account");
		JLabel lb=new JLabel("Delete Student Account");
		lb.setBounds(70,20,350,30);
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
		delete =new JButton("Delete");
		delete.setBounds(80,190,130,50);
		delete.setForeground(Color.black);
		delete.setFont(new Font("Raleway",Font.BOLD,20));
		add(delete);
		delete.addActionListener(this);
		back =new JButton("Back");
		back.setBounds(250,190,130,50);
		back.setForeground(Color.black);
		back.setFont(new Font("Raleway",Font.BOLD,20));
		add(back);
		back.addActionListener(this);
		setLocation(450,200);
		setSize(550,300);
		setVisible(true);
		getContentPane().setBackground(Color.black);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		connection con=new connection();
		if(e.getSource()==delete) {
			try {
				String rol=rl.getText();
				ResultSet rs=con.stm.executeQuery("select * from add_student where Roll_no = '"+rol+"'"); 
				if(rs.next()) {
					con.stm.execute("delete from add_student where Roll_no='"+rol+"'");
					JOptionPane.showMessageDialog(null, "Successfully Deleted");
					new homepage();
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
			new homepage();
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new delete();
	}

	

}
