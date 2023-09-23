package student_management_system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class signup extends JFrame implements ActionListener{
	JTextField last_text,first_text,address_text,email_text;
	JPasswordField  pass_text,confirm;
	JButton signup;
	signup(){
		setLayout(null);
		JLabel title=new JLabel("SIGN UP PAGE");
		title.setBounds(170,30,300,30);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Raleway",Font.BOLD,30));
		add(title);
		JLabel last=new JLabel("Last Name");
		last.setBounds(50,100,150,30);
		last.setForeground(Color.WHITE);
		last.setFont(new Font("Raleway",Font.BOLD,20));
		add(last);
		 last_text=new JTextField();
		last_text.setBounds(230,100,280,30);
		last_text.setForeground(Color.BLACK);
		last_text.setFont(new Font("Raleway",Font.BOLD,17));
		add(last_text);
		JLabel first=new JLabel("First Name");
		first.setBounds(50,150,150,30);
		first.setForeground(Color.WHITE);
		first.setFont(new Font("Raleway",Font.BOLD,20));
		add(first);
		first_text=new JTextField();
		first_text.setBounds(230,150,280,30);
		first_text.setForeground(Color.BLACK);
		first_text.setFont(new Font("Raleway",Font.BOLD,17));
		add(first_text);
		JLabel address=new JLabel("Address");
		address.setBounds(50,200,150,30);
		address.setForeground(Color.WHITE);
		address.setFont(new Font("Raleway",Font.BOLD,20));
		add(address);
		address_text=new JTextField();
		address_text.setBounds(230,200,280,30);
		address_text.setForeground(Color.BLACK);
		address_text.setFont(new Font("Raleway",Font.BOLD,17));
		add(address_text);
		JLabel email=new JLabel("Email");
		email.setBounds(50,250,150,30);
		email.setForeground(Color.WHITE);
	   email.setFont(new Font("Raleway",Font.BOLD,20));
		add(email);
		email_text=new JTextField();
		email_text.setBounds(230,250,320,30);
		email_text.setForeground(Color.BLACK);
		email_text.setFont(new Font("Raleway",Font.BOLD,17));
		add(email_text);
		JLabel pass=new JLabel("Password");
		pass.setBounds(50,300,150,30);
		pass.setForeground(Color.WHITE);
	   pass.setFont(new Font("Raleway",Font.BOLD,20));
		add(pass);
		pass_text=new JPasswordField();
		pass_text.setBounds(230,300,280,30);
		pass_text.setForeground(Color.BLACK);
		pass_text.setFont(new Font("Raleway",Font.BOLD,17));
		add(pass_text);
		JLabel cpass=new JLabel("Confirm Password");
		cpass.setBounds(50,350,200,30);
		cpass.setForeground(Color.WHITE);
	   cpass.setFont(new Font("Raleway",Font.BOLD,20));
		add(cpass);
		confirm=new JPasswordField();
		confirm.setBounds(250,350,280,30);
		confirm.setForeground(Color.BLACK);
		confirm.setFont(new Font("Raleway",Font.BOLD,17));
		add(confirm);
		signup=new JButton("Sign Up");
		signup.setBounds(400,400,120,40);
		signup.setForeground(Color.BLACK);
	   signup.setFont(new Font("Raleway",Font.BOLD,20));
	   signup.setBackground(Color.white);
		add(signup);
		signup.addActionListener(this);
		setVisible(true);
		setLocation(300,100);
		setSize(600,500);
		getContentPane().setBackground(Color.black);
	}
	public void actionPerformed(ActionEvent e) {
		String last=last_text.getText();
		String first=first_text.getText();
		String address=address_text.getText();
		String email=email_text.getText();
		String pass=pass_text.getText();
		String conf=confirm.getText();
		if((pass.equals("") && conf.equals(""))||(!pass.equals(conf))) {
			JOptionPane.showMessageDialog(null, "Incorrect Password");
			pass_text.setText("");
			confirm.setText("");
		}
		if(!last.equals("") && !first.equals("") && !address.equals("") && !email.equals("") && !pass.equals("") && !conf.equals("") ) {
			connection cn=new connection();
			String query="insert into signup values('"+last+"','"+first+"', '"+email+"', '"+pass+"', '"+address+"')";
			String query1="insert into login values('"+email+"','"+pass+"')";
			try {
				cn.stm.executeUpdate(query);
				cn.stm.executeUpdate(query1);
				setVisible(false);
				new homepage();
				
			}catch(Exception ae) {
				System.out.println(ae);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Fill all Fields");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new signup();
	}

	
}
