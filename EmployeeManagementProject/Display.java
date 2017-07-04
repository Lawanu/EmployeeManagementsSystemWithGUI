package EmployeeManagementProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display extends JFrame {

public Display()
{
	try
	{Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver loaded");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mlr");
	System.out.println("Got Database Connection");
	PreparedStatement pstmt=con.prepareStatement("select *from EmpGUI");
	ResultSet rs=pstmt.executeQuery();
	//System.out.println(rs.getInt("UserID"));
	String column[]={"ID","Name","Age","Designation","Salary","Photo"};
	//Object data[][]={{new ImageIcon( rs.getBytes(6))}};
	JTable tb1=new JTable();
	DefaultTableModel model = new DefaultTableModel(null,column)
	{
		public Class<?> getColumnClass(int column)
		{
			if(column==5) 
			{
			
				return ImageIcon.class;
			}
				return Object.class;
		}
	};
 
	if(rs!=null)
	{
	while(rs.next())
	
	{
	model.insertRow(0,new Object[]{rs.getInt("UserID"),rs.getString("name"),rs.getInt("age"),rs.getString("desig"),rs.getInt("salary"),new ImageIcon(new ImageIcon(rs.getBytes("photo")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))});
	}}
	rs.close();
	/*Object []data1=new Object[2];
	data1[0]=rs.getInt("UserID");We can do it by this process also
	data1[1]= new ImageIcon(new ImageIcon(rs.getBytes("photo")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	model.addRow(data1);*/
	
	
	tb1.setModel(model);
	 
	tb1.setPreferredScrollableViewportSize(tb1.getPreferredSize());

	   tb1.setRowHeight (150);
	   tb1.setRowMargin(2);
       JScrollPane scrollPane = new JScrollPane( tb1 );
       getContentPane().add( scrollPane );
      
	}
	
	catch(Exception e)
	{
		System.out.println(e);
		
	}
}



	
		
		
	}


