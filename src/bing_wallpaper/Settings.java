package bing_wallpaper;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Settings extends JDialog {

	private JPanel contentPane;
	private JButton saveBtn, cancelBtn;
	JCheckBox startup, background;

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
		setType(Type.POPUP);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 195, 142);
		setLocationRelativeTo(f);
		setBackground(new Color(0, 0, 0, 150));
		setCursor(c);
		setOpacity(0.8f);

		contentPane = new JPanel() {

			@Override
			protected void paintChildren(Graphics g) {
				super.paintChildren(g);
			}

		};
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
		contentPane.add(background);

		saveBtn = new JButton("保存");
		saveBtn.setForeground(new Color(0, 0, 0, 255));
		saveBtn.setBackground(new Color(0, 0, 0, 150));
		saveBtn.setOpaque(false);
		saveBtn.setFont(new Font(font, Font.PLAIN, 15));
		saveBtn.setBounds(104, 88, 73, 37);
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(saveBtn);

		cancelBtn = new JButton("取消");
		cancelBtn.setForeground(new Color(0, 0, 0, 255));
		cancelBtn.setBackground(new Color(0, 0, 0, 150));
		cancelBtn.setOpaque(false);
		cancelBtn.setFont(new Font(font, Font.PLAIN, 15));
		cancelBtn.setBounds(18, 88, 73, 37);
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

}
