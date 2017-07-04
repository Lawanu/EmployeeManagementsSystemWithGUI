package EmployeeManagementProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame implements ActionListener {

	JTable tb1=new JTable();
	JLabel l1=new JLabel("User ID:");
    JTextField tf1=new JTextField(10);
	JPanel p1=new JPanel();
    JButton b1=new JButton("Search");
	public Search()
    { p1.setLayout(null);
    l1.setBounds(150,250,100,20);	
	tf1.setBounds(250,250,100,20);
	b1.setBounds(200,300,100,20);
	tb1.setBounds(0, 0, 500, 200);	
	    p1.add(l1);
    	p1.add(tf1);
    	p1.add(b1);
    	p1.add(tb1);
    	
    	add(p1);
    b1.addActionListener(this);	
    }
	public void actionPerformed(ActionEvent e) {
		try{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		System.out.println("Driver loaded");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","mlr");
    		System.out.println("Got Database Connection");
    		PreparedStatement ps=null;
    	 
    		Object obj=e.getSource();
    	if(obj==b1)
    	{System.out.println("Search");
    		String uid1=tf1.getText();
    	int uid=Integer.parseInt(uid1); 
    	
    	PreparedStatement ps1=con.prepareStatement("select *from EmpGUI where UserID=?");
    	 ps1.setInt(1,uid);
     	ps1.executeUpdate();
    	ResultSet rs=ps1.executeQuery();
    	//System.out.println(rs.getInt("UserID"));
    	String column[]={"ID","Name","Age","Designation","Salary","Photo"};
    	//Object data[][]={{new ImageIcon( rs.getBytes(6))}};
    	
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
    if(rs.getInt("UserId")==uid)
    {	System.out.println(uid);
    	model.insertRow(0,new Object[]{rs.getInt("UserID"),rs.getString("name"),rs.getInt("age"),rs.getString("desig"),rs.getInt("salary"),new ImageIcon(new ImageIcon(rs.getBytes("photo")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT))});
    }	
    }}
    	rs.close();
    	tb1.setModel(model);
    	tb1.setPreferredScrollableViewportSize(tb1.getPreferredSize());
        tb1.setRowHeight (150);
    	tb1.setRowMargin(2);
        JScrollPane scrollPane = new JScrollPane( tb1 );
        getContentPane().add( scrollPane );
        ps1.setInt(1,uid);
    	ps1.executeUpdate();
    	
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
