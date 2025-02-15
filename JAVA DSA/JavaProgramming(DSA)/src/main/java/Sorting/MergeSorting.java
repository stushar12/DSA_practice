package Sorting;

public class MergeSorting {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        int n = arr.length;

        System.out.println("Before sorting: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }

        mergeSort(arr, 0, n - 1);
        System.out.println();

        System.out.println("After sorting: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeArray(arr, low, mid, high);
    }

    static void mergeArray(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[arr.length];
        int counter = 0;

        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                temp[counter++] = arr[left++];
            }
            else {
                temp[counter++] = arr[right++];
            }
        }

        while (left<=mid){
            temp[counter++] = arr[left++];
        }

        while (right<=high){
            temp[counter++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }

        System.out.println();
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        System.out.println("low = "+ low);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
