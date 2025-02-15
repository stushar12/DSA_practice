package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastPositionInArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 8, 8, 11, 13));
        int value = 8;
        System.out.println("First occurrence of given value is: " + firstAndLastPosition(arrayList, arrayList.size(), value)[0]);
        System.out.println("Last occurrence of given value is: " + firstAndLastPosition(arrayList, arrayList.size(), value)[1]);
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int value) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        ans[0] = firstOccurrence(arr, n, value);
        if (ans[0] != -1)
            ans[1] = lastOccurrence(arr, n, value);
        return ans;
    }

    public static int firstOccurrence(ArrayList<Integer> arr, int n, int value) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == value) {
                ans = mid;
                high = mid - 1;
            } else if (arr.get(mid) > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(ArrayList<Integer> arr, int n, int value) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == value) {
                ans = mid;
                low = mid + 1;
            } else if (arr.get(mid) > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
