package Fichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileInputS {
	public static void main(String[] args) {

		File file = new File("src/Fichero/fichero.txt");

		try {
		FileInputStream fis = new FileInputStream(file);

			int code = 0;

			while ((code = fis.read()) != -1) {

				System.out.print((char) code);
			}

			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
