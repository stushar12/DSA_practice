package BinarySearch;

public class FloorAndCeilInArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int value = 5;
        System.out.println("Floor of the given element is : " + getFloorAndCeil(arr, arr.length, value)[0]);
        System.out.println("Ceil of the given element is : " + getFloorAndCeil(arr, arr.length, value)[1]);
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int value) {
        int[] ans = new int[2];
        /*
        The floor of value is the largest element in the array which is smaller than or equal to value.
        The ceiling of value is the smallest element in the array greater than or equal to value.
        */
        ans[0] = floor(arr, n, value);      /*floor value*/
        ans[1] = lowerBound(arr, value, n); /*ceil value*/
        return ans;
    }

    public static int floor(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        if (value < arr[0]) /*if the given element is smaller than the first element of the sorted array then return -1*/
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return arr[ans];
    }

    public static int lowerBound(int[] arr, int value, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        if (value > arr[n - 1]) /*if the given element is greater than the last element of the sorted array then return -1*/
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= value) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return arr[ans];
    }
}
