package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        int num1 = 12;
        int num2 = 5;
        int nums[] = {1, 2, 3};
        Basics obj = new Basics();
//        obj.swap2Numbers(num1, num2);
//        System.out.println(obj.check_ithBitSetOrNot(num1, 2));
//        System.out.println(obj.set_ithBit(num1, 1));
//        System.out.println(obj.clear_ithBit(num1, 2));
//        System.out.println(obj.toggle_ithBit(num1, 2));
//        System.out.println(obj.removeLastSetBit(num1));
//        System.out.println(obj.checkNumberPowerOf2(num1));
//        System.out.println(obj.countNumberOfSetBits(num1));
//        System.out.println(obj.minBitsFlip(10, 7));
//        System.out.println(obj.singleNumber2(nums));
//        System.out.println(obj.divide(22, 3));
        System.out.println(obj.powerSet(nums));
    }



    void swap2Numbers(int num1, int num2) {
        System.out.println("Original Numbers:  num1: " + num1 + " num2: " + num2);
        num1 = num1 ^ num2;      //eg num1 = 10 num2 =5  => num1 = 10^5;
        num2 = num1 ^ num2;      // num2 = 10^5 ^ 5  => num2 =10
        num1 = num1 ^ num2;       // num1 = 10^5 ^ 10 => num1 =5
        System.out.println("Swapped Numbers:  num1: " + num1 + " num2: " + num2);
    }

    boolean check_ithBitSetOrNot(int num, int index) {
        int modifiedNum = num;
//        return (modifiedNum & (1 << index)) != 0;   // 1st way  by left shifting one
        return ((modifiedNum >> index) & 1) == 1;         //2nd way by right shifting the num
    }

    int set_ithBit(int num, int index) {
        return ((1 << index) | num);
    }

    int clear_ithBit(int num, int index) {
        return (~(1 << index) & num);
    }

    int toggle_ithBit(int num, int index) {
        return ((1 << index) ^ num);
    }

    int removeLastSetBit(int num) {
        return (num & (num - 1));
    }

    boolean checkNumberPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    int countNumberOfSetBits(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) count++;
            num = num >> 1;
        }

        return count;
    }

    int minBitsFlip(int start, int goal) {
        int count = 0;
        int resultantNumber = start ^ goal;
        count = countNumberOfSetBits(resultantNumber);
        return count;
    }

    int singleNumber2(int[] nums) {
        int first = 0, second = 0;

        for (int num : nums) {
            first = (num ^ first) & ~second;
            second = (num ^ second) & ~first;
        }
        return first;
    }



    int divide(int dividend, int divisor) {
        long ans = 0;
        if (dividend == divisor) return 1;

        boolean negativeDivision = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend >= divisor) {
            int count = 0;

            while (dividend >= (divisor << (count + 1))) {
                count++;
            }
            ans += 1 << count;

            dividend = dividend - (divisor << count);
        }

        if (ans == (1 << 31) && negativeDivision) return Integer.MIN_VALUE;

        else if (!negativeDivision && ans == 1 << 31) return Integer.MAX_VALUE;
        return (int) (negativeDivision ? -1 * ans : ans);
    }

    List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        int totalCombinations = 1<<n;

        for(int i=0;i<totalCombinations;i++){
            List<Integer> nestedAns = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if ((i & (1 << j)) != 0) {
                    nestedAns.add(nums[j]);
                }
            }
            ans.add(nestedAns);
        }

        return ans;
    }
}


