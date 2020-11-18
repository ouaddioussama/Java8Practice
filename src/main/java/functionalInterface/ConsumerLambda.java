package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fetchList();
	}
	
	public static void consume() {
		Consumer<String> print= x->System.out.println(x);
		print.accept("oussama");
		
	}
	
	public static void fetchList() {
        List<String> listString = Arrays.asList("ouss","kira","sama");
		Consumer<String> print= x->System.out.println(x);

        forEach( listString, print) ;
	}

	
	

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
    
}
