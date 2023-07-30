import javax.swing.*;
import java.awt.*;
public class About extends JFrame {
    About(){
        setBounds(100,100,500,400);
        setTitle("About Notepad Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon icon=new ImageIcon(getClass().getResource("notepad-icon.png"));
    	 setIconImage(icon.getImage());
         setLayout(null);
          JLabel iconLabel=new JLabel(new ImageIcon(getClass().getResource("notepad-icon.png")));
          iconLabel.setBounds(100,50,80,80);
          add(iconLabel);
          JLabel textLabel=new JLabel("<html>Welcome to Notepad<br>Notepad is a simple text editor for microsoft windows and a basic text-editing program which enables computer users to create documents<br>All rights reserved@2021</html>");
          textLabel.setBounds(100,150,350,80);
          add(textLabel);
        setVisible(true);
       
    }
    public static void main(String args[]){
        new About();
    }
}