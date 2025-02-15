package Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetImplementation {
    public static void main(String[] args) {
        Set<String> hashSet = new TreeSet<>();

        hashSet.add("Tushar");
        hashSet.add("Ashish");
        hashSet.add("Rahul");
        hashSet.add("Dheeraj");

        hashSet.remove("Dheeraj");

        System.out.println(hashSet);        // values will be stored in sorted order

        System.out.println("hashSet.contains(\"Tushar\") " +hashSet.contains("Tushar"));

        System.out.println("hashSet.size()  "  +hashSet.size());

        System.out.println("IsEmpty() "+hashSet.isEmpty());

        hashSet.clear();
        System.out.println("hashSet.clear() "+hashSet);
    }
}
