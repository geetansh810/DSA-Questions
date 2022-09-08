import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    public static void main(String[] args){

        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("five", 5);
        numbers.put("two", 2);

        System.out.println(numbers);

        numbers.putIfAbsent("one", 10);
        System.out.println(numbers);

        numbers.put("one", 10);
        System.out.println(numbers);

        System.out.println(numbers.get("five"));
        System.out.println(numbers.get("Five"));

        System.out.println("three => " +numbers.containsKey("three"));
        System.out.println("5 => " +numbers.containsValue(5));

        System.out.println(numbers.keySet());
        System.out.println(numbers.values());
        System.out.println(numbers.entrySet());


    }

}
