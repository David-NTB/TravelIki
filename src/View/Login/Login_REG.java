package View.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.border.*;
import Model.*;
import Controller.*;
import java.io.IOException;

public class Login_REG {

	private JFrame frmLoginPanel;
	private JTextField user;
	private JTextField email;
	private JTextField notelpon;
	private JPasswordField passw;
	private JComboBox<String> rol;
	private JButton btnRegister;
	private JLabel user_lbl;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
		frmLoginPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmLoginPanel.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		desktopPane = new JDesktopPane() {
			private Image image;
			{
				try {
					// Load the background image
					image = ImageIO.read(Login_Jfrm.class.getResource("/resource/RevisiDoneRegis.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (image != null) {
					g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		addRegistrationComponents();
	}

	private void addRegistrationComponents() {
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Poppins", Font.BOLD, 16));
		lblUsername.setBounds(785, 18, 120, 30);
		desktopPane.add(lblUsername);

		user = new JTextField();
		user.setBounds(885, 18, 250, 30);
		desktopPane.add(user);
		user.setColumns(10);

		user_lbl = new JLabel("Username Already Exist !!!"); 
		user_lbl.setForeground(new Color(128, 0, 0));
		user_lbl.setFont(new Font("Poppins", Font.PLAIN, 10));
		user_lbl.setVisible(false);
		user_lbl.setBounds(886, 37, 250, 30); // ubah ini
		desktopPane.add(user_lbl);

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
					btnRegister.setEnabled(true);
				} else {
					user.setBorder(new LineBorder(new Color(255, 0, 0)));
					user_lbl.setVisible(true);
					btnRegister.setEnabled(false);
				}
			}
		});

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Poppins", Font.BOLD, 16));
		lblEmail.setBounds(785, 55, 120, 30);
		desktopPane.add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(885, 55, 250, 30);
		desktopPane.add(email);

		JLabel lblTelpon = new JLabel("No. Telepon : ");
		lblTelpon.setFont(new Font("Poppins", Font.BOLD, 16));
		lblTelpon.setBounds(785, 95, 120, 30);
		desktopPane.add(lblTelpon);

		notelpon = new JTextField();
		notelpon.setColumns(10);
		notelpon.setBounds(885, 95, 250, 30);
		desktopPane.add(notelpon);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Poppins", Font.BOLD, 16));
		lblPassword.setBounds(785, 135, 120, 30);
		desktopPane.add(lblPassword);

		passw = new JPasswordField();
		passw.setColumns(10);
		passw.setBounds(885, 135, 250, 30);
		desktopPane.add(passw);

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rol.getSelectedItem().toString().equals("Select")) {
					JOptionPane.showMessageDialog(null, "Select Your Role");
				} else {
					String un = user.getText();
					String ps = new String(passw.getPassword());
					String emailText = email.getText();
					String phone = notelpon.getText();
					String role = rol.getSelectedItem().toString();
					new Login_REG_ctrl(user, emailText, notelpon, passw, role);
					JOptionPane.showMessageDialog(null, "Registration Successful");

					frmLoginPanel.dispose();
				}
			}
		});
		btnRegister.setBounds(885, 220, 100, 30);
		desktopPane.add(btnRegister);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user.setText("");
				email.setText("");
				notelpon.setText("");
				passw.setText("");
				rol.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(1035, 220, 100, 30);
		desktopPane.add(btnReset);

		rol = new JComboBox<>();
		rol.setModel(
				new DefaultComboBoxModel<>(new String[] { "Select", "Employee", "Manager", "Admin", "Super_Admin" }));
		rol.setBounds(885, 175, 250, 30);
		desktopPane.add(rol);

		JLabel lblRole = new JLabel("Role : ");
		lblRole.setFont(new Font("Poppins", Font.BOLD, 16));
		lblRole.setBounds(785, 175, 120, 30);
		desktopPane.add(lblRole);
	}
}
