package Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {4,0,3,2,5};
        int n = arr.length;

        System.out.println("Original Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        int j = 0;

        for (int i = 0; i < n; i++) {
            if(arr[i]!=0){
                swapValues(arr,j,i);
                j++;
            }
        }

        System.out.println("Final Array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void swapValues(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
