import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminData {
	
	public static boolean validate_admin(String name, String password){
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
	
	public static int getAdminId(String name, String password) {
		int id = 0;
 		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT getAdminId(?, ?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			id = rs.getInt(1);
		}catch(Exception e) {
			System.out.println(e);
		}
 		return id;
	}
	
	public static int save(String name, String surname, String password, String email, int adm_id){
		int status=0;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT save_lib(?, ?, ?, ?, ?)");
			ps.setString(1,name);
			ps.setString(2,surname);
			ps.setString(3,password);
			ps.setString(4,email);
			ps.setInt(5, adm_id);
			ps.executeQuery();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
