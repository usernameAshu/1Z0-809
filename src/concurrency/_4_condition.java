package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _4_condition {
	
	private Lock lock = new  ReentrantLock();
	private Condition condition1 = lock.newCondition(); 
	
	public static void main(String[] args) throws InterruptedException {
		
		_4_condition obj = new _4_condition();
		Runnable producerTask = obj::produce;
		Runnable consumerTask = obj::consume;
		
		Thread producerThread = new  Thread(producerTask, "producer-thread");
		Thread consumerThread = new  Thread(consumerTask, "consumer-thread");
		
		consumerThread.start();
		//Thread.sleep(2000);
		producerThread.start();
		
	}
	
	public void produce() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" :producing the data to queue...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			condition1.signal();
			
		} finally {
			lock.unlock();
		}
		
	}
	
	public void consume() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() +" :Waiting to consume the data from queue...");
			condition1.await();
			System.out.println(Thread.currentThread().getName() +" :Data consumed from queue...");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
