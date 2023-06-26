package file_io_nio.serialization;

import java.util.Scanner;

public class _3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press enter to exit");
		while(true) {
			String input = scanner.nextLine();
			if(input.isEmpty()) {
				break;
			}
		}
		
	}

}
