package Arrays;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int n = arr.length;
        System.out.println("Maximum subArraySum: " + maximumSubArraySum(arr, n)); /*Kadane's algorithm*/
    }

    static int maximumSubArraySum(int[] arr, int n) {
        int maxiSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1, startPoint = -1, endPoint = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];
            if (sum > maxiSum) {
                maxiSum = sum;
                startPoint = start;
                endPoint = i;
            }
            if (sum < 0) {
                sum = 0;    /*whenever sum becomes -ve no need to carry it*/
            }
        }
        if (startPoint != -1 && endPoint != -1) {
            System.out.print("SubArray is: ");
            for (int i = startPoint; i <= endPoint; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        return Math.max(maxiSum, 0);
    }
}
