//import java.sql.Connection;
package myproject;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gj
 */
public class MyConnection {
    public static Connection getConnection(){
    Connection con=null;
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost/login_register?serverTimezone=UTC","root","");
    
}catch(Exception ex){
    System.out.println(ex.getMessage());
}
   return con; 
}
}
