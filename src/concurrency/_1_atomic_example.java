package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * It's a video game having 2 players and 10 monsters
 * The objective is that 2 players simultaneously is destroying the monsters
 * Display how many monsters each player destroys 
 * @author 002L2N744
 *
 */
public class _1_atomic_example {
	
	public static void main(String[] args) throws InterruptedException {
		
		Monster monster = new Monster(11);
		Player player1 = new Player("player-1", monster);
		Player player2 = new Player("player-2", monster);
		
		player1.start();
		player2.start();
		
		player1.join();
		player2.join();
		
		System.out.println("\nPlayer 1: " + player1.count +"\nPlayer 2: "+ player2.count);
	}
	
}

class Monster { 
	private AtomicInteger monsterCount = new AtomicInteger();
	
	Monster(int initialCount) {
		monsterCount.set(initialCount);
	}
	
	void decrementMonster() {
		monsterCount.getAndDecrement();
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " has killed 1 monster");
			System.out.println("Monster count remaining: " + getCount());
		}
	}
	
	int getCount() {
		return monsterCount.get();
	}
}

class Player extends Thread {
	
	Monster monster;
	int count;
	
	Player(String threadName, Monster monster) {
		super(threadName);
		this.monster = monster;
	}
	
	@Override
	public void run()  {
		
		while(monster.getCount() > 0) {
			monster.decrementMonster();
			count++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	
}
	

