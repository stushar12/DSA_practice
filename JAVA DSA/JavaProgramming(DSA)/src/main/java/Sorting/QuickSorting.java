package Sorting;

public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        int n = arr.length;

        System.out.println("Before sorting: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        quickSort(arr, 0, n - 1);
        System.out.println();

        System.out.println("After sorting: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionArray(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    static int partitionArray(int[] arr, int low, int high) {
        int i = low;
        int j = high;

        int pivotIndexValue = arr[low];
//        int pivotIndexValue = arr[high];  last element as pivot
        while (i < j) {
            while (arr[i] <= pivotIndexValue && i < high) {
                i++;
            }

            while (arr[j] > pivotIndexValue && j > low) {
                j--;
            }

//            while (arr[i] < pivotIndexValue && i < high) {
//                i++;
//            }
//
//            while (arr[j] >= pivotIndexValue && j > low) {
//                j--;
//            }     last element as pivot


            if (i < j) {
                swapValues(arr, i, j);
            }
        }
        swapValues(arr, low, j);
//        swapValues(arr, high, i);         last element as pivot
        return j;
//        return j;  last element as pivot
    }

    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
