package Sorting;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = {10, 1, 7, 6, 8, 9};
        int n = arr.length;
        bubbleSortingIterative(arr,n);
//        bubbleSortingRecursive(arr,n);
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    static void bubbleSortingIterative(int [] arr, int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapValues(arr, j, j + 1);
                }
            }
        }
    }

    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

    static void bubbleSortingRecursive(int [] arr, int n){
        if(n == 1)
            return;
        for (int j = 0; j < n-1; j++) {
            if (arr[j] > arr[j + 1]) {
                swapValues(arr, j, j + 1);
            }
        }
        bubbleSortingRecursive(arr,n-1);
    }
}
