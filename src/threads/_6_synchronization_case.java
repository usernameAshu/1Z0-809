package threads;

public class _6_synchronization_case {
	
	public static void main(String[] args) {
		
		AccountTest test = new AccountTest();
		
		Runnable withdrawTask = () -> {
			int index = 1;
			while(index<=5) {
				test.makeWithdrawal(10);
				index++;
			}
		};
		
		Thread john = new Thread(withdrawTask, "John");
		Thread mary = new Thread(withdrawTask, "Mary");
		
		john.start();
		mary.start();
	}

}



class Account {
	
	private int balance = 50;
	
	public void withdraw(int amt) {
		balance = balance - amt;
	}
	
	public int getBalance() {
		return balance;
	}
}

class AccountTest {
	
	private Account acc = new Account();
	
	synchronized void makeWithdrawal(int amt) {
		if(acc.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() 
					+" prepares to withdraw, Balance : "+ acc.getBalance());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		acc.withdraw(amt);
		System.out.println(Thread.currentThread().getName() + 
				" withdrawn "+ amt+ " from account, Remaining Balance: "+ acc.getBalance());
			
		} else {
			System.out.println(Thread.currentThread().getName() +
					" is trying to withdraw from an overdrawn account, Balance: "+ 
					acc.getBalance());
		}
	}
	
}