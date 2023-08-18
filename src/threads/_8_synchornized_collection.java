package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Here instead of using Collections.synchronizedList(new LinkedList<>());
 * we are synchronizing at higher level, ensuring data integrity
 * @author 002L2N744
 *
 */
public class _8_synchornized_collection {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PlayWithCollection obj1 = new PlayWithCollection();
		
		obj1.addName("Burj Khalifa");
		obj1.addName("Taj Mahal");
		obj1.addName("St Petersburg");
		obj1.addName("Qututb Minar");
		obj1.addName("Bangalore");
		
		Runnable task = () -> {
			obj1.removeFirst();
		};
		
		Thread t1;
		Thread t2;
		String in;
		do {
			
			t1 = new Thread(task, "thread-0");
			t2 = new Thread(task, "thread-1");
			
			t1.start();
			t2.start();
			
			Thread.sleep(2000);
			System.out.print("\nPress any key to exit or enter to continue: ");
			in = br.readLine();
			
		} while(in.isEmpty());
	}
}

class PlayWithCollection {
	
	private final List<String> names = new LinkedList<>();
	
	public synchronized void addName(String name) {
		names.add(name);
	}
	
	public synchronized void removeFirst() {
		if(names.size() > 0) {
			System.out.println(Thread.currentThread().getName()+ 
					" removing "+ names.get(0));
			names.remove(0);
			
		} else {
			System.out.println(Thread.currentThread().getName()
					+ " finds List is empty");
		}
	}
}