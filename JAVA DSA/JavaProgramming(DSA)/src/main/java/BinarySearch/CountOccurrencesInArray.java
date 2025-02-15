package BinarySearch;

public class CountOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 3, 4};
        int value = 3;
        /*count of that element is basically the (difference between last and first occurrence of that element) + 1 */
        System.out.println("Occurrence of given element is: " + count(arr, arr.length, value));
    }

    public static int count(int[] arr, int n, int value) {
        int[] ans = new int[2];
        ans[0] = firstOccurrence(arr, n, value);
        if (ans[0] != -1)
            ans[1] = lastOccurrence(arr, n, value);
        if (ans[0] == -1 || ans[1] == -1)
            return 0;
        else
            return ans[1] - ans[0] + 1;
    }

    public static int firstOccurrence(int[] arr, int n, int value) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] arr, int n, int value) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
