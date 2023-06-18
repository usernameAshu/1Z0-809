package file_io_nio.nio_apis;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Relativizing a Path 
 * @author 002L2N744
 *
 */
public class _5 {

	/**
	 * If any of the path type (relative/absolute) is different from the other 
	 * then <code>IllegalArgumentException</code> is thrown
	 */
	public static void main(String[] args) {
		
		
		Path p1 = Paths.get("C:/a/b/c/d");
		Path p2 = Paths.get("C:/a/b/e/f/g.txt");
		
		/**
		 * Imagine how you will get from last-element in p1 to last-element in p2
		 * cd ../../e/f/g.txt
		 */
		System.out.println(p1.relativize(p2));
	}

}
