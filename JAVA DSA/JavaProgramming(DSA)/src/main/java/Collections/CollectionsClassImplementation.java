package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsClassImplementation {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(13);
        arrayList.add(11);
        arrayList.add(20);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(10);
        arrayList.add(5);

        System.out.println("Minimum element present is : "+ Collections.min(arrayList));
        System.out.println("Maximum element present is : "+ Collections.max(arrayList));
        System.out.println("Frequency of element is : "+ Collections.frequency(arrayList,10));

        Collections.sort(arrayList);
        System.out.println("Sorting in ascending order: "+ arrayList);

        Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println("Sorting in de scending order: "+ arrayList);
    }
}
