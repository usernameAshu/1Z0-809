package file_io_nio.nio_apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _8_create_old_new {

	public static void main(String[] args) {

		//old way 
		File file = new File("ioFile.txt");

		try (FileWriter fw = new FileWriter(file);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				PrintWriter pw = new PrintWriter(fw);) {
			pw.println("Welcome to Java 21\n Happy learning");
			pw.flush();
			pw.close();

			while (br.ready()) {
				System.out.println(br.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//new way
		Path nioFile = Paths.get("nioFile.txt");
		try {
		Files.createFile(nioFile);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}
}
