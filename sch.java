import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class sch extends JFrame implements ActionListener
{  JButton b1,s1,s2,s3;
   JLabel j1,j2,j3,j4,j5,j6,l1,l2,l3,l4,l5,f1,f2,f3,f4,f6,f5;
   JTextField t1;
   int ctr=0;
   Choice c,c1;
   int a;
   Container con;
   JFrame frame;
   sch()
   {   JFrame frame=new JFrame("Search");
        Container con=getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	  

      ImageIcon i1=new ImageIcon("move/search.jpg");
      j6=new JLabel(i1);
      ImageIcon d1=new ImageIcon("bimage/back.jpg");
  	  s1=new JButton(d1);
  	  s1.addActionListener(this);
  	 
    
	/* c=new Choice();
	   for(int i=1;i<=4;i++)
	   { c.add(String.valueOf(i));
	   
	   }
	  c1=new Choice();
	  c1.add("beverage");
	  c1.add("starter");
	  c1.add("desert");
	  c1.add("thai");
	  c1.select(0);*/
	  j1=new JLabel("Search HERE");
	  j1.setFont(new Font("ARIAL",Font.BOLD,30));
	  j1.setForeground(Color.green);
	  con.add(j1);
	// con.add(c1);
	  t1=new JTextField(5);
	  con.add(t1);
		
	  b1=new JButton("Go");
	  b1.addActionListener(this); 
//	  b1.setBackground(Color.DARK_GRAY);
//	  b1.setForeground(Color.red);
	  con.add(b1);
	  con.add(s1);
	 // con.add(s2);
	  //con.add(s3);
	 
	
	//  a=Integer.parseInt(c.getSelectedItem());
	 	 // frame.add(panel,BorderLayout.CENTER);
	 
	  b1.addActionListener(this);
	  con.add(j6);
      frame.add(con);	
      frame.setVisible(true);
	  frame.setSize(1400,900);
	  j6.setBounds(600,50,100,100);
	  j1.setBounds(600,100,200,100);
	  b1.setBounds(400,200,250,50);
	  t1.setBounds(800,100,400,100);
	  
   }
   
      Connection conn=null;
	  PreparedStatement pstmt=null;
	  Statement stmt=null;
public void actionPerformed(ActionEvent ae)
{  
	if(ae.getSource()==b1)
  {  String s=t1.getText();
    
   
   for(int i=1;i<=a;i++)
    { try
		{
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from starter  where name ='"+s+"'");
		String s2="";
		String a="";
		String x="";
		String y="";
		String z="";
		String w="";
		  while(rs.next())
		  { a=rs.getString("name");
		    w=rs.getString("ing");
		    x=rs.getString("method");
		    y=rs.getString("time");
		    z=rs.getString("serving");
		    System.out.println(""+a+w+x+y+z);
		    //l1=new JLabel(a);
		    //l1.setFont(new Font("TAHOMA",Font.BOLD,20));
		    //l2=new JLabel(w);
		    //l2.setFont(new Font("TAHOMA",Font.BOLD,20));
		    //l3=new JLabel(x);
		    //l3.setFont(new Font("TAHOMA",Font.BOLD,20));
		    //l4=new JLabel(y);
		    //l4.setFont(new Font("TAHOMA",Font.BOLD,20));
		  //  l5=new JLabel(z);
		    //l5.setFont(new Font("TAHOMA",Font.BOLD,20));
		  }
		  
		  if(ctr==0)
		  { JOptionPane.showMessageDialog(null,"No results found");
		  }
		  else
		  {
		 	  }
	
		  f2=new JLabel("NAME: ");
	//	  f2.setFont(new Font("ARIAL",Font.BOLD,25));
		  f2.setForeground(Color.RED);
		  f3=new JLabel("INGREDIENTS: ");
	//	  f3.setFont(new Font("ARIAL",Font.BOLD,25));
		  f3.setForeground(Color.RED);
		  f4=new JLabel("METHOD: ");
		//  f4.setFont(new Font("ARIAL",Font.BOLD,25));
		  f4.setForeground(Color.RED);
		  f5=new JLabel("PREPARATION TIME: ");
		  //f5.setFont(new Font("ARIAL",Font.BOLD,25));
		  f5.setForeground(Color.RED);
		  f6= new JLabel("SERVINGS: ");
		  //f6.setFont(new Font("ARIAL",Font.BOLD,25));
		  f6.setForeground(Color.RED);		 
		
		  conn.close();
		  
		}
		
	catch(Exception e)
	{  System.out.println(""+e.getMessage());
	
	}
   
    con.add(f1);
    con.add(f2);
    con.add(l1);
    con.add(f3);
    con.add(l2);
    con.add(f4);
    con.add(l3);
    con.add(f5);
    con.add(l4);
    con.add(f6);
    con.add(l5);
    con.add(j6);
    frame.add(con);
	
}
  }
   else if(ae.getSource()==s1) 
   { abc h=new abc();
	   
   }
    
}  
}