package conceptsTesting;

import java.util.LinkedHashMap;
import java.util.Map;

public class SwitchTest {
	
	public static void main(String[] args) {
		
//		System.out.println(m());
		
	}
	
	static String m() {
		String str = "SS";

		switch (str) {
		case "SS":
			System.out.println("SS");
			return "SS";
		case "DD":
			System.out.println("DD");
			return "SS";
		default:
			return null;
		}
	}
}
