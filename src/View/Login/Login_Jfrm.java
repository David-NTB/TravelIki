package View.Login;

import Controller.Login_cntrl;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Login_Jfrm extends JFrame {

    public static Login_Jfrm window;
    private JTextField user;
    private JPasswordField passw; // Ganti JTextField dengan JPasswordField
    private JComboBox<String> rol;
    private JToggleButton tglbtnNewToggleButton;
    private JDesktopPane desktopPane;
    public static JFrame frmLoginPanel;

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
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    window = new Login_Jfrm();
                    window.setVisible(true);
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
        setTitle("Welcome To, Traveliki🦇");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(445, 100, 890, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set frame to maximize

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        desktopPane = new JDesktopPane() {
            private Image image;
            {
                try {
                    // Load the background image
                    image = ImageIO.read(Login_Jfrm.class.getResource("/resource/RevDoneAcc1.png"));
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

        addLoginComponents();
        
    }

    private void addLoginComponents() {
        // Tambahkan semua komponen GUI pada desktopPane

        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblUsername.setBounds(785, 48, 120, 30); // Sesuaikan bounds agar lebih besar
        desktopPane.add(lblUsername);

        user = new JTextField();
        user.setBounds(885, 48, 250, 30); // Perbesar ukuran dan sesuaikan posisi
        desktopPane.add(user);
        user.setColumns(10);    

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setFont(new Font("Poppins", Font.BOLD, 16)); // Perbesar teks
        lblPassword.setBounds(785, 84, 120, 30); // Tempatkan di bawah Username
        desktopPane.add(lblPassword);

        passw = new JPasswordField();
        passw.setColumns(10);
        passw.setBounds(885, 84, 250, 30); // Tempatkan di bawah Username
        desktopPane.add(passw);

        // Initialize and set up the JComboBox
        rol = new JComboBox<>();
        rol.setModel(
                new DefaultComboBoxModel<>(new String[] { "Select", "Employee", "Manager", "Admin", "Super_Admin" }));
        rol.setBounds(885, 125, 250, 30); // Position below Password
        desktopPane.add(rol); // Add to the content pane

        // Initialize and set up the JLabel for Role
        JLabel lblRole = new JLabel("Role : "); 
        lblRole.setFont(new Font("Poppins", Font.BOLD, 16)); // Match the font
        lblRole.setBounds(785, 125, 120, 30); // Position below Password
        desktopPane.add(lblRole); // Add to the content pane

        // Login button
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rol.getSelectedItem().toString().equals("Select")) {
                    JOptionPane.showMessageDialog(null, "Select Your Role");
                } else {
                    String un = user.getText();
                    String ps = new String(((JPasswordField) passw).getPassword()); // Use getPassword() for
                                                                                    // JPasswordField
                    String role = rol.getSelectedItem().toString();
                    new Login_cntrl(un, ps, role);
                }
            }
        });
        btnLogin.setBounds(885, 165, 100, 30); // Adjusted position and size
        desktopPane.add(btnLogin);

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
        btnReset.setBounds(1040, 165, 100, 30); // Adjusted posi    tion and size
        desktopPane.add(btnReset);

        // Icon untuk field Username
        JLabel lblUsernameIcon = new JLabel();
        lblUsernameIcon.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/Vector.png")));
        lblUsernameIcon.setBounds(1140, 48, 50, 30); // Sesuaikan posisinya
        desktopPane.add(lblUsernameIcon);

        // icon password
        tglbtnNewToggleButton = new JToggleButton("");
        tglbtnNewToggleButton.setIcon(new ImageIcon(Login_Jfrm.class.getResource("/resource/eye.png")));
        tglbtnNewToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (tglbtnNewToggleButton.isSelected()) {
                    passw.setEchoChar((char) 0);
                } else {
                    passw.setEchoChar('*');
                }
            }
        });

        tglbtnNewToggleButton.setBounds(1140, 84, 34, 30);
        desktopPane.add(tglbtnNewToggleButton);

        // Label for "Already have an account?"
        JLabel lblNotRegisterYet = new JLabel("Sudah punya akun?");
        lblNotRegisterYet.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNotRegisterYet.setBounds(885, 195, 150, 20); // Adjusted position
        desktopPane.add(lblNotRegisterYet);

        // Label for "Register here"
        JLabel lblRegisterHere = new JLabel("Daftar dulu sini !!!");
        lblRegisterHere.setForeground(new Color(0, 51, 153));
        lblRegisterHere.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRegisterHere.setBounds(1040, 195, 150, 20); // Adjusted position with increased x-value for spacing
        
        lblRegisterHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Login_REG loginReg = new Login_REG();
                loginReg.main(null);
            }
        });
        desktopPane.add(lblRegisterHere);

        
    }
}
