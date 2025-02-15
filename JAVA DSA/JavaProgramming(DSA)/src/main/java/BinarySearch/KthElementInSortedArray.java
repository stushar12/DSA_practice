package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class KthElementInSortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 7, 8, 9, 100));
        int k = 6;
        System.out.println("K-th element is: " + kthElement(arr1, arr2, arr1.size(), arr2.size(), k));
    }

    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {

        // n - first array length
        // m  - second array length
        if (n > m)
            return kthElement(arr2, arr1, m, n, k);

        int low = Math.max(0, k - m);   // if k is 3 then we can take low as 0 but if k is 7 then we can't take low as 0 because 2nd array has 5 elements so at minimum we need to take 2 elements from array 1
        int high = Math.min(k, n);      // similarly if k is 3 we can't take all 5 elements so will take 3 as high in that case else if k is 7 then we can take all 5 elements

        while (low <= high) {
            int cut1 = (low + high) / 2;    //first half will contain only k-elements
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1.get(cut1 - 1);
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2.get(cut2 - 1);
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1.get(cut1);
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2.get(cut2);

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);        // max of l1,l2 is  the k-th element
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }

        return 0;
    }
}
