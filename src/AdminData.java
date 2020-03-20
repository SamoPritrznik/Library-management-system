import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminData {
	public static boolean validate_admin(String name,String password){
		boolean status = false;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT validation_admin(?, ?)");
			ps.setString(1, name); 
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			if(rs.getBoolean(1) == true) {
				con.close();
				return true;
			}else {
				con.close();
				return false;
			}
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
