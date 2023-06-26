package file_io_nio.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class _2_deserialize {

	public static void main(String[] args) {
		
		try (
				FileInputStream fis = new FileInputStream("C:\\Users\\002L2N744\\Documents\\RTEST-applications-docs\\production-code\\proof-of-concepts\\1Z0-819\\cat1");
				ObjectInputStream ois = new ObjectInputStream(fis);
				FileInputStream fis2 = new FileInputStream("kitten");
				ObjectInputStream ois2 = new ObjectInputStream(fis2);
				){
			
			Cat cat = (Cat) ois.readObject();
			
			System.out.println(cat);
			
			var kitten = (Kittens)ois2.readObject();
			
			System.out.println(kitten);
			
		} catch (IOException |ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

}
