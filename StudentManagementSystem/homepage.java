package student_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class homepage extends JFrame implements ActionListener{
	JButton btnadd,btnoperations,btndisplay,btnupdate,btncancel,btnsearch;
	homepage(){
		setLayout(null);
		JLabel title=new JLabel("HOME PAGE");
		title.setBounds(200,20,300,30);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Raleway",Font.BOLD,30));
		add(title);
		 btnadd=new JButton("ADD STUDENT");
		btnadd.setBounds(40,90,150,100);
		btnadd.setForeground(Color.BLACK);
		btnadd.setBackground(Color.white);
		btnadd.setFont(new Font("Raleway",Font.BOLD,15));
		add(btnadd);
		btnadd.addActionListener(this);
		 btnoperations=new JButton("DELETE STUDENT");
		 btnoperations.setBounds(210,90,180,100);
		 btnoperations.setForeground(Color.BLACK);
		 btnoperations.setBackground(Color.white);
		 btnoperations.setFont(new Font("Raleway",Font.BOLD,15));
		 add(btnoperations);
		 btnoperations.addActionListener(this);
		 btndisplay=new JButton("DISPLAY DETAILS");
		 btndisplay.setBounds(410,90,190,100);
		 btndisplay.setForeground(Color.BLACK);
		 btndisplay.setBackground(Color.white);
		 btndisplay.setFont(new Font("Raleway",Font.BOLD,15));
		 add(btndisplay);
		 btndisplay.addActionListener(this);
		 btnupdate=new JButton("UPDATE DETAILS");
		 btnupdate.setBounds(50,230,180,100);
		 btnupdate.setForeground(Color.BLACK);
		 btnupdate.setBackground(Color.white);
		 btnupdate.setFont(new Font("Raleway",Font.BOLD,15));
		 add(btnupdate);
		 btnupdate.addActionListener(this);
		 btncancel=new JButton("CANCEL");
		 btncancel.setBounds(240,230,160,100);
		 btncancel.setForeground(Color.BLACK);
		 btncancel.setBackground(Color.white);
		 btncancel.setFont(new Font("Raleway",Font.BOLD,15));
		 add(btncancel);
		 btncancel.addActionListener(this);
		 btnsearch=new JButton("SEARCH STUDENT");
		 btnsearch.setBounds(410,230,190,100);
		 btnsearch.setForeground(Color.BLACK);
		 btnsearch.setBackground(Color.white);
		 btnsearch.setFont(new Font("Raleway",Font.BOLD,15));
		 add(btnsearch);
		 btnsearch.addActionListener(this);
		setVisible(true);
		setSize(640,400);
		setLocation(400,150);
		getContentPane().setBackground(Color.BLACK);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btncancel) {
			System.exit(0);
		}
		else if(e.getSource()==btnoperations) {
			setVisible(false);
			new delete();
		}
		else if(e.getSource()==btnupdate) {
			setVisible(false);
		new update();
		}
		else if(e.getSource()==btnadd) {
			setVisible(false);
			new add();
		}
		else if(e.getSource()==btndisplay) {
			setVisible(false);
		new display();
		}
		else if(e.getSource()==btnsearch) {
			setVisible(false);
			new search();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new homepage();

	}

	

}
