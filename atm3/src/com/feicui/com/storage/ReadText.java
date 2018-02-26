package com.feicui.com.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 读取文件方法
 */
public class ReadText {
	
	public String readText(String filepath) {

		try {

			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];

			int count = 0;

			while ((count = fis.read(b)) != -1) {

				String str = new String(b, 0, count);
				System.out.println(str);

			}

			fis.close();

		} catch (FileNotFoundException e) {

			System.out.println("文件打开失败 !");

		} catch (IOException e) {

			System.out.println("未知异常 !");

		}
		return null;

	}
}
