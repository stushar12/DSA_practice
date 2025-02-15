package BinarySearch;

import java.util.Arrays;

public class SmallestDivisor {
    public static void main(String[] args) {
        int[] arr ={2,3,5,7,11};
        int limit = 11;
        System.out.println("Smallest divisor less than or equal to limit: "+ smallestDivisor(arr,limit));
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int ans = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int valueReceived = checkDivisibility(arr,mid);

            if(valueReceived<=limit){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }

    public static int checkDivisibility(int[] arr, int mid) {
        double total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += Math.ceil((double) arr[i] / (double) mid);
        }

        return (int) total;
    }
}
