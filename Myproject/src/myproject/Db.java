
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.*;

public class Db {
	Db() throws ClassNotFoundException
	{
		JFrame f=new JFrame("aaki");
		f.setLayout(new FlowLayout());
		JTextField t1=new JTextField(30);f.add(t1);
		JButton ins=new JButton("insert");f.add(ins);
		
		f.setVisible(true);
		ins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{System.out.println("hello");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java?serverTimezone=UTC","root","");
					java.sql.Statement stmt=con.createStatement();
					String g=t1.getText();
					System.out.println(g);
					((java.sql.Statement) stmt).executeUpdate("insert into demo values('"+g+"')");
					((Connection) stmt).close();
					con.close();
				}
				catch(SQLException ex)
				{
					System.out.println(ex);
				
				}
				
			}
		});
	}
	public static void main(String[] args) throws ClassNotFoundException
	{
		new Db();
	}

}
