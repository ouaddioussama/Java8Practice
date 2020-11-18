package list;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//iterate();
		
		List<String> lists=Arrays.asList("hello","ola","you","kira");
		iterate(lists);

	}
	
	public static void iterate() {
		String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
		List<String> list=IntStream.range(0, names.length)
				 .peek(i->System.out.println(names[i]))
		         .filter(i -> names[i].length() <= i)
		         .mapToObj(i -> names[i])
		         .collect(Collectors.toList());
		
	 
		System.out.println(list);
	}

	
	public static void iterate(List<String> list) {
		String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
		
		IntStream.range(0, list.size())
				.filter(i->list.get(i).length()>3)
				.mapToObj(i->list.get(i))
				.forEach(System.out::println);
	}
	
	protected Integer chew() throws Exception {
		System.out.println("Rodent is chewing");
		return 1;
		}
	
}
