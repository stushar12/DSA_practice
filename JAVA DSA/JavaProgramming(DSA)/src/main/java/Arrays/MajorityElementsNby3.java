package Arrays;

import java.util.*;

public class MajorityElementsNby3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 2, 2, 3};

        for (Integer element : majorityElement(arr)) {
            System.out.print(element + " ");
        }
    }

    static List<Integer> majorityElement(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int size = arr.length;
        int cutOff = Math.floorDiv(size, 3);
        int element1 = 0, element2 = 0, count1 = 0, count2 = 0;

        for (int j : arr) {
            if (count1 == 0 && j != element2) {
                element1 = j;
                count1 = 1;
            } else if (count2 == 0 && j != element1) {
                element2 = j;
                count2 = 1;
            } else if (j == element1) {
                count1++;
            } else if (j == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        checkMajorityOrNot(element1, element2, cutOff, arr, list);
        return list;
    }

    static void checkMajorityOrNot(int element1, int element2, int cutOff, int[] arr, List<Integer> list) {
        int counter1 = 0, counter2 = 0;

        for (int j : arr) {
            if (j == element1) {
                counter1++;
            } else if (j == element2) {
                counter2++;
            }
        }
        if (counter1 > cutOff) {
            list.add(element1);
        }
        if (counter2 > cutOff) {
            list.add(element2);
        }
        Collections.sort(list);
    }


    static List<Integer> betterSolution(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int size = arr.length;
        int cutoff = Math.floorDiv(size, 3);
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {      //iterating a hashMap
            if (e.getValue() > cutoff) {
                ans.add(e.getKey());
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
