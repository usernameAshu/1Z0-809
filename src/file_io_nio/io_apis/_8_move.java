package file_io_nio.io_apis;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class _8_move {
	
	public static void main(String[] args) {
		File srcFile;
		File destFile;
		
		try {
			
			srcFile = new File("ioFile1.txt");
			destFile = new File("ioFile2.txt");
			
			FileWriter fw = new FileWriter(srcFile);
			PrintWriter pw = new PrintWriter(fw);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
