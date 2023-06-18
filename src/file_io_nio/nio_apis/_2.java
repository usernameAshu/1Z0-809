package file_io_nio.nio_apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Creating directories 
 * @author 002L2N744
 *
 */
public class _2 {

	public static void main(String[] args) throws IOException {
		
		Path path1 = Paths.get("nio");
		Path path2 = Paths.get("nio/nio_file.txt");
		
		Files.createDirectories(path1);
		Files.createFile(path2);
		
		PrintWriter pw = new PrintWriter(path2.toFile());
		pw.println("howdy java\n12 folks\n");
		pw.flush();
		pw.close();		
		
		//multiple directories 
		Path path3 = Paths.get("nio/nio2/nio3");
		Path filePath = Paths.get("nio/nio2/nio3/nio_file_2.txt");
		
		Files.createDirectories(path3);
		Files.createFile(filePath);
		
		PrintWriter pw2 = new PrintWriter(filePath.toFile());
		pw2.println("howdy java\n12 folks\n");
		pw2.flush();
		pw2.close();		
		
	}

}
