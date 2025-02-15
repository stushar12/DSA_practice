package Collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetImplementation {
    public static void main(String[] args) {
        Set<String> hashSet = new LinkedHashSet<>();

        hashSet.add("Tushar");
        hashSet.add("Ashish");
        hashSet.add("Rahul");
        hashSet.add("Dheeraj");

        hashSet.remove("Dheeraj");

        System.out.println(hashSet);        // values will be stored in the way they were entered

        System.out.println("hashSet.contains(\"Tushar\") " + hashSet.contains("Tushar"));

        System.out.println("hashSet.size()  " + hashSet.size());

        System.out.println("IsEmpty() " + hashSet.isEmpty());

        hashSet.clear();
        System.out.println("hashSet.clear() " + hashSet);
    }
}
