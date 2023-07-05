package file_io_nio.nio_apis;

import java.nio.file.Path;

public class _93_retrieveFileInfo {
	
	public static void main(String[] args) {
		
		Path file = Path.of("C:/Users/002L2N744/Documents/demo");
		
		System.out.println(file.getFileName());
		System.out.println(file.getFileSystem());
		System.out.println(file.getClass());
		System.out.println(file.getName(0));
		System.out.println(file.getParent());
		System.out.println(file.getNameCount());
		System.out.println(file.subpath(0, file.getNameCount()));
		System.out.println(file.getRoot());
		System.out.println(file.toString());
		
		/*
		    demo
			sun.nio.fs.WindowsFileSystem@7960847b
			class sun.nio.fs.WindowsPath
			Users
			C:\Users\002L2N744\Documents
			4
			Users\002L2N744\Documents\demo
			C:\
			C:\Users\002L2N744\Documents\demo
		 */
	}

}
