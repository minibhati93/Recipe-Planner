import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
class reg extends JFrame implements ActionListener
{
            JPanel panel;
	  		JLabel un,un1,un2,z1;
			JTextField  u1,u2,u3,u4;
			JPasswordField p1;
  			Choice j1,j2,j3,j4,j5,j6,j7,j8,r1;
			JButton  b1,b2,b3,b4;
		
reg()
{   Container con=getContentPane();

	j1= new Choice();
	j1.add("date");	
     for(int i = 1; i<=31; i++)
      {
	     j1.add(String.valueOf(i));
      }
	j1.select(0);

    j2 = new Choice();
    j2.add("Month");
	j2.add("January");
	j2.add("February");
	j2.add("March");
	j2.add("April");
	j2.add("May");
	j2.add("June");
	j2.add("July");
	j2.add("August");
	j2.add("September");
	j2.add("October");
	j2.add("November");
	j2.add("December");
	j2.select(0); 
	
    j3=new Choice();
    j3.add("year");
    for(int j=1990 ; j<=2010; j++) 
     {
	   j3.add(String.valueOf(j));
     }
	j3.select(0);
	j4=new Choice();
	j4.add("User");
	j4.add("Chef");
	j4.select(0);
	r1=new Choice();
	r1.add("Male");
	r1.add("Female");
   
	JFrame frame = new JFrame("Join us");
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frame.setVisible(true);
	frame.setSize(500,500);
	panel = new JPanel(new GridLayout(10,2,10,20));
	panel.setBackground(Color.yellow);
	/*ImageIcon i4=new ImageIcon("pics/w.jpg");
	z1=new JLabel(i4);
	panel.add(z1);*/
	un=new JLabel("Name :");
    panel.add(un);
	u1=new JTextField(5);
 	panel.add(u1);
 	
	panel.add(new JLabel("Gender :" ));
	panel.add(r1);
    
 	
	panel.add(new JLabel("Password :" ));
	p1=new JPasswordField(5);
	panel.add(p1);
    panel.add(new JLabel("Email :" ));
  	u3=new JTextField(20);
	panel.add(u3);
	panel.add(new JLabel("Date Of  Birth:"));
	panel.add(j1);
	panel.add(j2);
	panel.add(j3);
	panel.add(new JLabel("Type of access"));
	panel.add(j4);
	b1= new JButton(" OK ");
	b2= new JButton(" RESET");
	b3= new JButton(" CANCEL");
	panel.add(b1);
	panel.add(b2);
  	panel.add(b3);
  	
	con.add(panel);
	frame.add(panel);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
} 
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()== b1)
	{
       String uname=u1.getText();
		char[] pass=p1.getPassword();
        String s1="";
   	    for(int i=0;i<pass.length;i++)
   	      {
	    	  s1=s1+pass[i];
    	  }
		String em=u3.getText();
		int date=Integer.parseInt(j1.getSelectedItem());
		String month=(String)j2.getSelectedItem();
		int year=Integer.parseInt(j3.getSelectedItem());
		String gender=(String)r1.getSelectedItem();
		String type=(String)j4.getSelectedItem();
			
		if(uname.trim().equals(""))
			JOptionPane.showMessageDialog(null, "please enter username ");
		else if(s1.trim().equals(""))
			JOptionPane.showMessageDialog(null, "please enter valid password");
			
		else 		
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			Statement stmt=null;
			try
		  {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql:///receipe","root",""); 
			pstmt=conn.prepareStatement("insert into register(uname,gender,pass,type,email,month,year,date) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1,uname);
			pstmt.setString(2,gender);
			pstmt.setString(3,s1);
			pstmt.setString(4,type);
			pstmt.setString(5,em);
			pstmt.setString(6,month);
			pstmt.setInt(7,year);
			pstmt.setInt(8,date);
	        
			int rs1=pstmt.executeUpdate();
			if(rs1>0)
			System.out.println("Inserted");
			else
			System.out.println(" not Inserted");
			
			stmt=conn.createStatement();
			profile p=new profile(uname,s1);
			
			conn.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			//setVisible(false);
		
		}
	}
}
}
