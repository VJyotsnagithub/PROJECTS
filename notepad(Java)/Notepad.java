import javax.swing.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.print.PrinterException;
import javax.swing.UIManager;
public class Notepad extends JFrame implements ActionListener{
	JMenuBar menubar=new JMenuBar();;
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help");
	JMenuItem newfile=new JMenuItem("New");
	JMenuItem openFile=new JMenuItem("Open");
	JMenuItem savefile=new JMenuItem("Save");
	JMenuItem print=new JMenuItem("Print");
	JMenuItem exit=new JMenuItem("Exit");
	JMenuItem cut=new JMenuItem("Cut");
	JMenuItem copy=new JMenuItem("Copy");
	JMenuItem paste=new JMenuItem("Paste");
	JMenuItem selectall=new JMenuItem("Select All");
	JMenuItem about=new JMenuItem("About");
	JTextArea textarea=new JTextArea();
     Notepad(){
    	 setTitle("Notepad Application");
    	 setBounds(250,100,800,600);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 ImageIcon icon=new ImageIcon(getClass().getResource("notepad-icon.png"));
    	 setIconImage(icon.getImage());
		 setJMenuBar(menubar);

		 menubar.add(file);
		 menubar.add(edit);
		 menubar.add(help);
		 file.add(newfile);
		 file.add(openFile);
		 file.add(savefile);
		 file.add(print);
		 file.add(exit);

		newfile.addActionListener(this);
		openFile.addActionListener(this); //adding actionlistener to menuitems
		savefile.addActionListener(this);
		print.addActionListener(this);
		exit.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
	    cut.addActionListener(this);
		about.addActionListener(this);
		 edit.add(copy);
		 edit.add(cut);
		 edit.add(paste);
		 edit.add(selectall);
		 help.add(about);
		 JScrollPane scrollpane=new JScrollPane(textarea);
		 scrollpane.setBorder(BorderFactory.createEmptyBorder());//removes border
		 textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,17));
		 textarea.setLineWrap(true); //nextline
		 textarea.setWrapStyleWord(true);
		 scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //prevent horizontalscroll
		 scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 add(scrollpane);

		 newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK)); //shortcut keys
		 openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		 savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		 print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
		 exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
		 copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
		 cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
		 paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
		 selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));

    	 setVisible(true);
     }
	 public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equalsIgnoreCase("New")){
			textarea.setText("");

		}
		else if(e.getActionCommand().equalsIgnoreCase("Open")){
			JFileChooser fileChooser=new JFileChooser();
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","text");
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(textFilter);
			int action=fileChooser.showOpenDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION){
				return;
			}
			else{
				try{
				BufferedReader reader=new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
				textarea.read(reader,null);
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
			}

		}
		else if(e.getActionCommand().equalsIgnoreCase("Save")){
			JFileChooser fileChooser=new JFileChooser(); //choosing file
			FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","text"); //filtering extensions
			fileChooser.setAcceptAllFileFilterUsed(false); //dening acceptingallfiles
			fileChooser.addChoosableFileFilter(textFilter); //allowing textfile
			int action=fileChooser.showSaveDialog(null);
			if(action!=JFileChooser.APPROVE_OPTION){
				return;
			}
			else{
				String fileName=fileChooser.getSelectedFile().getAbsolutePath().toString();
				if(!fileName.contains(".txt")){
                    fileName=fileName+".txt";}
					try{
						BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
						textarea.write(writer);
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
				}
			}
		else if(e.getActionCommand().equalsIgnoreCase("Print")){
			try{
			textarea.print();
			}
			catch(PrinterException px){
				Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE,null,px);
			}
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Exit")){
			System.exit(0);
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("cut")){
			textarea.cut();
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("copy")){
			textarea.copy();
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Paste")){
			textarea.paste();
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Select All")){
			
			textarea.selectAll();
		}
		else if(e.getActionCommand().equalsIgnoreCase("About")){
			new About();
		}

	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception ex){}
		Notepad note=new Notepad();

	}

}
