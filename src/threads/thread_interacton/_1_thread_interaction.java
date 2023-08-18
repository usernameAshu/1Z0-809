package threads.thread_interacton;

/**
 * wait(), notify(), notifyAll()
 * 
 * @author 002L2N744
 *
 */
public class _1_thread_interaction {
	
}

class ThreadA {

	public static void main(String[] args) {
		
		ThreadB t = new ThreadB("thread-b");
		t.start();
		
		synchronized(t) {
			try {
				System.out.println("Waiting for "+Thread.currentThread().getName()+" to finish");
				t.wait();
			} catch (InterruptedException e) {
				
			}
			System.out.println(Thread.currentThread().getName()+" notified, wait over");
		}

	}
}

class ThreadB extends Thread {
	int total;
	
	public ThreadB(String name) {
		super(name);
	}
	
	public void run() {
		synchronized(this) {
			System.out.println(Thread.currentThread().getName()+ " processing start...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(Thread.currentThread().getName()+ " processing done...");
		this.notify();
		}
	}
	
	
	
	
}
