package Fichero;

import java.io.*;

public class EscrituraCaracterArchivo {
	public static void main(String[] args) {

		String nombreArchivo = "src/Fichero/ejemplo1.txt";
		FileWriter archivo;
		
		try {
			archivo = new FileWriter(nombreArchivo);
			for (char letra = 'A'; letra <= 'Z'; letra++) {
				archivo.write(letra);
			}
			archivo.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un error al escribir en el archivo.");
		}
	}
}
