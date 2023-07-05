package file_io_nio.directory_attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

public class _3_DosFileAttributes {

	public static void main(String[] args) {
		Path file = null;
		try {
			file = Path.of("temp-file.txt");
			Files.createFile(file);
			
			//to read the file properties 
			DosFileAttributes dos
				= Files.readAttributes(file, DosFileAttributes.class);
			
			FileTime creationTime = dos.creationTime();
			FileTime lastModifiedTime = dos.lastModifiedTime();
			FileTime lastAccessTime = dos.lastAccessTime();
			dos.isHidden();
			dos.isReadOnly();
			System.out.println("Original: "+  creationTime +"\t" + lastModifiedTime + "\t" + lastAccessTime );
			
			
			creationTime = _1_permissions.generateFileTimeAfter(-20L);
			
			//to change the file properties 
			DosFileAttributeView dosView 
				= Files.getFileAttributeView(file, DosFileAttributeView.class);
			
			dosView.setTimes(lastModifiedTime, lastAccessTime, creationTime);
			
			
			dos = dosView.readAttributes();
			creationTime = dos.creationTime();
			lastModifiedTime = dos.lastModifiedTime();
			lastAccessTime = dos.lastAccessTime();
			dosView.setSystem(true);
			dosView.setHidden(false);
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
