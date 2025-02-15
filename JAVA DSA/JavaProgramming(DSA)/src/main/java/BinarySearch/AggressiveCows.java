package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 6};
        int numberOfCows = 2;
        System.out.println("Aggressive Cows : " + aggressiveCows(arr, numberOfCows));
    }

    public static int aggressiveCows(int[] arr, int cows) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int low = 1;     // lowest possible value of answer
        int high = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();    /*max possible answer
       value one cow placed in the beginning and the other cow at the very end. */

        while (low <= high) {
            int mid = (low + high) / 2;
            int ansReceived = eligibleAnswer(arr, mid, cows);
            if (ansReceived == 1) {
                ans = mid;
                low = mid + 1; //search for maximum value;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }


    public static int eligibleAnswer(int[] arr, int mid, int cows) {
        int cowsPlaced = 1;
        int positionPlaced = arr[0];/* placing 1st cow at  starting index then placing other cows at greater
        than or equal to mid+  distance*/
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - positionPlaced >= mid) {
                cowsPlaced++;
                positionPlaced = arr[i];
            }
            if (cowsPlaced == cows) {
                return 1;
            }
        }
        return 0;
    }
}
