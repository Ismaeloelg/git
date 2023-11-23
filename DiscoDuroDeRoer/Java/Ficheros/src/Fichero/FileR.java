package Fichero;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileR {
	public static void main(String[] args) {

		File file = new File("src/Fichero/fichero.txt");

		try {
			FileReader fr = new FileReader(file);

			char c;
			int code = 0;

			while ((code = fr.read()) != -1) {

				c = (char) code;

				System.out.print(c);
			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
