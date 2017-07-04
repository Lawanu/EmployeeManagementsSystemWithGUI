package EmployeeManagementProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Delete extends JFrame implements ActionListener {

	JLabel l1=new JLabel("User ID:");
    JTextField tf1=new JTextField(10);
	JPanel p1=new JPanel();
    JButton b1=new JButton("Delete");
	public Delete()
    { p1.setLayout(null);
    	l1.setBounds(150,150,100,20);	
	tf1.setBounds(250,150,100,20);
	b1.setBounds(200,200,100,20);
    	p1.add(l1);
    	p1.add(tf1);
    	p1.add(b1);
    	add(p1);
    b1.addActionListener(this);	
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
    	{System.out.println("Delete");
    		String uid1=tf1.getText();
    	int uid=Integer.parseInt(uid1); 
    	ps=con.prepareStatement("DELETE from EmpGUI where UserID=?");
    	 ps.setInt(1,uid);
    	ps.executeUpdate();
    	
    	}
    	
    		
    		
    	
    	ps.close();
    	con.close();
    		}
    		catch(Exception ew)
    		{
    			System.out.println(ew);
    		}
		
	}
	
	
}
