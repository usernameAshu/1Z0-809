package file_io_nio.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDogs {

	public static void main(String[] args) {

		try (FileOutputStream fis = new FileOutputStream("dog");
				ObjectOutputStream oos = new ObjectOutputStream(fis);) {
			
			Dog dog = new Dog("Tommy", new Collar("dog-collar", "rubber-cotton"));
			oos.writeObject(dog);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
