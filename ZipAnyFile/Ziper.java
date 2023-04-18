package com.codeinsight.zipfile;

import java.util.Scanner;

public class Ziper {

	private void takeFileAddress(Scanner scanner) {
		ZipContent zipContent = new ZipContent();

		System.out.println("Enter file path :-");
		String fileAddress = scanner.nextLine();

		try {
			zipContent.zipFile(fileAddress);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Ziper ziper = new Ziper();
		ziper.takeFileAddress(scanner);
		scanner.close();
	}
}
