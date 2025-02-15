package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImplementation {
    public static void main(String[] args) {
        Map<String,Integer> hashmap = new TreeMap<>();
        hashmap.put("one",1);
        hashmap.put("four",4);
        hashmap.put("two",2);
        hashmap.put("three",3);

        hashmap.putIfAbsent("four",4);              // will add key only if the key doesn't exist.


        System.out.println(hashmap);        // keys are stored in sorted fashion

        for (Map.Entry<String,Integer> e: hashmap.entrySet()){      //iterating a hashMap
            System.out.println("key: "+ e.getKey() + " value: "+ e.getValue());
            System.out.println(e);
        }

        {   //Alternative way of iterating hashmap
            for (String key : hashmap.keySet()) {
                System.out.println("key : " + key);
            }

            for (Integer value : hashmap.values()) {
                System.out.println("value  : " + value);
            }
        }
    }
}
