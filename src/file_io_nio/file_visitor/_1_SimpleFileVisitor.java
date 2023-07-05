package file_io_nio.file_visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class _1_SimpleFileVisitor {
	public static void main(String[] args) {
			
		Path dir = Path.of("temp");
		
		try {
			Files.walkFileTree(dir, new TraverseFileDirs());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class TraverseFileDirs extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("pre dir: " + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("file: "+ file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("post dir: " + dir);
		return FileVisitResult.CONTINUE;
	}
	
	
}