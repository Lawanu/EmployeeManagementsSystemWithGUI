package EmployeeManagementProject;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;



public class Clerk extends JFrame implements ActionListener{
	static InputStream imag=null;
	File getImg;
	JLabel l1=new JLabel("User ID");
	JLabel l2=new JLabel("Name");
	JLabel l3=new JLabel("Age");
	JLabel l4=new JLabel();
    JTextField tf1=new JTextField(10);
	JTextField tf2=new JTextField(10);
	JTextField tf3=new JTextField(10);
	JButton b1=new JButton("Submit");
	JButton b2=new JButton("Reset");
	JButton b3=new JButton("Upload");
	ImageIcon img=new ImageIcon(new ImageIcon("images/icon_user_default.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
	//ImageIcon img=new ImageIcon("images/icon_user_default.png");
	JPanel p1=new JPanel();
	public Clerk()
	{   
	    p1.setSize(400,400);
	    p1.setVisible(true);
		p1.setLayout(null);
		l1.setBounds(30,50,100,20);	
		tf1.setBounds(150,50,100,20);
		l2.setBounds(30,100,100,20);	
		tf2.setBounds(150,100,100,20);
		l3.setBounds(30,150,100,20);	
		tf3.setBounds(150,150,100,20);
		l4.setBounds(300,50,120,120);
		b1.setBounds(200,250,100,20);
		b2.setBounds(50,250,100,20);
		b3.setBounds(300,169,120,20);
		Border border=BorderFactory.createLineBorder(Color.black,5);
		l4.setIcon(img);
		l4.setBorder(border);
		p1.add(l1);
		p1.add(l2);
        p1.add(l3);
        p1.add(tf1);
        p1.add(tf2);
        p1.add(tf3);
        p1.add(b1);
        p1.add(b2);
        p1.add(l4);
        p1.add(b3);
        add(p1);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mlr");
		System.out.println("Got Database Connection");
		PreparedStatement ps=null;
	 
		Object obj=e.getSource();
	if(obj==b1)
	{
		
		 String uid1=tf1.getText();
	     String age1=tf3.getText();
         int uid=Integer.parseInt(uid1);	
         String name=tf2.getText();
         int age=Integer.parseInt(age1);
         String desig="CLERK";
         int salary=8000;
         System.out.println(uid+":"+name+":"+age);
         System.out.println(img);
         ps=con.prepareStatement("insert into EmpGUI values(?,?,?,?,?,?)");
	     ps.setInt(1,uid);
	     ps.setString(2,name);
	     ps.setInt(3,age);
	     ps.setString(4,desig);
	     ps.setInt(5,salary);
	     ps.setBinaryStream(6,imag,(int)getImg.length());
	if(ps.executeUpdate()==1)
	{
		System.out.println("1 row inserted");
		JOptionPane.showMessageDialog(p1,"1 Row inserted to the database");
	}
	
	}
	if(obj==b2)
	{
		tf1.setText(" ");
		tf2.setText(" ");
		tf3.setText(" ");
		
	}
	if(obj==b3)
	{
	JFileChooser file=new JFileChooser();	
	file.setCurrentDirectory(new File(System.getProperty("user.home")));
	FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","png","gif");	
	file.addChoosableFileFilter(filter);
	int result =file.showSaveDialog(null);
	if(result == JFileChooser.APPROVE_OPTION)
	{
	File selectedFile = file.getSelectedFile();
	String path=selectedFile.getAbsolutePath();
	ImageIcon image=new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
	l4.setIcon(image);
	System.out.println(path);
	 getImg=new File(path);
	imag=new FileInputStream(getImg);
	}
	else if(result==JFileChooser.CANCEL_OPTION)
	{
	System.out.println("No file selected");	
	}
	}
	
	ps.close();
	con.close();
		}
		catch(Exception ew)
		{
			System.out.println(ew);
		}
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame f=new Clerk();
f.setSize(500,500);
f.setVisible(true);
	
	}*/

	
	

}
