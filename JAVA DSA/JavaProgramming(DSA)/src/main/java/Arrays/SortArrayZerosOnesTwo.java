package Arrays;

public class SortArrayZerosOnesTwo {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 1, 0, 1, 1, 0};
        int n = arr.length;

        int low = 0, high = n - 1, mid = 0;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swapValues(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swapValues(arr, mid, high);
                high--;
            }
        }
        System.out.println(low+" "+mid+" "+high);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
