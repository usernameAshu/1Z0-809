package threads.thread_interacton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_operator_machine_interface {
	public static void main(String[] args) {
		_Operator operator = new _Operator();
		Machine machine = new Machine(operator);

		Thread operatorThread = new Thread(operator, "operator-thread");
		Thread machineThread = new Thread(machine, "machine-thread");

		machineThread.start();
		operatorThread.start();
	}

}

class Operator implements Runnable {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String shape;
	@Override
	public void run() {

		while (true) {
			System.out.print("Enter the shape : ");
			try {
				shape = br.readLine();
			} catch (IOException e) {}

			synchronized (this) {
				System.out.println("Calculating the machine steps...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				this.notify();
			}
		}

	}

}

class Machine implements Runnable {

	_Operator operator;

	public Machine(_Operator operator) {
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
				
				System.out.println("Machine received the shape : "+ operator.shape);
				//execute machine-hardware steps
				System.out.println("Executing machine hardware steps...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				System.out.println("Execution Complete machine hardware steps...");
			}
		}
	}

}