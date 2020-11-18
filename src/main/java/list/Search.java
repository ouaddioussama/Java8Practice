package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import models.Person;

public  class Search {

	public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Kotlin");
        list.add("Clojure");
        list.add("Groovy");
        list.add(null);
        list.add("Scala");
        list.add(null);
        
		//filterMap();
        
        List<String> listFiltred=filterNullValue(list);
        listFiltred.forEach(System.out::println);
	}

	private static void filterMapwithPredicate() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Kotlin");
        list.add("Clojure");
        list.add("Groovy");
        list.add("null");
        list.add("Scala");
        list.add(null);

        List<String> result = list.stream()
        		 				  .filter(x->x.contains("Java"))
        		 				  .collect(Collectors.toList());

        System.out.println(result);		
	}
	
	private static void filterMap () {
		
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 40),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );
        
        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName())  && 20 == x.getAge())        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println(result1);
        
        
        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        
	}
	
	public static  <T>  List<T>  filterNullValue(List<T> list) {
		List<T> filtredList=list.stream().filter(x->x!=null)
										 .collect(Collectors.toList());
		return filtredList ;
	}

	
	

}
