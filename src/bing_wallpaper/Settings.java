package bing_wallpaper;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.Window.Type;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Settings extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings(null, new Cursor(Cursor.DEFAULT_CURSOR), "µ»œﬂ");
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
		super(f, "…Ë÷√", true);
		setType(Type.POPUP);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 275);
		setLocationRelativeTo(f);
		setBackground(new Color(0, 0, 0, 0));
		setCursor(c);

		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 0, 0, 100));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCheckBox startupbtn = new JCheckBox("");
		startupbtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		startupbtn.setBackground(new Color(0, 0, 0, 0));
		// startupbtn.setForeground(Color.WHITE);
		startupbtn.setBounds(29, 23, 194, 43);
		// startupbtn.setFont(new Font(font,Font.PLAIN,25));
		contentPane.add(startupbtn);

		JLabel startuplabel = new JLabel("\u5F00\u673A\u542F\u52A8");
		startuplabel.setBounds(54, 23, 168, 43);
		startuplabel.setFont(new Font(font, Font.BOLD, 25));
		startuplabel.setForeground(Color.WHITE);
		contentPane.add(startuplabel);
	}
}
