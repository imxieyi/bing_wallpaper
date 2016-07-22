package bing_wallpaper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class MainFrame extends JFrame {

	private static byte[] runhiddenconsole = { 77, 90, -112, 0, 3, 0, 0, 0, 4, 0, 0, 0, -1, -1, 0, 0, -72, 0, 0, 0, 0,
			0, 0, 0, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, -56, 0, 0, 0, 14, 31, -70, 14, 0, -76, 9, -51, 33, -72, 1, 76, -51, 33, 84, 104, 105, 115, 32, 112,
			114, 111, 103, 114, 97, 109, 32, 99, 97, 110, 110, 111, 116, 32, 98, 101, 32, 114, 117, 110, 32, 105, 110,
			32, 68, 79, 83, 32, 109, 111, 100, 101, 46, 13, 13, 10, 36, 0, 0, 0, 0, 0, 0, 0, 13, 38, -58, -33, 73, 71,
			-88, -116, 73, 71, -88, -116, 73, 71, -88, -116, -77, 100, -79, -116, 76, 71, -88, -116, 73, 71, -87, -116,
			78, 71, -88, -116, -77, 99, -75, -116, 72, 71, -88, -116, -77, 99, -107, -116, 72, 71, -88, -116, 82, 105,
			99, 104, 73, 71, -88, -116, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 69, 0, 0, 76, 1, 1, 0, 17,
			36, -63, 66, 0, 0, 0, 0, 0, 0, 0, 0, -32, 0, 15, 1, 11, 1, 7, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17,
			0, 0, 0, 16, 0, 0, 0, 32, 0, 0, 0, 0, 64, 0, 0, 16, 0, 0, 0, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0,
			0, 0, 0, 0, 32, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 16, 0, 0, 16, 0, 0, 0, 0, 16, 0, 0, 16, 0,
			0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 18, 0, 0, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16,
			0, 0, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 116, 101,
			120, 116, 0, 0, 0, -2, 2, 0, 0, 0, 16, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32,
			0, 4, -32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 112, 18, 0, 0, -128, 18,
			0, 0, -114, 18, 0, 0, -92, 18, 0, 0, -74, 18, 0, 0, -60, 18, 0, 0, 0, 0, 0, 0, -28, 18, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 65, 98, 111, 117, 116, 58, 10, 10, 104, 105, 100, 101, 99, 32, 104, 105, 100, 101, 115, 32, 99,
			111, 110, 115, 111, 108, 101, 32, 119, 105, 110, 100, 111, 119, 32, 111, 102, 32, 115, 116, 97, 114, 116,
			101, 100, 32, 112, 114, 111, 103, 114, 97, 109, 32, 38, 32, 119, 97, 105, 116, 115, 32, 40, 111, 112, 116,
			46, 41, 32, 102, 111, 114, 32, 105, 116, 115, 32, 116, 101, 114, 109, 105, 110, 97, 116, 105, 111, 110, 10,
			10, 85, 115, 97, 103, 101, 58, 10, 10, 9, 104, 105, 100, 101, 99, 32, 91, 47, 119, 93, 32, 60, 102, 105,
			108, 101, 110, 97, 109, 101, 62, 10, 10, 87, 104, 101, 114, 101, 58, 10, 10, 47, 119, 9, 119, 97, 105, 116,
			32, 102, 111, 114, 32, 112, 114, 111, 103, 114, 97, 109, 32, 116, 101, 114, 109, 105, 110, 97, 116, 105,
			111, 110, 10, 102, 105, 108, 101, 110, 97, 109, 101, 9, 101, 120, 101, 99, 117, 116, 97, 98, 108, 101, 32,
			102, 105, 108, 101, 32, 110, 97, 109, 101, 0, 69, 114, 114, 111, 114, 58, 32, 73, 110, 99, 111, 114, 114,
			101, 99, 116, 32, 117, 115, 97, 103, 101, 0, 0, -125, -20, 84, 83, 85, 86, 51, -19, 51, -10, -77, 32, -1,
			21, 20, 16, 64, 0, -117, -48, -128, 58, 34, 117, 7, -77, 34, -21, 3, -115, 73, 0, -118, 66, 1, 66, 58, -61,
			116, 6, -124, -64, 117, -12, -21, 25, -128, 58, 0, 116, 20, -118, 66, 1, 66, -124, -64, 116, 12, 60, 32,
			116, -12, 60, 9, 116, -16, -124, -64, 117, 25, 85, 104, -24, 16, 64, 0, 104, 40, 16, 64, 0, 85, -1, 21, 28,
			16, 64, 0, 85, -1, 21, 16, 16, 64, 0, 60, 47, 117, 23, -118, 66, 1, 12, 32, 60, 119, 117, 14, -128, 122, 2,
			32, 117, 8, -66, 1, 0, 0, 0, -125, -62, 3, -118, 2, -124, -64, 116, 16, 60, 32, 116, 4, 60, 9, 117, 8, -118,
			66, 1, 66, -124, -64, 117, -16, 87, 51, -64, -71, 17, 0, 0, 0, -115, 124, 36, 32, -13, -85, -115, 76, 36,
			16, 81, -115, 68, 36, 36, 80, 85, 85, 106, 16, 85, 85, 85, 82, 85, -57, 68, 36, 72, 68, 0, 0, 0, -57, 68,
			36, 116, 1, 0, 0, 0, 102, -119, 108, 36, 120, -1, 21, 12, 16, 64, 0, -123, -64, 95, 116, 39, 59, -11, 116,
			13, -117, 76, 36, 12, 106, -1, 81, -1, 21, 8, 16, 64, 0, -117, 84, 36, 12, -117, 53, 4, 16, 64, 0, 82, -1,
			-42, -117, 68, 36, 16, 80, -1, -42, -21, 8, -1, 21, 0, 16, 64, 0, -117, -24, 85, -1, 21, 16, 16, 64, 0, -52,
			-112, -112, -112, -112, -112, -112, -112, 76, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -42, 18, 0, 0, 0, 16, 0, 0,
			104, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -14, 18, 0, 0, 28, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 112, 18, 0, 0, -128, 18, 0, 0, -114, 18, 0, 0, -92, 18, 0, 0, -74, 18, 0, 0, -60, 18,
			0, 0, 0, 0, 0, 0, -28, 18, 0, 0, 0, 0, 0, 0, 90, 1, 71, 101, 116, 76, 97, 115, 116, 69, 114, 114, 111, 114,
			0, 0, 44, 0, 67, 108, 111, 115, 101, 72, 97, 110, 100, 108, 101, 0, 101, 3, 87, 97, 105, 116, 70, 111, 114,
			83, 105, 110, 103, 108, 101, 79, 98, 106, 101, 99, 116, 0, 92, 0, 67, 114, 101, 97, 116, 101, 80, 114, 111,
			99, 101, 115, 115, 65, 0, 0, -85, 0, 69, 120, 105, 116, 80, 114, 111, 99, 101, 115, 115, 0, -3, 0, 71, 101,
			116, 67, 111, 109, 109, 97, 110, 100, 76, 105, 110, 101, 65, 0, 75, 69, 82, 78, 69, 76, 51, 50, 46, 100,
			108, 108, 0, 0, -36, 1, 77, 101, 115, 115, 97, 103, 101, 66, 111, 120, 65, 0, 85, 83, 69, 82, 51, 50, 46,
			100, 108, 108, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	/**
	 * 
	 */
	private static final long serialVersionUID = -6182536279422708436L;
	private JPanel contentPane;
	private JLabel img;
	private JPanel panel;
	private JLabel info;
	private JButton setwallpaper;
	private JCheckBox startup;
	private int num = 0;
	private boolean flag;
	private static String jarPath;

	/**
	 * Launch the application.
	 * 
	 * @throws Exception
	 * 
	 */
	public static void main(String[] args) throws Exception {

		BeautyEyeLNFHelper.launchBeautyEyeLNF();
		UIManager.put("RootPane.setupButtonVisible", false);

		File f = new File(GetWallPaper.dir);
		if (!f.exists() || !f.isDirectory())
			f.mkdir();

		jarPath = java.net.URLDecoder
				.decode(MainFrame.class.getProtectionDomain().getCodeSource().getLocation().getFile(), "UTF-8");
		jarPath = jarPath.substring(1);

		f = new File(GetWallPaper.dir + "RunHiddenConsole.exe");
		if (!f.exists()) {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(runhiddenconsole);
			fos.close();
		}

		if (args.length > 0)
			if (args[0].equals("-auto")) {
				while (true) {
					try {
						GetWallPaper.downSelectedWallPaper(0);
						setWallPaper();
						// System.out.println("Success!");
						System.exit(0);
					} catch (UnknownHostException e) {
						System.err.println("DNS error. Try again after 10 sec...");
						Thread.sleep(10000);
					} catch (SocketException e) {
						System.err.println("Socket Error. Try again after 10 sec...");
						Thread.sleep(10000);
					} catch (RuntimeException e) {
						if (e.getMessage().equals("WallPaper Address Not Found!"))
							System.exit(1);
						else
							throw e;
					} catch (Exception e) {
						// e.printStackTrace();
						// Thread.sleep(60000);
						File ef = new File(GetWallPaper.dir + "error.txt");
						if (ef.exists())
							ef.delete();
						ef.createNewFile();
						PrintStream eps = new PrintStream(ef);
						e.printStackTrace(eps);
						eps.close();
						Runtime.getRuntime()
								.exec("rundll32 url.dll,FileProtocolHandler \"" + GetWallPaper.dir + "error.txt\"");
						System.exit(1);
					}
				}
			}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public MainFrame() throws IOException {

		setTitle("bing每日壁纸");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 12, 501, 287);
		contentPane.add(panel);

		img = new JLabel();
		panel.add(img, BorderLayout.CENTER);

		JButton last = new JButton("\u4E0A\u4E00\u5F20");
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					JOptionPane.showMessageDialog(null, "已经是第一张！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				num--;
				info.setText(String.valueOf(num + 1) + "/16");
				try {
					if (!showWallPaper(num))
						System.exit(1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		last.setFont(new Font("微软雅黑", Font.BOLD, 20));
		last.setBounds(12, 312, 153, 46);
		contentPane.add(last);

		JButton next = new JButton("\u4E0B\u4E00\u5F20");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num == 15) {
					JOptionPane.showMessageDialog(null, "已经是最后一张！", "错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				num++;
				info.setText(String.valueOf(num + 1) + "/16");
				try {
					if (!showWallPaper(num))
						System.exit(1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		next.setFont(new Font("微软雅黑", Font.BOLD, 20));
		next.setBounds(348, 312, 153, 46);
		contentPane.add(next);

		setwallpaper = new JButton("\u8BBE\u7F6E\u4E3A\u58C1\u7EB8");
		setwallpaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWallPaper();
			}
		});
		setwallpaper.setFont(new Font("微软雅黑", Font.BOLD, 20));
		setwallpaper.setBounds(177, 370, 161, 46);
		contentPane.add(setwallpaper);

		JButton about = new JButton("\u5173\u4E8E");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrame af = new AboutFrame();
				af.setVisible(true);
				af.setLocationRelativeTo(null);
				af.setResizable(false);
			}
		});
		about.setFont(new Font("微软雅黑", Font.BOLD, 20));
		about.setBounds(348, 370, 153, 46);
		contentPane.add(about);

		info = new JLabel("01/16");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setFont(new Font("微软雅黑", Font.BOLD, 20));
		info.setBounds(183, 312, 153, 46);
		contentPane.add(info);

		startup = new JCheckBox("\u5F00\u673A\u81EA\u52A8\u66F4\u65B0");
		startup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					flag = true;
					return;
				}
				if (startup.isSelected()) {
					try {

						File dest = new File(GetWallPaper.dir + "jbingwallpaper.jar");
						File ori = new File(jarPath);
						if ((!dest.exists()) || (dest.length() != ori.length())) {
							if (dest.exists())
								dest.delete();
							FileInputStream fis = new FileInputStream(ori);
							FileOutputStream fos = new FileOutputStream(dest);
							byte[] temp = new byte[fis.available()];
							fis.read(temp);
							fos.write(temp);
							fis.close();
							fos.close();
						}
						Runtime.getRuntime()
								.exec("reg add \"HKCU\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v JBingWallPaper /t REG_SZ /d \"\"\"\""
										+ GetWallPaper.dir + "RunHiddenConsole.exe\"\"\" " + "\"\"\""
										+ System.getProperty("java.home") + "\\bin\\java.exe\"\"\" -jar \"\"\""
										+ GetWallPaper.dir + "jbingwallpaper.jar" + "\"\"\" -auto\" /f");
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "启动项添加失败！", "错误", JOptionPane.ERROR_MESSAGE);
						startup.setSelected(false);
						flag = true;
					}
				} else {
					try {
						Runtime.getRuntime().exec(
								"reg delete \"HKCU\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v JBingWallPaper /f");
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "启动项删除失败！", "错误", JOptionPane.ERROR_MESSAGE);
						startup.setSelected(true);
						flag = true;
					}
				}
			}
		});
		startup.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		startup.setBounds(12, 382, 153, 30);
		contentPane.add(startup);

		try {
			Process p = Runtime.getRuntime()
					.exec("reg query HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Run /v JBingWallpaper");
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String t = br.readLine();
			System.out.println(t);
			while ((t != null) && (t.length() == 0))
				t = br.readLine();
			if (t == null)
				startup.setSelected(false);
			else if (t.indexOf("HKEY_CURRENT_USER") >= 0)
				startup.setSelected(true);
			else
				startup.setSelected(false);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		if (!showWallPaper(num))
			System.exit(1);

	}

	private boolean showWallPaper(int n) throws IOException {
		boolean flag = true;
		while (flag) {
			try {
				GetWallPaper.downSelectedWallPaper(n);
				ImageIcon ico = new ImageIcon(GetWallPaper.dir + "selected.jpg");
				ico.getImage();
				Image temp = ico.getImage().getScaledInstance(panel.getWidth(), panel.getWidth(), Image.SCALE_DEFAULT);
				ico = new ImageIcon(temp);
				img.setIcon(ico);
				flag = false;
			} catch (UnknownHostException e) {
				if (JOptionPane.showConfirmDialog(null, "无法连接网络，是否重试？", "错误", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.CANCEL_OPTION)
					return false;
			} catch (SocketException e) {
				if (JOptionPane.showConfirmDialog(null, "连接被重置，是否重试？", "错误", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.CANCEL_OPTION)
					return false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "未知错误！", "错误", JOptionPane.ERROR_MESSAGE);
				File ef = new File(GetWallPaper.dir + "error.txt");
				if (ef.exists())
					ef.delete();
				ef.createNewFile();
				PrintStream eps = new PrintStream(ef);
				e.printStackTrace(eps);
				eps.close();
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler \"" + GetWallPaper.dir + "error.txt\"");
				return false;
			}
		}
		return true;
	}

	private static void setWallPaper() {
		try {
			File f1 = new File(GetWallPaper.dir + "selected.jpg");
			File f2 = new File(GetWallPaper.dir + "current.jpg");
			if (f2.exists())
				f2.delete();
			FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);
			byte t[] = new byte[fis.available()];
			fis.read(t);
			fos.write(t);
			fis.close();
			fos.close();

			// 调用windows api更新壁纸
			int SPI_SETDESKWALLPAPER = 0x14;
			int SPIF_UPDATEINIFILE = 0x01;
			int SPIF_SENDWININICHANGE = 0x02;

			MyUser32.INSTANCE.SystemParametersInfoA(SPI_SETDESKWALLPAPER, 0, GetWallPaper.dir + "selected.jpg",
					SPIF_UPDATEINIFILE | SPIF_SENDWININICHANGE);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		/*
		 * RegistryKey reg = new RegistryKey(RootKey.HKCU,
		 * "Control Panel\\Desktop"); File f = new File("selected.jpg");
		 * RegistryValue rv = new RegistryValue("Wallpaper",
		 * f.getAbsolutePath()); reg.setValue(rv); rv = new
		 * RegistryValue("WallpaperStyle", "10"); reg.setValue(rv);
		 */
	}

}

interface MyUser32 extends StdCallLibrary
/*
 * JNA Win32 extensions includes a User32 class, but it doesn't contain
 * SystemParametersInfo(), so it must be defined here.
 * 
 * MSDN libary docs on SystemParametersInfo() are at:
 * http://msdn.microsoft.com/en-us/library/ms724947(VS.85).aspx
 * 
 * BOOL WINAPI SystemParametersInfo( __in UINT uiAction, __in UINT uiParam,
 * __inout PVOID pvParam, __in UINT fWinIni );
 * 
 * When uiAction == SPI_SETDESKWALLPAPER, SystemParametersInfo() sets the
 * desktop wallpaper. The value of the pvParam parameter determines the new
 * wallpaper.
 */
{
	MyUser32 INSTANCE = (MyUser32) Native.loadLibrary("user32", MyUser32.class);

	boolean SystemParametersInfoA(int uiAction, int uiParam, String fnm, int fWinIni);
	// SystemParametersInfoA() is the ANSI name used in User32.dll
} // end of MyUser32 interface
