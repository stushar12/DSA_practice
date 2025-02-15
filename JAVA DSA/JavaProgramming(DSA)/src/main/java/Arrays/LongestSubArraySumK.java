package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int sumToFind = 15;
        System.out.println("Longest subArray length: " + betterApproachUsingHashMapForPositiveNumbers(arr, n, sumToFind));
        System.out.println("Longest subArray length: " + optimalApproachUsingHashMapForPositiveNumbers(arr, n, sumToFind));
        System.out.println("Longest subArray length: " + optimalApproachUsingHashMapForBothPositiveAndNegativeNumbers(arr, n, sumToFind));
    }

    static int betterApproachUsingHashMapForPositiveNumbers(int[] arr, int n, int k) {
        int longestSubArrayLength = Integer.MIN_VALUE;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            if (sum == k)   // if array is like used in example and sum is total sum of array
                longestSubArrayLength = Math.max(longestSubArrayLength, j + 1);
            else if (map.get(sum - k) != null) {
                int length = j - map.get(sum - k);
                longestSubArrayLength = Math.max(longestSubArrayLength, length);
            }
            map.putIfAbsent(sum, j);   // if array contains 0 then this is the edge case to handle
        }   // e.g. {2,0,0,0,3} and k = 3 so answer should be 4 so no need to update map if same value is coming
        return longestSubArrayLength;
    }

    static int optimalApproachUsingHashMapForBothPositiveAndNegativeNumbers(int[] arr, int n, int k) {
        int longestSubArrayLength = 0;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            if (sum == k)   // if array is like used in example and sum is total sum of array
                longestSubArrayLength = Math.max(longestSubArrayLength, j + 1);
            else if (map.get(sum - k) != null) {
                int length = j - map.get(sum - k);
                longestSubArrayLength = Math.max(longestSubArrayLength, length);
            }
            map.putIfAbsent(sum, j);
         
        }   // e.g. {2,0,0,0,3} and k = 3 so answer should be 4 so no need to update map if same value is coming because our end goal is to find the longest
        return longestSubArrayLength;
    }

    static int optimalApproachUsingHashMapForPositiveNumbers(int[] arr, int n, long k) {
        int longestSubArrayLength = 0;

        int left = 0, right = 0;
        long sum = arr[0];
        while (right < n) {
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                longestSubArrayLength = Math.max(longestSubArrayLength, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += arr[right];
            }
        }

        return longestSubArrayLength;
    }
}
