// connect with database
// mysql-connector-java-8.0.28.jar library install
package bank.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Dheeraj@123");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
