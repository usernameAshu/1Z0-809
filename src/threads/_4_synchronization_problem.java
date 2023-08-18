package threads;

public class _4_synchronization_problem {
	
	public static void main(String[] args) {
		
		Account2 a = new Account2();
		Runnable withdrawTask = () -> {
			int x =0;
			while(x<15) {
			a.makeWithdrawal(5);
			x++;
			}
		};
		
		Thread sam = new Thread(withdrawTask, "sam");
		Thread john = new Thread(withdrawTask, "john");
		
		sam.start();
		john.start();
	}
	
}

class Account2 {
	
	int balance = 50 ;
	
	public void makeWithdrawal(int amount) {
		if(balance >= amount) {
		balance = balance - amount; 
		System.out.println(Thread.currentThread().getName() 
				+ " withdrew "+ amount+ ", Balance="+ balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " is overdrawing");
		}
	}
}
