package BinarySearch;

import java.util.Arrays;

public class SplitArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int partition =  5;
        System.out.println("Split Array – Largest Sum: "+ largestSubarraySumMinimized(arr,partition));
    }

    public static int largestSubarraySumMinimized(int[] arr, int partitions) {
        int ans = 1;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int ansReceived = getPartitions(arr, partitions, mid);
            if (ansReceived <= partitions) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int getPartitions(int[] arr, int partitions, int mid) {
        int subArraySum = 0;
        int partitionCount = 1;

        for (int i = 0; i < arr.length; i++) {
            if ((subArraySum + arr[i]) <= mid) {
                subArraySum += arr[i];
            } else {
                partitionCount++;
                subArraySum = arr[i];
            }
        }
        return partitionCount;
    }
}
