package BinarySearch;

public class CountOfRotationsInSortedArray {
    public static void main(String[] args) {
        int[] arr = {27, 31, 43, 45, 46, 5, 11, 13, 18, 19, 20};
        System.out.println("Number of times array is rotated: " + findMin(arr));
    }

    public static int findMin(int[] arr) {
        int n = arr.length;
        int minValue = Integer.MAX_VALUE;
        int indexOfMinValue = -1;

        if (arr[0] < arr[n - 1])      //means array is not rotated
            return 0;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) { /* for dealing with duplicate elements*/
                if (arr[low] < minValue) {
                    minValue = arr[low];
                    indexOfMinValue = low;
                }
                low++;
                high--;
                continue;
            }
            if (arr[mid] >= arr[low]) {     /*left half is sorted*/
                if (arr[low] < minValue) {
                    minValue = arr[low];
                    indexOfMinValue = low;
                }     // if left half is sorted take the lowest value which is arr[low] and eliminate that half
                low = mid + 1;
            } else {  /*right half is sorted*/
                if (arr[mid] < minValue) {
                    minValue = arr[mid];
                    indexOfMinValue = mid;
                }//if right half is sorted take the lowest value which is arr[mid] and eliminate that half
                high = mid - 1;
            }
        }

        return indexOfMinValue;
    }
}
