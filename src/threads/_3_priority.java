package threads;

public class _3_priority {
	
	public static void main(String[] args) {
		
		Runnable r = () -> {
			for(int i=0; i<100; i++)
				System.out.println("Run by:\t"+Thread.currentThread().getName()+ 
						"\ti ="+ i);
		};
		
		Thread john = new Thread(r, "john");
		Thread mary = new Thread(r, "mary");
		Thread sam = new Thread(r, "sam");
		john.setPriority(Thread.MAX_PRIORITY);
		sam.setPriority(Thread.MIN_PRIORITY);
		
		mary.start();
		sam.start();
		john.start();
	}

}

