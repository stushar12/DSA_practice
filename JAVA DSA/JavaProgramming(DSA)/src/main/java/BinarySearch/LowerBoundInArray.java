package BinarySearch;

public class LowerBoundInArray {
    public static void main(String[] args) {
        /*lower bound for a sorted array is to find the smallest index where value at that index is greater than or equal to given value*/
        int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        int x = 8;
        System.out.println("Lower bound index for the given array is : " + lowerBound(arr, arr.length, x));
    }

    static int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
