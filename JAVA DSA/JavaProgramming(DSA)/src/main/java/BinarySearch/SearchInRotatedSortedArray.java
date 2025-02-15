package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 11, 1, 2, 3, 4, 5, 6, 9));
        int target = 9;
        System.out.println("Index found at location: " + searchInUniqueElements(arrayList, arrayList.size(), target));
    }

    public static int searchInDuplicateElements(ArrayList<Integer> arr, int n, int target) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }
            if (Objects.equals(arr.get(low), arr.get(mid)) && Objects.equals(arr.get(mid), arr.get(high))) {  /*
            edge case when low, mid and high all are equal then shrink the search space to make it work as unique elements*/
                low++;
                high--;
            }
            /*first identify which half is sorted*/
            else if (arr.get(low) <= arr.get(mid)) {
                /*this should be true for the left half to be sorted*/
             /*now we need to check whether the target lies in left sorted half if yes then search in
              left search space otherwise we will update search space to right */
                if (target >= arr.get(low) && target < arr.get(mid)) {/* is target element lying in the range of low to mid*/
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {   //right half is sorted now apply binary search
                if (target > arr.get(mid) && target <= arr.get(high)) {/* is target element lying in the range of mid to high*/
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
    }

    public static int searchInUniqueElements(ArrayList<Integer> arr, int n, int target) {
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == target) {
                return mid;
            }
            /*first identify which half is sorted*/
            else if (arr.get(low) <= arr.get(mid)) {    /*this should be true for the left half to be sorted*/

             /*now we need to check whether the target lies in left sorted half if yes then search in
              left search space otherwise we will update search space to right */
                if (target >= arr.get(low) && target < arr.get(mid)) {/* is target element lying in the range of low to mid*/
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {   //right half is sorted now apply binary search
                if (target > arr.get(mid) && target <= arr.get(high)) {/* is target element lying in the range of mid to high*/
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return ans;
    }

}
