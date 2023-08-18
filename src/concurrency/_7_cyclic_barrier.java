package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class _7_cyclic_barrier {
	
	private List<String> result = new ArrayList<>();
	
	static String[] dogs1 = {"splitz","pug","alsassian","doverman" };
	static String[] dogs2 = {"Labrador","retriver","shephard","pitbull" };
	CyclicBarrier barrier;
	
	class ProcessDogs implements Runnable {
		
		String s[];
		
		ProcessDogs(String s[]) {
			this.s = s;
		}

		@Override
		public void run() {
			for(int i=0;i<s.length;i++) {
				String dogName = s[i];
				String newDogName = dogName.substring(0,1).toUpperCase() + dogName.substring(1);
				s[i] = newDogName;
			}
			
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() +" done!");
		}
		
	}
	
	public _7_cyclic_barrier() {
		barrier = new CyclicBarrier(2, () -> {
			
			for(int i=0;i<dogs1.length;i++)
				result.add(dogs1[i]);
			for(int i=0;i<dogs2.length;i++)
				result.add(dogs2[i]);
			
			System.out.println("Result array: "+ result);
			
		});
		
		Thread t1 = new Thread(new ProcessDogs(dogs1));
		Thread t2 = new Thread(new ProcessDogs(dogs2));
		
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		_7_cyclic_barrier cb = new _7_cyclic_barrier();
	}
}
