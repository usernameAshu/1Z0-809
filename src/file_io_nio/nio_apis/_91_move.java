package file_io_nio.nio_apis;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _91_move {
	
	public static void main(String[] args) {
		
		Path srcDir = null;
		Path srcPath = null;
		Path destDir = null;
		Path destPath = null;
		
		try {
			
			srcDir = Path.of("temp");
			srcPath = Path.of("temp", "file1.txt");
			
			Files.createDirectory(srcDir);
			Files.createFile(srcPath);
			
			writeToFile(srcPath, "Hello from file 1");
			
			destDir = Path.of("temp2");
			//Files.createDirectory(destDir);
			destPath = Path.of("temp2/newFile.txt");
			
			Files.move(srcPath, destPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			try {
//				Files.deleteIfExists(filePath);
//				//Files.deleteIfExists(dirPath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
		}
			
	}

	private static void writeToFile(Path srcPath, String str) throws IOException {
		FileWriter fw = new FileWriter(srcPath.toFile().getAbsolutePath());
		PrintWriter pw = new PrintWriter(fw, true);
		pw.println(str);
		pw.flush();
		pw.close();
	}

}
