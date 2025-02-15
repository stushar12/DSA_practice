package Collections;

import java.util.*;

public class ArrayListImplementation {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> newArrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);

        arrayList.add(1, 4);         // add operation
        System.out.println("After add operation " + arrayList);

        List<Integer> arrayListClone = new ArrayList<Integer>();

        arrayListClone.add(21);
        arrayListClone.add(21);
        arrayListClone.add(22);
        arrayListClone.add(23);

        arrayList.addAll(arrayListClone);       //addAll operation
        System.out.println("After addAll operation " + arrayList);

        System.out.println("After get operation " + arrayList.get(3));       //get operation

        arrayList.remove(5);                   //remove operation
        System.out.println("After remove operation by index " + arrayList);

        arrayList.remove(Integer.valueOf(21));  // looks for the value in arrayList and remove all occurrences from it
        System.out.println("After remove operation by element " + arrayList);

        arrayList.set(3,200);       // set operation to update the value in the list at particular index
        System.out.println("After set operation "+arrayList );

        System.out.println("After contains operation "+ arrayList.contains(1000));  //check whether the value is present
                                                                                    //and returns boolean value

        System.out.println("After size operation "+arrayList.size());       //size operation




        System.out.println("Iterating the list with for each loop");
        for (Integer element: arrayList) {
            System.out.print(element+ " ");
        }
        System.out.println();


        System.out.println("Iterating the list with for loop");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();


        System.out.println("Iterating the list with iterator");
        Iterator<Integer> it = arrayList.iterator();

        while (it.hasNext()){
            System.out.print( it.next()+" ");
        }
        System.out.println();

        arrayList.clear();      // clear operation empties the entire list
        System.out.println("After clear operation " + arrayList);
    }
}
