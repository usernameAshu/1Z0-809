package file_io_nio.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDogs {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("dog");
			 ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			Dog dog = (Dog) ois.readObject();
			System.out.println(dog);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
