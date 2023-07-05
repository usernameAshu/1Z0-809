package file_io_nio.directory_attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class _2_BasicFileAttributes {

	public static void main(String[] args) {
		Path file = null;
		try {
			file = Path.of("temp-file.txt");
			Files.createFile(file);
			
			//to read the file properties 
			BasicFileAttributes basic
				= Files.readAttributes(file, BasicFileAttributes.class);
			
			FileTime creationTime = basic.creationTime();
			FileTime lastModifiedTime = basic.lastModifiedTime();
			FileTime lastAccessTime = basic.lastAccessTime();
			System.out.println("Original: "+  creationTime +"\t" + lastModifiedTime + "\t" + lastAccessTime );
			
			
			creationTime = _1_permissions.generateFileTimeAfter(-20L);
			
			//to change the file properties 
			BasicFileAttributeView basicView 
				= Files.getFileAttributeView(file, BasicFileAttributeView.class);
			
			basicView.setTimes(lastModifiedTime, lastAccessTime, creationTime);
			
			
			basic = basicView.readAttributes();
			creationTime = basic.creationTime();
			lastModifiedTime = basic.lastModifiedTime();
			lastAccessTime = basic.lastAccessTime();
			System.out.println("New: "+  creationTime +"\t" + lastModifiedTime + "\t" + lastAccessTime );
			
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
