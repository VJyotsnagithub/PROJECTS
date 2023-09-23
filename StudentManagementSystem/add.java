package student_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class add extends JFrame implements ActionListener {
	JTextField last_text,first_text,address_text,email_text,pass_text,confirm,coursef;
	JButton signup,cancel;

	add(){
	setLayout(null);
	JLabel title=new JLabel("Add New Student");
	title.setBounds(170,30,300,30);
	title.setForeground(Color.WHITE);
	title.setFont(new Font("Raleway",Font.BOLD,30));
	add(title);
	JLabel last=new JLabel("Student Name");
	last.setBounds(50,100,150,30);
	last.setForeground(Color.WHITE);
	last.setFont(new Font("Raleway",Font.BOLD,20));
	add(last);
	 last_text=new JTextField();
	last_text.setBounds(230,100,280,30);
	last_text.setForeground(Color.BLACK);
	last_text.setFont(new Font("Raleway",Font.BOLD,17));
	add(last_text);
	JLabel first=new JLabel("Student RollNO");
	first.setBounds(50,150,150,30);
	first.setForeground(Color.WHITE);
	first.setFont(new Font("Raleway",Font.BOLD,20));
	add(first);
	first_text=new JTextField();
	first_text.setBounds(230,150,280,30);
	first_text.setForeground(Color.BLACK);
	first_text.setFont(new Font("Raleway",Font.BOLD,17));
	add(first_text);
	JLabel address=new JLabel("Grade");
	address.setBounds(50,200,150,30);
	address.setForeground(Color.WHITE);
	address.setFont(new Font("Raleway",Font.BOLD,20));
	add(address);
	address_text=new JTextField();
	address_text.setBounds(230,200,150,30);
	address_text.setForeground(Color.BLACK);
	address_text.setFont(new Font("Raleway",Font.BOLD,17));
	add(address_text);
	JLabel email=new JLabel("Email Id");
	email.setBounds(50,250,150,30);
	email.setForeground(Color.WHITE);
   email.setFont(new Font("Raleway",Font.BOLD,20));
	add(email);
	email_text=new JTextField();
	email_text.setBounds(230,250,320,30);
	email_text.setForeground(Color.BLACK);
	email_text.setFont(new Font("Raleway",Font.BOLD,17));
	add(email_text);
	JLabel pass=new JLabel("Phone Number");
	pass.setBounds(50,300,150,30);
	pass.setForeground(Color.WHITE);
   pass.setFont(new Font("Raleway",Font.BOLD,20));
	add(pass);
	pass_text=new JTextField();
	pass_text.setBounds(230,300,280,30);
	pass_text.setForeground(Color.BLACK);
	pass_text.setFont(new Font("Raleway",Font.BOLD,17));
	add(pass_text);
	JLabel cpass=new JLabel("Attendance Percentage");
	cpass.setBounds(50,350,200,30);
	cpass.setForeground(Color.WHITE);
   cpass.setFont(new Font("Raleway",Font.BOLD,20));
	add(cpass);
	confirm=new JTextField();
	confirm.setBounds(250,350,150,30);
	confirm.setForeground(Color.BLACK);
	confirm.setFont(new Font("Raleway",Font.BOLD,17));
	add(confirm);
	JLabel course=new JLabel("Course");
	course.setBounds(50,400,200,30);
	course.setForeground(Color.WHITE);
   course.setFont(new Font("Raleway",Font.BOLD,20));
	add(course);
	coursef=new JTextField();
	coursef.setBounds(250,410,150,30);
	coursef.setForeground(Color.BLACK);
	coursef.setFont(new Font("Raleway",Font.BOLD,17));
	add(coursef);
	signup=new JButton("ADD");
	signup.setBounds(400,460,120,40);
	signup.setForeground(Color.BLACK);
   signup.setFont(new Font("Raleway",Font.BOLD,20));
   signup.setBackground(Color.white);
	add(signup);
	signup.addActionListener(this);
	cancel=new JButton("cancel");
	cancel.setBounds(250,460,120,40);
	cancel.setForeground(Color.BLACK);
	cancel.setFont(new Font("Raleway",Font.BOLD,20));
	cancel.setBackground(Color.white);
	add(cancel);
	cancel.addActionListener(this);
	setVisible(true);
	setLocation(300,100);
	setSize(600,550);
	getContentPane().setBackground(Color.black);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String last=last_text.getText();
		String first=first_text.getText();
		String address=address_text.getText();
		String email=email_text.getText();
		String pass=pass_text.getText();
		String conf=confirm.getText();
		String cf= coursef.getText();
		if(e.getSource()==signup) {
		if(!last.equals("") && !first.equals("") && !address.equals("") && !email.equals("") && !pass.equals("") && !conf.equals("") ) {
			connection cn=new connection();
			String query="insert into add_student values('"+last+"','"+first+"', '"+address+"', '"+pass+"', '"+email+"','"+conf+"','"+cf+"')";
			try {
				cn.stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Successfully Added");
				setVisible(false);
				new homepage();              
				
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Fill all Fields");
		}}
		if(e.getSource()==cancel) {
			setVisible(false);
			new homepage();   
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new add();

	}

	

}
