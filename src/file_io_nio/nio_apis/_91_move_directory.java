package file_io_nio.nio_apis;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class _91_move_directory {
	
	public static void main(String[] args) throws Exception {
		
		Path emptydir = Path.of("src-dir");
		Path destdir = Path.of("target-dir");
		
		Files.move(emptydir, destdir, StandardCopyOption.REPLACE_EXISTING);
		
	}

	
}
