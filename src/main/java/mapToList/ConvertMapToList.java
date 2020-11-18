package mapToList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {

	public static void main(String[] args) {
		convertWithJava8Sort();
	}

	public static void convertBeforeJava8() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");

		// Convert all Map keys to a List
		List<String> result = new ArrayList(map.keySet());

		// Convert all Map values to a List
		List<String> result2 = new ArrayList(map.values());

		System.out.println(result);
		System.out.println(result2);

	}

	public static void convertWithJava8() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");

		// Java 8, Convert all Map keys to a List

		List<Integer> result3 = map.keySet().stream()
								   .collect(Collectors.toList());
		
		System.out.println(result3);
		
		
		// Java 8, Convert all Map values  to a List
		List<String> result4 = map.values().stream() 
								  .filter(x -> x.contains("heroku"))
								  .collect(Collectors.toList());
		
		System.out.println(result4);
	
	}
	
	public static void convertWithJava8Sort() {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());

        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);
	}


}
