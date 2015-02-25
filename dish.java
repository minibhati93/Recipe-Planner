import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class dish extends JFrame implements ActionListener
{  JLabel a1,a2,a3,a4,a5;
   JTextField f1,f2,f3,f4,f5,f6,f7;
   JButton d1,d2,d3;
   JPanel panel;
   Choice c,c1;
   JTextArea t1,t2;
   dish()
   {  c= new Choice();
      c.add("Choose");
	  c.add("Beverages");
      c.add("Main Course");
      c.add("Appetizers");
	  c.add("Desserts");
	  c.select(0);
	  c1= new Choice();
      
	  c1.add("Veg");
      c1.add("Non-Veg");
     
	   Container con=getContentPane();
      con.setLayout(null);
      JFrame frame=new JFrame();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  frame.setSize(500,500);
	  panel=new JPanel(new GridLayout(10,2,10,20));
	  panel.add(new JLabel("Name of the chef : "));
	  f1=new JTextField(5);
	  panel.add(f1);
	  panel.add(new JLabel("Name of the dish : "));
	  f2=new JTextField(5);
	  panel.add(f2);
	  panel.add(new JLabel("Cuisine : "));
	  panel.add(c);
	  panel.add(new JLabel("Cook time : "));
	  f4=new JTextField(5);
	  panel.add(f4);
	  panel.add(new JLabel("Servings : "));
	  f5=new JTextField(5);
	  panel.add(f5);
	  panel.add(new JLabel("Ingredients :"));
	  t1=new JTextArea(4,2);
	  panel.add(t1);
	  panel.add(new JLabel("Method :"));
	  t2=new JTextArea(4,2);
	  panel.add(t2);
	  panel.add(new JLabel("Pick 1 : "));
	  panel.add(c1);
	  d2=new JButton("Upload a pic");
	  panel.add(d2);
	  d2.addActionListener(this); 
	  d1=new JButton("Done");
	  panel.add(d1);
	  d1.addActionListener(this); 
	  d3=new JButton("Go to profile");
	  panel.add(d3);
	  d3.addActionListener(this); 
	  
	  con.add(panel);
	  frame.add(panel); 
	  
	  
   }
   
 public void actionPerformed(ActionEvent ae)
	  {
	  	if(ae.getSource()==d1)
	  	{    
	  		 String chef=f1.getText();
	  		 String name=f2.getText();
	  		 String cu=(String)c.getSelectedItem();
	  		 String time=f4.getText();
	  		 String ser=f5.getText();
	  		 String ing=t1.getText();
	  		 String meth=t2.getText();
	  	     String p=(String)c1.getSelectedItem();	
	  		if(name.trim().equals(""))
	  			JOptionPane.showMessageDialog(null, "please enter name ");
	  		
	  		else 		
	  		{
	  			Connection conn=null;
	  			PreparedStatement pstmt=null;
	  			Statement stmt=null;
	  			try
	  		  {
	  			Class.forName("com.mysql.jdbc.Driver");
	  			conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
	  			pstmt=conn.prepareStatement("insert into adddish(name,chef,genre,servings,ing,method,time,kind) values(?,?,?,?,?,?,?,?)");
	  			pstmt.setString(1,name);
	  			pstmt.setString(2,chef);
	  			pstmt.setString(3,cu);
	  			pstmt.setString(4,ser);
	  			pstmt.setString(5,ing);
	  			pstmt.setString(6,meth);
	  			pstmt.setString(7,time);
	  			pstmt.setString(8,p);
	  	        
	  			int rs1=pstmt.executeUpdate();
	  			if(rs1>0)
	  			{ System.out.println("Inserted");
	  			JOptionPane.showMessageDialog(null,"Successfully posted!!!");
	  			}
	  			else
	  			System.out.println(" not Inserted");
	  			
	  			stmt=conn.createStatement();
	  			
	  			
	  			conn.close();
	  			}
	  			catch(Exception e)
	  			{
	  				System.out.println("4"+e.getMessage());
	  			}
	  			
	  		}	//setVisible(false);
	  		
	  		}
	  	else if(ae.getSource()==d2)
	  	 {
	  		 
	  	 }
	  	
	  	else if(ae.getSource()==d3)
	  	 {   Connection c1=null;
	  		 try
	  		 { String chef=f1.getText();
               Class.forName("com.mysql.jdbc.Driver");
		       c1= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
			   Statement s1=c1.createStatement();
			   String str=chef;
			  ResultSet rs=s1.executeQuery("select * from register  where uname=\'"+str+"\'");
			  String z="";
			  
			  while(rs.next())
			  { z=rs.getString("pass");  
	  		    profile p=new profile(chef,z);
			  }
			  System.out.print("done");
			  c1.close();
	  		 }
	  		catch(Exception e)
  			{
  				System.out.println("5"+e.getMessage());
  			}
	  	 }
	  	
	  }
}
	  


