package Fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferR {
	public static void main(String[] args) {

		File file = new File("src/Fichero/ejemplo1.txt");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea = null;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error de lectura: Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error de lectura: Error de entrada/salida");
		}

	}
}
