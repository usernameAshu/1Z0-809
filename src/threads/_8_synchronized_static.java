package threads;

public class _8_synchronized_static {

	public static void main(String[] args) throws InterruptedException {
		
		_8_synchronized_static obj1 = new _8_synchronized_static();
		_8_synchronized_static obj2 = new _8_synchronized_static();
		_8_synchronized_static obj3 = new _8_synchronized_static();
		
		Runnable instanceMethod1 = () -> { 
			obj1.instanceMethod1();
		};
		
		Runnable instanceMethod2 = () -> {
			obj2.instanceMethod2();
		};
		
		Runnable static1 = () -> {
			//_8_synchronized_static.staticMethod1();
			obj1.staticMethod1();
		};
		

		Runnable static2 = () -> {
			//_8_synchronized_static.staticMethod2();
			obj2.staticMethod2();
		};
		
		Runnable staticInstanceBlock = () -> {
			obj3.instanceMethod1();
			_8_synchronized_static.staticMethod1();
		};
		
//		Thread instance_static = new Thread(staticInstanceBlock, "thread-0");
//		instance_static.start();
//		
//		Thread t1_instance = new Thread(instanceMethod1, "t1-instance");
//		Thread t2_instance = new Thread(instanceMethod2, "t2-instance");
//		
		Thread t1_static = new Thread(static1, "t1-static");
		Thread t2_static = new Thread(static2, "t2-static");
//		
//		t1_instance.start();
//		t2_instance.start();
//		
//		Thread.sleep(15000);
//		
		t1_static.start();
		t2_static.start();
		
	}
	
	public synchronized void instanceMethod1() {
		System.out.println(Thread.currentThread().getName() + " enters instanceMethod1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " exits instanceMethod1 after sleeping 5secs");

	}

	public synchronized void instanceMethod2() {
		System.out.println(Thread.currentThread().getName() + " enters instanceMethod2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " exits instanceMethod2 after sleeping 5secs");

	}

	public synchronized static void staticMethod1() {
		System.out.println(Thread.currentThread().getName() + " enters staticMethod1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " exits staticMethod1 after sleeping 5secs");
	}

	public synchronized static void staticMethod2() {
		System.out.println(Thread.currentThread().getName() + " enters staticMethod2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + " exits staticMethod2 after sleeping 5secs");

	}

}