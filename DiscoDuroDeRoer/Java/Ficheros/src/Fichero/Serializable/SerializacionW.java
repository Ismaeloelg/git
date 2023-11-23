package Fichero.Serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializacionW {
	public static void main(String[] args) {

		Empleado e1 = new Empleado("Fernando", "Ureña", 23, 800);
		Empleado e2 = new Empleado("Antonio", "Lopez", 35, 1000);

		try {
			File file = new File("src/Fichero/Serializable/ser.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(e1);
			oos.writeObject(e2);

			
			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("[ ERROR ] -  No se ha pododo acceder al fichero");
		}
	}
}
