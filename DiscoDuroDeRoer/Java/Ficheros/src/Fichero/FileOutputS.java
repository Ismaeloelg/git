package Fichero;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputS {
	public static void main(String[] args) {

		// Escribir en un fichero "Hola mundo"

		try {
			File file = new File("src/Fichero/ficheroBytes.txt");
			file.createNewFile();

			FileOutputStream fos = new FileOutputStream(file);
			String s = "Hola byte";
			byte [ ] sbyte = s.getBytes();
			
			fos.write(sbyte);
			
			
			
			
			
			
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
