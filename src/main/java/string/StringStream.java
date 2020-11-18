package string;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStream {

	public static void main(String[] args) {
		collectorJoinObject();

	}
	
	
    public static void concatChars() 
    { 
        // Create a character array 
        char[] ch = { 'G', 'e', 'e', 'k', 's', 
                      'f', 'o', 'r', 
                      'G', 'e', 'e', 'k', 's' }; 
  
        // Convert the character array into String 
        // using Collectors.joining() method 
        String chString = Stream.of(ch) 
                              .map(arr -> new String(arr)) 
                              .collect(Collectors.joining()); 
  
        // Print the concatenated String 
        System.out.println(chString); 
    } 

    public static void concatChars2() 
    { 
        // Create a character array 
        char[] ch = { 'G', 'e', 'e', 'k', 's', 
                      'f', 'o', 'r', 
                      'G', 'e', 'e', 'k', 's' }; 
  
        // Convert the character array into String 
        // using Collectors.joining() method 
        String chString = Stream.of(ch) 
                              .map(String::valueOf) 
                              .collect(Collectors.joining()); 
  
        // Print the concatenated String 
        System.out.println(chString); 
    } 

    public static void joinString() {
        String result = String.join("-", "2015", "10", "31" );
        System.out.println(result);
        
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        result=String.join("*", list);
        System.out.println(result);
        
        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
           result = sj.toString(); //aaa,bbb,ccc
        System.out.println(result);

    }
    
    public static void collectorJoin() {
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        String result=list.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(result);
    }

    
    public static void collectorJoinObject() {
        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result = list.stream().map(x -> x.getName())
        				.collect(Collectors.joining(", ", "{", "}"));
        
        System.out.println(result);
        
    }



    
    static class Game{
        String name;
        int ranking;

        public Game(String name, int ranking) {
            this.name = name;
            this.ranking = ranking;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }
    
}
