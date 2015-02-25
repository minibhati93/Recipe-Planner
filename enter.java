import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class enter extends JFrame implements ActionListener
{       JButton b1,b2,a1,a2,a3,s1;
        JTextField f1;
        JPasswordField f2;
        JLabel j1,j2,j3,l1,l2,l3,p1,p2,m1,m2,j4,j5,j6,j7;
        JPanel panel,p,panel1;
        enter()
        {      
        JFrame f=new JFrame();
        Container con=getContentPane();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ImageIcon d1=new ImageIcon("bimage/back.jpg");
	  	  s1=new JButton(d1);
	  	  s1.addActionListener(this);
	    j1=new JLabel("Name: ");
	    j1.setForeground(Color.green);
	    j1.setFont(new Font("TAHOMA",Font.BOLD,30));
	    f1=new JTextField(5);
	    
	    j2=new JLabel("Password: ");
	    j2.setForeground(Color.green);
	    j2.setFont(new Font("TAHOMA",Font.BOLD,30));
	    f2=new JPasswordField(5);
	     
	    b1=new JButton("OK");
	    b1.setFont(new Font("TAHOMA",Font.BOLD,30));
	    b1.setBackground(Color.white);
	    ImageIcon i5=new ImageIcon("pics/logo1.jpg");
	       j7=new JLabel(i5);
		b1.addActionListener(this);
		ImageIcon i2=new ImageIcon("pics/c.jpg");
		m1=new JLabel(i2);
		con.add(s1);
	    con.add(j1);
	    con.add(f1);
	    con.add(j2);
	    con.add(f2);
	    con.add(b1);
	    con.add(j7);
	    con.add(m1);
	    f.add(con);
	    f.setVisible(true);
	    f.setSize(1400,900);
	    s1.setBounds(1200,20,40,40);
	    j1.setBounds(100,50,300,200 );
	    f1.setBounds(200,130,170,40 );
	    j2.setBounds(100,210,300,200 );
	    f2.setBounds(255,290,170,40);
	    b1.setBounds(100,450,200,50  );
	    j7.setBounds(950,0,500,500);
        }
        
 public void actionPerformed(ActionEvent ae)
 {      if(ae.getSource()==b1)
        { String name=f1.getText();
          char[] pass=f2.getPassword();
          String s1="";
   	      for(int i=0;i<pass.length;i++)
   	        {
	    	  s1=s1+pass[i];
    	    }
   	     
   	      Connection conn=null;
	   	   PreparedStatement pstmt=null;
		   Statement stmt=null;
		   try
		    {
		       Class.forName("com.mysql.jdbc.Driver");
		       conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		       pstmt=conn.prepareStatement("select * from register where uname=? and pass=? and type=?");
		       pstmt.setString(1,name);
		       pstmt.setString(2,s1);
		       pstmt.setString(3,"chef");
		      
		       ResultSet rs1= pstmt.executeQuery();
		       int ctr=0;
			   while(rs1.next())
				 { ctr++;
				 System.out.println("Sent"+ctr);
				  
				   profile p=new profile(name,s1);
				 }
			   if(ctr==0)
			   {
				   JOptionPane.showMessageDialog(null,"Sorry"+name+" you are not a chef or password does not match or register now");
			   }
				          
	           
			conn.close();
        } 
   	       
		    
		  catch(Exception e)
		  { System.out.println("1"+e.getMessage());
	       }
        }
 else if(ae.getSource()==s1)
 { login l=new login();
	 
 }
  }
 
}