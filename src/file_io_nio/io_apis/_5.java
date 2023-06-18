package file_io_nio.io_apis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Playing with the Directories & files
 * 
 * @author 002L2N744
 *
 */
public class _5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file1;
		File file2;
		File file3;
		PrintWriter pw;

		try {
			// creating directory and file
			file1 = new File("myDir2");
			file1.mkdir();
			file1 = new File("myDir2", "MyFile5_1.txt");
			file1.createNewFile();

			// writing to the file
			pw = new PrintWriter(file1);
			pw.println("Howdy java! Welcome to java 17");
			pw.flush();
			pw.close();

			// creating another file in same directory
			file2 = new File("myDir2", "MyFile5_2.txt");
			file2.createNewFile();
			// writing to the file
			pw = new PrintWriter(file2);
			pw.println("Howdy java! Welcome to java 21");
			pw.flush();
			pw.close();

			// renaming
			//Rename is possible when file is renamed to an empty file object 
			file3 = new File("myDir2", "new_file_1.txt");
			if (file2.renameTo(file3)) {
				System.out.println("Rename is success");
				file2.delete();
			} else {
				System.out.println("Rename failed");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
