package Arrays;

import java.util.*;

public class CountSubArraysSumK {

    public static void main(String[] args) {
        int[] arr = {3,-3,1,1,1};
        int target = 3;

        System.out.println("Total subArrays: " + countSubArrays(arr, target));
    }

    static int countSubArrays(int[] arr, int target) {
        int totalSubArrays = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int j : arr) {

            sum += j;
            totalSubArrays += map.getOrDefault(sum - target, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return totalSubArrays;
    }
}
