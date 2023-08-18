package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2_locks {
	
	public static void main(String[] args) throws InterruptedException {
		
		Reader reader = new Reader();
		Thread t1 = new Thread(reader, "reader-t1");
		Thread t2 = new Thread(reader, "reader-t2");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Reader count: "+ reader.count);
	}

}

class Reader implements Runnable {
	
	int count;
	Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		
		for(int i =0 ; i<1000;i++) {
				lock.lock();
				try {
					count++;
				} finally {
					lock.unlock();
				}
			
			
		}
	}
	
	
}