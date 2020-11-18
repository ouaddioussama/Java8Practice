package listTomap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertListToMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertListToMapWithDuplicate();

	}
	
	public static void convertListToMapWithDuplicate() {
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));
        
        list.add(new Hosting(6, "linode.com", 100000)); // new line

        // key = name, value - websites , but the key 'linode' is duplicated!?
        //Note
       // (oldValue, newValue) -> oldValue ==> If the key is duplicated, do you prefer oldKey or newKey?
        Map<String, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites,(oldValue, newValue) -> oldValue));

        System.out.println("Result 1 : " + result1);

	}
		public static void convertListToMap() {
	     List<Hosting> list = new ArrayList<>();
	        list.add(new Hosting(1, "liquidweb.com", 80000));
	        list.add(new Hosting(2, "linode.com", 90000));
	        list.add(new Hosting(3, "digitalocean.com", 120000));
	        list.add(new Hosting(4, "aws.amazon.com", 200000));
	        list.add(new Hosting(5, "mkyong.com", 1));

	        // key = id, value - websites
	        Map<Integer, String> result1 = list.stream()
	        								   .collect(Collectors.toMap(Hosting::getId, Hosting::getName));

	        System.out.println("Result 1 : " + result1);
	        
	        // key = name, value - websites
	        Map<String, Long> result2 = list.stream().collect(
	                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

	        System.out.println("Result 2 : " + result2);

	        // Same with result1, just different syntax
	        // key = id, value = name
	        Map<Integer, String> result3 = list.stream().collect(
	                Collectors.toMap(x -> x.getId(), x -> x.getName()));

	        System.out.println("Result 3 : " + result3);

	        
	}
	
	
	static class Hosting {

	    private int Id;
	    private String name;
	    private long websites;

	    public Hosting(int id, String name, long websites) {
	        Id = id;
	        this.name = name;
	        this.websites = websites;
	    }

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getWebsites() {
			return websites;
		}

		public void setWebsites(long websites) {
			this.websites = websites;
		}

	    //getters, setters and toString()
	    
	    
	}

}
