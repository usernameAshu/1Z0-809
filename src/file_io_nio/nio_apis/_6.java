package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * isSameFile
 * @author 002L2N744
 *
 */
public class _6 {

	public static void main(String[] args) throws IOException {
		
		Path p1 = Paths.get("demo1.txt");
		Path p2 = Paths.get("demo2.txt");
		
//		Files.createFile(p1);
//		Files.createFile(p2);
		
		boolean result = Files.isSameFile(p1, p2);
		System.out.println(result);
	}

}
