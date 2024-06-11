package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_Manager {

	private String usr;
	private String pw;
	private String rl;

	public static String mngr_data_chek(String give_username, String give_password, String give_rol) {
		Connection obj = Database.getconnection();

		String comnd = "SELECT `username`, `password` FROM `login_manager` WHERE username=? AND password=? AND role=?";

		String user = null;
		String pass;

		try {
			PreparedStatement ps = obj.prepareStatement(comnd);
			ps.setString(1, give_username);
			ps.setString(2, give_password);
			ps.setString(3, give_rol);
			ps.execute();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = rs.getString("username");
				pass = rs.getString("password");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public static String username_exist_mngr(String give_username) {
		Connection obj = Database.getconnection();

		String comnd = "SELECT username FROM login_manager WHERE username=?";

		String user = null;

		try {
			PreparedStatement ps = obj.prepareStatement(comnd);
			ps.setString(1, give_username);

			ps.execute();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = rs.getString("username");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public void prepare_Manager_data(String username, String password, String role) {
		this.usr = username;
		this.pw = password;
		this.rl = role;

	}

	public void manager_data_insert() {
		Connection ok = Database.getconnection();

		String query = "INSERT INTO `login_Manager`(`username`,`password`,`role`) VALUES (?,?,?)";

		try {
			PreparedStatement gas = ok.prepareStatement(query);
			gas.setString(1, query);
			gas.setString(2, query);
			gas.setString(3, query);
			gas.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
