package Arrays;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,6,4};
        int n = arr.length;

        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        boolean descending = false;
        boolean ascending = false;

        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]){
                continue;
            }
            else if(arr[i] < arr[i-1]){
                descending = true;
            }
            else if(arr[i] > arr[i-1]){
                ascending = true;
            }
        }

        if(ascending && descending){
            System.out.println("Array is not sorted");
        }
        else{
            System.out.println("Array is sorted");
        }
    }
}
