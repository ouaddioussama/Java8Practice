package stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethodes {

	public static void main(String[] args) {
		groupingByItem();
	}

	public static void reduceSum() {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 1st argument, init value = 0
		int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
		System.out.println("sum : " + sum); // 55

		// methode 2
		sum = Arrays.stream(numbers).reduce(0, Integer::sum); // 55
		System.out.println("sum : " + sum); // 55
	}

	public static void reduceMax() {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(max);
		int max1 = Arrays.stream(numbers).reduce(0, Integer::max); // 10
		System.out.println(max1);

	}

	public static void groupingBy() {
		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);
		
		//sorting
        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
        

	}
	
	public static void groupingByItem() {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        
        Map<String, Long> counting =items.stream()
        							.collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
        
        System.out.println(counting);
        
        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);
        
        
	}


}
