package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Backup_Restore.BackUpFrame;
import View.All_panel.Add_category;
import View.All_panel.Create_Purchase;
import View.All_panel.Create_Sale;
import View.All_panel.Create_bill;

import View.All_panel.Product_name;
import View.All_panel.Units;
import View.Login.LOG_Splash;
import View.Login.Login_Jfrm;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Point;
import javax.swing.JCheckBoxMenuItem;

public class Dashboard_JFrm extends JFrame {

	// ini penginisialisasikan apapun itu nantinya yang di buat :)
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenu mnHome;
	private JMenu mnHomeEmp;
	private JMenuItem mntmAddCatagory;
	private JMenuItem mntmAddProduct;
	private JMenuItem mntmAddUnit;
	private JMenu mnBillingInfo;
	private JMenuItem mntmCreateCashMemo;
	private JMenuItem mntmP;
	private JMenu mnExtra;
	private JMenu Logout;
	private JMenu mnBackupRestore;
	private JMenuItem mntmBackupData;
	private JMenuItem mntmRestoreData;
	private JMenu keluar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Dashboard_JFrm frame = new Dashboard_JFrm("Running Dash");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// iki tera bas

	/**
	 * Create the frame.
	 */
	public Dashboard_JFrm(String role) {

		if (role.equals("Admin")) {
			System.out.println("ok");
			Login_Jfrm l = new Login_Jfrm();
			l.window.dispose();
		} else if (role.equals("Employee")) {
			System.out.println("ok employee");
			Login_Jfrm em = new Login_Jfrm();
			em.window.dispose();
		} else if (role.equals("Manager")) {
			System.out.println("Ok manager");
			Login_Jfrm Mngr = new Login_Jfrm();
			Mngr.window.dispose();
		}

		System.out.println(role);

		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard_JFrm.class.getResource("/resource/sp (4).png")));
		setBackground(new Color(0, 51, 153));
		setTitle("WWW.Traveliki.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(445, 100, 850, 550);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// sebagai admin aksess all
		if (role.equals("Admin")) {
			mnHome = new JMenu("Home");
			mnHome.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/home (2).png")));
			menuBar.add(mnHome);

			mntmAddCatagory = new JMenuItem("Add Catagory");
			mntmAddCatagory.setMnemonic(KeyEvent.VK_O);
			mntmAddCatagory.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/cat.png")));
			mntmAddCatagory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					JInternalFrame JIF = new JInternalFrame("Category", false, true, false, true);

					Add_category Add_category = new Add_category();
					JIF.getContentPane().add(Add_category);
					JIF.pack();

					desktopPane.add(JIF);
					setBackground(new Color(0, 51, 153));
					JIF.setVisible(true);

				}
			});

			mnHome.add(mntmAddCatagory);

			mntmAddProduct = new JMenuItem("Add Product");
			mntmAddProduct.setMnemonic('b');
			mntmAddProduct.setMnemonic(KeyEvent.VK_D);
			mntmAddProduct.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/sp (9).png")));
			mntmAddProduct.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					JInternalFrame JIF = new JInternalFrame("Product Category", false, true, false, true);
					Product_name Product_name = new Product_name();
					JIF.getContentPane().add(Product_name);
					JIF.pack();

					desktopPane.add(JIF);
					JIF.setVisible(true);
				}
			});

			mnHome.add(mntmAddProduct);

			mntmAddUnit = new JMenuItem("Add Unit");
			mntmAddUnit.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/unit.gif")));
			mntmAddUnit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JInternalFrame JIF = new JInternalFrame("Add Units", false, true, false, true);
					Units unit = new Units();
					JIF.getContentPane().add(unit);
					JIF.pack();

					desktopPane.add(JIF);
					JIF.setVisible(true);
				}
			});
			mnHome.add(mntmAddUnit);

		}

		// ini untuk akses user dan employee teman : )

		mnBillingInfo = new JMenu("Billing Info");
		mnBillingInfo.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/bill.png")));
		menuBar.add(mnBillingInfo);

		mntmCreateCashMemo = new JMenuItem("Create Bill");
		mntmCreateCashMemo.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/sp (11).png")));
		mntmCreateCashMemo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame JIF = new JInternalFrame("All Units", false, true, false, true);
				Create_Sale Create_Sale = new Create_Sale();
				JIF.getContentPane().add(Create_Sale);
				JIF.pack();

				desktopPane.add(JIF);
				JIF.setVisible(true);
			}
		});

		// cut
		mnBillingInfo.add(mntmCreateCashMemo);

		mnExtra = new JMenu("Extra");
		mnExtra.setLocation(new Point(43, 100));
		menuBar.add(mnExtra);

		// cut
		mnBackupRestore = new JMenu("Backup");
		mnExtra.add(mnBackupRestore);

		mntmBackupData = new JMenuItem("Backup Data");
		mntmBackupData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BackUpFrame b = new BackUpFrame();
				b.setVisible(true);
			}
		});
		mnBackupRestore.add(mntmBackupData);

		if (role.equals("Admin") || role.equals("Manager")) {
			mntmP = new JMenuItem("Create Purchase");
			mntmP.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/sp (12).png")));
			mntmP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JInternalFrame JIF = new JInternalFrame("All Units", false, true, false, true);
					Create_Purchase Create_Purchase = new Create_Purchase();
					JIF.getContentPane().add(Create_Purchase);
					JIF.pack();

					desktopPane.add(JIF);
					JIF.setVisible(true);
				}
			});
			mnBillingInfo.add(mntmP);

		}

			//ini tampilan yang ada di awal :)
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			desktopPane = new JDesktopPane() {
				private Image image;
				{
					try {
						// URL
						image = ImageIO.read(LOG_Splash.class.getResource("/resource/LatarBelakang.png")); // ganti :)
	
					} catch (IOException e) {
						e.printStackTrace();	
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

		// Tambahkan panel untuk menampilkan deskripsi produk di tengah desktopPane
		JPanel productDescriptionPanel = new JPanel();
		productDescriptionPanel.setBackground(Color.WHITE); // Ubah warna latar belakang sesuai kebutuhan
		productDescriptionPanel.setBounds(100, 100, 300, 200); // Atur ukuran dan posisi panel
		desktopPane.add(productDescriptionPanel);

		// Tambahkan label untuk menampilkan deskripsi produk
		JLabel productDescriptionLabel = new JLabel("apalah tubes iki jancuk milik si Admin 👌");
		productDescriptionPanel.add(productDescriptionLabel);

		// Tambahkan menu keluar
		JMenu keluar = new JMenu("Log-out");
		keluar.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/home (3).png")));
		menuBar.add(keluar);

		JMenuItem keluarItem = new JMenuItem("Keluar");
		keluarItem.setIcon(new ImageIcon(Dashboard_JFrm.class.getResource("/resource/home (3).png")));
		keluarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Keluar dari aplikasi
				Login_Jfrm keluarJendela = new Login_Jfrm();
				keluarJendela.frmLoginPanel.setVisible(true);
				dispose();
			}
		});
		keluar.add(keluarItem);
	}
}
