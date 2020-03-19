import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Database {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7328719","sql7328719","Xd55U7zAXZ");
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}
}
