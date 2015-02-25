
	import javax.swing.*;

	import java.awt.*;
	import java.awt.event.*;
	class wel
	{
	public static void main(String args[])
	   {
	   new abc();
	   }
	}

	class abc extends JFrame implements ActionListener,Runnable
	{  Thread t;
	   JLabel j1,j2,j3,j4,j5,j6,l1,l2;
	   JButton b1,b2,b3,b4,b5,b6;
	   JPanel panel,p1,p2;
	   int ctr=0;
	   public void run()
		{
		   while(true)
			{
			   try
			   	{
				   t.sleep(500);
			   	}
			   catch(Exception e)
			   {
			   }		
			   if(ctr==0)
			   {
				   int rd,rg,b1;
				    rd=(int)(Math.random()*255);
				    rg=(int)(Math.random()*255);
				    b1=(int)(Math.random()*255);
				    Color fcolor=new Color(rd,rg,b1);
				   ctr=1;
			   }
			   else
			   {
				   int rd,rg,b1;
				    rd=(int)(Math.random()*255);
				    rg=(int)(Math.random()*255);
				    b1=(int)(Math.random()*255);
				    Color fcolor=new Color(rd,rg,b1);
				   ctr=0;
			   }
		}

		}
		
		
	 public abc()
	   {  
	      
	      JFrame frame=new JFrame("Delicious");
	      Container con=getContentPane();
	      con.setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		  //panel=new JPanel();
		 
//		 t=new Thread();
		// t.start();
		 JPanel p=new JPanel();
		 con.setBackground(Color.DARK_GRAY);
		 j1=new JLabel("WELCOME");
		 j1.setForeground(Color.black);
		 j1.setFont(new Font("Times new roman",Font.BOLD,65));
		 
		
		  b1=new JButton("Home");
		  b1.setFont(new Font("ARIAL",Font.BOLD,25));
		  b1.setBackground(Color.red);
		 //con.add(b1);
		  b2=new JButton("Join us");
		  b2.setFont(new Font("ARIAL",Font.BOLD,25));
		  b2.setBackground(Color.yellow);
		  //con.add(b2);
		 
		  b4=new JButton("Search");
		  b4.setFont(new Font("ARIAL",Font.BOLD,25));
		  b4.setBackground(Color.green);
		 //con.add(b4);
		  b5=new JButton("About us");
		  b5.setFont(new Font("ARIAL",Font.BOLD,25));
		  b5.setBackground(Color.pink);
		  b6=new JButton("Cuisines");
		  b6.setFont(new Font("ARIAL",Font.BOLD,25));
		  b6.setBackground(Color.blue);
		  con.add(b6);
		 
	     ImageIcon i4=new ImageIcon("bimage/coll1.jpg");
	     j6=new JLabel(i4);
		   
		    
		  // t=new Thread(this);
		   //t.start();
			
		  
		
		 con.add(j1);
	     con.add(b1);
	     con.add(b2);
	     con.add(b4);
	     con.add(b5);
	     
	     con.add(j6);
		  frame.add(con); 
		  frame.setSize(1500,900);
		  frame.setVisible(true);
		 b1.setBounds(200,25,200,50 );
		  b2.setBounds(400,25,200,50 );
		  b4.setBounds(600,25,200,50 );
		  b5.setBounds(800,25,200,50);
		  b6.setBounds(1000,25,200,50);
		  j1.setBounds(490,250,500,200);
		  b1.addActionListener(this);
		  b2.addActionListener(this); 
		
		  b4.addActionListener(this);
		  b5.addActionListener(this);  
		  b6.addActionListener(this);


		}

	public void actionPerformed(ActionEvent ae)
	{   if(ae.getSource()==b2)
	      { login l=new login();       
	      }
	    
	    else if(ae.getSource()==b1)
	    {  home h=new home();
	    
	    }
	    else if(ae.getSource()==b4)
	    {  sch s=new sch();
	    	//s.setVisible(true);
	    
	    }
	    else if(ae.getSource()==b6)
	    {   JOptionPane.showMessageDialog(null,"You will know about cuisines across the world");
	    	cuisine c=new cuisine();
	    
	    }

	}  
	}



