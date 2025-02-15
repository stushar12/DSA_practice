package BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] arr = {4, 9, 4, 3, 1, 3};
        int hours = 66;
        System.out.println("Minimum number of bananas monkey need to eat per hour is: " + minimumRateToEatBananas(arr, hours));
    }

    public static int minimumRateToEatBananas(int[] arr, int hours) {
        int maxElement = Arrays.stream(arr).max().getAsInt();
        int low = 1;
        int high = maxElement;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int possibleAnswer = possibleAns(arr, mid);
            if (possibleAnswer <= hours) {      /*if possible answer is less than or equal we need to decrease the value so
             denominator decreases and overall result increases*/
                ans = mid;
                high = mid - 1;
            } else { /*increase denominator to reduce overall result*/
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int possibleAns(int[] arr, int mid) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+= Math.ceil((double) arr[i]/ (double) mid);
        }
        return (int)sum;
    }
}
