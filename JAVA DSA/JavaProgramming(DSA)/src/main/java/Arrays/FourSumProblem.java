package Arrays;

import java.util.*;

import java.util.List;

public class FourSumProblem {
    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        int n = arr.length;
        for (List<Integer> ans : quadrupletOptimalSolution(n, arr, target)) {
            for (Integer elem : ans) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> quadrupletOptimalSolution(int n, int[] arr, int target) {
        List<List<Integer>> finalAns = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i])
                continue;        /*always start checking from very next index the array is initialized here it was 0 */
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j])
                    continue;        /*always start checking from very next index the array is initialized here it was i+1 */

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        Collections.sort(list);
                        finalAns.add(list);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) k++;

                        while (k < l && arr[l] == arr[l + 1]) l--;
                    }
                }

            }
        }
        return finalAns;
    }

    static List<List<Integer>> quadrupletBetterSolution(int n, int[] arr, int target) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> hashSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourthElement = target - (arr[i] + arr[j] + arr[k]);      //arr[i]+arr[j]+ arr[k]+ fourthElement= target
                    if (hashSet.contains(fourthElement)) {
                        List<Integer> ans = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], fourthElement));
                        Collections.sort(ans);
                        set.add(ans);
                    }
                    hashSet.add(arr[k]);
                }
            }
        }

        List<List<Integer>> finalAns = new ArrayList<>(set);
        return finalAns;
    }
}

