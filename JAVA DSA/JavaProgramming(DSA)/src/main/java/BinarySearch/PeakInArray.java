package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakInArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 8, 1, 5, 3));
        int ans = findPeakElement(arr);
        System.out.println("The peak is at index: " + ans);
    }

    public static int findPeakElement(ArrayList<Integer> arr) {

        int size = arr.size();
        if (size == 1)
            return 0;

        if (arr.get(0) > arr.get(1))    /*if 0th element is greater than 1st we got a peak because before 0 we are
        considering -infinity*/
            return 0;

        if (arr.get(size - 1) > arr.get(size - 2))/*if n-1th element is greater than n-2th we got a peak because after
        n-1 we are considering -infinity*/
            return size - 1;

        /*search space reduced*/
        int low = 1;
        int high = size - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) > arr.get(mid + 1) && arr.get(mid) > arr.get(mid - 1)) {   /*if we are at the peak greater
            than both the sides*/
                return mid;
            } else if (arr.get(mid) > arr.get(mid - 1)) {       /*left side increasing so peak will be on the right*/
                low = mid + 1;
            } else if (arr.get(mid) > arr.get(mid + 1)) {   /*right side decreasing so peak will be on left*/
                high = mid - 1;
            } else {        /*if it's a dip e.g. 1 8 1 5 3     both side there is a peak but when we are standing on 1,
                        so if we don't have else case then we will go to infinite loop, so
                         we need to eliminate one half(it can be any half left or right) which will be taken care by
                         else case*/
                low = mid + 1;
            }
        }
        return -1;
    }
}
