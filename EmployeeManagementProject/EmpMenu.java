package EmployeeManagementProject;




import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EmpMenu extends JFrame implements ActionListener{
	JFrame p1=new JFrame();
	JMenuBar menubar=new JMenuBar();
	JMenu task=new JMenu("Tasks");
	JMenu insert=new JMenu("Add");
	JMenu view=new JMenu("View");
	JMenuItem clerk=new JMenuItem("CLERK");
	JMenuItem programmer=new JMenuItem("PROGRAMMER");
	JMenuItem manager=new JMenuItem("MANAGER");
    JMenuItem display=new JMenuItem("Display");
	JMenuItem delete=new JMenuItem("Delete");
	JMenuItem search=new JMenuItem("Search");
	public EmpMenu()
	{
	
		p1.setSize(400,400);
		p1.setVisible(true);
		p1.setJMenuBar(menubar);
		task.add(insert);
		menubar.add(task);
		menubar.add(view);
		task.add(delete);
		view.add(display);
		view.add(search);
		insert.add(clerk);
		insert.add(programmer);
		insert.add(manager);

		clerk.addActionListener(this);
	    display.addActionListener(this);
        delete.addActionListener(this);	
        search.addActionListener(this);	
    	p1.setTitle("Employee Management System");
        p1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==clerk)
		{
		System.out.println("Hii Steve");
		JFrame f=new Clerk();
		f.setSize(500,500);
		f.setVisible(true);
		f.setTitle("Clerk Entry");
		}
	    if(obj==display)
		{
		JFrame d=new Display();
		d.setSize(500,500);
		d.setVisible(true);
		d.setTitle("Employee Details");
		}
	    if(obj==delete)
	    {
	    	JFrame del=new Delete();
	    	del.setSize(500,500);
	    	del.setVisible(true);
	    	del.setTitle("Delete Employee Details");
	    	
	    }
	    if(obj==search)
	    {
	    	JFrame f=new Search();
			f.setSize(400,400);
			f.setVisible(true);
			f.setTitle("Search Employee Details");
	    }
	

	}
	}
