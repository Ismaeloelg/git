package Fichero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputS {

	public static void main(String[] args) {

		String line,line2;
		int unidad;
		char espacios;

		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("src/Fichero/ficheroBytes.by"));
			line = dis.readUTF();
			espacios = dis.readChar();
			unidad = dis.readInt();
			line2 = dis.readUTF();

			System.out.print(line);
			System.out.print(unidad);
			System.out.print(espacios);
			System.out.print(line2);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no se ha encontrado");
		} catch (IOException e) {
			System.out.println("No se ha podido acceder al fichero");
		}
	}
}