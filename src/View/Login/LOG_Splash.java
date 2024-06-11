package View.Login;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import java.awt.BorderLayout;

public class LOG_Splash {
	public static void main(String[] args) throws InterruptedException {
		showSplashAndRunMainApp();
	}

	public static void showSplashAndRunMainApp() throws InterruptedException {
		showSplash();
		// Tampilkan aplikasi utama (misal JFrame)
		Login_Jfrm log = new Login_Jfrm();
		log.main(null);
	}

	public static void showSplash() throws InterruptedException {
		// Membuat splash screen kustom menggunakan JWindow
		JWindow splash = new JWindow();

		// Panel untuk konten splash screen
		JPanel content = new JPanel(new BorderLayout());

		// Gambar splash
		JLabel splashLabel = new JLabel(new ImageIcon(LOG_Splash.class.getResource("/resource/landingpage.png")));
		splash.setBounds(480, 250, 625, 350);
		content.add(splashLabel, BorderLayout.CENTER);

		// Progress bar
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN); // Warna progress bar
		progressBar.setStringPainted(true);
		content.add(progressBar, BorderLayout.SOUTH);

		splash.setContentPane(content);
		splash.pack();
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);

		// Simulasi proses loading
		for (int i = 0; i <= 100; i++) {
			progressBar.setValue(i);
			Thread.sleep(50); // Simulasi waktu loading
		}

		splash.setVisible(false);
		// splash.dispose();
	}
}
