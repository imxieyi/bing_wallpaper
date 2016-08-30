package bing_wallpaper;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Settings extends JDialog {

	private JPanel contentPane;
	private JButton cancelBtn;
	JCheckBox startup, background;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// System.setProperty("awt.useSystemAAFontSettings", "on");
					// System.setProperty("swing.aatext", "true");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Settings frame = new Settings(null, new Cursor(Cursor.DEFAULT_CURSOR), "等线");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int mouseX, mouseY;

	/**
	 * Create the frame.
	 */
	public Settings(JFrame f, Cursor c, String font) {
		super(f, "设置", true);
		System.out.println(NewUI.jarPath);
		setType(Type.POPUP);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 195, 142);
		setLocationRelativeTo(f);
		setBackground(new Color(0, 0, 0, 150));
		setCursor(c);
		setOpacity(0.8f);

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 150), 2, true));
		contentPane.setBackground(new Color(0, 0, 0, 0));
		add(new AlphaContainer(contentPane));
		contentPane.setLayout(null);

		startup = new JCheckBox("\u5F00\u673A\u542F\u52A8");
		startup.setFont(new Font(font, Font.PLAIN, 20));
		startup.setForeground(Color.WHITE);
		startup.setHorizontalTextPosition(SwingConstants.RIGHT);
		startup.setBackground(new Color(0, 0, 0, 0));
		startup.setOpaque(false);
		startup.setBounds(18, 18, 159, 31);
		startup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (NewUI.isRelease) {
					if (flag) {
						flag = true;
						return;
					}
					if (startup.isSelected()) {
						try {
							File dest = new File(GetWallPaper.dir + "jbingwallpaper.jar");
							File ori = new File(NewUI.jarPath);
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
				} else {
					startup.setSelected(!startup.isSelected());
					JOptionPane.showMessageDialog(null, "请先导出jar！", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(startup);

		background = new JCheckBox("\u540E\u53F0\u81EA\u52A8\u66F4\u65B0");
		background.setToolTipText(
				"\u5F00\u673A\u81EA\u542F\u65F6\u4E0D\u663E\u793A\u8F6F\u4EF6\u754C\u9762\uFF0C\u5728\u540E\u53F0\u9759\u9ED8\u66F4\u65B0\u58C1\u7EB8\u3002");
		background.setHorizontalTextPosition(SwingConstants.RIGHT);
		background.setForeground(Color.WHITE);
		background.setOpaque(false);
		background.setFont(new Font(font, Font.PLAIN, 20));
		background.setBackground(new Color(0, 0, 0, 0));
		background.setBounds(18, 51, 159, 31);
		background.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File sf = new File(GetWallPaper.dir + "settings.json");
					JSONObject json=new JSONObject();
					if (!sf.exists()) {
						sf.createNewFile();
					}else{
						sf.delete();
						sf.createNewFile();
					}
					PrintStream ps=new PrintStream(sf);
					json.put("background", background.isSelected());
					ps.print(json);
					ps.close();
				} catch (IOException ee) {
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "无法写入配置文件！", "错误", JOptionPane.ERROR_MESSAGE);
					background.setSelected(!background.isSelected());
				}
			}
		});
		contentPane.add(background);

		// saveBtn = new JButton("保存");
		// saveBtn.setForeground(new Color(0, 0, 0, 255));
		// saveBtn.setBackground(new Color(0, 0, 0, 150));
		// saveBtn.setOpaque(false);
		// saveBtn.setFont(new Font(font, Font.PLAIN, 15));
		// saveBtn.setBounds(104, 88, 73, 37);
		// saveBtn.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// contentPane.add(saveBtn);

		cancelBtn = new JButton("关闭");
		cancelBtn.setForeground(new Color(0, 0, 0, 255));
		cancelBtn.setBackground(new Color(0, 0, 0, 150));
		cancelBtn.setOpaque(false);
		cancelBtn.setFont(new Font(font, Font.PLAIN, 15));
		cancelBtn.setBounds(61, 88, 73, 37);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(cancelBtn);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});

		init();

	}

	// In order to solve fuzzy text bug
	// Reference:https://tips4java.wordpress.com/2009/05/31/backgrounds-with-transparency/
	public class AlphaContainer extends JComponent {
		private JComponent component;

		public AlphaContainer(JComponent component) {
			this.component = component;
			setLayout(new BorderLayout());
			setOpaque(false);
			component.setOpaque(false);
			add(component);
		}

		/**
		 * Paint the background using the background Color of the contained
		 * component
		 */
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(component.getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	private void init() {
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
			JOptionPane.showMessageDialog(null, "注册表读取失败！", "错误", JOptionPane.ERROR_MESSAGE);
		}
		try{
			File sf=new File(GetWallPaper.dir+"settings.json");
			JSONObject json;
			if(!sf.exists()){
				sf.createNewFile();
				json=new JSONObject();
				json.put("background", false);
				PrintStream ps=new PrintStream(sf);
				ps.print(json);
				ps.close();
				return;
			}else{
				FileInputStream fis=new FileInputStream(sf);
				byte[] b=new byte[fis.available()];
				fis.read(b);
				fis.close();
				json=new JSONObject(new String(b));
				if(json.getBoolean("background"))
					background.setSelected(true);
			}
		}catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "无法读取配置文件！", "错误", JOptionPane.ERROR_MESSAGE);
		}catch(JSONException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "配置文件存在错误！", "错误", JOptionPane.ERROR_MESSAGE);
			File sf=new File(GetWallPaper.dir+"settings.json");
			JSONObject json=new JSONObject();
			json.put("background", false);
			try {
				sf.delete();
				sf.createNewFile();
				FileOutputStream fos=new FileOutputStream(sf);
				fos.write(json.toString().getBytes());
				fos.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "创建配置文件错误！", "错误", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "无法写入配置文件！", "错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
