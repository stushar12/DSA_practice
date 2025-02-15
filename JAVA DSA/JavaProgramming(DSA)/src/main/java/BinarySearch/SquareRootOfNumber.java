package BinarySearch;

public class SquareRootOfNumber {
    public static void main(String[] args) {
        long num = 24;
        System.out.println("Floor value of square root of the number is : " + sqrtN(num));
    }

    public static int sqrtN(long n) {
        long ans = 0;

        long low = 0;
        long high = n;  /*till n not n-1 because it is not an array*/

        while (low <= high) {
            long mid = (low + high) / 2;

            if ((mid * mid) <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }
}
