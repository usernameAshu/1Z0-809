package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Copying directory from one path to another
 * 
 * @author 002L2N744
 *
 */
public class _3_Files_copyDirectory {
	
	public static void main(String[] args) throws IOException {
		
		Path src = Path.of("src-dir");
		Path dest = Path.of("target-dir");
		
		/*
		 * This code will only create an empty destination directory 
		 * It won't copy the individual files 
		 */
		//Files.copy(src, dest, StandardCopyOption.COPY_ATTRIBUTES);
		
		/*
		 * This code copies the entire directory contents in the destination location 
		 */
		Files.walkFileTree(src, new WalktheTree());
		
		/*
		 * To copy a file into a directory
		 * directory has be to present physically 
		 */
		
//		Path srcFile = Path.of("sample.txt");
//		Files.copy(srcFile, dest.resolve(srcFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);
		
	}
}


class WalktheTree extends SimpleFileVisitor<Path> {
	Path dest = Path.of("target-dir");
	
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		Files.copy(dir, dest);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Files.copy(file, dest.resolve(file.getFileName()));
		return super.visitFile(file, attrs);
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("Failed operation on :" + file.getFileName());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}
	
	
}