package Arrays;

import java.util.ArrayList;

public class UnionOfArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 5, 5, 5, 10, 10};
        int[] arr2 = {2, 4, 7, 10, 10};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int i = 0;    // pointer for array 1
        int j = 0;    // pointer for array 2

        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] <= arr2[j]) {
                if (arrayList.isEmpty() || arr1[i] != arrayList.get(arrayList.size() - 1)) {
                    arrayList.add(arr1[i]);
                }
                i++;
            } else {
                if (arrayList.isEmpty() || arr2[j] != arrayList.get(arrayList.size() - 1)) {
                    arrayList.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < arr1Length) {
            if (arr1[i] != arrayList.get(arrayList.size() - 1))
                arrayList.add(arr1[i]);
            i++;
        }
        while (j < arr2Length) {
            if (arr2[j] != arrayList.get(arrayList.size() - 1))
                arrayList.add(arr2[j]);
            j++;
        }

        for (Integer val : arrayList) {
            System.out.print(val + " ");
        }
    }
}
