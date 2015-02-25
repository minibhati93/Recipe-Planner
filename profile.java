import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class profile extends JFrame implements ActionListener
{  JButton a1,a2,a3,a4,a5;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,j1,j2;
   String str="";
    profile(String name,String pass)
     {  str=name;
        Container con=getContentPane();
        con.setBackground(Color.green);
    	JOptionPane.showMessageDialog(null,"Welcome "+name+"..We appreciate your contribution"); 
    	JFrame f=new JFrame("My CookBook");
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Connection conn=null;
         try
          {   Class.forName("com.mysql.jdbc.Driver");
		      conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
			  Statement stmt=conn.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from register  where uname=\'"+name+"\'and pass=\'"+pass+"\'");
			  String a="";
			  String x="";
			  String z="";
			  while(rs.next())
			  { z=rs.getString("uname");
			    x=rs.getString("pass");
			    a=rs.getString("type");
			    l6=new JLabel(z);
			    l7=new JLabel(x);
			    l8=new JLabel(a);
			  }
			  
			  l1=new JLabel("Welcome");
			  l1.setFont(new Font("Monotype Corsiva",Font.BOLD,35));
			  l2=new JLabel(a);
			  l2.setFont(new Font("Monotype Corsiva",Font.BOLD,35));
			  l3=new JLabel(z);
			  l3.setFont(new Font("Monotype Corsiva",Font.BOLD,35));
			  
			  a1=new JButton("OK");
			  a1.setFont(new Font("ARIAL",Font.BOLD,20));
			  a1.setBackground(Color.red);
		      a2=new JButton("Logout");
		      a2.setFont(new Font("ARIAL",Font.BOLD,20));
			  a2.setBackground(Color.pink);
			  
		      a3=new JButton("Post");
		      a3.setFont(new Font("ARIAL",Font.BOLD,20));
			  a3.setBackground(Color.yellow);
			  
		      a4=new JButton("Change password");
		      a4.setFont(new Font("ARIAL",Font.BOLD,20));
			  a4.setBackground(Color.magenta);
			  
		      a5=new JButton("View");
		      a5.setFont(new Font("ARIAL",Font.BOLD,20));
			  a5.setBackground(Color.green);
		 ImageIcon i4=new ImageIcon("pics/d.jpg");
		     j1=new JLabel(i4);
		/*      ImageIcon i5=new ImageIcon("pics/logo1.jpg");
		      j2=new JLabel(i5);*/
		       con.add(l1);
		       con.add(l2);
		       con.add(l3);
		  //    con.add(a1);
		       con.add(a2);
		       con.add(a3);
		       con.add(a4);
		       con.add(a5);
		       con.add(j1);
		       f.add(con);
		       
		   	   f.setSize(1400,1000);
		   	   f.setVisible(true); 
		   	   l1.setBounds(500,30,200,50);
		   	   l2.setBounds(630,30,200,50 );
		   	   l3.setBounds(720,30,200,50 );
		   	//   a1.setBounds(100, 600,180, 50);
		   	   a2.setBounds(320, 600,180, 50);
		       a3.setBounds(550,600,180, 50);
		       a4.setBounds(780, 600, 250, 50);
		   	   a5.setBounds(1050, 600, 180, 50);
		   	 //  j2.setBounds(950,0,500,500);
		   	   
        } 
      catch(Exception e)
       { System.out.println("3"+e.getMessage());
       }
         
       a1.addActionListener(this);
       a2.addActionListener(this);
       a3.addActionListener(this);
       a5.addActionListener(this);
     }

	
	
    public void actionPerformed(ActionEvent ae)
    {  if(ae.getSource()==a3)
       {  
        	dish d=new dish();
        } 
    else  if(ae.getSource()==a2)
    {  
     	enter d=new enter();
     } 
       else if(ae.getSource()==a5)
       {  Connection c1=null;
          
		 try
		 { String chef=str;
		 
           Class.forName("com.mysql.jdbc.Driver");
	       c1= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		   Statement s1=c1.createStatement();
		   ResultSet rs1=s1.executeQuery("select * from adddish where chef=\'"+chef+"\'");
		   String z1="";
		   int ctr=0;
		   
		  while(rs1.next())
		  {  ctr++;
			  z1=rs1.getString("name");  
		      System.out.print(" done "+ctr);
		      
		  }
		  rec r=new rec(str,ctr);
		  c1.close();
		 }
		catch(Exception e)
		{
			System.out.println("6"+e.getMessage());
		}
	
     	
     }         
}   
}
