package conceptsTesting;

public class StringTest {
	
	public static void main(String[] args) {
		String str = "Hi, Second message! How can I help you?";
		String substring = str.substring(4, str.indexOf('!'));
		
		System.out.println( substring );
	}
}
