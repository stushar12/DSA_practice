package BinarySearch;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 9, 11, 12, 45};
        int target = 15;
        System.out.println(binarySearch(arr, 0, arr.length - 1, target));
    }

    static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, high, target);
        } else
            return binarySearch(arr, low, mid - 1, target);
    }
}
