package Arrays;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4, 6, 7, 5};
        for (int elem : optimal2(arr)) {
            System.out.print(elem + " ");
        }
    }

    static int[] optimal1(int[] arr) {
        int[] res = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                res[0] = Math.abs(arr[i]);      //repeating number
            } else {
                arr[Math.abs(arr[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                res[1] = i + 1;     //missing number
                break;
            }
        }
        return res;
    }

    static int[] optimal2(int[] arr) {
        int[] res = new int[2];
        int n = arr.length;
        long sum = 0L, sumOfNNumbers;
        long sumOfSquare = 0L, sumOfNSquare;
        sumOfNNumbers = (long) n * (n + 1) / 2;
        sumOfNSquare = n * (n + 1) * (2L * n + 1) / 6;

        for (int j : arr) {
            sum += j;
            sumOfSquare += (long) j * j;
        }

        long equation1 = sum - sumOfNNumbers; // (x-y);
        long equation2 = sumOfSquare - sumOfNSquare;  // (x^2-y^2) = (x+y)(x-y)
        equation2 = equation2 / equation1; // (x+y)

        long x = (equation1 + equation2) / 2L; //(x+y)+(x-y) = 2x/2 = x
        long y = equation2 - x; // x+y = equation2

        res[0] = (int) x;       // x is repeating number
        res[1] = (int) y;       // y is missing number
        return res;
    }
}
