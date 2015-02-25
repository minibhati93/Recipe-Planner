import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class home extends JFrame implements ActionListener
{  JButton s1,c1,c2,c3,c4;
   JLabel l1,l2,l3,l4,l5,t2,t1,c5,s,j7;
   JTextArea jt;
   JFrame frame;
   Container con;
   home()
   {  
      JFrame frame=new JFrame("Home");
       Container con=getContentPane();
      // con.setLayout(new FlowLayout());
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  

	  ImageIcon d1=new ImageIcon("bimage/back.jpg");
  	  s1=new JButton(d1);
  	  s1.addActionListener(this);
  	  
	  
	  ImageIcon i6=new ImageIcon("pics/bev.jpg");
	  l1=new JLabel(i6);
	 
	  c1=new JButton("Beverages");
	  c1.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
	  c1.setBackground(Color.blue);
	  
	  
	  c1.addActionListener(this);
	  
	  
      ImageIcon v=new ImageIcon("pics/logo.jpg");
      j7=new JLabel(v);
	  
	
	  
	  ImageIcon i7=new ImageIcon("pics/mc.jpg");
	  l2=new JLabel(i7);
	  
	
	  c2=new JButton("Main course");
	  c2.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
	  c2.setBackground(Color.yellow);
	 
	  c2.addActionListener(this);
	  
	  ImageIcon i8=new ImageIcon("pics/strt.jpg");
	  l3=new JLabel(i8);
	
	  c3=new JButton("Appetizers");
	  c3.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
	  c3.setBackground(Color.pink);
	 
	  c3.addActionListener(this);
	  
	  ImageIcon i9=new ImageIcon("pics/des.jpg");
	  l4=new JLabel(i9);
	 
	  c4=new JButton("Desserts");
	  c4.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
	  c4.setBackground(Color.green);
	 
	  c4.addActionListener(this);
      
	  c5=new JLabel("TIP OF THE DAY");
      c5.setFont(new Font("ARIAL",Font.BOLD,35));
	  c5.setBackground(Color.red);
	 
	  
	ImageIcon i=new ImageIcon("pics/e.jpg");
	s=new JLabel(i);
	  con.add(s1);
	  con.add(j7);
	  con.add(l1);
	  con.add(c1);
	  con.add(l2);
	  con.add(c2);
	  con.add(l3);
	  con.add(c3);
	  con.add(l4);
      con.add(c4);
	  con.add(c5);
	 
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  Statement stmt=null;
      try  
	  {
	    Class.forName("com.mysql.jdbc.Driver");
	    conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
	    stmt=conn.createStatement();
	    int a=(int)(Math.random()*30);
	    if(a==0)
	    { a++;
         }
	    System.out.println(a);
	    ResultSet rs=stmt.executeQuery("select * from tip where sno=\'"+a+"\'");
	    String b="";
	
	  while(rs.next())
	  { b=rs.getString("tipday");
	    System.out.print("hello");
	  
	  } 
	    
	   jt=new JTextArea();
		jt.setRows(10);
		jt.setColumns(11);
		jt.setForeground(Color.DARK_GRAY);
		jt.setFont(new Font("ARIAL",Font.BOLD,18));
		jt.setEditable(false);
		jt.setOpaque(false);
	    JScrollPane scrollPane = new JScrollPane(jt); 
		jt.setLineWrap(true);
	 	jt.setText(b);
	  // jt=new JLabel(b);
	 	
		//con.add(jt);
		//con.add(t1);
		jt.setBounds(500,200,300,300);
		//JLabel man=new JLabel();
		//man.add(jt);
		//man.setBounds(300,0,200,200);
		//man.add(jt);
	con.add(jt);
        
		}
catch(Exception ae)
{  System.out.println("tip null"+ae.getMessage());

}

 
      con.add(s);
	  frame.add(con);
	  frame.setSize(1400,900);
	  frame.setVisible(true);
	  s1.setBounds(600,5,79,80);
	  j7.setBounds(400,280,500,500);
	  l1.setBounds(30,0,300,300);
	  c1.setBounds(30,275,300,50);
	  l2.setBounds(30,330,300,300);
	  c2.setBounds(30,585,300,50);
	  l3.setBounds(1000,0,300,300);
	  c3.setBounds(1000,282,300,50);
	  l4.setBounds(1000,330,300,300);
      c4.setBounds(1000,589,300,50);
      c5.setBounds(500, 80, 300, 80);
      t1.setBounds(700, 70, 300, 80);
     
   }

public void actionPerformed(ActionEvent e) {
	{ if(e.getSource()==c1)
	     { bev b=new bev();
		  }
	  else if(e.getSource()==c2)
	   {  maincourse m=new maincourse();
	    }
	  else if(e.getSource()==c3)
	  {		  start s=new start();
	  }
	  else if(e.getSource()==c4)
	  {   des d=new des();
		  
	  }
	  else if(e.getSource()==s1)
      {   abc h=new abc();
	      


	  }
	 
}
}
}