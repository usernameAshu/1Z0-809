package file_io_nio.io_apis;

import java.io.File;

/**
 * Searching & listing files in directory 
 * @author 002L2N744
 *
 */
public class _6_file_list {

	public static void main(String[] args) {
		File file;
		
		try {
			file = new File("myDir2");
			String[] listOfFiles = file.list();
			for(String fileName : listOfFiles) { 
				System.out.println(fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
