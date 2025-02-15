package BinarySearch;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Median of 2 sorted arrays: " + median(arr1, arr2));
    }

    public static double median(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;

        if (len1 > len2) return median(b, a);   /*always run this function for smaller array*/

        int low = 0;
        int high = len1; // length of smaller array

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (len1 + len2 + 1) / 2 - cut1; /*remaining half */

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = cut1 == len1 ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == len2 ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return (len1 + len2) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

}

