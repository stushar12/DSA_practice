package Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int n = arr.length;

        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        int nextIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[nextIndex]) {
                arr[++nextIndex] = arr[i];
            }
        }

        System.out.println("Final Array: ");
        for (int i = 0; i < nextIndex + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}