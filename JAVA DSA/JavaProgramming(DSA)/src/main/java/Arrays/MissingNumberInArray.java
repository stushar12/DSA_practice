package Arrays;

public class MissingNumberInArray {
    public static void main(String[] args) {

        int n = 5;
        int[] arr = {1, 2, 4, 5};
        System.out.println("Missing number from approach1 is : " + approach1(arr, n));
        System.out.println("Missing number from approach2 is : " + approach2(arr, n));
    }

    static int approach1(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 ^= arr[i];
            xor2 ^= (i + 1);
        }
        xor2 ^= n;
        return xor1 ^ xor2;
    }

    static int approach2(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int j : arr) {
            arraySum += j;
        }
        return sum - arraySum;
    }
}
