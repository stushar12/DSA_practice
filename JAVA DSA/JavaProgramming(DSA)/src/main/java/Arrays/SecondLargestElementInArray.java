package Arrays;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        int n = arr.length;

        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }
        System.out.println("Second largest element is : " + secondLargest + " and Second smallest element is : " + secondSmallest);
    }
}
