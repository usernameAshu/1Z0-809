package file_io_nio.nio_apis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Copying files from one directory to another
 * 
 * @author 002L2N744
 *
 */
public class _3_Files_copy {

	public static void main(String[] args) throws IOException {
		Path directory = Path.of("./temp");
		Path source = Path.of("./temp/srcFile.txt");
		Path dest = Path.of("./temp/destFile.txt");

		Files.createDirectories(directory);
		Files.createFile(source);

		Files.writeString(source, "This is from source file");

		// Creates 2 copies of the file
		Files.copy(source, dest, StandardCopyOption.COPY_ATTRIBUTES);
		System.out.println("2 copies of file created");

		Path target = Path.of("./temp/target.txt");
		Files.createFile(target);
		
		Files.writeString(target, "This is from target file");
		/*
		 * throws FileAlreadyExistsException, since destination file is physically
		 * present on the disk need to provide a CopyOptions here
		 * Using REPLACE_EXISTING replaces the target contents with the contents from the source 
		 * COPY_ATTRIBUTES throws FileAlreadyExistsException
		 */
		// Files.copy(source, target);
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		//Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);
	}

	private static void populateText(Path source, String msg) {

//		try (PrintWriter pw = new PrintWriter(source.toFile());) {
//			pw.println(msg);
//		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
//		}

	}

}
