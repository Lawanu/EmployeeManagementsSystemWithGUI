package EmployeeManagementProject;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EmpLogin extends JFrame implements ActionListener{
	JButton b1=new JButton("Login");
	JButton b2=new JButton("Reset");
	

	JLabel l1=new JLabel("UserId");
	JLabel l2=new JLabel("Password");

	JTextField tf1=new JTextField(10);
	JPasswordField tf2=new JPasswordField(10);

	JPanel p1=new JPanel();
	
	public EmpLogin()
	{
		l1.setBounds(30,50,100,20);
		l2.setBounds(30,100,100,20);
		b1.setBounds(150,150,100,20);
		b2.setBounds(30,150,100,20);
		tf1.setBounds(150,50,100,20);
		tf2.setBounds(150,100,100,20);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		p1.add(b1);
		p1.add(b2);
		add(p1);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String uid=tf1.getText();
		String pass=tf2.getText();
		Object obj=e.getSource();
		System.out.println("uid:"+uid+"\n"+"pass:"+pass);
		if(obj==b1)
		{
		if(uid.equals("") && pass.equals(""))
		{
			EmpMenu menu=new EmpMenu();
			
			setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(p1,"Invalid username or Password");
			
		}}
		if(obj==b2)
		{
			tf1.setText("");
			tf2.setText("");
		}
		
	}
	public static void main(String[] args) {
	
		JFrame f=new EmpLogin();
		f.setTitle("Admin Login");
		f.setSize(400,400);
		f.setVisible(true);
	

	}

}
