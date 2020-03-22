import java.sql.Array;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminData {
	
	public static boolean checkBook(int id){
		boolean status=false;
		try{
			Connection con=Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Books WHERE id=?");
			ps.setInt(1, id);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean issueBook(int id, String name,String surname, String email){
		boolean status=false;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		try{
			Connection con=Database.getConnection();
			
			PreparedStatement ps=con.prepareStatement("SELECT issue_book(?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2,surname);
			ps.setString(3,email);
			ps.setTimestamp(4, time);
			ps.setInt(5,id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = rs.getBoolean(1);
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
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
	
	public static boolean validate_librarian(String email, String password){
		boolean status = false;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT validation_librarian(?, ?)");
			ps.setString(1, email); 
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
	
	public static int getLibrarianId(String email, String password) {
		int id = 0;
 		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT getLibraryId(?, ?)");
			ps.setString(1, email);
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
	
	public static int saveBook(String name, String desc, String aut_na, String aut_su, int adm_id){
		int status=0;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT new_book(?, ?, ?, ?, ?)");
			ps.setString(1,name);
			ps.setString(2,desc);
			ps.setString(3,aut_na);
			ps.setString(4,aut_su);
			ps.setInt(5, adm_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = rs.getInt(1);
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean delete(String name, String surname){
		boolean status = false;
		try{
			Connection con = Database.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT delete_lib(?, ?)");
			ps.setString(1,name);
			ps.setString(2,surname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = rs.getBoolean(1);
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
