package file_io_nio.file_visitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class _3_WatchService {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		//directory to observe
		Path dir = Path.of("temp/child");
		
		WatchService watcher = FileSystems.getDefault().newWatchService();
		dir.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
		
		while(true) {
			WatchKey key;
			
			key = watcher.take();
			
			for(WatchEvent<?> event : key.pollEvents()) {
				 Kind<?> kind = event.kind();
				 System.out.println("Event name: "+ kind.name());
				 System.out.println("Type of Event: "+ kind.type());
				 System.out.println("Name of the File: "+ event.context());
				 
				 String fileName = event.context().toString();
				 if(fileName.equalsIgnoreCase("stepChild")) {
					 System.out.println("stepChild directory deleted");
					 return;
				 }
			}
			key.reset();
		}
		
	}

}
