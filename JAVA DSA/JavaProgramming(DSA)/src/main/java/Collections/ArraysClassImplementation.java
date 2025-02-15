package Collections;

import java.util.Arrays;

public class ArraysClassImplementation {
    public static void main(String[] args) {

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = Arrays.binarySearch(sortedArray,4);
        System.out.println("Index : "+ index);

        int[] unsortedArray = {10, 2, 13, 4, 5, 16, 7, 8, 29, 10};
        Arrays.sort(unsortedArray);
        for (Integer element: unsortedArray) {
            System.out.print(element+" ");
        }
        System.out.println();

        System.out.println("Before ");
        for (Integer element: sortedArray) {
            System.out.print(element+" ");
        }
        System.out.println();
        Arrays.fill(sortedArray,0);
        System.out.println("After ");
        for (Integer element: sortedArray) {
            System.out.print(element+" ");
        }
    }
}
