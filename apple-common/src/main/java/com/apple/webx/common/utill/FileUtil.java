package com.apple.webx.common.utill;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 类FileUtil.java的实现描述：TODO 类实现描述
 * 
 * @author Jndong 2013-8-16 上午2:41:21
 */
public class FileUtil {

	private static final String UTF_8 = "UTF-8";

	private static final String DIR_SEPARATOR = File.separator;

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyMMddHHmmssSSS");

	/**
	 * 文件 根据系统时间重新定义
	 * 
	 * @param item
	 * @return
	 */
	public static String fileName() {
		return CipherUtil.encode(DATE_FORMAT.format(new Date()));
	}

	public static void write(String fullPath, List<String> contents) {
		try {
			File file = new File(fullPath).getAbsoluteFile();

			mkdirIfNotExists(file.getParentFile().getAbsolutePath());

			PrintWriter out = new PrintWriter(file, UTF_8);
			try {
				for (String line : contents) {
					out.println(line);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void zipSingleFile(String filePath, String zipFilePath) {
		try {
			File f = new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream fos = new FileOutputStream(zipFilePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ZipOutputStream zos = new ZipOutputStream(bos);// 压缩包
			ZipEntry ze = new ZipEntry(f.getName());// 这是压缩包名里的文件名
			zos.putNextEntry(ze);// 写入新的 ZIP 文件条目并将流定位到条目数据的开始处

			byte[] buf = new byte[1024];
			int len;

			while ((len = bis.read(buf)) != -1) {
				zos.write(buf, 0, len);
				zos.flush();
			}
			bis.close();
			zos.close();
		} catch (Exception e) {
			throw new RuntimeException("zip file exception: filePath=" + filePath);
		}
	}

	public static String buildPath(String... names) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names.length; ++i) {
			sb.append(names[i]);
			if (i < names.length - 1) {
				sb.append(DIR_SEPARATOR);
			}
		}
		return sb.toString();
	}

	public static void mkdirIfNotExists(String dirPath) {
		File dir = new File(dirPath);
		if (!dir.exists()) {
			if (!dir.mkdirs() && !dir.isDirectory()) {
				throw new RuntimeException("mkdir failed, dir=" + dirPath);
			}
		}
	}
}
