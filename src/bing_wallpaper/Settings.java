package bing_wallpaper;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JDialog {

	private JPanel contentPane;
	// private JComponent saveBtn, cancelBtn;

	// private Image save, cancel;
	private JButton saveBtn, cancelBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("awt.useSystemAAFontSettings", "on");
					System.setProperty("swing.aatext", "true");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Settings frame = new Settings(null, new Cursor(Cursor.DEFAULT_CURSOR), "等线");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Settings(JFrame f, Cursor c, String font) {
		super(f, "设置", true);
		setType(Type.POPUP);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 178, 152);
		setLocationRelativeTo(f);
		setBackground(new Color(0, 0, 0, 100));
		setCursor(c);
		setOpacity(0.7f);
		//
		// save = getRes("save_plain");
		// cancel = getRes("cancel_plain");

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 150), 2, true));
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCheckBox startupbtn = new JCheckBox("\u5F00\u673A\u542F\u52A8");
		startupbtn.setFont(new Font(font, Font.PLAIN, 20));
		startupbtn.setForeground(Color.WHITE);
		startupbtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		startupbtn.setBackground(new Color(0, 0, 0, 0));
		startupbtn.setBounds(16, 16, 154, 37);
		contentPane.add(startupbtn);

		JCheckBox checkBox = new JCheckBox("\u540E\u53F0\u81EA\u52A8\u66F4\u65B0");
		checkBox.setToolTipText(
				"\u5F00\u673A\u81EA\u542F\u65F6\u4E0D\u663E\u793A\u8F6F\u4EF6\u754C\u9762\uFF0C\u5728\u540E\u53F0\u9759\u9ED8\u66F4\u65B0\u58C1\u7EB8\u3002");
		checkBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		checkBox.setForeground(Color.WHITE);
		checkBox.setOpaque(false);
		checkBox.setFont(new Font(font, Font.PLAIN, 20));
		// checkBox.setBackground(new Color(0, 0, 0, 0));
		checkBox.setBounds(16, 55, 154, 37);
		contentPane.add(checkBox);

		saveBtn = new JButton("保存") {

			@Override
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && saveBtn.getBackground().getAlpha() < 255) {
					g.setColor(getBackground());
					g.fillRect(0, 0, getWidth(), getHeight());
				}
				super.paintComponent(g);
			}

		};
		saveBtn.setForeground(new Color(0, 0, 0, 255));
		saveBtn.setBackground(new Color(0, 0, 0, 150));
		saveBtn.setOpaque(false);
		saveBtn.setFont(new Font(font, Font.PLAIN, 15));
		saveBtn.setBounds(95, 99, 65, 37);
		contentPane.add(saveBtn);

		cancelBtn = new JButton("取消") {

			@Override
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && cancelBtn.getBackground().getAlpha() < 255) {
					g.setColor(getBackground());
					g.fillRect(0, 0, getWidth(), getHeight());
				}
				super.paintComponent(g);
			}

		};
		cancelBtn.setForeground(new Color(0, 0, 0, 255));
		cancelBtn.setBackground(new Color(0, 0, 0, 150));
		cancelBtn.setOpaque(false);
		cancelBtn.setFont(new Font(font, Font.PLAIN, 15));
		cancelBtn.setBounds(18, 99, 65, 37);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(cancelBtn);
	}

	// handle resource image file
	// private Image getRes(String name) {
	// if (NewUI.isRelease = false)
	// return getToolkit().createImage(getClass().getResource("/res/" + name +
	// ".png"));
	// else
	// return getToolkit().createImage("res\\" + name + ".png");
	// }

}
