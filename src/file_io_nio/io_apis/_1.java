package file_io_nio.io_apis;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "howdy java\n12 folks\n";
		char[] c = new char[str.length()];
		File file;
		FileWriter fw;
		FileReader fr;
		try {
			file = new File("MyFile.txt");
			fw = new FileWriter(file);
			fw.write(str);
			fw.flush();
			fw.close();
			
			fr = new FileReader(file);
			fr.read(c);
			for(char in : c) {
				System.out.print(in);
			}
			
			fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
