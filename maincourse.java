import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class maincourse extends JFrame implements ActionListener
{  JButton s1,s2,s3,s4,s5,s6,s7,s8;
   JLabel l1,l2,l3,l4,l5;
   JPanel panel,p;
  
   
   maincourse()
   { 
       JFrame frame=new JFrame("Home");
       Container con=getContentPane();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ImageIcon d9=new ImageIcon("pics/mcbg.jpg");
   	   l4=new JLabel(d9);
	  ImageIcon d1=new ImageIcon("bimage/back.jpg");
  	  s1=new JButton(d1);
  	  s1.addActionListener(this);
  	  ImageIcon d8=new ImageIcon("bimage/home.jpg");
	  s2=new JButton(d8);
	  s2.setBackground(Color.green);
	  s2.addActionListener(this);
	  ImageIcon i5=new ImageIcon("pics/logo1.jpg");
      l5=new JLabel(i5);
  	 
  	 
  	 ImageIcon d2=new ImageIcon("pics/indian.jpg");
 	  s3=new JButton(d2);
 	  //s2.setBackground(Color.green);
 	 
 	  s3.addActionListener(this);
 	 ImageIcon d3=new ImageIcon("pics/thai.jpg");
	  s4=new JButton(d3);
	  //s3.setBackground(Color.green);
	
	  s4.addActionListener(this);
	  ImageIcon d4=new ImageIcon("pics/conti.jpg");
 	  s5=new JButton(d4);
 
 	
 	  s5.addActionListener(this);
 	  
 	 ImageIcon d5=new ImageIcon("pics/mexican.jpg");
	  s6=new JButton(d5);

	  s6.addActionListener(this);
	  ImageIcon d6=new ImageIcon("pics/italian.jpg");
	  s7=new JButton(d6);
	
	s7.addActionListener(this);
	  ImageIcon d7=new ImageIcon("pics/china.jpg");
	  s8=new JButton(d7);
	  
	s8.addActionListener(this);
	 con.add(s1);
	 con.add(s2);
	 con.add(l5);
	 con.add(s3);
	 con.add(s4);
	 con.add(s5);
	 con.add(s6);
	 con.add(s7);
	 con.add(s8);
	 con.add(l4);
	 frame.add(con);
	  frame.setSize(1400,900);
      frame.setVisible(true);
      s1.setBounds(530,20,79,80);
      s2.setBounds(630,20,79,79);
      s3.setBounds(700,400,200,190);  

      s8.setBounds(1000,300,270,170);
          
      s4.setBounds(1000,60,250,170);
 
      s5.setBounds(400,400,200,200);
      
      s6.setBounds(30,60,270,170);
      l5.setBounds(380,10,500,500);
      s7.setBounds(30,300,270,170);
   }
public void actionPerformed(ActionEvent ae)
{ if(ae.getSource()==s1)
   {  
	home h=new home();
	
   }
else if(ae.getSource()==s2)
{ abc h=new abc();
	
}
else if(ae.getSource()==s3)
{indian i=new indian();	
}
else if(ae.getSource()==s4)
{ thai i=new thai();
	
}
else if(ae.getSource()==s5)
{ conti i=new conti();
	
}
else if(ae.getSource()==s6)
{ mexican i=new mexican();
 
}
else if(ae.getSource()==s7)
{ i1 i=new i1();
	
}
else if(ae.getSource()==s7)
{ chinese i=new chinese();
	
}

}
}
