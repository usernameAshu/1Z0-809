package file_io_nio.directory_attributes;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class _5_DirectoryStream {
	
	public static void main(String[] args) {
		Path dir = Path.of("temp/src");
		
		//displaying all the files in the specific directory 
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
				DirectoryStream<Path> filterDirectory = Files.newDirectoryStream(dir, "[jd]*");) {
			
			System.out.println("---------All files--------");
			directoryStream.iterator().forEachRemaining( path -> System.out.println(path.getFileName()) );
			
			System.out.println("---------Specific files--------");
			filterDirectory.forEach(System.out::println);
			//DirectoryStream.Filter<Path> filter = (Path path) -> path.endsWith("1");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
