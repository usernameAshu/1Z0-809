package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * By making the count as atomic, we can make it thread safe
 * We can also use synchronized at increment(), but acquiring & releasing locks takes lot of resources 
 * Atomic is more efficient 
 * @author 002L2N744
 *
 */
public class _1_atomic {
	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		IncrementCounter incCounter = new IncrementCounter(counter);
		
		Thread t1 = new Thread(incCounter, "thread-1");
		Thread t2 = new Thread(incCounter, "thread-2");
		
		t1.start();
		t2.start();
		
		t1.join();t2.join();
		System.out.println("Counter : "+ counter.getCount());
	}

}

class Counter {
	
//	private int count;
	private AtomicInteger count = new AtomicInteger();
	
	public void increment() {
		count.getAndIncrement();
//		count++;
	}
	
	public int getCount() {
		return count.get();
//		return count;
	}
}

class IncrementCounter implements Runnable {
	
	Counter counter;
	
	public IncrementCounter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for(int i = 0; i<1000; i++) {
			counter.increment();
		}
	}
	
}