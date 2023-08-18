package threads;

import java.util.HashSet;
import java.util.Set;

/**
 * Race condition occurs when multiple threads tries to book the same resource,
 * and ends up racing with one another 
 * We need to ensure that race condition doesn't do double bookings, and cause loss in data integrity 
 * @author 002L2N744
 *
 */
public class _9_race_condition {
	public static void main(String[] args) {
		
		TestShow testShow = new TestShow();
		testShow.go();
	}
}

class TestShow {
	
	public void go() {
		
		Thread mmt = new Thread(() -> {
			getMeSeats("1A");
			getMeSeats("1B");
			
		}, "MakeMyTrip" );
		
		Thread bms = new Thread( () -> {
			getMeSeats("1A");
			getMeSeats("1B");
			
		} , "BookMyShow" );
		
		mmt.start();
		bms.start();
	}
	
	public void getMeSeats(String seat) {
		Show show = Show.getInstance();
		System.out.println(Thread.currentThread().getName() + " books seat "+ seat+ " : " +show.bookSeat(seat));
	}
}

class Show {
	
	//making INSTANCE volatile, ensures operation is Atomic
	private static volatile Show INSTANCE;
	
	private Set<String> availableSeats;
	
	private Show() {
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
		
	}
	
	//synchronizing the object creation ensures multiple threads donot create multiple objects 
	public synchronized static Show getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Show();
		}
		
		return INSTANCE;
	}
	
	//synchronized the removal of value from Set, because Set is not thread-safe
	public synchronized boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}
}
