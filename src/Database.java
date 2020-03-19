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
			con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/32bgCe07X7","32bgCe07X7","bxv4toz8NW");
			
		}catch(Exception e){System.out.println(e);}
		return con;
	}
}
