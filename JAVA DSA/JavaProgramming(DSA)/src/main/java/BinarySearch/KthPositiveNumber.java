package BinarySearch;

public class KthPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 4;
        System.out.println("Kth Missing Positive Number: " + missingK(arr, arr.length, k));
    }

    public static int missingK(int[] arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    public static int optimalMissingK(int[] arr, int n, int k) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int missingNumbersCount = arr[mid] - (mid + 1); /*e.g. if at index 2 number is 6 ideally 3(0 based indexing) should be there so
            total 3 numbers are missing because of which 6 is there. */
            if (missingNumbersCount < k) {  /*if missing count at that position is less than the required number then
            search in the right search space. */
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return high + 1 + k;
    }
}
