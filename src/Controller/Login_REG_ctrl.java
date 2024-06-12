package Controller;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.Login_Admin;
import Model.Login_Employee;
import Model.Login_Manager;
import View.Dashboard_JFrm;

public class Login_REG_ctrl {

	public Login_REG_ctrl(String un, String ps, String rol) {
		// Employee
		if (rol.equals("Employee")) {
			Login_Employee.emp_data_chek(un, ps, rol);
			Login_Employee.emp_data_chek(un, ps, rol);
		}

		// MAnager
		if (rol.equals("Manager")) {
			Login_Manager loginAdmin = new Login_Manager();
			loginAdmin.prepare_Manager_data(un, ps, rol);
			loginAdmin.manager_data_insert();

		}

		// Admin
		if (rol.equals("Admin")) {
			Login_Admin Login_m = new Login_Admin();
			Login_m.prepare_admin_data(un, ps, rol);
			Login_m.admin_data_insert();
			//

		}

	}

    public Login_REG_ctrl(JTextField user, String emailText, JTextField notelpon, JPasswordField passw, String role) {
        //TODO Auto-generated constructor stub
    }

}
