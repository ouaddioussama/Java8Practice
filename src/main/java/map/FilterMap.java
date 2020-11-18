package map;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterMap {

	public static void main(String[] args) {
	      LocalDateTime now = LocalDateTime.now();
	        System.out.println( (now));
	        
		filterMapwithPredicate();
	}

	public static void filterMapBeforeJava8() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");

		String result = "";
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if ("heroku.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}

		System.out.println(result);
	}

	public static void filterMapwithJava8() {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");
		map.put(3, "heroku.com");

		// Map -> Stream -> Filter -> String
		String result = map.entrySet().stream().filter(x -> "heroku.com".equals(x.getValue())).map(x -> x.getValue())
				.collect(Collectors.joining());

		System.out.println(result);
	}

	public static void filterMapwithJava8Map() {
		// Map -> Stream -> Filter -> MAP
		

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "linode.com");
		map.put(2, "heroku.com");
		map.put(3, "heroku.com");
		
		Map<Integer, String> collect = map.entrySet().stream().filter(x -> x.getKey() == 2)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		System.out.println(collect);
		
	    Map<Integer, String> collect2 = map.entrySet().stream()
	            .filter(x -> x.getKey() == 3)
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	            
		System.out.println(collect2);
 
	    

	}
	
	public static void filterMapwithJava8Map2() {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

		
	    // filter more values
	    String result = HOSTING.entrySet().stream()
	            .filter(x -> {
	                if (!x.getValue().contains("amazon") && !x.getValue().contains("digital")) {
	                    return true;
	                }
	                return false;
	            })
	            .map(map -> map.getValue())
	            .collect(Collectors.joining(","));

	    System.out.println("With Java 8 : " + result);

	}
	
    // Generic Map filterbyvalue, with predicate
    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

	public static void filterMapwithPredicate() {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        HOSTING.put(5, "aws2.amazon.com");

        //  {1=linode.com}
        Map<Integer, String> filteredMap = filterByValue(HOSTING, x -> x.contains("linode"));
        System.out.println(filteredMap);

        // {1=linode.com, 4=aws.amazon.com, 5=aws2.amazon.com}
        Map<Integer, String> filteredMap2 = filterByValue(HOSTING, x -> (x.contains("aws") || x.contains("linode")));
        System.out.println(filteredMap2);

        // {4=aws.amazon.com}
        Map<Integer, String> filteredMap3 = filterByValue(HOSTING, x -> (x.contains("aws") && !x.contains("aws2")));
        System.out.println(filteredMap3);

        // {1=linode.com, 2=heroku.com}
        Map<Integer, String> filteredMap4 = filterByValue(HOSTING, x -> (x.length() <= 10));
        System.out.println(filteredMap4);
	}


}
