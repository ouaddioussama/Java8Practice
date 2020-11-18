package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BinaryOperatorLambda {
	
	public static void main(String[] args) {
		binaryoperator();
	}
	
	public static void binaryoperator() {
		BiFunction<Integer,Integer,Integer> biFunction= (x,y)->x+y;
		Integer result=biFunction.apply(4, 5);
		System.out.println(result);
        BinaryOperator<Integer> func2 = (x1, x2) -> x1 * x2;
	    result=func2.apply(4, 5);
		System.out.println(result);
	
        
	}
}
