package bing_wallpaper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GetWallPaper {

	public static String dir = System.getenv("APPDATA") + "\\JBingWallpaper\\";
	public static String description = null;

	/**
	 * 从网络Url中下载文件
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	private static void downLoadFromUrl(String urlStr, String fileName, String savePath)
			throws IOException, UnknownHostException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		// 设置超时间为5秒
		conn.setConnectTimeout(5 * 1000);

		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko");
		// conn.setRequestProperty("Accept-Charset",
		// "GB2312,utf-8;q=0.7,*;q=0.7");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();

		// 获取自己数组
		byte[] getData = readInputStream(inputStream);

		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}

		// System.out.println("info:" + url + " download success");

	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	private static byte[] readInputStream(InputStream inputStream) throws IOException, UnknownHostException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	private static String getWallPaperURL(int n) throws UnknownHostException, IOException {
		downLoadFromUrl("http://cn.bing.com/HPImageArchive.aspx?idx=" + String.valueOf(n) + "&n=1", "temp.xml", dir);
		File f = new File(dir + "temp.xml");
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[fis.available()];
		fis.read(b);
		String t = new String(b, "utf8");
		if (t.indexOf("<url>") >= 0) {
			if (t.indexOf(".jpg") < 0) {
				fis.close();
				return "Not Found!";
			}
			description = t.substring(t.indexOf("<copyright>") + 11, t.indexOf("</copyright>"));
			// System.out.println(new String(t.getBytes("utf8"), "utf8"));
			t = t.substring(t.indexOf("<url>") + 5, t.indexOf("</url>") - 12);
			fis.close();
			f.delete();
			return "http://cn.bing.com" + t + "1920x1080.jpg";
		}
		fis.close();
		f.delete();
		return "Not Found!";
	}

	/*
	 * public static void downTodayWallPaper() throws UnknownHostException,
	 * IOException{ String t=getWallPaperURL(0); if(t.equals("Not Found!"))
	 * throw new RuntimeException("WallPaper Address Not Found!");
	 * downLoadFromUrl(t, "current.jpg", "."); }
	 */

	public static void downSelectedWallPaper(int n) throws UnknownHostException, IOException {

		boolean flag = true;
		String t = null;
		while (true) {
			try {
				while (flag) {
					t = getWallPaperURL(n);
					if (!t.equals(
							"Not Found!"))/*
											 * { if (JOptionPane.
											 * showConfirmDialog(null,
											 * "未找到壁纸下载地址，可能是当前网络需要登录或者代理服务器出错，是否重试？",
											 * "遇到问题",
											 * JOptionPane.YES_NO_OPTION,
											 * JOptionPane.QUESTION_MESSAGE) ==
											 * JOptionPane.NO_OPTION) throw new
											 * RuntimeException("WallPaper Address Not Found!"
											 * ); } else
											 */
						flag = false;
				}
				downLoadFromUrl(t, "selected.jpg", dir);
				break;
			} catch (SocketTimeoutException e) {
				System.err.println("Connection timed out! Retrying...");
			}
		}
	}

}
