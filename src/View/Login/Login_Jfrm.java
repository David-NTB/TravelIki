package View.Login;

import Controller.Login_cntrl;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_Jfrm extends JFrame {

    public static JFrame frmLoginPanel;
    public static Login_Jfrm window;
    private JTextField user;
    private JTextField passw;
    private JComboBox rol;
    private JToggleButton tglbtnNewToggleButton;

    /**
     * Create the application.
     */
    public Login_Jfrm() {
        initialize();
    }

    /** 
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    // UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                    window = new Login_Jfrm();
                    window.frmLoginPanel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frmLoginPanel = new JFrame();
        frmLoginPanel.setSize(890, 600); // Set ukuran menjadi 889x602
        frmLoginPanel.setType(Type.POPUP);
        frmLoginPanel.setTitle("Welcome, Traveliki🦇");
        frmLoginPanel.setBounds(480, 250, 890, 600); // Set ukuran menjadi 889x602
        frmLoginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLoginPanel.getContentPane().setLayout(null);
        frmLoginPanel.getContentPane().setBackground(Color.orange);


        // tambahkan image

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        frmLoginPanel.getContentPane().add(lblLogin, BorderLayout.CENTER);

        // frmLoginPanel.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(6, 6, 31));
        panel.setPreferredSize(new Dimension(600, 400)); // Mengatur ukuran pan

        add(panel);

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

        // Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rol.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(null, "Select Your Role");
                } else {
                    String un = user.getText();
                    String ps = new String(((JPasswordField) passw).getPassword()); // Use getPassword() for JPasswordField
                    String role = rol.getSelectedItem().toString();
                    new Login_cntrl(un, ps, role);
                }
            }
        });
        btnLogin.setBounds(180 + 410, 135, 100, 30); // Adjusted position and size
        frmLoginPanel.getContentPane().add(btnLogin);

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

       // Icon untuk field Username
        JLabel lblUsernameIcon = new JLabel();
        lblUsernameIcon.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/Vector.png")));
        lblUsernameIcon.setBounds(440 + 400, 10, 50, 30); // Sesuaikan posisinya
        frmLoginPanel.getContentPane().add(lblUsernameIcon);

        // icon password
        tglbtnNewToggleButton = new JToggleButton("");
        tglbtnNewToggleButton.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/eye.png")));
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (tglbtnNewToggleButton.isSelected()) {
                    ((JPasswordField) passw).setEchoChar((char) 0);
                } else {
                    ((JPasswordField) passw).setEchoChar('*');
                }
            }
        });

        tglbtnNewToggleButton.setBounds(440 + 400, 48, 34, 30);
        frmLoginPanel.getContentPane().add(tglbtnNewToggleButton);

        // Label for "Already have an account?"
        JLabel lblNotRegisterYet = new JLabel("Sudah punya akun?");
        lblNotRegisterYet.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNotRegisterYet.setBounds(180 + 410, 170, 150, 20); // Adjusted position
        frmLoginPanel.getContentPane().add(lblNotRegisterYet);

        // Label for "Register here"
        JLabel lblRegisterHere = new JLabel("Daftar dulu sini !!!");
        lblRegisterHere.setForeground(new Color(0, 51, 153));
        lblRegisterHere.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRegisterHere.setBounds(330 + 415, 170, 150, 20); // Adjusted position with increased x-value for spacing
        lblRegisterHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Login_REG loginReg = new Login_REG();
                loginReg.main(null);
            }
        });
        frmLoginPanel.getContentPane().add(lblRegisterHere);

        JLabel lblImageBottom2 = new JLabel(new ImageIcon(Login_Jfrm.class.getResource("/resource/RevDone1.png")));
        lblImageBottom2.setBounds(0, 0, 889, 602); // Atur ukuran dan posisi sesuai kebutuhan
        frmLoginPanel.getContentPane().add(lblImageBottom2);

    }
}
