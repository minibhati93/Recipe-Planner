import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class rec extends JFrame
{  JButton a1,a2,a3,a4;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,n1,n2,j1;
   JPanel panel;
   
    rec(String name,int ctr)
     {  if(ctr==0)
    	  { JOptionPane.showMessageDialog(null,"You have not posted any receipes");
    	    
    	  }
     else{
    	 
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i4=new ImageIcon("pics/bk.jpg");
	     j1=new JLabel(i4);
         Container con=getContentPane();
         
         Connection c=null;
	      Statement s=null;
	  	  try
	  	  { Class.forName("com.mysql.jdbc.Driver");
	        c= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		    s=c.createStatement();
            ResultSet rs1=s.executeQuery("select * from adddish where chef=\'"+name+"\'");
		    String p="";
		  int i=0;
		  while(rs1.next())
		   {  i++;
			  p=rs1.getString("name");
			  n1=new JLabel(p);  
			  n1.setFont(new Font("ARIAL",Font.BOLD,20));
			  n1.setBackground(Color.darkGray);
			  n2=new JLabel(String.valueOf(i));
			  con.add(n2);
			  con.add(n1);
			  
		   }
		  
		  con.add(j1);
		  f.add(con);
		  c.close();
		  f.setVisible(true);
	    	f.setSize(1400,900);
		
	    
	    	}
     
	  	  catch(Exception e)
	  	  {
	  		System.out.println("7"+e.getMessage());
	  	  }
     }
     }
}
