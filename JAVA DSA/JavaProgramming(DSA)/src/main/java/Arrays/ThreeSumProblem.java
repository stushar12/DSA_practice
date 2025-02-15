package Arrays;

import java.util.*;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        for (List<Integer> ans : tripletOptimalSolution(n, arr)) {
            for (Integer elem : ans) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> tripletOptimalSolution(int n, int[] arr) {
        List<List<Integer>> finalAns = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                    finalAns.add(ans);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return finalAns;
    }

    static List<List<Integer>> tripletBetterSolution(int n, int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int thirdElement = -(arr[i] + arr[j]);      //arr[i]+arr[j]+ thirdElement= 0
                if (hashSet.contains(thirdElement)) {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(arr[i], arr[j], thirdElement));
                    Collections.sort(ans);
                    set.add(ans);
                }
                hashSet.add(arr[j]);
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>(set);
        return finalAns;
    }
}
