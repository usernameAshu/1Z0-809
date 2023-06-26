package file_io_nio.io_apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class _3_wrapper_reader {

	public static void main(String[] args) {
		
		String str = "Today we are again opening\nLive Classes\nPlease join asap!";
		File file;
		FileWriter fw;
		PrintWriter pw;
		FileReader fr;
		BufferedReader br;
		
		try {
			//writing
			file = new File("MyFile3.txt");
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			pw.println(str);
			
			fw.flush();
			fw.close();
			pw.flush();
			pw.close();
			
			//reading
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(br.ready()) {
				System.out.println(br.readLine());
			}
			
		} catch(Exception e) {
			
		}
	}

}
