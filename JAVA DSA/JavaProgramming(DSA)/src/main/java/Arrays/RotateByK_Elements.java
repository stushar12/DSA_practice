package Arrays;

public class RotateByK_Elements {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 4, 6, 7, 1, 2, 9, 2};
        int n = arr.length;
        int d = 2; // no of rotations
        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        d = d % n;         /* to get the number of times to rotate the array. because after every n-times rotation
          array will come to its original form*/

        rotateArray(arr, 0, d - 1); // rotate left
        rotateArray(arr, d, n - 1);       // rotate left

//        rotateArray(arr,0,n-d-1);  rotate right
//        rotateArray(arr,n-d,n-1);   rotate right
        rotateArray(arr, 0, n - 1);

        System.out.println("Final Array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();


    }

    static void rotateArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
