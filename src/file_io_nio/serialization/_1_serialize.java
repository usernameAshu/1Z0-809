package file_io_nio.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class _1_serialize {

	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("cat1");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				FileOutputStream fos2 = new FileOutputStream("kitten");
				ObjectOutputStream oos2 = new ObjectOutputStream(fos2);) {
			Cat cat = new Cat();
			cat.setName("Bella");
			cat.setDob(LocalDate.of(2012, 3, 20));
			oos.writeObject(cat);
			System.out.println("Cat Success");

			var kitten = new Kittens();
			kitten.setName("kitten");
			kitten.setDob(LocalDate.of(2022, 3, 21));
			oos2.writeObject(kitten);
			System.out.println("Kitten Success");

			var animal = new Animal();
			animal.setName("Tommy");
			animal.setType("Dog");
			var oos3 = new ObjectOutputStream(new FileOutputStream("animal1"));
			oos3.writeObject(animal);
			System.out.println("Animal Success");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
