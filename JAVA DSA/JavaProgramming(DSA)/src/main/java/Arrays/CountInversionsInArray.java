package Arrays;

import java.util.ArrayList;

public class CountInversionsInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        int n = arr.length;
        System.out.println("Inversion count is: " + mergeSort(arr, 0, n - 1));
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low == high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += mergeArray(arr, low, mid, high);
        return count;
    }

    static int mergeArray(int[] arr, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
                count += mid - left + 1;
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return count;
    }

}
