package com.codeinsight.zipfile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipContent {

	void zipFile(String fileAddress) throws Exception {

		File file = new File(fileAddress);

		String extension = (file.getName()).split("\\.")[1];
		String zipFileName = fileAddress.replace(extension, "zip");

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));

		ZipEntry zipEntry = new ZipEntry(file.getName());
		zipOutputStream.putNextEntry(zipEntry);

		Integer data;
		while ((data = bufferedInputStream.read()) != -1) {
			zipOutputStream.write(data);
		}
		bufferedInputStream.close();
		zipOutputStream.close();
	}
}
