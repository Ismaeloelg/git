package Fichero.Serializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializacionR {
	public static void main(String[] args) {

		try {
			File file = new File("src/Fichero/Serializable/ser.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Empleado aux = (Empleado) ois.readObject();

			System.out.println(
					aux.getNombre() + ", " + aux.getApellido() + ", " + aux.getEdad() + ", " + aux.getSalario());
			ois.close();
			ois.close();
		} catch (IOException e) {
			System.out.println("[ ERROR ] -  No se ha pododo acceder al fichero");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
