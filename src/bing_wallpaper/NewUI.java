package bing_wallpaper;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class NewUI extends JFrame {

	private static final long serialVersionUID = 5533403570062496817L;

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

	private JPanel contentPane;
	private Image icon, bg, closebtn, minibtn, nextbtn, lastbtn, setbtn, settingsbtn;
	private boolean mousePressed = false;
	private int mouseX, mouseY;
	private int num = 0;
	private static String jarPath;
	private boolean isRelease;
	private static String font;
	private static NewUI frame;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		if (init(args)) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new NewUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public NewUI() throws IOException {

		// 判断是否从jar包启动
		if (getClass().getResource("NewUI.class").toString().startsWith("jar"))
			isRelease = true;
		else
			isRelease = false;

		if (!showWallPaper(num))
			System.exit(1);

		icon = getRes("icon");
		closebtn = getRes("close_white");
		minibtn = getRes("minimize_white");
		settingsbtn = getRes("settings_plain");
		nextbtn = getRes("next_white");
		lastbtn = getRes("last_white");
		setbtn = getRes("set_plain");

		setTitle("必应每日壁纸 2.0 beta");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setIconImage(icon);
		setResizable(false);
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(getRes("cursor"), new Point(4, 0), "custom"));

		contentPane = new JPanel() {

			private static final long serialVersionUID = 7683019381928149207L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);

				((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// draw image
				g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);

				// draw ui
				g.drawImage(closebtn, 1225, 0, 55, 23, this);
				g.drawImage(minibtn, 1170, 0, 55, 23, this);
				g.drawImage(settingsbtn, 1135, 0, 35, 23, this);
				g.drawImage(nextbtn, 1189, 292, 91, 136, this);
				g.drawImage(lastbtn, 0, 292, 91, 136, this);
				g.drawImage(setbtn, 998, 588, 166, 72, this);

				// draw string
				g.setColor(new Color(255, 255, 255, 200));
				g.setFont(new Font(font, Font.BOLD, 20));
				g.drawString("必应每日壁纸 2.0 Beta", 36, 28);
				g.drawString(getDate(), 18, 675);
				g.drawString(GetWallPaper.description, 18, 700);

				// draw icon
				g.drawImage(icon, 8, 8, 27, 27, this);
			}

		};
		contentPane.addMouseListener(new MouseAdapter() {

			private boolean nextPressed = false;
			private boolean lastPressed = false;
			private boolean setPressed = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println("handle mouse clicked");

				// handle close button
				if (e.getX() >= 1225 && e.getY() <= 23) {
					dispose();
					System.exit(0);
				}

				// handle minimize button
				if (e.getX() >= 1170 && e.getY() <= 23) {
					setExtendedState(ICONIFIED);
					minibtn = getRes("minimize_white");
					return;
				}

				// handle settings button
				if (e.getX() >= 1135 && e.getX() < 1270 && e.getY() <= 23) {
					new Settings(frame, getCursor(), font).setVisible(true);
					return;
				}

				// handle next button
				if (e.getX() >= 1189 && e.getY() >= 292 && e.getY() <= 428) {
					if (num == 15) {
						num = -1;
						// JOptionPane.showMessageDialog(null, "已经是最后一张！", "错误",
						// JOptionPane.ERROR_MESSAGE);
						// return;
					}
					num++;
					try {
						if (!showWallPaper(num))
							System.exit(1);
						contentPane.repaint();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					return;
				}

				// handle last button
				if (e.getX() <= 91 && e.getY() >= 292 && e.getY() <= 428) {
					if (num == 0) {
						num = 16;
						// JOptionPane.showMessageDialog(null, "已经是第一张！", "错误",
						// JOptionPane.ERROR_MESSAGE);
						// return;
					}
					num--;
					try {
						if (!showWallPaper(num))
							System.exit(1);
						contentPane.repaint();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					return;
				}

				// handle set button
				if (e.getX() >= 998 && e.getX() <= 1164 && e.getY() >= 588 && e.getY() <= 660) {
					setWallPaper();
					contentPane.repaint();
					return;
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// System.out.println("handle mouse pressed");
				if (e.getX() >= 1170 && e.getY() <= 23) {
					return;
				}

				if (e.getX() >= 1189 && e.getY() >= 292 && e.getY() <= 428) {
					nextbtn = getRes("next_pressed");
					contentPane.repaint();
					nextPressed = true;
					return;
				}

				if (e.getX() <= 91 && e.getY() >= 292 && e.getY() <= 428) {
					lastbtn = getRes("last_pressed");
					contentPane.repaint();
					lastPressed = true;
					return;
				}

				if (e.getX() >= 998 && e.getX() <= 1164 && e.getY() >= 588 && e.getY() <= 660) {
					setbtn = getRes("set_pressed");
					contentPane.repaint();
					setPressed = true;
					return;
				}

				// System.out.println("mouse pressed");

				mousePressed = true;
				mouseX = e.getX();
				mouseY = e.getY();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// System.out.println("handle mouse released");

				if (nextPressed) {
					nextPressed = false;
					if (e.getX() >= 1189 && e.getY() >= 292 && e.getY() <= 428)
						nextbtn = getRes("next_passed");
					else
						nextbtn = getRes("next_white");
					contentPane.repaint();
				}

				if (lastPressed) {
					lastPressed = false;
					if (e.getX() <= 91 && e.getY() >= 292 && e.getY() <= 428)
						lastbtn = getRes("last_passed");
					else
						lastbtn = getRes("last_white");
					contentPane.repaint();
				}

				if (setPressed) {
					setPressed = false;
					if (e.getX() >= 998 && e.getX() <= 1164 && e.getY() >= 588 && e.getY() <= 660)
						setbtn = getRes("set_passed");
					else
						setbtn = getRes("set_plain");
					contentPane.repaint();
				}

				mousePressed = false;
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {

			private boolean isOnClose = false;
			private boolean isOnMinimize = false;
			private boolean isOnSettings = false;
			private boolean isOnNext = false;
			private boolean isOnLast = false;
			private boolean isOnSet = false;
			private boolean stateChanged = false;

			@Override
			public void mouseMoved(MouseEvent e) {

				// handle close button
				if (e.getX() >= 1225 && e.getY() <= 23) {
					if (!isOnClose) {
						isOnClose = true;
						stateChanged = true;
						closebtn = getRes("close_red");
					}
				} else {
					if (isOnClose) {
						isOnClose = false;
						stateChanged = true;
						closebtn = getRes("close_white");
					}
				}

				// handle minimize button
				if (e.getX() >= 1170 && e.getX() < 1225 && e.getY() <= 23) {
					if (!isOnMinimize) {
						isOnMinimize = true;
						stateChanged = true;
						minibtn = getRes("minimize_blue");
					}
				} else {
					if (isOnMinimize) {
						isOnMinimize = false;
						stateChanged = true;
						minibtn = getRes("minimize_white");
					}
				}

				// handle settings button
				if (e.getX() >= 1135 && e.getX() < 1170 && e.getY() <= 23) {
					if (!isOnSettings) {
						isOnSettings = true;
						stateChanged = true;
						settingsbtn = getRes("settings_yellow");
					}
				} else {
					if (isOnSettings) {
						isOnSettings = false;
						stateChanged = true;
						settingsbtn = getRes("settings_plain");
					}
				}

				// handle next button
				if (e.getX() >= 1189 && e.getY() >= 292 && e.getY() <= 428) {
					if (!isOnNext) {
						isOnNext = true;
						stateChanged = true;
						nextbtn = getRes("next_passed");
					}
				} else {
					if (isOnNext) {
						isOnNext = false;
						stateChanged = true;
						nextbtn = getRes("next_white");
					}
				}

				// handle last button
				if (e.getX() <= 91 && e.getY() >= 292 && e.getY() <= 428) {
					if (!isOnLast) {
						isOnLast = true;
						stateChanged = true;
						lastbtn = getRes("last_passed");
					}
				} else {
					if (isOnLast) {
						isOnLast = false;
						stateChanged = true;
						lastbtn = getRes("last_white");
					}
				}

				// handle set button
				if (e.getX() >= 998 && e.getX() <= 1164 && e.getY() >= 588 && e.getY() <= 660) {
					if (!isOnSet) {
						isOnSet = true;
						stateChanged = true;
						setbtn = getRes("set_passed");
					}
				} else {
					if (isOnSet) {
						isOnSet = false;
						stateChanged = true;
						setbtn = getRes("set_plain");
					}
				}

				// call repaint
				if (stateChanged) {
					stateChanged = false;
					contentPane.repaint();
				}

			}

			@Override
			public void mouseDragged(MouseEvent e) {

				if (mousePressed) {
					setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
					// System.out.println("move window");
					return;
				}
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private static boolean init(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException, UnsupportedEncodingException {

		System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		// find best font
		String[] fontnames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		boolean dengxian = false, msyh = false, simhei = false;
		for (String i : fontnames) {
			if (!dengxian)
				if (i.equals("等线")) {
					dengxian = true;
					break;
				}
			if (!msyh)
				if (i.equals("微软雅黑"))
					msyh = true;
			if (!simhei)
				if (i.equals("黑体"))
					simhei = true;
		}
		if (dengxian)
			font = "等线";
		else {
			if (msyh)
				font = "微软雅黑";
			else if (simhei)
				font = "黑体";

		}
		if (font == null)
			font = "";

		File f = new File(GetWallPaper.dir);
		if (!f.exists() || !f.isDirectory())
			f.mkdir();

		jarPath = java.net.URLDecoder.decode(NewUI.class.getProtectionDomain().getCodeSource().getLocation().getFile(),
				"UTF-8");
		jarPath = jarPath.substring(1);

		return true;
	}

	// handle resource image file
	private Image getRes(String name) {
		if (isRelease)
			return getToolkit().createImage(getClass().getResource("/res/" + name + ".png"));
		else
			return getToolkit().createImage("res\\" + name + ".png");
	}

	private boolean showWallPaper(int n) throws IOException {
		boolean flag = true;
		while (flag) {
			try {
				GetWallPaper.downSelectedWallPaper(n);
				bg = getToolkit().createImage(GetWallPaper.dir + "selected.jpg");
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
	}

	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -num);
		return sdf.format(c.getTime());
	}
}

interface MyUser32 extends StdCallLibrary {
	MyUser32 INSTANCE = (MyUser32) Native.loadLibrary("user32", MyUser32.class);

	boolean SystemParametersInfoA(int uiAction, int uiParam, String fnm, int fWinIni);
}
