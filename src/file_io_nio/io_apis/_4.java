package file_io_nio.io_apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class _4 {

	public static void main(String[] args) {
		File file;
		PrintWriter pw; 
		FileReader fr;
		BufferedReader br;
		
		try {
			//creating directory & writing data into file
			file = new File("mydir");
			file.mkdir();
			
			file = new File("mydir", "MyFile4.txt");
			pw = new PrintWriter(file);
			pw.println("Good morning\nJava learning files & directories");
			pw.close();
			
			//read the data 
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while(br.ready()) {
				System.out.println(br.readLine());
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
