package Fichero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class InputStreamR {

	public static void main(String[] args) throws IOException {

		//Convierte los bytes en caracteres y le puedes pasar la codificación.
		try {
			File file = new File("src/Fichero/ejemplo1.txt");
			InputStream is = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");

			System.out.println((char)isr.read());
			
			
			
			is.close();
			isr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
