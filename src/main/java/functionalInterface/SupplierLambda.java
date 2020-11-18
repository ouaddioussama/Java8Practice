package functionalInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierLambda {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		formatDateSupplier();
		SupplierLambda supplierLambda =new SupplierLambda();
		 List<String> list = (List<String>)(List<?>)  supplierLambda.supplier().get();
		 list.add("hello");
		 System.out.println(list);
	}

	public static void formatDateSupplier() {

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
	}
	
	
    public <T> Supplier<List<T>> supplier() {

        return ArrayList::new;

    }
}
