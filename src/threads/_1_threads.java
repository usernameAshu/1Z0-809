package threads;

public class _1_threads {

	public static void main(String[] args) throws InterruptedException {

		Runnable task1 = () -> System.out.println(Thread.currentThread().getName() 
				+ " running task1");

		System.out.println(Thread.currentThread().getName() 
				+ " inside main.. starting the task1");
		
		Thread t1 = new Thread(task1);
		t1.run();
//		t1.join();

		System.out.println(Thread.currentThread().getName() 
				+ " inside main..end of program");

	}

}
