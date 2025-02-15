package BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 0, 1};
        System.out.println("Minimum element in the array is: " + arr[findMin(arr)]);
    }

    public static int findMin(int[] arr) {
        int n = arr.length;
        int minValue = Integer.MAX_VALUE;
        int indexOfMinValue = -1;

        if (arr[0] < arr[n - 1])      //means array is not rotated
            return arr[0];

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
                if (arr[low] < minValue) {  // if left half is sorted take the lowest value which is arr[low] and eliminate that half
                    minValue = arr[low];
                    indexOfMinValue = low;
                }
                low = mid + 1;
            } else {  /*right half is sorted*/
                if (arr[mid] < minValue) { //if right half is sorted take the lowest value which is arr[mid] and eliminate that half
                    minValue = arr[mid];
                    indexOfMinValue = low;
                }
                high = mid - 1;
            }
        }
        return indexOfMinValue;
    }
}
