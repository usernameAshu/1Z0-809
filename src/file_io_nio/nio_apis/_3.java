package file_io_nio.nio_apis;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Copying files from one directory to another
 * @author 002L2N744
 *
 */
public class _3 {
	
	private static Path path1 = Paths.get("dir1/subdir1/sub_subdir1");
	private static Path path1_file = Paths.get("dir1/subdir1/sub_subdir1", "file1.txt");
	private static Path path2 = Paths.get("dir2/subdir1/sub_subdir1");
	private static Path path2_file = Paths.get("dir2/subdir1/sub_subdir1", "file2.txt");
	private static Path path3 = Paths.get("dir3/subdir1/sub_subdir1");
	private static Path path3_file = Paths.get("dir3/subdir1/sub_subdir1", "file3.txt");
	
	public static void main(String[] args) throws IOException
	{
		
		//createFile();
		//Files.copy(path1_file, path2_file, StandardCopyOption.REPLACE_EXISTING);
		
		Files.createDirectories(path3);
		//Files.createFile(path3_file);
		Files.copy(path1_file, path3_file, StandardCopyOption.COPY_ATTRIBUTES);
		
	}
	
	static void createFile() throws IOException {
		Files.createDirectories(path1);
		Files.createDirectories(path2);
		
		Files.createFile(path1_file);
		//Files.createFile(path2_file);
		
		PrintWriter pw1 = new PrintWriter(path1_file.toFile());
		PrintWriter pw2 = new PrintWriter(path2_file.toFile());
		pw1.println("file 1");
		pw2.println("file 2");
		pw1.flush(); pw1.close();
		pw2.flush(); pw2.close();
	}

}
