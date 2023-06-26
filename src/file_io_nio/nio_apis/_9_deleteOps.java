package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _9_deleteOps {
	
	public static void main(String[] args) {
		
		Path dir = Paths.get("dir1/dir2");
		Path file = Paths.get("dir1/dir2/file1.txt");
		try {
//			Files.createDirectories(dir);
//			System.out.println("directories created");
//			Files.createFile(file);
//			System.out.println("file created");
			
			Files.delete(file);
			System.out.println("file deleted");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
