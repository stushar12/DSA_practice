package Arrays;

import java.util.ArrayList;

public class CountReversePairs {
    public static void main(String[] args) {
        int[] arr = {12,19,25,40,2,6,9};
        int n = arr.length;
        System.out.println("Inversion count is: " + mergeSort(arr, 0, n - 1));
    }
    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low == high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count+= countPairs(arr,low,mid,high);
        mergeArray(arr, low, mid, high);
        return count;
    }

    static void mergeArray(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
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
    }

    static int countPairs(int []arr,int low,int mid,int high){
        int count = 0;
        int right = mid+1;
        for (int i = low; i <= mid; i++) {  /*so we will iterate over the entire left part*/
            while (right<=high && arr[i]>2*arr[right]){
                right++;
            }
            count+= right-(mid+1);
        }

        return count;
    }
}
