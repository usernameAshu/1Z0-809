package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _92_exists {
	public static void main(String[] args) throws IOException {
		Path file = Path.of("test.txt");
		Files.createFile(file);
		
		System.out.println( Files.exists(file) );
		
		//cleanup
		Files.deleteIfExists(file);
	}
}
