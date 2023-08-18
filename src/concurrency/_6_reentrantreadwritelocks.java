package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author 002L2N744
 *
 */
public class _6_reentrantreadwritelocks {
	
	private List<Integer> integers = new ArrayList<>();
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private int max;
	
	public void add(int i) {
		lock.writeLock().lock();
		try {
			integers.add(i);
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public void findMax() {
		lock.readLock().lock();
		try {
			max = Collections.max(integers);
		} finally {
			lock.readLock().unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		_6_reentrantreadwritelocks obj = new _6_reentrantreadwritelocks();
		
		Runnable addTask = () -> { for(int index=0;index <= 100000000;index++) obj.add(index); };
		Runnable readTask = obj::findMax;
		
		Thread t1 = new Thread(addTask);
		Thread t2 = new Thread(readTask);
		t1.start();
		Thread.sleep(100);
		t2.start();
		Thread.sleep(500);
		System.out.println(obj.max);
	}

}
