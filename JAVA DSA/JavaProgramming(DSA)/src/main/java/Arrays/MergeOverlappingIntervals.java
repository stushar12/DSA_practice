package Arrays;

import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {3, 3}, {3, 3}, {3, 3}, {3, 4}, {4, 4}, {5, 5}, {5, 5}, {5, 6}};
        for (List<Integer> list : mergeOverlappingIntervals(arr)) {
            for (int elem : list) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            if (list.isEmpty() || list.get(list.size() - 1).get(1) < arr[i][0]) {   /* which means if either the list is empty or first element in the [1] last pair
                        of the ans is smaller than the current element then we have to insert the interval as it will be a new start*/
                list.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {   /*otherwise if already present then we need to update the first index[1] of the last pair of ans*/
                list.get(list.size() - 1).set(1, Math.max(arr[i][1], list.get(list.size() - 1).get(1)));
            }
        }

        return list;
    }
}
