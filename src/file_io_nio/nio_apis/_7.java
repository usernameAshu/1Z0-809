package file_io_nio.nio_apis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * isSameFile
 * @author 002L2N744
 *
 */
public class _7 {
    public static void main(String[] args) throws IOException {
        /*
          When isSameFile is called ,
          Files first compares the paths of the files
          If paths are not same , then file name and file existence is checked
         */
        Path p1 = Paths.get("nio1.txt");
        Path p2 = Paths.get("nio1.txt");

        boolean result = Files.isSameFile(p1, p2);
        System.out.println(result);

    }
}
