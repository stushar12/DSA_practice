package Collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Tushar");
        hashSet.add("Ashish");
        hashSet.add("Rahul");
        hashSet.add("Dheeraj");

        hashSet.remove("Dheeraj");

        System.out.println(hashSet);        // no order for storing values

        System.out.println("hashSet.contains(\"Tushar\") " +hashSet.contains("Tushar"));

        System.out.println("hashSet.size()  "  +hashSet.size());

        System.out.println("IsEmpty() "+hashSet.isEmpty());

        hashSet.clear();
        System.out.println("hashSet.clear() "+hashSet);
    }
}
