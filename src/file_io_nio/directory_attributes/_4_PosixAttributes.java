package file_io_nio.directory_attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * this class can be executed on a linux/unix file system
 * @author 002L2N744
 *
 */
public class _4_PosixAttributes {

	public static void main(String[] args) {
		Path file = null;
		try {
			file = Path.of("temp-file.txt");
			Files.createFile(file);
			
			//reading attributes
			PosixFileAttributes posix = 
					Files.readAttributes(file, PosixFileAttributes.class);
			
			System.out.println( posix.permissions() );
			
			String permissionStr = "rwxr--r--";
			Set<PosixFilePermission> permSet = PosixFilePermissions.fromString(permissionStr);
			
			//change the attributes 
			PosixFileAttributeView posixView = Files.getFileAttributeView(file, PosixFileAttributeView.class);
			posixView.setPermissions(permSet);
			
			System.out.println(posixView.readAttributes().permissions());
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				Files.deleteIfExists(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
