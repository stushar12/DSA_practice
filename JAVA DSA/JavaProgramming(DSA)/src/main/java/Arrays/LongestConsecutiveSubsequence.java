package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2};
        System.out.println(getLongestSubsequenceBetterSolution(arr));
        System.out.println(getLongestSubsequenceOptimalSolution(arr));
    }

    static int getLongestSubsequenceBetterSolution(int[] arr) {
        int maxLength = Integer.MIN_VALUE;
        int count = 1;
        int lastElement = Integer.MIN_VALUE;
        Arrays.sort(arr);

        for (int j : arr) {
            if (j - 1 == lastElement) { // if current element is +1 of last element
                count++;
            } else if (j != lastElement) {  // means a new element is encountered which is not forming a subsequence with the lastElement so start a new subsequence
                count = 1;
            }
            /*
             * else{
             * nothing to do in case of same element as last element eg. [1 1 1 1 2]
             * }*/
            lastElement = j;
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }

    static int getLongestSubsequenceOptimalSolution(int[] arr) { /*Total TC O(3N) and SC O(N)  assuming no collisions and contains operation is taking O(1) time*/
        int n = arr.length;
        if (n == 0)
            return 0;
        /*TC:  near about O(2n)*/
        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i : arr) {       /*TC:  near about O(n)*/
            set.add(i);
        }

        // Find the longest sequence
        for (int it : set) {        /*TC:  near about O(2n)*/
            // if 'it' is a starting number
            if (!set.contains(it - 1)) { /*if previous number doesn't exist
            then we can start a subsequence with this number*/
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
