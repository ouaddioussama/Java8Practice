package usallyUsedMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListOperation {

	static List<Integer> listInteger=new ArrayList<>();
	
	static {
		  listInteger=Arrays.asList(1,2,3,2,2,4,5,6,17);

	}

	public static void main(String[] args) {
		System.out.println(getMaxOccur(listInteger));

	}
	
	public static int getMaxOfList(List<Integer> listData) {
		
		Optional<Integer> max=listData.stream().max((o1,o2)->o1-o2);
		return max.isPresent()?max.get():0;
	}
	
	public static int getMinOfList(List<Integer> listData) {
		
		Optional<Integer> min=listData.stream().min((o1,o2)->o1-o2);
		return min.isPresent()?min.get():0;
	}
	
	public static int getMaxOccur(List<Integer> listData) {
		
		Map<Integer,Long> valueCounts = 
				listData.stream()
			           .collect ( Collectors.groupingBy(Function.identity(), Collectors.counting()  ))
			           ;
	   /*
		Map<Integer,Long> valueCounts2 = valueCounts
													.entrySet().stream()
													.sorted(Map.Entry.comparingByValue())
													.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
													*/
        Map<Integer, Long> valueCounts2 = new LinkedHashMap<>();
		
		valueCounts.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> valueCounts2.put(x.getKey(), x.getValue()));
        
		System.out.println(valueCounts2.keySet().toArray()[0]);
		/*
		int max=valueCounts.entrySet().stream()
                			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                			;
			*/
		
		System.out.println(valueCounts2);
		//Collectors.groupingBy(listData::getValue,Collectors.counting())
		
		
		return 0;
	}


}
