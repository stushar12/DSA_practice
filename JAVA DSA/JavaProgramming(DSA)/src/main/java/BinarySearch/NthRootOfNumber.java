package BinarySearch;

public class NthRootOfNumber {
    public static void main(String[] args) {
        int number = 1953125;
        int root = 9;
        System.out.printf("root %d for %d is: %d", root, number, NthRoot(number, root));
    }

    public static int NthRoot(int number, int root) {
        int ans = -1;
        int low = 1;
        int high = number;

        while (low <= high) {
            int mid = (low + high) / 2;
            long multipliedValue = calcPower(mid, root, number);

            if (multipliedValue == 1)           //exact value found
                return mid;
            else if (multipliedValue == 2) {        //means mid-value can't be answer need to eliminate right search space
                high = mid - 1;
            } else {                        // need to increase the mid-value
                low = mid + 1;
            }


        }
        return ans;
    }

    static long calcPower(int number, int power, int originalNumber) {
        long ans = 1;


        for (int i = 1; i <= power; i++) {
            ans *= number;
            if (ans > originalNumber) {         // no need to continue if product exceeds original number
                return 2;
            }
            if (ans == originalNumber)
                return 1;
        }
        return 0;
    }

}
