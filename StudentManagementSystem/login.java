package student_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{
	JTextField email_text;
	JPasswordField pass;
	JButton login,signup,clear;
	login(){
		setLayout(null);
		JLabel title=new JLabel("LOGIN PAGE");
		title.setBounds(200,20,300,30);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Raleway",Font.BOLD,30));
		add(title);
		JLabel email=new JLabel("EMAIL ID");
		email.setBounds(50,90,150,30);
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Raleway",Font.BOLD,20));
		add(email);
		email_text=new JTextField();
		email_text.setBounds(220,90,300,30);
		email_text.setFont(new Font("Raleway",Font.BOLD,20));
		add(email_text);
		JLabel Password=new JLabel("PASSWORD");
		Password.setBounds(50,160,300,30);
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Raleway",Font.BOLD,20));
		add(Password);
		pass=new JPasswordField();
		pass.setBounds(220,160,300,30);
		pass.setFont(new Font("Raleway",Font.BOLD,20));
		add(pass);
		login=new JButton("Login");
		login.setBounds(70,250,100,30);
		login.setBackground(Color.WHITE);
	    login.setFont(new Font("Raleway",Font.BOLD,15));
		add(login);
		login.addActionListener(this);
		signup=new JButton("SignUp");
		signup.setBounds(210,250,100,30);
		signup.setBackground(Color.WHITE);
		signup.setFont(new Font("Raleway",Font.BOLD,15));
		add(signup);
		signup.addActionListener(this);
		clear=new JButton("Clear");
		clear.setBounds(350,250,100,30);
		clear.setBackground(Color.WHITE);
		clear.setFont(new Font("Raleway",Font.BOLD,15));
		add(clear);
		clear.addActionListener(this);
		setVisible(true);
		setSize(600,400);
		setLocation(400,150);
		getContentPane().setBackground(Color.BLACK);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clear) {
			email_text.setText("");
			pass.setText("");
		}
		
		else if(e.getSource()==login) {
			String email=email_text.getText();
			String passwords=pass.getText();
			if(!email.equals("") && !passwords.equals("")) {
				connection cn=new connection();
				 String query = "select * from login where email_id = '"+email+"' and password = '"+passwords+"'";
				
				
				try {
					ResultSet rs = cn.stm.executeQuery(query);
					if(rs.next()) {
				         new homepage();
						setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
					}
				}catch(Exception ae) {
					System.out.println(e);
				}
			}
		}
		else if(e.getSource()==signup) {
			new signup();
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new login();

	}

	

}
