package Sorting;

public class InsertionSorting {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 12, 6, 8, 19};
        int n = arr.length;
        insertionSortingRecursive(arr,0,n);
//        insertionSortingIterative(arr, n);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    static void insertionSortingRecursive(int[] arr,int i,int n){
        if(i == n)
            return;
        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            swapValues(arr, j, j - 1);
            j--;
        }
        insertionSortingRecursive(arr,i+1,n);
    }

    static void insertionSortingIterative(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swapValues(arr, j, j - 1);
                j--;
            }
        }
    }

    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
