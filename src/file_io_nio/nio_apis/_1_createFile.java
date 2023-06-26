package file_io_nio.nio_apis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _1_createFile {

	public static void main(String[] args) {
		String str = "howdy java\n12 folks\n";
		File file;
		PrintWriter pw;
		try {
			
			//Files --uses--> Paths --creates--> Path --converts--> File  
			file = Files.createFile(Paths.get("nio_file1.txt")).toFile();
			
//
//			pw = new PrintWriter(file);
//			pw.println(str);
//			pw.flush();
//			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
