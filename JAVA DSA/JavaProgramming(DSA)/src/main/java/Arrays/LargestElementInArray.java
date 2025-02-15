package Arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        int n = arr.length;

        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        int maxValue =  arr[0];
        for (int i = 0; i < n; i++) {
            maxValue = maxValue > arr[i] ? maxValue : arr[i];
        }
        System.out.println("Maximum element in the array is : "+ maxValue);
    }
}
