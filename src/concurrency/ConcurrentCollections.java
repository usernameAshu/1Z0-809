package concurrency;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConcurrentCollections {

	public static void main(String[] args) {

		Map<String, String> map = new LinkedHashMap<>();

		map.put("Name", "Ashutosh");
		map.put("Address", "banagalore");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());

		}

		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

		map.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}
