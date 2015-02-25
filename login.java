import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class login extends JFrame implements ActionListener
{   JLabel j1,j2,j3,j4,j5,j6,l1,l2,l3,j7;
    JTextField t1,t2;
    JPasswordField p1;
    JButton b1,b2,s1;
    Choice c1,c;
    JButton a,b;
    	login()
	{  
	   
       JFrame frame=new JFrame("Join us");
       Container con=getContentPane();
       con.setBackground(Color.yellow);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   //panel4=new JPanel();
	   ImageIcon d1=new ImageIcon("bimage/back.jpg");
	  	  s1=new JButton(d1);
	  	  s1.addActionListener(this); 
	   ImageIcon i1=new ImageIcon("pics/chef.jpg");
	   b1=new JButton(i1);
	   b1.addActionListener(this);
		
	   ImageIcon i2=new ImageIcon("pics/user.jpg");
	   b2=new JButton(i2);
	   
	   b2.addActionListener(this);

	   //panel4.add(j2);
	
     
       b=new JButton("New User???Register here");
       //panel4.add(b);
       b.setBackground(Color.red);
       b.setFont(new Font("ARIAL",Font.BOLD,20));
       ImageIcon i4=new ImageIcon("pics/a.jpg");
       j6=new JLabel(i4);
       ImageIcon i5=new ImageIcon("pics/logo.jpg");
       j7=new JLabel(i5);
      con.add(s1);
       con.add(b1);
       con.add(j7);
      
       con.add(b);
       con.add(b2);
       con.add(j6);
       frame.add(con);
	   
	   frame.setSize(1400,900);
	   frame.setVisible(true);
	   s1.setBounds(1200,20,40,40);
	   b1.setBounds(160,90,250,250 );
	   b2.setBounds(900,90,230,240 );
	   b.setBounds(500,120,300,50  );
	   j7.setBounds(400,200,500,500);
	   b.addActionListener(this);
	   	}

public void actionPerformed(ActionEvent ae)
{  
	if(ae.getSource()==b1)
     {
        enter e=new enter();
        
     }
   else if(ae.getSource()==b)
     {  reg r=new reg();
 }
   else if(ae.getSource()==b2)
   {   userlog u=new userlog();
   
   }
   else if(ae.getSource()==s1)
   {   abc a=new abc();
   
   }
}
}
 