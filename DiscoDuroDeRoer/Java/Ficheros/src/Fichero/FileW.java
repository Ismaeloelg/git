package Fichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileW {
	public static void main(String[] args) {

		// Escribir en un fichero "Hola mundo"

		try {
			File file = new File("src/Fichero/fichero.txt");
			file.createNewFile();

			FileWriter fw = new FileWriter(file);
			fw.write("Hola mundo0");

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
