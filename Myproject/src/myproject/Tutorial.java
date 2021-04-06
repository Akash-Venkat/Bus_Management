/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import static java.time.Clock.system;
import static javafx.beans.binding.Bindings.select;
import javax.swing.*;  
public class Tutorial {  
JFrame f;  
Tutorial()throws ClassNotFoundException{  
    f=new JFrame();  
    
    JPanel p1=new JPanel();  
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel(); 
    JPanel p4=new JPanel(); 
    JTabbedPane tp=new JTabbedPane(); 
    JLabel l1,l2,l3,l4;
    l1 = new JLabel("Book name");
    l2=new JLabel("department");
    l3=new JLabel("search book name");
    l4=new JLabel("search results");
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JTextField t3=new JTextField(10);
    JTextField t4=new JTextField(10);
    JButton ins=new JButton("insert");
    JButton ins1=new JButton("get");
    tp.setBounds(100,100,800,800);  
    tp.add("Add book",p1);  
    tp.add("view book",p2);  
    tp.add("Book list",p3);    
    tp.add("Book list",p4);
    p1.add(l1);
    p1.add(t1);
    p1.add(l2);
    p1.add(t2);
    p1.add(ins);
    p2.add(l3);
    p2.add(t3);
    p2.add(l4);
    p2.add(t4);
    p2.add(ins1);
    f.add(tp);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
    
    
    ins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{System.out.println("hello");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/first?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					String g=t1.getText();
                                        String g1=t2.getText();
					System.out.println(g);
					((java.sql.Statement) stmt).executeUpdate("insert into lib values('"+g+"','"+g1+"')");
					((Connection) stmt).close();
					con.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}
				
			}
		});
    
    
      ins1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{System.out.println("hello");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/first?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					String g2=t3.getText();
                                        ResultSet rs;
                                       rs = stmt.executeQuery("select dep from lib where name=t3.getText()");
					t4.setText(String(rs));
					
                                   //((java.sql.Statement) stmt).executeQuery("select dep from lib where name=g2");
					((Connection) stmt).close();
					con.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}
				
			}

        private String String(ResultSet rs) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
		});
   
}  
public static void main(String[] args)     throws ClassNotFoundException{
 {  
                            Tutorial tutorial = new Tutorial();  
}

    } }

       