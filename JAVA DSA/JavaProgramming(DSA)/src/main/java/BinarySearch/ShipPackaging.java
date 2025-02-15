package BinarySearch;

import java.util.Arrays;

public class ShipPackaging {
    public static void main(String[] args) {
        int[] arr = {86, 45, 74, 64, 14, 68, 44, 11, 43, 33, 8, 20};
        int limit = 12;
        System.out.println("Capacity to Ship Packages within D Days: " + leastWeightCapacity(arr, limit));
    }

    public static int leastWeightCapacity(int[] arr, int limit) {
        int ans = 1;
        int low = Arrays.stream(arr).max().getAsInt(); /*because minimum if we take something less than max-element
        then we can't carry that item, so we need to have a minimum low to cover all weights*/
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int ansReceived = getShippingCapacity(arr, limit, mid);
            if (ansReceived == 1) {/*possible answer search for smallest*/
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int getShippingCapacity(int[] arr, int limit, int mid) {
        int dayCount = 1; /*by default, we are assuming 1st day has started */
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((sum + arr[i]) > mid) {/*if sum is exceeding the limit then need to update the day and update
            the sum with the value which is causing overflow*/
                dayCount++;
                sum = arr[i];
            } else
                sum += arr[i];
        }

        if (dayCount <= limit)
            return 1;

        return 0;
    }
}
