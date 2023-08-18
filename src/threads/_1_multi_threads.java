package threads;

public class _1_multi_threads {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Start: "+ Thread.currentThread().getName());
		Runnable r = () -> {
			for(int i=0; i<10;i++) 
				System.out.println(Thread.currentThread().getName() + ", i ="+ i);
		};
		
		Thread john = new Thread(r, "john");
		Thread smith = new Thread(r, "smith");
		Thread hulk = new Thread(r, "hulk");
		
		john.start();
		smith.start();
		hulk.start();
		
		System.out.println("End"+ Thread.currentThread().getName());
	}

}
