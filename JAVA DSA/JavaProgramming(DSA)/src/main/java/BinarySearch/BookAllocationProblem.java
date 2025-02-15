package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BookAllocationProblem {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 17, 14, 9, 15, 9, 14));
        int students = 7;
        System.out.println("Minimum Number of Pages to be allocated: " + findPages(list, list.size(), students));
    }

    public static int findPages(ArrayList<Integer> arr, int numberOfPages, int students) {
        int ans = -1;
        if (students > numberOfPages) {
            return ans;
        }
        int low = Collections.max(arr); /* lowest point in the array should be max number of pages . for e.g. if we take
        1 in above example then 1 is the limit how 17 pages can be taken so if low is 17 then 1 can also accommodate in
        17 can also be taken because max-capacity is 17 pages. */
        int high = 0;
        for (Integer elem : arr) {
            high += elem;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int ansReceived = bookAllocation(arr, mid);
            if (ansReceived <= students) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int bookAllocation(ArrayList<Integer> arr, int mid) {
        int studentCount = 1;
        int pagesSum = 0;
        int i = 0;
        while (i < arr.size()) {
            if ((pagesSum + arr.get(i)) <= mid) {
                pagesSum += arr.get(i);
            } else {
                studentCount++;
                pagesSum = arr.get(i);
            }
            i++;
        }
        return studentCount;
    }
}
