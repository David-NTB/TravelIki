		package View;

		import Controller.Login;
		import java.awt.BorderLayout;
		import java.awt.EventQueue;
		import java.awt.Font;
		import java.awt.Graphics;
		import java.awt.Image;

		import javax.swing.JFrame;
		import javax.swing.JInternalFrame;
		import javax.swing.JPanel;
		import javax.swing.UIManager;
		import javax.swing.border.EmptyBorder;

		import Model.Enums;
		import View.All_Panel.*;
		import View.Login.*;

		import javax.swing.JDesktopPane;
		import java.awt.Color;
		import javax.swing.JMenuBar;
		import javax.swing.JMenu;
		import javax.swing.JMenuItem;
		// import java.awt.event.ActionListener;
		import java.awt.event.KeyEvent;
		// import java.awt.image.BufferedImage;
		// import java.io.File;
		import java.io.IOException;
		// import java.net.URL;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
		import java.awt.Toolkit;

		import javax.imageio.ImageIO;
		import javax.swing.Box;
		import javax.swing.ImageIcon;

		import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
		// import net.miginfocom.swing.MigLayout;
		import net.miginfocom.swing.MigLayout;
		import javax.swing.JLabel;
		// import java.awt.GridLayout;
		import java.awt.Dialog.ModalExclusionType;
		// import java.awt.Window.Type;
		// import javax.swing.JButton;
		// import java.awt.ComponentOrientation;
		// import java.awt.Component;
		import java.awt.Point;
		// import javax.swing.JCheckBoxMenuItem;
		import javax.swing.UnsupportedLookAndFeelException;

		public class Menu_Dashboard extends JFrame {

			// ini penginisialisasikan apapun itu nantinya yang di buat :)
			private final JPanel contentPane;
			private JDesktopPane desktopPane;
			private final JMenu mnHome;
			// private JMenu mnHomeEmp;
			private JMenuItem mntmAddCategory;
			private JMenuItem mntmAddProduct;
			private JMenuItem mntmAddUnit;
			private final JMenu mnBillingInfo;
			private JMenuItem mntmCreateCashMemo;
			// private JMenuItem mntmP;
			private final JMenu mnExtra;
			private JMenuBar menuBar;
			// private JMenu Logout;
			// private JMenu mnBackupRestore;
			// private JMenuItem mntmBackupData;
			// private JMenuItem mntmRestoreData;
			// private JMenu keluar;

			/**
			 * Launch the application. || Pemanggilan aplikasi 
			 * ===============================================
			 */
				public static void main(String[] args) {
				EventQueue.invokeLater(() -> {
					try {
						// UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
						Menu_Dashboard frame = new Menu_Dashboard(Enums.role.CUSTOMER);
						frame.setVisible(true);
					} catch (Exception e) {
						System.err.println(e);
					}
				});
			}

			public Menu_Dashboard(Enums.role give_role) {
				setTitle("WWW.Traveliki.com");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setExtendedState(JFrame.MAXIMIZED_BOTH); // Maksimalkan JFrame saat dijalankan
				setIconImage(Toolkit.getDefaultToolkit().getImage(Menu_Dashboard.class.getResource("/resource/sp (4).png")));
				setBackground(new Color(0, 51, 153));

				JPanel contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));

				desktopPane = new JDesktopPane() {
					private Image image;
					{
						try {
							// Load the background image
							image = ImageIO.read(Menu_Dashboard.class.getResource("/resource/RevDoneAcc1.png"));
						} catch (IOException e) {
							System.err.println(e);
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

				// Add menu bar
				JMenuBar menuBar = new JMenuBar();
				setJMenuBar(menuBar);

				// Add components to the desktop pane
				// addLoginComponents();

				// Buat label untuk menampilkan teks "WWW.Traveliki.com" di tengah
				JLabel titleLabel = new JLabel("WWW.Traveliki.com");
				titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
				titleLabel.setForeground(Color.BLACK); // Atur warna teks sesuai keinginan
				titleLabel.setHorizontalAlignment(JLabel.CENTER);

				// Tambahkan label ke menu bar
				menuBar.add(Box.createHorizontalGlue()); // Glue untuk menyebarkan komponen ke tepi
				menuBar.add(titleLabel);
				menuBar.add(Box.createHorizontalGlue()); // Glue untuk menyebarkan komponen ke tepi lainnya
				this.contentPane = new JPanel();

				mnHome = new JMenu("Home");
				mnHome.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/home (2).png")));
				menuBar.add(mnHome);

				mnBillingInfo = new JMenu("Info Pembayaran");
				mnBillingInfo.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/ingpo.png")));
				menuBar.add(mnBillingInfo);

				mnExtra = new JMenu("About");
				mnExtra.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/sp (11).png")));
				mnExtra.setLocation(new Point(43, 100));
				menuBar.add(mnExtra);

				switch (give_role) {
					case ADMIN -> {
						System.out.println("[ LOGIN ADMIN ]");

						// LOGIN MENU 

					}

					case EMPLOYEE -> {
						System.out.println("[ LOGIN EMPLOYEE ]");

						// LOGIN MENU

					}

					case CUSTOMER -> {
						System.out.println("[ LOGIN CUSTOMER ]");
						
						// LOGIN MENU

					}

					default -> throw new AssertionError();
				}	

				// SEMENTARA
				menu_insert_kategori();
				menu_insert_layanan();
				menu_insert_pembayaran();
				menu_insert_pemesanan(); // salah
				menu_insert_paket();
				menu_insert_ulasan();


				// ini tampilan yang ada di awal :)
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(new BorderLayout(0, 0));

				desktopPane = new JDesktopPane() {
					private Image image;
					{
						try {
							// URL
							image = ImageIO.read(Splash_Screen.class.getResource("/resource/LatarBelakang.png")); // ganti :)

						} catch (IOException e) {
							System.err.println(e);
						}	
					}

					@Override
					protected void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
					}

				};

				desktopPane.setBackground(Color.GRAY);
				contentPane.add(desktopPane, BorderLayout.CENTER);
				desktopPane.setLayout(new MigLayout("", "[][]", "[][]"));


				
				// // Tambahkan panel untuk menampilkan deskripsi produk di tengah desktopPane

				// Tambahkan menu keluar
				JMenu keluar = new JMenu("Log-out");
				keluar.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/home (3).png")));
				menuBar.add(keluar);

				// Keluar dari aplikasi
				JMenuItem keluarItem = new JMenuItem("Keluar");
				keluarItem.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/home (3).png")));
				keluarItem.addActionListener((ActionEvent arg0) -> {
					dispose();
					Login_Pengguna.main(null);;
				});
				keluar.add(keluarItem);
			}


			//====================================================================

			// MENU
			private void menu_insert_kategori() {
				mntmAddCategory = new JMenuItem("Tambahkan Kategori");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Kategori", false, true, false, true);
					Panel_Insert_Kategori addCategoryPanel = new Panel_Insert_Kategori();
					JIF.getContentPane().add(addCategoryPanel);
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

			private void menu_insert_layanan() {
				mntmAddCategory = new JMenuItem("Tambahkan layanan");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Layanan", false, true, false, true);
					Panel_Insert_Layanan addCategoryPanel = new Panel_Insert_Layanan();
					JIF.getContentPane().add(addCategoryPanel);
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

			private void menu_insert_paket() {
				mntmAddCategory = new JMenuItem("Tambahkan Paket");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Paket", false, true, false, true);
					Panel_Insert_Paket addCategoryPanel = new Panel_Insert_Paket();
					JIF.getContentPane().add(addCategoryPanel);
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

			private void menu_insert_ulasan() {
				mntmAddCategory = new JMenuItem("Tambahkan Ulasan");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Ulasan", false, true, false, true);
					Panel_Insert_Ulasan addCategoryPanel = new Panel_Insert_Ulasan();	
					JIF.getContentPane().add(addCategoryPanel); 
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

			private void menu_insert_pemesanan() {
				mntmAddCategory = new JMenuItem("Tambahkan Pesanan");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Pesanan", false, true, false, true);
					Panel_Insert_Pemesanan addCategoryPanel = new Panel_Insert_Pemesanan();
					JIF.getContentPane().add(addCategoryPanel);
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

			private void menu_insert_pembayaran() {
				mntmAddCategory = new JMenuItem("Tambahkan Pembayaran");
				mntmAddCategory.setMnemonic(KeyEvent.VK_O);
				mntmAddCategory.setIcon(new ImageIcon(Menu_Dashboard.class.getResource("/resource/cat.png")));
				mntmAddCategory.addActionListener((ActionEvent arg0) -> {
					JInternalFrame JIF = new JInternalFrame("Tambahkan Pembayaran", false, true, false, true);
					Panel_Insert_Pembayaran addCategoryPanel = new Panel_Insert_Pembayaran();
					JIF.getContentPane().add(addCategoryPanel);
					JIF.pack();
					desktopPane.add(JIF);
					JIF.setVisible(true);
				});

				mnHome.add(mntmAddCategory);
			}

		}
