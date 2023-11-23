package Fichero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BackUp {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("src/Fichero/entrada.txt");
			FileOutputStream fos = new FileOutputStream("src/Fichero/salida.txt");
			int code, n = 0;

			System.out.println("Iniciando Copia de seguirdad...");
			while ((code = fis.read()) != -1) {
				fos.write(code);
				n++;
			}

			fis.close();
			fos.close();
			System.out.println("Se han copidado " + n + " caracteres");

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("No se ha podido acceder al fichero");
		}

	}
}
