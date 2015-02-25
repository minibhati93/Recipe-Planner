import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class cuisine extends JFrame implements ActionListener
{  JButton b1,b2;
   JTextField f1,f2;
   JLabel j1,j2,j3,j4,j5,t1;
   JTextArea jn1;
   Container con;
   JFrame f;
    cuisine()
     {  con=getContentPane();
       	f=new JFrame("Around the World ");
    	//ImageIcon i1=new ImageIcon("bimage/coll1.jpg");
    	//j1=new JLabel(i1);
       
       	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1=new ImageIcon("bimage/way.jpg");
        j5=new JLabel(i1);
        con.setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        JTextArea jn1=new JTextArea();
        jn1.setRows(60);
        jn1.setColumns(10);
       // p1.add(jn1);
        con.add(jn1);
        Connection conn=null;
        Statement stmt=null;
              try{
        	Class.forName("com.mysql.jdbc.Driver");
    		conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
    		stmt=conn.createStatement();
    		ResultSet rs=stmt.executeQuery("select * from article");
    	    String z[]=new String[20];
    	    int ctr=0;
    	    
    		while(rs.next())
    	    { 
    			//System.out.println(""+rs.getString("name"));
    			z[ctr]=rs.getString("name");
    	        System.out.println(z[ctr]);
    	      
    	      t1=new JLabel(z[ctr]);
    	      ctr++;
    	      con.add(t1);
            }
    		// j3=new JLabel(z);
    		 //   con.add(j3);
    	    	  
            
        	j1=new JLabel("Enter the number of cuisine you want to view");
    		f1=new JTextField(5); 
            con.add(j1);
            con.add(f1);
            b2=new JButton("View");
            con.add(b2);
            b2.addActionListener(this);
            conn.close();
            t1.setBounds(10,10,100,100);
            j3.setBounds(30,40,100,100);
            b2.setBounds(100,100,100,100);
        con.add(j5);
        con.add(f);
      
   	   f.setSize(1400,900);
   	 f.setVisible(true);
   	   //con.add(j1);
//   	   f.add(con);
       //frame.setSize(300,300);
       //frame.setVisible(true);
      
       
       }
      catch(Exception e)
      {
    	  System.out.println(""+e.getMessage());
      }
            
     }
  
public void actionPerformed(ActionEvent ae)
  {  if(ae.getSource()==b2)
	{  
	   JFrame frame=new JFrame("Around the World ");
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
	    int a=Integer.parseInt(f1.getText());
        Connection conn=null;
        Statement stmt=null;
          try{
    	Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from article where sno=\'"+a+"\'");
	    String z="";
        while(rs.next())
        { z=rs.getString("matter");
          j4=new JLabel(z);
           jn1.setText(z);
        }
       
		conn.close();
		con.add(j5);
		
		frame.setSize(1000,700);
		frame.setVisible(true);
		
		
          }
          catch(Exception e)
          {
        	  System.out.println(""+e.getMessage());
          }
	

}

}
  }

	
