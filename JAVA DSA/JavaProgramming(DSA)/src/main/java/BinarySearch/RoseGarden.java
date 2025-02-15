package BinarySearch;

import java.util.Arrays;

public class RoseGarden {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int roses = 3;
        int bouquet = 2;
        System.out.println("Minimum days to make M bouquets: " + roseGarden(arr, roses, bouquet));
    }

    public static int roseGarden(int[] arr, int roses, int bouquet) {
        int ans = -1;
        if (roses * bouquet > arr.length)
            return -1;
        int low = Arrays.stream(arr).min().getAsInt();       /*no need to start from 1 the least possible answer can be
        the minimum in the array  */
        int high = Arrays.stream(arr).max().getAsInt();     /*max possible value*/

        while (low <= high) {
            int mid = (low + high) / 2;
            int answer = getAnswer(arr, mid, roses, bouquet);
            if (answer == 1) {/* this could be one of the possible answer, but we have to find minimum*/
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;

        }
        return ans;
    }

    public static int getAnswer(int[] arr, int mid, int roses, int bouquet) {
        int count = 0;
        int bouquetCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                count++;
            } else {/* if we encounter any else case reset the count to 0*/
                count = 0;
            }
            if (count == roses) {
                bouquetCount++;
                count = 0;
            }
            if (bouquetCount == bouquet) {
                return 1;
            }
        }


        return 0;
    }
}
