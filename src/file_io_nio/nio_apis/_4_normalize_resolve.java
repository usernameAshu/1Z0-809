package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Normalizing paths 
 * @author 002L2N744
 *
 */
public class _4_normalize_resolve {

	public static void main(String[] args) throws IOException {
		
		Path p1 = Paths.get("nio/dir1/files/");
		Path file_p1 = Paths.get("nio/dir1/files/file1.txt");
		Path p2 = Paths.get("C:/nio_dir/nio_files/");
		Files.createDirectories(p1);
		//Files.createFile(file_p1);	
		
		System.out.println(file_p1.getFileName());
		System.out.println(file_p1.getRoot());
		System.out.println(file_p1.getParent());
		System.out.println(p2.getRoot());
		System.out.println(p2.getParent());
		
		Path p3 = Paths.get("a/b/c/././././d/../../c");
		
		/**
		 * a/b/c/././././d/../../c ->
		 * We can remove "current directory command" {./} when we see it after any directory
		 * So removing {././././}
		 * a/b/c/d/../../c
		 * When we have parent directory {../} after any folder, we can remove that folder and {../}
		 * So removing {d/../} , in same way removing others {c/../}
		 * a/b/c  => This is the normalized path 
		 */
		
		System.out.println(p3.normalize());
		
		/**
		 * When we have relative path : a/../../../b 
		 * Then as per the rules : {a/../} will be removed, but since we don't know what's before the relative path
		 * the other "previous directory" command will be kept intact:
		 * Normalized path: after removing { a/../}
		 * ../../b
		 * 
		 * For absolute path : /a/../../../b 
		 * We will remove: {a/../}, {/../}, {/..} 
		 * Normalized path:
		 * /b
		 */
		
		p1 = Paths.get("a/../../../b");
		p2 = Paths.get("/a/../../../b");
		System.out.println(p1.normalize());
		System.out.println(p2.normalize());
		
		
		/**
		 * Resolve: 
		 * Basically it means concatenating two paths , below are the scenarios:
		 * relative path + relative path 
		 * absolute path + relative path
		 * relative path + absolute path 
		 * absolute path + absolute path  
		 * If you have absolute path as the 2nd attribute, then that always gets chosen 
		 */
		p1 = Paths.get("a/b/c/d");
		p2 = Paths.get("e/f/g/h");
		System.out.println(p1.resolve(p2)); //  a\b\c\d\e\f\g\h
		
		p1 = Paths.get("/a/b/c/d");
		p2 = Paths.get("e/f/g/h");
		System.out.println(p1.resolve(p2));//  \a\b\c\d\e\f\g\h
		
		p1 = Paths.get("a/b/c/d");
		p2 = Paths.get("/e/f/g/h");
		System.out.println(p1.resolve(p2));//  \e\f\g\h
		
		p1 = Paths.get("/a/b/c/d");
		p2 = Paths.get("/e/f/g/h");
		System.out.println(p1.resolve(p2));//  \e\f\g\h
		
		p1 = Paths.get("/a/b/c/d");
		p2 = Paths.get("/e/f/g/h");
		System.out.println(p1.resolve(p2));//  \e\f\g\h
		
		p1 = Paths.get("/a/b/c/d");
		p2 = null;
		//System.out.println( p1.resolve(p2)); /NullPointerException 
	}

}
