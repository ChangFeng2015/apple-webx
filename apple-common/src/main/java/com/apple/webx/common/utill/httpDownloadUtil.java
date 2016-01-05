package com.apple.webx.common.utill;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class httpDownloadUtil {
	public static byte[] httpDownload(String httpUrl) {
		if (httpUrl.indexOf("?") > 0) {
			httpUrl = httpUrl.substring(0, httpUrl.indexOf("?"));
		}

		URL url = null;
		try {
			url = new URL(httpUrl);
		} catch (MalformedURLException e1) {

		}
		InputStream inStream = null;
		ByteArrayOutputStream swapStream = null;
		try {
			URLConnection conn = url.openConnection();
			inStream = conn.getInputStream();
			swapStream = new ByteArrayOutputStream();
			byte[] buff = new byte[100];
			int rc = 0;
			while ((rc = inStream.read(buff, 0, 100)) > 0) {
				swapStream.write(buff, 0, rc);
			}
			byte[] in2b = swapStream.toByteArray();
			return in2b;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				swapStream.close();
			} catch (IOException e) {

			}
		}
		return null;
	}
}
