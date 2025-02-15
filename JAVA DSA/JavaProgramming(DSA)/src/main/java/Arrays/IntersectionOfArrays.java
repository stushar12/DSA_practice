package Arrays;

import java.util.ArrayList;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3};
        int[] arr2 = {3, 3, 4};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int i = 0;    // pointer for array 1
        int j = 0;    // pointer for array 2

        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr1[i]) {
                j++;
            } else {
                arrayList.add(arr2[j]);
                i++;
                j++;
            }
        }

        for (Integer val : arrayList) {
            System.out.print(val + " ");
        }
    }
}
