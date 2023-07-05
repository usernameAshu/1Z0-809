package file_io_nio.directory_attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

public class _1_permissions {
	
	public static void main(String[] args) {
		
		Path sample = Path.of("sample.txt");
		try {
		Files.createFile(sample);
		
		System.out.println( Files.isReadable(sample));
		System.out.println( Files.isExecutable(sample));
		System.out.println( Files.isWritable(sample));
		System.out.println( Files.getLastModifiedTime(sample)); 
		
		//change files's last modified time 
		FileTime fileTime = generateFileTimeAfter(20L);
		Files.setLastModifiedTime(sample, fileTime);
		
		System.out.println("Updated: "+ Files.getLastModifiedTime(sample)); 
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				Files.deleteIfExists(sample);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static FileTime generateFileTimeAfter(long days) {
		Clock clock = Clock.offset(Clock.systemDefaultZone(), Duration.ofDays(days));
		Instant instant = Instant.now(clock);
		FileTime fileTime = FileTime.from(instant);
		
		return fileTime;
	}
}
