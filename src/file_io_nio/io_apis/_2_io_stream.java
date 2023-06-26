package file_io_nio.io_apis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class _2_io_stream {

	public static void main(String[] args) {
		String str = "Today we are opening\nLive Classes\nPlease join!";
		File file;
		FileInputStream fis;
		FileOutputStream fos;
		byte[] in = new byte[str.length()];
		
		try {
			file = new File("C:\\Users\\002L2N744\\Documents\\Code-Practice\\temp\\MyFile2.txt");
			fos = new FileOutputStream(file);
			fos.write(str.getBytes(Charset.defaultCharset()));
			
			fos.flush();
			fos.close();
			
			fis = new FileInputStream(file);
			int read = fis.read(in);
			System.out.println("size of read: "+ read);
			for(byte b: in) 
				System.out.print((char)b);
			
			fis.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
