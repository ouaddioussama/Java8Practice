package functionalInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertListToMap();
	}
	
	
	public static void function1() {
        //Function<T,R> -> type argument of type T and return result of type R
		
        Function<String, Integer> func = x -> x.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result = func.andThen(func2).apply("oussama");   // 14

        System.out.println(result);
	}

	public static void convertListToMap() {
		

        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        // lambda
        Map<String, Integer> map = convertListToMap(list, x -> x.length());

        System.out.println(map);    // {node=4, c++=3, java=4, javascript=10}

        // method reference
        Map<String, Integer> map2 = convertListToMap(list, FunctionLambda::getLength);

        System.out.println(map2);
        
	}
	
    public static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {

        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;

    }

    public static Integer getLength(String str) {
        return str.length();
    }
    
    
    
}
