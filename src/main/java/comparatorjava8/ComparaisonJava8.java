package comparatorjava8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import models.Person;	

public class ComparaisonJava8 {
	
	List<Person> listPerson=new ArrayList<>();

	public ComparaisonJava8() {
		listPerson=Arrays.asList(
				new Person("oussama",28),
				new Person("ouaddi",29),
				new Person("kira",24)
				);
	}

	public static void main(String[] args) {
		System.out.println("hello".hashCode());
		int aaa=2;
		int bbb=5;
		double d =3+aaa/bbb+2;
		System.out.println(d);
		
		int x=Math.multiplyExact(2^11131,31);
		System.out.println(x);
		LocalDateTime lp=LocalDateTime.now();
		
		
		ComparaisonJava8 pp=new ComparaisonJava8();
		int a=5;
		int b=7;
		int c=a+=2*3+b--;
		System.out.println(c);
		List<String> listPerson=new ArrayList<>();
		listPerson.add("ouss");
		listPerson.add("kira");
		listPerson.add("toto");
		Predicate<String> p1=p->p.equals("ouss");
		Predicate<String> p2=p->p.equals("kira");
		listPerson.removeIf(p1.or(p2));
		System.out.println(listPerson);

		ComparaisonJava8 comparaisonJava8=new ComparaisonJava8();
		//Collections.sort(comparaisonJava8.listPerson,comparaisonJava8.personComparatorName());
		//comparaisonJava8.listPerson.forEach(System.out::println);
		//comparaisonJava8.listPerson.sort(personComparatorNameJava8());
		comparaisonJava8.listPerson.sort((o1, o2)->o1.getAge()-o2.getAge());
		comparaisonJava8.listPerson.forEach(System.out::println);


	}

	public Comparator<Person> personComparatorAge() {
		Comparator<Person> personComparator = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
		};
		return personComparator;

	}
	
	public Comparator<Person> personComparatorName() {
		Comparator<Person> personComparator = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		return personComparator;

	}
	
	//comparator java8
	public static Comparator<Person> personComparatorNameJava8() {
		
		Comparator<Person> comparator = Comparator.comparing(Person::getName,Comparator.reverseOrder());
		return comparator;

	}

}
