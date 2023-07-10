package file_io_nio.file_visitor;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class _2_PathMatcher {
	
	public static void main(String[] args) {
		
		Path searchDir = Path.of("temp");
		Path dir = Path.of("temp/child/grandChild/angular.txt");
		
//		String globPattern = "glob:**/grandChild/**.txt";
		String globPattern = "glob:**.txt";
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(globPattern );
		
		System.out.println( matcher.matches(dir));
		
		//combining the functionality of PathMatcher and FileVisitor 
		try {
			Files.walkFileTree(searchDir, new CustomFileVisitor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



class CustomFileVisitor extends SimpleFileVisitor<Path> {
	
	String globPattern = "glob:**/grandChild/*.txt";
	PathMatcher matcher = FileSystems.getDefault().getPathMatcher(globPattern );
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (matcher.matches(file))
			System.out.println("file: " + file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	
}