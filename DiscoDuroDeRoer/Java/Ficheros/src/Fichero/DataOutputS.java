package Fichero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputS {

	public static void main(String[] args) {

		try {
			File file = new File("src/Fichero/ficheroBytes.by");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);

			String c = "Hola me llamo Ismael Ouardane y tengo ";
			dos.writeUTF(c);
			dos.writeChar(' ');
			dos.writeInt(23);
			dos.writeUTF("años");

			
			dos.flush();
			System.out.println("Do it !!");
			dos.close();
		} catch (FileNotFoundException e) {
			System.out.println("[ ERROR ] - No se ha encontrado el fichero");
		} catch (IOException e) {
			System.out.println("[ ERROR ] - No se ha podido acceder al fichero");
		}

	}
}