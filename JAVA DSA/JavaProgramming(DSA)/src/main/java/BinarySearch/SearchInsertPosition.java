package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int target = 3;
            /*similar to lower bound if present return the index otherwise the number at the very first index which should be greater than value*/
        System.out.println("Index where the given target should be is : " + searchInsert(arr, target));
    }

    public static int searchInsert(int[] arr, int value) {
        int index = 0;      /* -1 is cannot be an option because that element will be placed somewhere in the array  between the range (0 to n-1)*/
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid]>=value) {    /*means if value is smaller than arr[mid] means that index could be a potential answer as arr[mid] will be shifted to (mid+1) index */
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
