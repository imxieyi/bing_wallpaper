package bing_wallpaper;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class AboutFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2010907907874172592L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AboutFrame() {
		setTitle("\u5173\u4E8E");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 413, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbljava = new JLabel("\u5FC5\u5E94\u6BCF\u65E5\u58C1\u7EB8java\u7248");
		lbljava.setHorizontalAlignment(SwingConstants.CENTER);
		lbljava.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		lbljava.setBounds(12, 12, 335, 41);
		contentPane.add(lbljava);
		
		JLabel lblNewLabel = new JLabel("\u8F6F\u4EF6\u7248\u672C£º1.2");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 52, 335, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblJvm = new JLabel("JVM°æ±¾£º"+System.getProperty("java.version"));
		lblJvm.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblJvm.setBounds(12, 90, 335, 26);
		contentPane.add(lblJvm);
		
		JLabel lblJna = new JLabel("JNA°æ±¾£º4.2.2");
		lblJna.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblJna.setBounds(12, 128, 335, 26);
		contentPane.add(lblJna);
		
		JLabel lblxieyi = new JLabel("\u4F5C\u8005\uFF1Axieyi");
		lblxieyi.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblxieyi.setBounds(12, 168, 335, 26);
		contentPane.add(lblxieyi);
		
		JLabel lblhttpsimxieyicom = new JLabel("\u7F51\u7AD9\uFF1Ahttps://imxieyi.com");
		lblhttpsimxieyicom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://imxieyi.com");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblhttpsimxieyicom.setForeground(Color.BLUE);
		lblhttpsimxieyicom.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		lblhttpsimxieyicom.setBounds(12, 206, 335, 26);
		contentPane.add(lblhttpsimxieyicom);
	}
}
