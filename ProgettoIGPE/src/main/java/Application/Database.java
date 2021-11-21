package Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Database {
	
	public static void insertUsers(String Username,String Password) {
		Connection con=DbConnection.connect();
		PreparedStatement ps=null;
		try {
			String PasswordCrypted=CryptPass(Password);
			String sql="INSERT INTO users (Username,Password) VALUES(?,?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Username);
			ps.setString(2, PasswordCrypted);
			ps.execute();
			ps.close();
			System.out.println("dato inserito");
		}
		catch(SQLException e){System.out.println(e.toString());}
	}
	public static void deleteAll() {
		Connection con=DbConnection.connect();
		PreparedStatement ps=null;
		try {
			String sql="DELETE FROM users";
			ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
			System.out.println("Tabella Cancellata");
		}
		catch(SQLException e){System.out.println(e.toString());}
	}
	public static String CryptPass(String originalPassword) {
		 String Crypted= BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
		 return Crypted;		
	}
		public static Boolean Checkuser(String user,String Pass) throws SQLException {
			String sql = "SELECT Username, Password FROM users ;";
			Connection con=DbConnection.connect();
			PreparedStatement ps=null;
			ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				if (user.matches(rs.getString("Username")) && BCrypt.checkpw(Pass,rs.getString("Password"))) {
					ps.close();
					return true;
				}
				
			}
			ps.close();
			return false;
	}
}
