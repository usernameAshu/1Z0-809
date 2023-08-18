package threads;

public class _7_synchronization_locks {

	public static void main(String[] args) {
		
		_7_synchronization_locks obj1 = new _7_synchronization_locks();
		_7_synchronization_locks obj2 = new _7_synchronization_locks();
		
		Runnable r1 = () -> obj1.firstStep();
		Runnable r2 = () -> obj2.firstStep();
		
		Thread t1 = new Thread(r1, "Thread-1");
		Thread t2 = new Thread(r1, "Thread-2");
		
		t1.start();
		t2.start();
	}

	public synchronized void firstStep() {

		System.out.println(Thread.currentThread().getName() + " enters firstStep");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		System.out.println(Thread.currentThread().getName() + " exits firstStep after sleeping 5secs");
		this.thirdMethod();
		new A().methodA();
	}

	public void secondMethod() {

		System.out.println(Thread.currentThread().getName() + " enters secondMethod");
		this.thirdMethod();
		System.out.println(Thread.currentThread().getName() + " exits secondMethod");
	}

	public void thirdMethod() {

		System.out.println(Thread.currentThread().getName() + " enters thirdMethod");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		System.out.println(Thread.currentThread().getName() + " exits thirdMethod after sleeping 5secs");
	}
}

class A {
	
	public synchronized void methodA() {
		System.out.println(Thread.currentThread().getName() + " enters methodA");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		System.out.println(Thread.currentThread().getName() + " exits methodA after sleeping 5secs");
	}
}
