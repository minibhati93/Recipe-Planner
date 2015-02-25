import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class des9 extends JFrame implements ActionListener
{  JButton s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,z1;
   JLabel l1,l2,l3,l4,l5,f1,f2,f3,f4,f5,f6,image;
   JPanel p,p1,p2,p3;
   des9()
   {  //JOptionPane.showMessageDialog(null,"Welcome to the world of beverages..Enjoy!!");
      JFrame frame=new JFrame("Beverages");
      Container con=getContentPane();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	  ImageIcon d1=new ImageIcon("bimage/back.jpg");
  	  s1=new JButton(d1);
  	  s1.addActionListener(this);
  	  ImageIcon d2=new ImageIcon("bimage/home.jpg");
	  s2=new JButton(d2);
	  s2.addActionListener(this);
	  ImageIcon d3=new ImageIcon("bimage/next.jpg");
	  s3=new JButton(d3);
	  s3.addActionListener(this);
	  ImageIcon d4=new ImageIcon("pics/f.jpg");
	  image=new JLabel(d4);
	  
	
	
	   Connection conn=null;
	  PreparedStatement pstmt=null;
	  Statement stmt=null;
for(int i=10;i<=10;i++)
{	try
		{
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from desert where sno=\'"+i+"\'");
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
		    l1=new JLabel(a);
		    l1.setFont(new Font("TAHOMA",Font.BOLD,20));
		    l2=new JLabel(w);
		    l2.setFont(new Font("TAHOMA",Font.BOLD,20));
		    l3=new JLabel(x);
		    l3.setFont(new Font("TAHOMA",Font.BOLD,20));
		    l4=new JLabel(y);
		    l4.setFont(new Font("TAHOMA",Font.BOLD,20));
		    l5=new JLabel(z);
		    l5.setFont(new Font("TAHOMA",Font.BOLD,20));
		  }
		  
		 
		  ImageIcon i1=new ImageIcon("des/"+i+".jpg");
		  f1=new JLabel(i1);
		  f2=new JLabel("NAME: ");
		  f2.setFont(new Font("ARIAL",Font.BOLD,25));
		  f2.setForeground(Color.RED);
		  f3=new JLabel("INGREDIENTS: ");
		  f3.setFont(new Font("ARIAL",Font.BOLD,25));
		  f3.setForeground(Color.RED);
		  f4=new JLabel("METHOD: ");
		  f4.setFont(new Font("ARIAL",Font.BOLD,25));
		  f4.setForeground(Color.RED);
		  f5=new JLabel("PREPARATION TIME: ");
		  f5.setFont(new Font("ARIAL",Font.BOLD,25));
		  f5.setForeground(Color.RED);
		  f6= new JLabel("SERVINGS: ");
		  f6.setFont(new Font("ARIAL",Font.BOLD,25));
		  f6.setForeground(Color.RED);		 
		  conn.close();
	
		  
		}
	catch(Exception e)
	{  System.out.println(""+e.getMessage());
	
	}

}
con.add(s1);
con.add(s2);
con.add(s3);
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
con.add(image);
frame.add(con);
frame.setSize(1400,900);
frame.setVisible(true);
s1.setBounds(1200,20,40,40);
s2.setBounds(1250,20,40,40);
s3.setBounds(1150,20,40,40);  

f1.setBounds(60,140,300,300);
f2.setBounds(400,130,150,50);
l1.setBounds(400,150,300,50);
f3.setBounds(400,190,200,50);
l2.setBounds(400,190,1300,100);
f4.setBounds(400,250,200,50);
l3.setBounds(400,200,1300,200);
f5.setBounds(400,305,300,50);
l4.setBounds(400,330,100,50);
f6.setBounds(400,360,200,50);
l5.setBounds(400,380,100,50);
}
  
public void actionPerformed(ActionEvent ae)
{  if(ae.getSource()==s1)
    {  setVisible(false);
	   des8 h=new des8();
     //  h.setVisible(true);
     
	}
else if(ae.getSource()==s3)
{ setVisible(false);
  des10 b1=new des10();
  
}
else if(ae.getSource()==s2)
{ setVisible(false);
	home h=new home();
}
}
}