package threads.thread_interacton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * We have a Operator and Machine 
 * Operator is a single user running on a single thread 
 * Machine are multiple so we have multiple threads for Machine 
 * Machines wait for Operator to enter the shape
 * Once shape is provided Operator notifies all the Machines to start their operation 
 * @author 002L2N744
 *
 */
public class _3_operator_machine_notifyAll {
	public static void main(String[] args) {
		_Operator operator = new _Operator();
		_Machine machine = new _Machine(operator);

		Thread operatorThread = new Thread(operator, "operator-thread");
		Thread machineThread = new Thread(machine, "machine-thread-1");
		Thread machineThread2 = new Thread(machine, "machine-thread-2");

		machineThread.start();
		machineThread2.start();
		operatorThread.start();
		
	}

}

class _Operator implements Runnable {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String shape;
	@Override
	public void run() {

		while (true) {
			System.out.print(Thread.currentThread().getName()+ ":"+ "Enter the shape : ");
			try {
				shape = br.readLine();
			} catch (IOException e) {}

			synchronized (this) {
				System.out.println(Thread.currentThread().getName()+ ":"+ "Calculating the machine steps...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				this.notifyAll();
			}
		}

	}

}

class _Machine implements Runnable {

	_Operator operator;

	public _Machine(_Operator operator) {
		this.operator = operator;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (operator) {
				// wait for the operator to provide the shape
				try {
					operator.wait();
				} catch (InterruptedException e) {}
				
				System.out.println(Thread.currentThread().getName()+ ":"+ "Machine received the shape : "+ operator.shape);
				//execute machine-hardware steps
				System.out.println("Executing machine hardware steps...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				System.out.println(Thread.currentThread().getName()+ ":"+ "Execution Complete machine hardware steps...");
			}
		}
	}

}