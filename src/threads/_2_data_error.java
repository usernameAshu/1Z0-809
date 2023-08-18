package threads;

public class _2_data_error {
	
	public static void main(String[] args) {
		
		Sum sum = () -> {
			int n = 10;
			int result = 0;
			//int result = (n * (n+1))/2;
			for(int i=1;i<=n;i++)
				result = result +i;
			
			System.out.println(Thread.currentThread().getName()+ ", Sum="+ result);
		};
		
		Runnable r = () -> sum.getSumOf10naturalNumbers();
		
		Thread john = new Thread(r, "john");
		Thread smith = new Thread(r, "smith");
		Thread hulk = new Thread(r, "hulk");
		
		john.start();
		smith.start();
		hulk.start();
		
	}

}

interface Sum {
	
	void getSumOf10naturalNumbers();
}