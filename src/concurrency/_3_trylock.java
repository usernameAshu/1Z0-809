package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _3_trylock {
	
	public static void main(String[] args) throws InterruptedException {
		
		Reader2 reader = new Reader2();
		Thread t1 = new Thread(reader, "reader-t1");
		Thread t2 = new Thread(reader, "reader-t2");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Reader count: "+ reader.count);
		System.out.println("Failed count: "+ reader.failedCount);
	}

}

class Reader2 implements Runnable {
	
	int count;
	int failedCount;
	Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		
		for(int i =0 ; i<1000;i++) {
			  if(lock.tryLock()) {
				try {
					count++;
				} finally {
					lock.unlock();
				}
			  } else {
				  failedCount++;
			  }
			
			
		}
	}
	
	
}