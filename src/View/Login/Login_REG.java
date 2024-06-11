package View.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import Model.*;
import Controller.*;

public class Login_REG {

	private JFrame frmLoginPanel;
	private JTextField user;
	private JTextField passw;
	private JComboBox<String> rol;
	private JButton btnLogin;
	private JLabel user_lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
					Login_REG window = new Login_REG();
					window.frmLoginPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_REG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPanel = new JFrame();
		frmLoginPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginPanel.setTitle("Account Registration");
		frmLoginPanel.setBounds(480, 250, 890, 600);
		frmLoginPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginPanel.getContentPane().setLayout(null);

		// JLabel lblLogin = new JLabel("Account Registration Form");
		// lblLogin.setBounds(137, 11, 157, 24);
		// frmLoginPanel.getContentPane().add(lblLogin);

		user = new JTextField();
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String usr = user.getText();
				String ad = Login_Admin.username_exist_admin(usr);
				String em = Login_Employee.username_exist_emp(usr);
				String mng = Login_Manager.username_exist_mngr(usr);

				if (ad == null && em == null && mng == null) {
					user.setBorder(null);
					user_lbl.setVisible(false);
					btnLogin.setEnabled(true);
				} else {
					user.setBorder(new LineBorder(new Color(255, 0, 0)));
					user_lbl.setVisible(true);
					btnLogin.setEnabled(false);
				}
			}
		});

		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
		lblUsername.setBounds(41 + 445, 10, 120, 30); // Sesuaikan bounds agar lebih besar
		frmLoginPanel.getContentPane().add(lblUsername);

		user = new JTextField();
		user.setBounds(140 + 445, 10, 250, 30); // Perbesar ukuran dan sesuaikan posisi
		frmLoginPanel.getContentPane().add(user);
		user.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
		lblPassword.setBounds(41 + 445, 48, 120, 30); // Tempatkan di bawah Username
		frmLoginPanel.getContentPane().add(lblPassword);

		passw = new JPasswordField();
		passw.setColumns(10);
		passw.setBounds(140 + 445, 48, 250, 30); // Tempatkan di bawah Username
		frmLoginPanel.getContentPane().add(passw);

		// Register button
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (rol.getSelectedItem().toString().equals("Select")) {
					JOptionPane.showMessageDialog(null, "Select Your Role");
				} else {
					String un = user.getText();
					String ps = passw.getText();
					String role = rol.getSelectedItem().toString();
					new Login_REG_ctrl(un, ps, role);
					JOptionPane.showMessageDialog(null, "Registration Successful");

					// Tutup jendela Login_REG
					frmLoginPanel.dispose();

					// Tampilkan kembali splash screen
					// try {
					// LOG_Splash.main(null);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
				}
			}
		});
		btnRegister.setBounds(590, 135, 100, 30); // Menyesuaikan dengan posisi dan ukuran tombol "Reset"
		frmLoginPanel.getContentPane().add(btnRegister);

		// Reset button
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Clear input fields
				user.setText("");
				passw.setText("");
				rol.setSelectedIndex(0); // Reset combo box to default
			}
		});
		btnReset.setBounds(330 + 415, 135, 100, 30); // Adjusted position and size
		frmLoginPanel.getContentPane().add(btnReset);

		// Initialize and set up the JComboBox
		rol = new JComboBox<>();
		rol.setModel(
				new DefaultComboBoxModel<>(new String[] { "Select", "Employee", "Manager", "Admin", "Super_Admin" }));
		rol.setBounds(140 + 447, 84, 250, 30); // Position below Password
		frmLoginPanel.getContentPane().add(rol); // Add to the content pane

		// Initialize and set up the JLabel for Role
		JLabel lblRole = new JLabel("Role : ");
		lblRole.setFont(new Font("Poppins", Font.BOLD, 16)); // Match the font
		lblRole.setBounds(41 + 447, 84, 120, 30); // Position below Password
		frmLoginPanel.getContentPane().add(lblRole); // Add to the content pane

		user_lbl = new JLabel("Username Already Exist !!!");
		user_lbl.setForeground(new Color(255, 0, 0));
		user_lbl.setVisible(false);
		user_lbl.setBounds(124, 96, 207, 14);
		frmLoginPanel.getContentPane().add(user_lbl);

		JLabel lblImageBottom2 = new JLabel(new ImageIcon(Login_Jfrm.class.getResource("/resource/RevDone1.png")));
		lblImageBottom2.setBounds(0, 0, 889, 602); // Atur ukuran dan posisi sesuai kebutuhan
		frmLoginPanel.getContentPane().add(lblImageBottom2);
	}
}